package com.yuliya1303.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
//import com.yuliya1303.drivers.BrowserstackMobileDriver;
import com.yuliya1303.drivers.LocalMobileDriver;
import com.yuliya1303.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static com.yuliya1303.helpers.Attach.sessionId;
import static io.qameta.allure.Allure.step;

public class TestBase {
    @BeforeAll
    public static void setup() {

        //Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.browser = LocalMobileDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());

        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        step("Close driver", Selenide::closeWebDriver);

        //Attach.video(sessionId);
    }
}
