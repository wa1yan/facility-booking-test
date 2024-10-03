package dev.waiyanhtet.facilitybookingtest.service;

import dev.waiyanhtet.facilitybookingtest.dto.response.FacilityResponse;

import java.util.List;

public interface FacilityService {

    List<FacilityResponse> retrieveFacilities();
}
