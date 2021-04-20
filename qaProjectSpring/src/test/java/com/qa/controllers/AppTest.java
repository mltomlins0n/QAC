package com.qa.controllers;

import com.qa.App;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class AppTest {
    App app;

    @Test
    public void appTest() {
        app = new App();
        app.main(new String[]{});
    }
}