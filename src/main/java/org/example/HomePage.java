package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomePage
{
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);



        driver.get("https://www.makemytrip.com/");

        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]"));

        // Approach 1: Using JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display = 'none';", element);

        //from city
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")).click();
        Thread.sleep(1000);
        //to city
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/p[1]")).click();




    }
}