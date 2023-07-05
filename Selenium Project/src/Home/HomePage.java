package Home;

import org.openqa.selenium.*;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By containerBy = By.xpath("/html/body/div[5]/div[2]/div");
    private By sucasaSectionTextBy = By.tagName("h4");
    private String[] expectedH4Texts = {
            "Work From Anywhere",
            "Transparent Pricing",
            "Premium Properties"
    };

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void verifySucasaSectionText() {
        WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(containerBy));
        List<WebElement> sucasaSectionText = container.findElements(sucasaSectionTextBy);

        if (sucasaSectionText.size() == expectedH4Texts.length) {
            for (int i = 0; i < sucasaSectionText.size(); i++) {
                WebElement heading = sucasaSectionText.get(i);
                String actualText = heading.getText();
                String expectedText = expectedH4Texts[i];

                if (actualText.equals(expectedText)) {
                    System.out.println("Test is passed");
                } else {
                    System.out.println("Test is failed");
                }
            }
        } else {
            System.out.println("Number of Sucasa section texts does not match");
        }
    }

    public void clickFindStaysButton() {

        WebElement btnFindStays = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Find Stays']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnFindStays);
        System.out.println("Button is clicked");

    }
}

