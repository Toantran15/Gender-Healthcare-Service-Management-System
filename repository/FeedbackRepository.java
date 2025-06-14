package com.abc.gender_healthcare.repository;

import com.abc.gender_healthcare.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
