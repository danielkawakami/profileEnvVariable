package com.example.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyService {
    @Value("${spring.profiles.active}")
    private String profile;

    public String getProfile() {
        return profile;
    }

}
