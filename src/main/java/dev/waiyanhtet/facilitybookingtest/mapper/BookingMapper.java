package dev.waiyanhtet.facilitybookingtest.mapper;

import dev.waiyanhtet.facilitybookingtest.dto.response.BookingResponse;
import dev.waiyanhtet.facilitybookingtest.dto.response.FacilityResponse;
import dev.waiyanhtet.facilitybookingtest.entity.BookingEntity;
import dev.waiyanhtet.facilitybookingtest.entity.FacilityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {

    @Mapping(source = "id", target = "bookingId")
    @Mapping(source = "facilities", target = "facilities")
    @Mapping(source = "bookingTime", target = "bookingTime")
    BookingResponse asBookingResponse(BookingEntity entity);

    FacilityResponse asFacilityResponse(FacilityEntity entity);
}
