package com.wikipedia.tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    @Test
    @DisplayName("Verify that Search results are displayed after entering valid Search data")
    void searchResultsDisplayedWithExistingData() {
        back();
        step("Type existing search data", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Verify that No results are displayed after entering not available Search data")
    void noResultsDisplayedWithNotExistingData() {
        back();
        step("Type not existing search data", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("tttttes");
        });
        step("Verify no results displayed", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/results_text"))
                        .shouldHave(text("No results")));
    }

    @Test
    @DisplayName("Verify that Empty placeholder is displayed after clearing Search field")
    void emptyPlaceholderDisplayedIfDataIsCleared() {
        back();
        step("Type search data", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("tttttes");
        });
        step("Clear search data", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_close_btn")).click();
        });
        step("Verify empty message placeholder is displayed", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/search_empty_message")).isDisplayed());
    }

    @Test
    @DisplayName("Verify that Article is opened after clicking on Search result data")
    void articleIsOpenedFromSearchResults() {
        back();
        step("Type existing search data", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenide");
        });
        step("Click on search result", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).find(matchText("Selenide")).click();
        });
        step("Verify that article is opened", () ->
                $(AppiumBy.id("00000000-0000-00ad-0000-000e000000ca")).isDisplayed());
    }
}
