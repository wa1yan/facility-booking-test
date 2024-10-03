package dev.waiyanhtet.facilitybookingtest.service.impl;

import dev.waiyanhtet.facilitybookingtest.dto.response.FacilityResponse;
import dev.waiyanhtet.facilitybookingtest.mapper.FacilityMapper;
import dev.waiyanhtet.facilitybookingtest.repository.FacilityRepository;
import dev.waiyanhtet.facilitybookingtest.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;
    private final FacilityMapper facilityMapper;

    @Override
    public List<FacilityResponse> retrieveFacilities() {
        return facilityRepository.findAll().stream().map(facilityMapper::asFacilityResponse).toList();
    }
}
