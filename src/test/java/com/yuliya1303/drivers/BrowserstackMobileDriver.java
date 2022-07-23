package com.yuliya1303.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.yuliya1303.config.BrowserstackCredentialsConfig;
import com.yuliya1303.config.LaunchConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    static LaunchConfig launchConfig = ConfigFactory.create(LaunchConfig.class);

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        BrowserstackCredentialsConfig browserstackConfig = ConfigFactory.create(BrowserstackCredentialsConfig.class);

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", browserstackConfig.user());
        mutableCapabilities.setCapability("browserstack.key", browserstackConfig.key());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", "bs://j3c874f21852ba57957a3fdc33f47514288c4ba4");

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", launchConfig.device());
        mutableCapabilities.setCapability("os_version", launchConfig.osVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "homework21");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "selenide android test");
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {

        try {
            return new URL(launchConfig.hostUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
