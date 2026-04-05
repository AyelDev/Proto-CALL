package com.protocall.callchat_service.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.protocall.callchat_service.model.PrtUser;
import com.protocall.callchat_service.repository.UserRepository;
import org.springframework.security.core.userdetails.User;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        PrtUser prtc_user = userRepository.findByEmail(email);
        
        if(prtc_user != null){
            var springuser = User.withUsername(prtc_user.getEmail())
                .password(prtc_user.getPassword())
                .roles(prtc_user.getRole())
                .build();

                return springuser;
        }
 
        return null;
    }

    
}
