package com.abc.gender_healthcare.controller;

import com.abc.gender_healthcare.entity.Feedback;
import com.abc.gender_healthcare.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback/form";
    }

    @PostMapping("/submit")
    public String submitFeedback(@ModelAttribute Feedback feedback) {
        feedbackService.saveFeedback(feedback);
        return "redirect:/feedback/form?success";
    }

    @GetMapping("/list")
    public String listFeedbacks(Model model) {
        model.addAttribute("feedbacks", feedbackService.getAllFeedbacks());
        return "feedback/list";
    }
}
