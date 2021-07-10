package com.packt.chapter2.containernative;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "John", name = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}
