package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MakeMyTripFlightSelection {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriverManager.chromedriver().setup();
        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Open MakeMyTrip website
        driver.get("https://www.makemytrip.com/");

        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]"));

        // Approach 1: Using JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display = 'none';", element);

        // Enter departure city
        String departureCity = "New York";
        WebElement departureInput = driver.findElement(By.id("fromCity"));
        departureInput.sendKeys(departureCity);
        departureInput.click();



        // Enter arrival city
        String arrivalCity = "Los Angeles";
        WebElement arrivalInput = driver.findElement(By.id("toCity"));
        arrivalInput.sendKeys(arrivalCity);
        driver.findElement(By.xpath("//li[contains(text(),'New York')]")).click();

        // Wait for the city suggestions to appear for departure and arrival
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.react-autosuggest__suggestions-list")));

        // Choose the desired city from the suggestions (Departure)
        WebElement departureSuggestion = driver.findElement(By.xpath("//li[@role='option' and contains(@id, 'react-autowhatever-fromCity')]"));
        departureSuggestion.click();

        // Choose the desired city from the suggestions (Arrival)
        WebElement arrivalSuggestion = driver.findElement(By.xpath("//li[@role='option' and contains(@id, 'react-autowhatever-toCity')]"));
        arrivalSuggestion.click();

        // Continue with the rest of the booking process...
    }
}
