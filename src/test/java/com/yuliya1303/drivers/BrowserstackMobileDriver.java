package com.yuliya1303.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.yuliya1303.config.AppUrlConfig;
import com.yuliya1303.config.BrowserstackCredentialsConfig;
import com.yuliya1303.config.DeviceConfig;
import com.yuliya1303.config.OsVersionConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        BrowserstackCredentialsConfig browserstackConfig = ConfigFactory.create(BrowserstackCredentialsConfig.class);
        DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class);
        OsVersionConfig versionConfig = ConfigFactory.create(OsVersionConfig.class);
        AppUrlConfig appUrlConfig = ConfigFactory.create(AppUrlConfig.class);

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", browserstackConfig.user());
        mutableCapabilities.setCapability("browserstack.key", browserstackConfig.key());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", "bs://" + appUrlConfig);

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", deviceConfig.device());
        mutableCapabilities.setCapability("os_version", versionConfig.version());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "homework21");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "selenide android test");
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
