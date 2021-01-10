package SF;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Elements {

    WebDriver driver;

    @BeforeClass
    public void NavigateURL(){
        //Get Current directory
        String driverPath = System.getProperty("user.dir");

        //Setting System Path and Initialize the driver
        System.setProperty("webdriver.chrome.driver", driverPath + "\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();

        //Maximize the driver
        driver.manage().window().maximize();

        //Navigate to URL
        driver.get("https://demoqa.com/");
    }

    @Test
    public void TextBoxTest(){

        //Click elements section
        driver.findElement(By.xpath("//*[text()='Elements']")).click();
        driver.findElement(By.xpath("//span[text()='Text Box']")).click();
        driver.findElement(By.id("userName")).sendKeys("janardhan reddy");
    }

    @AfterClass
    public void CloseBrowser(){
        driver.quit();
    }
}
