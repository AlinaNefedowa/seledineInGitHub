package guru.qa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests {
    @Test
    public void testIssueSearch() {

        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("selenide");
        $(".header-search-input").submit();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("Soft");
        $(By.linkText("SoftAssertions")).shouldBe(visible).click();
        $$(".markdown-body").findBy(visible).shouldHave(text("Using JUnit5 extend test class"));
    }
}