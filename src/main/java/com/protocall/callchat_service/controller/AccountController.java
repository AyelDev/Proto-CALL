package com.protocall.callchat_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Authentication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.protocall.callchat_service.dto.RegisterDto;
import com.protocall.callchat_service.model.PrtUser;
import com.protocall.callchat_service.repository.UserRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AccountController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute("registerDto", registerDto);
        model.addAttribute("successMessage", false);
        return "register";
    }

    @PostMapping("/register")
    public String register(
            Model model,
            @Valid @ModelAttribute RegisterDto registerDto,
            BindingResult result) {

        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            result.addError(
                    new FieldError("registerDto", "confirmPassword", "Passwords do not match"));
        }

        PrtUser prtUser = userRepository.findByEmail(registerDto.getEmail());

        if (prtUser != null) {
            result.addError(
                    new FieldError("registerDto", "email", "Email is already in use"));
        }

        if (result.hasErrors()) {
            return "register";
        }

        try {

            var BCryptPasswordEncoder = new BCryptPasswordEncoder();
            PrtUser prtcUser = new PrtUser();
            prtcUser.setFirstName(registerDto.getFirstName());
            prtcUser.setLastName(registerDto.getLastName());
            prtcUser.setEmail(registerDto.getEmail());
            prtcUser.setPassword(BCryptPasswordEncoder.encode(registerDto.getPassword()));

            userRepository.save(prtcUser);

            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("successMessage", true);
        } catch (Exception e) {
            result.addError(
                    new FieldError("registerDto", "email", "An error occurred while registering"));
        }

        return "register";

    }

}