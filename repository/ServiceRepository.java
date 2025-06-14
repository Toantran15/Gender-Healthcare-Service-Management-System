package com.abc.gender_healthcare.repository;

import com.abc.gender_healthcare.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {}
