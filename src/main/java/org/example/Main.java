package org.example;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

    /*
     * public Date ConvertDate(Date date) throws java.text.ParseException{
     *
     * SimpleDateFormat df = new SimpleDateFormat("2023-07-28"); String s =
     * df.format(date); String result = s; date=(Date) df.parse(result); return
     * date; }
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait

        driver.get("https://www.makemytrip.com");

        // Find the element to modify its CSS
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]"));


        // Approach 1: Using JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display = 'none';", element);

        // Approach 2: Using setAttribute()
        //   element.setAttribute("style", "background-color: red;");

        // Approach 3: Using Actions class
        //    Actions actions = new Actions(driver);
        // actions.moveToElement(element).build().perform();
        //    actions.style().setBackgroundColor("red").perform();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Close the browser

        //From
        WebElement flightFrom = driver.findElement(By.id("fromCity"));
        flightFrom.sendKeys("Los Angeles, United States");
        Thread.sleep(1000);
        WebElement from = driver.findElement(By.id("//*[@class='react-autosuggest__suggestions-list']/*[@id='react-autowhatever-1-section-0-item-0']/*[@class='makeFlex hrtlCenter']"));
        from.click();
        //*[@class='calc60']//*[text()='Los Angeles, United States']
        // Wait for the To field to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement flightTo = driver.findElement(By.id("toCity"));
        flightTo.sendKeys("Pune");
        driver.findElement(By.id("react-autowhatever-1-section-0-item-1")).click();


        // Wait for the departure calendar date field to be clickable
        WebElement dateField = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[3]/label/p[1]")); // Replace "datePickerId" with the actual ID of the date picker element
        dateField.click(); // Open the date picker

      /* String dateToSelect = "2023-07-28"; // Replace with the desired date in the format yyyy-MM-dd
        dateField.sendKeys(dateToSelect);
        dateField.click();*/

        /*
         * WebElement dateBox = driver.findElement(By.xpath("//*[@id=\"departure\"]"));
         *
         * //Fill date as mm/dd/yyyy as 09/25/2013
         *
         * dateBox.sendKeys("09252023");
         *
         * //Press tab to shift focus to time field
         *
         * dateBox.sendKeys(Keys.TAB);
         */
        //Fill time as 02:45 PM
        WebElement dateWidget = driver.findElement(By.xpath("//input[@id='hp-widget__depart']"));
        List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

        for (WebElement cell: columns){
            //Select 13th Date
            if (cell.getText().equals("22")){
                cell.findElement(By.linkText("22")).click();
                break;
            }

            WebElement test = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[6]"));
            test.click();
            driver.quit();
        }
    }
}

