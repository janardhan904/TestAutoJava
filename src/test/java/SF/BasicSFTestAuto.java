package SF;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BasicSFTestAuto {

    @Test
    public void BasicTestAuto(){

        //Get Current directory path dynamically
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        String driverPath = System.getProperty("user.dir");

        //Setting System Path
        System.setProperty("webdriver.chrome.driver", driverPath + "\\BrowserDrivers\\chromedriver.exe");

        //Calling Driver and Chrome Driver
        WebDriver driver=new ChromeDriver();

        //Navigating to URL
        driver.get("http://automationpractice.com/index.php");

        //Clicking an Element logo by using XPATH
        driver.findElement(By.xpath("//img[contains(@class,'logo')]")).click();

        //Closing the browser window
        driver.close();
    }
}
