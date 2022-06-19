package com.yuliya1303.tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MoreMenuTests extends TestBase {
    @Test
    void moreMenuContainsLoginItem() {
        back();
        step("Open More menu", () ->
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_more_container")).click());
        step("Verify Menu contains Login item", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_account_container"))
                        .isDisplayed());
    }

    @Test
    void moreMenuContainsSettingsItem() {
        back();
        step("Open More menu", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/nav_more_container")).click());
        step("Verify Menu contains Settings item", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_settings_container"))
                        .isDisplayed());
    }

    @Test
    void moreMenuContainsDonateItem() {
        back();
        step("Open More menu", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/nav_more_container")).click());
        step("Verify Menu contains Donate item", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_donate_container"))
                        .isDisplayed());
    }
}
