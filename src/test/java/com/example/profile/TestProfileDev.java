package com.example.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * IMPORTANTE
 * Se não anotar com @ActiveProfiles("dev"), a configuração tenta ler a propriedade, que por sua
 * vez tenta ler a variável de ambiente. Ocorre problemas com isso
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class TestProfileDev {
    @Autowired
    private MyService service;

    @Autowired
    private MyComponent myComponent;

    @Test
    public void testProfileDev() {
        assertThat("Testing profile in service", service.getProfile(), is("dev"));
        assertThat("Testing profile in configuration", myComponent.getSomething(), is("You are on default environment"));
    }
}
