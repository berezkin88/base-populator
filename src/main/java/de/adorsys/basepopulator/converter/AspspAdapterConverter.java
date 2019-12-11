package de.adorsys.basepopulator.converter;

import de.adorsys.basepopulator.db.model.AspspAdapterEntity;
import de.adorsys.basepopulator.service.model.AspspAdapter;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AspspAdapterConverter {

    AspspAdapterEntity toAdapterEntity(AspspAdapter aspspAdapter);

    List<AspspAdapterEntity> toAdapterEntityList(List<AspspAdapter> aspspAdapters);
}
