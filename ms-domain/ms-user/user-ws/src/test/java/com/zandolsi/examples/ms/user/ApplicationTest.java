package com.zandolsi.examples.ms.user;

import com.zandolsi.examples.ms.user.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private UserController controller;

    @Test
    public void givenDefaultConfiguration_whenCallMainClass_thenApplicationStarted() {
        assertThat(controller).isNotNull();
    }
}