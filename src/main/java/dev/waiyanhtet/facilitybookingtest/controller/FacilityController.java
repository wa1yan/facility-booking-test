package dev.waiyanhtet.facilitybookingtest.controller;

import dev.waiyanhtet.facilitybookingtest.dto.response.FacilityResponse;
import dev.waiyanhtet.facilitybookingtest.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FacilityController {

    private final FacilityService facilityService;

    @GetMapping("/facilities")
    public List<FacilityResponse> retrieveFacilities() {
        return facilityService.retrieveFacilities();
    }
}
