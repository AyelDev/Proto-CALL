package com.protocall_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protocall_service.model.User;
import com.protocall_service.repository.UserRepository;
import com.protocall_service.web.dto.UserRegistrationDto;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    
    public UserServiceImp(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        // Implementation for saving user
        User user = new User(
            registrationDto.getUsername(),
            registrationDto.getPassword(),
            registrationDto.getRole(),
            registrationDto.isEnabled()
        );
        return userRepository.save(user);
    }


}
