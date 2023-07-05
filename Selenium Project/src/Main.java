import Home.HomePage;
import Stays.StaysPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to URL
        driver.get("https://saucasa.zaptatech.com/");

        HomePage homePage = new HomePage(driver);
        System.out.println("Verifying Sucasa section texts");
        homePage.verifySucasaSectionText();

        homePage.clickFindStaysButton();

        StaysPage staysPage = new StaysPage(driver);
        staysPage.verifyPageUrl();

        // Take a picture of the page
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss"));
        FileUtils.copyFile(src, new File("FIRST_" + timestamp + ".png"));
        System.out.println("Picture is taken and saved with the required name");

        driver.quit();

    }}

