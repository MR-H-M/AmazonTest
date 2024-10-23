package com.MyMavenProject;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CrossbrowserTest {
    public static void main(String[] args) throws Exception {
        String gridURL = "http://localhost:4444/wd/hub";

        // Test on Chrome
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver chromeDriver = new RemoteWebDriver(new URL(gridURL), chromeOptions);
        testAmazon(chromeDriver);

        // Test on Firefox
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriver firefoxDriver = new RemoteWebDriver(new URL(gridURL), firefoxOptions);
        testAmazon(firefoxDriver);

        // Test on Edge
        EdgeOptions edgeOptions = new EdgeOptions();
        WebDriver edgeDriver = new RemoteWebDriver(new URL(gridURL), edgeOptions);
        testAmazon(edgeDriver);
    }

    public static void testAmazon(WebDriver driver) {
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Laptop");
        searchBox.submit();
        if (driver instanceof RemoteWebDriver) {
            String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
            System.out.println("Test on " + browserName + " completed.");
    }
    }}
