package dev.waiyanhtet.facilitybookingtest.dto.response;

import dev.waiyanhtet.facilitybookingtest.dto.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {

    private String bookingId;
    private List<FacilityResponse> facilities;
    private LocalDateTime bookingTime;
    private BookingStatus bookingStatus;

}
