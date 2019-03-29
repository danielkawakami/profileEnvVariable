package com.example.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Value("${spring.profiles.active}")
    private String profile;

    @Bean
    public MyComponent createComponent() {
        MyComponent myComponent = new MyComponent();
        if(profile.equals("prod")) {
            myComponent.setSomething("Your environment is under Production! Be careful!");
        }
        else if(profile.equals("qa")) {
            myComponent.setSomething("You are on QA environment. DO your acceptance tests");
        }
        else if(profile.equals("dev")) {
            myComponent.setSomething("You are on default environment");
        }
        return myComponent;
    }
}
