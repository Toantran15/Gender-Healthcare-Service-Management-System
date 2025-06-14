package com.abc.gender_healthcare.repository;

import com.abc.gender_healthcare.entity.ConsultationAppointment;
import com.abc.gender_healthcare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationAppointmentRepository extends JpaRepository<ConsultationAppointment, Long> {
    List<ConsultationAppointment> findByCustomer(User customer);
    List<ConsultationAppointment> findByConsultant(User consultant);
}
