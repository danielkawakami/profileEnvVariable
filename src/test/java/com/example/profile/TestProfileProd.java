package com.example.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("prod")
public class TestProfileProd {
    @Autowired
    private MyService service;

    @Autowired
    private MyComponent myComponent;

    @Test
    public void testProfileQa() {
        assertThat("Testing profile in service", service.getProfile(), is("prod"));
        assertThat("Testing profile in configuration", myComponent.getSomething(), is("Your environment is under Production! Be careful!"));
    }
}
