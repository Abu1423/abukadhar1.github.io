package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @PostMapping("/submit")
    public String handleForm(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message,
            RedirectAttributes redirectAttributes
    ) {
        logger.info("===== NEW MESSAGE RECEIVED =====");
        logger.info("Name: {}", name);
        logger.info("Email: {}", email);
        logger.info("Message: {}", message);

        // Add success feedback for user
        redirectAttributes.addFlashAttribute("successMessage", "Your message has been sent successfully!");

        // Redirect back to homepage or contact page
        return "redirect:/contact";
    }
}
