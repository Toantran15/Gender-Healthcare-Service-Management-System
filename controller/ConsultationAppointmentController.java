package com.abc.gender_healthcare.controller;

import com.abc.gender_healthcare.entity.ConsultationAppointment;
import com.abc.gender_healthcare.entity.User;
import com.abc.gender_healthcare.service.ConsultationAppointmentService;
import com.abc.gender_healthcare.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.abc.gender_healthcare.entity.Role;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class ConsultationAppointmentController {

    private final ConsultationAppointmentService appointmentService;
    private final UserService userService;

    @GetMapping("/new")
    public String showBookingForm(Model model) {
        model.addAttribute("appointment", new ConsultationAppointment());
        model.addAttribute("consultants", userService.findAllByRole(Role.CONSULTANT));

        return "appointment/form";
    }

    @PostMapping("/save")
    public String saveAppointment(@ModelAttribute ConsultationAppointment appointment,
                                  @AuthenticationPrincipal UserDetails userDetails) {
        User customer = userService.findByUsername(userDetails.getUsername());
        appointment.setCustomer(customer);
        appointmentService.bookAppointment(appointment);
        return "redirect:/appointments/my";
    }

    @GetMapping("/my")
    public String viewMyAppointments(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername());
        model.addAttribute("appointments", appointmentService.getAppointmentsByCustomer(user));
        return "appointment/list";
    }

    @GetMapping("/consultant")
    public String viewConsultantAppointments(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User consultant = userService.findByUsername(userDetails.getUsername());
        model.addAttribute("appointments", appointmentService.getAppointmentsByConsultant(consultant));
        return "appointment/consultant_list";
    }

    @PostMapping("/status/{id}")
    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
        appointmentService.updateStatus(id, status);
        return "redirect:/appointments/consultant";
    }
}
