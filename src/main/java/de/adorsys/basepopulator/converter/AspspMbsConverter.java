package de.adorsys.basepopulator.converter;

import de.adorsys.basepopulator.db.model.AspspMbsEntity;
import de.adorsys.basepopulator.service.model.AspspMbs;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AspspMbsConverter {

    @Mapping(target = "aspspName", source = "name")
    AspspMbsEntity toEntity(AspspMbs aspspMbs);

    List<AspspMbsEntity> toEntityList(List<AspspMbs> aspspMbs);
}
