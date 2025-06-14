package com.abc.gender_healthcare.controller;

import com.abc.gender_healthcare.repository.ConsultationAppointmentRepository;
import com.abc.gender_healthcare.repository.STITestRepository;
import com.abc.gender_healthcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private STITestRepository stiTestRepository;

    @Autowired
    private ConsultationAppointmentRepository consultationRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String viewDashboard(Model model) {
        long totalStiTests = stiTestRepository.count();
        long totalConsultations = consultationRepository.count();
        long totalUsers = userRepository.count();

        model.addAttribute("totalStiTests", totalStiTests);
        model.addAttribute("totalConsultations", totalConsultations);
        model.addAttribute("totalUsers", totalUsers);

        return "dashboard";
    }
}
