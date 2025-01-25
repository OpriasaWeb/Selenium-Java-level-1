package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SecondSeleniumTest {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void tearDown(){
//        driver.quit();
    }

    @Test
    public void testLoggingIntoApplication() throws InterruptedException {
        Thread.sleep(2000);

//        For username input
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

//        For password input
        var password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

//        For login button
        driver.findElement(By.tagName("button")).click();

//        NOTE: For testing purposes only, it is not recommended in real project.
        Thread.sleep(2000);
//        For assertions
        String actualResult = driver.findElement(By.tagName("h6")).getText();
        String expectedResult = "Dashboard";
//        Test failed on purpose
        Assert.assertNotEquals(actualResult, expectedResult);
    }
}
