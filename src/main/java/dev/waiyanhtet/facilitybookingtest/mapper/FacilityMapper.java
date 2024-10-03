package dev.waiyanhtet.facilitybookingtest.mapper;


import dev.waiyanhtet.facilitybookingtest.dto.response.FacilityResponse;
import dev.waiyanhtet.facilitybookingtest.entity.FacilityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FacilityMapper {

    FacilityResponse asFacilityResponse(FacilityEntity entity);
}
