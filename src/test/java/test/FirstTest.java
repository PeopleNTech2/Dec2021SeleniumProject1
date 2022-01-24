package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "/Users/nacer-zimu/IdeaProjects/Dec2021SeleniumProject1/src/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

    }
    @Test
    public void test1() throws InterruptedException {
        String expectedTitle = "Amazon. Spend less. Smile more.";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "title validation success");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book");
        driver.findElement(By.id("nav-search-submit-button")).click();
    }
    @Test
    public void test2(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("selenium book");
        driver.findElement(By.id("nav-search-submit-button")).click();
    }
    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
