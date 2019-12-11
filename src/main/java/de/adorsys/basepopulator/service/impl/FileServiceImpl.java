package de.adorsys.basepopulator.service.impl;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import de.adorsys.basepopulator.converter.AspspAdapterConverter;
import de.adorsys.basepopulator.converter.AspspMbsConverter;
import de.adorsys.basepopulator.db.AspspAdapterRepository;
import de.adorsys.basepopulator.db.AspspMbsRepository;
import de.adorsys.basepopulator.db.impl.AspspAdapterRepositoryImpl;
import de.adorsys.basepopulator.db.impl.AspspMbsRepositoryImpl;
import de.adorsys.basepopulator.db.model.AspspAdapterEntity;
import de.adorsys.basepopulator.db.model.AspspMbsEntity;
import de.adorsys.basepopulator.service.FileService;
import de.adorsys.basepopulator.service.model.AspspAdapter;
import de.adorsys.basepopulator.service.model.AspspMbs;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Service
public class FileServiceImpl implements FileService {
    private static final ObjectReader CSV_OBJECT_READER;
    private static final ObjectReader YAML_OBJECT_READER;
    private static final Logger logger = Logger.getLogger(FileServiceImpl.class.getName());

    private final AspspAdapterRepository adapterRepository;
    private final AspspMbsRepository mbsRepository;
    private final AspspMbsConverter mbsConverter;
    private final AspspAdapterConverter adapterConverter;

    static {
        CsvMapper csvMapper = new CsvMapper();
        CSV_OBJECT_READER = csvMapper
            .readerFor(AspspAdapter.class)
            .with(csvMapper.typedSchemaFor(AspspAdapter.class).withNullValue(""))
            .withHandler(new DeserializationProblemHandler() {
                @Override
                public Object handleWeirdStringValue(DeserializationContext ctxt, Class<?> targetType, String valueToConvert, String failureMsg) {
                    if (targetType.isEnum()) {
                        return Enum.valueOf((Class<Enum>) targetType, valueToConvert.trim().toUpperCase());
                    }

                    return DeserializationProblemHandler.NOT_HANDLED;
                }
            });

        YAMLMapper yamlMapper = new YAMLMapper();
        YAML_OBJECT_READER = yamlMapper.readerFor(AspspMbs.class);
    }

    public FileServiceImpl(AspspAdapterRepositoryImpl adapterRepository, AspspMbsRepositoryImpl mbsRepository, AspspMbsConverter mbsConverter, AspspAdapterConverter adapterConverter) {
        this.adapterRepository = adapterRepository;
        this.mbsRepository = mbsRepository;
        this.mbsConverter = mbsConverter;
        this.adapterConverter = adapterConverter;
    }

    @Override
    public void parse(MultipartFile file) throws IOException {

        FileType fileType = determineFileType(file.getOriginalFilename());

        if (fileType.equals(FileType.CSV)) {
            adapterRepository.saveAll(parseCsv(file.getBytes()));
        } else if (fileType.equals(FileType.YAML)) {
            mbsRepository.saveAll(parseYaml(file.getBytes()));
        }
    }

    private List<AspspMbsEntity> parseYaml(byte[] yaml) {
        List<AspspMbs> input = null;

        try {
            input = YAML_OBJECT_READER
                .<AspspMbs>readValues(yaml)
                .readAll();
        } catch (IOException e) {
            logger.warning("Failed to parse Yaml");
            e.printStackTrace();
        }

        return mbsConverter.toEntityList(input);
    }

    private List<AspspAdapterEntity> parseCsv(byte[] csv) {
        List<AspspAdapter> input;
        try {
            input = CSV_OBJECT_READER
                .<AspspAdapter>readValues(csv)
                .readAll();
        } catch (IOException e) {
            logger.warning("Failed to parse csv");
            throw new UncheckedIOException(e);
        }

        return adapterConverter.toAdapterEntityList(input);
    }

    private FileType determineFileType(String name) {
        return Arrays.stream(name.split("\\."))
            .reduce((a, b) -> b)
            .map(el -> el.equals("csv") ? FileType.CSV : (el.equals("yml") ? FileType.YAML : null))
            .orElse(null);
    }

    enum FileType {
        CSV,
        YAML
    }
}
