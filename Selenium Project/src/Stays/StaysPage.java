package Stays;

import org.openqa.selenium.*;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.Assert;

import java.time.Duration;

public class StaysPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String expectedUrl = "https://saucasa.zaptatech.com/index?#featured";

    public StaysPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void verifyPageUrl() {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        System.out.println("URL is verified");
    }
}
