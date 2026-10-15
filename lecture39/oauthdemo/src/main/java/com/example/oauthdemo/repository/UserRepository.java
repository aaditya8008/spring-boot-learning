package com.example.oauthdemo.repository;


import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oauthdemo.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByProviderAndProviderSubject(String provider,
                                                    String providerSubject);
}
