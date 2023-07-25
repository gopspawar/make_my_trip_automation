package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hiddensuggetions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
        Thread.sleep(1000);

        driver.findElement(By.name("q")).sendKeys("iphone");

        driver.findElement(By.className(" _3izBDY")).click();
        Thread.sleep(1000);




    }
}
