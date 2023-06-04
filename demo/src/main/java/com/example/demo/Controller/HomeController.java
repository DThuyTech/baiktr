package com.example.demo.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping
    public String home(Model model) {
        String message = "Hello, me!";
        model.addAttribute("message", message);
        return "home";
    }

}
