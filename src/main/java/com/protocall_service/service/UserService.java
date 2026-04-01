package com.protocall_service.service;

import org.springframework.stereotype.Service;

import com.protocall_service.model.User;
import com.protocall_service.web.dto.UserRegistrationDto;

@Service
public interface UserService {
    User save(UserRegistrationDto registrationDto);
}
