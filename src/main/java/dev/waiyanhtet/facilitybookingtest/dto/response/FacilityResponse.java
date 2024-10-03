package dev.waiyanhtet.facilitybookingtest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityResponse {

    private Long id;
    private String name;
    private String description;
}
