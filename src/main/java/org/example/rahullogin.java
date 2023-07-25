package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class rahullogin {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        System.out.println("Login Functionality checked _/ ");

        driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
  //      Thread.sleep(1000);
        System.out.println("checkbox checked one...");
//        Thread.sleep(1000);
        driver.findElement(By.id("chkboxTwo")).click();
        System.out.println("checkbox checked Two...");
        driver.findElement(By.className("signInBtn")).click();
   //     Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("/html/body/div")).getText());

        System.out.println("Logout Functionality checked _/ ");
        driver.findElement(By.className("logout-btn")).click();
//        Thread.sleep(2000);

        System.out.println("Forgot_Password_Functionality");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);

        System.out.println("Go_To_Login");
        driver.findElement(By.className("go-to-login-btn")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("/html/body/div")).getText());


        System.out.println("Visit_Us");
        driver.findElement(By.id("visitUsTwo")).click();
        System.out.println(driver.findElement(By.xpath("/html/body/div")).getText());
        Thread.sleep(3000);

        driver.quit();



    }

}
