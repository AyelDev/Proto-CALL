package com.protocall.callchat_service.repository;

import com.protocall.callchat_service.model.PrtUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<PrtUser, Integer> {
    public PrtUser findByEmail(String email);
}
