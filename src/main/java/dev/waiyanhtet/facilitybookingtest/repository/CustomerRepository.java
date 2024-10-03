package dev.waiyanhtet.facilitybookingtest.repository;

import dev.waiyanhtet.facilitybookingtest.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
