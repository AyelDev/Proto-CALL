package com.protocall.callchat_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping({"", "/", "login"})
    public String login() {
        return "login";
    }

    @GetMapping("contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("dashboard")
    public String dashboard() {
        return "dashboard";
    }

}
