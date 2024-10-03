package dev.waiyanhtet.facilitybookingtest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {

    private List<Long> facilityIds;
    private Long customerId;
    private String description;
}
