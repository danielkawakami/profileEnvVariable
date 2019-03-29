package com.example.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProfileDev {
    @Autowired
    private MyService service;

    @Autowired
    private MyComponent myComponent;

    @Value("${spring.profiles.active}")
    private String profile;

    @Test
    public void testProfileDev() {
        assertThat("Testing profile in service", service.getProfile(), is("dev"));
        assertThat("Testing profile in configuration", myComponent.getSomething(), is("You are on default environment"));
    }
}
