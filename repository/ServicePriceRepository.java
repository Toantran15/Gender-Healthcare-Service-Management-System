package com.abc.gender_healthcare.repository;

import com.abc.gender_healthcare.entity.ServicePrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicePriceRepository extends JpaRepository<ServicePrice, Long> {
    List<ServicePrice> findByService_ServiceId(Long serviceId);
}
