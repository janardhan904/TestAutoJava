package SF;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class Elements {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

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

        wait = new WebDriverWait(driver,30);
        driver.findElement(By.xpath("//*[text()='Elements']")).click();

        js=(JavascriptExecutor)driver;

    }

    //@Test
    public void TextBoxTest(){

        //Click elements section
        driver.findElement(By.xpath("//span[text()='Text Box']")).click();
        driver.findElement(By.id("userName")).sendKeys("janardhan reddy");
        driver.findElement(By.id("userEmail")).sendKeys("janardhan.reddy75@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("London, UK");
        driver.findElement(By.id("permanentAddress")).sendKeys("Hyderabad, INDIA");
        driver.findElement(By.id("submit")).click();

        //Verify text in the output
        String output = driver.findElement(By.id("output")).getText();
        Assert.assertTrue(output.contains("Name:"));
    }

    @Test
    public void CheckBoxTest() throws InterruptedException {

        //Click on Check Box
        driver.findElement(By.xpath("//span[text()='Check Box']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Expand all']")));

        //Click on Expand All
        driver.findElement(By.xpath("//button[@title='Expand all']")).click();

        //Click on Collapse All
        driver.findElement(By.xpath("//button[@title='Collapse all']")).click();

        WebElement TreeCheck = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/button[1]"));
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 5px solid red;');", TreeCheck);



        //Click on Tree check box and Uncheck
        //TreeCheck.click();

        List<WebElement> treeEles = driver.findElements(By.xpath("//span[@class='rct-text']/button[@title='Toggle']"));

        for (WebElement ele:treeEles) {
            ele.click();
            Thread.sleep(1000);
        }


        //TreeCheck.click();

        //Click on All checkboxes


        //Verify text in the output

    }

    //@AfterClass
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
