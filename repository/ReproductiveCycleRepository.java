package com.abc.gender_healthcare.repository;

import com.abc.gender_healthcare.entity.ReproductiveCycle;
import com.abc.gender_healthcare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReproductiveCycleRepository extends JpaRepository<ReproductiveCycle, Long> {
    List<ReproductiveCycle> findByUser(User user);
}
