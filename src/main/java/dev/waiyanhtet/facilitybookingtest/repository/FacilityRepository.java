package dev.waiyanhtet.facilitybookingtest.repository;

import dev.waiyanhtet.facilitybookingtest.entity.FacilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository  extends JpaRepository<FacilityEntity, Long> {
}
