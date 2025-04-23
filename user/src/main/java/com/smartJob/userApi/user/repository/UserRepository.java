package com.smartJob.userApi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartJob.userApi.user.entity.SjUser;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository  extends JpaRepository<SjUser, UUID> {
    
    boolean existsByEmail(String email);

    Optional<SjUser> findByEmail(String email);
}
