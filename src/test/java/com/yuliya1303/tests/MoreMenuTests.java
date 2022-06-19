package com.yuliya1303.tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MoreMenuTests extends TestBase {
    @Test
    @DisplayName("Verify that Login item exists in 'More' menu item")
    void moreMenuContainsLoginItem() {
        back();
        step("Open More menu", () ->
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_more_container")).click());
        step("Verify Menu contains Login item", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_account_container"))
                        .isDisplayed());
    }

    @Test
    @DisplayName("Verify that Settings item exists in 'More' menu item")
    void moreMenuContainsSettingsItem() {
        back();
        step("Open More menu", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/nav_more_container")).click());
        step("Verify Menu contains Settings item", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_settings_container"))
                        .isDisplayed());
    }

    @Test
    @DisplayName("Verify that Donate item exists in 'More' menu item")
    void moreMenuContainsDonateItem() {
        back();
        step("Open More menu", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/nav_more_container")).click());
        step("Verify Menu contains Donate item", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_donate_container"))
                        .isDisplayed());
    }
}
