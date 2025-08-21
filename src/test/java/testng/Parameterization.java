package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
    public static  WebDriver driver;
    @Parameters({"browserName"})
    @BeforeTest
    public void prerequisit(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            driver= new ChromeDriver();
            driver.get("https://www.saucedemo.com/v1/");
        } else if( browserName.equalsIgnoreCase("firefox")){
            driver= new FirefoxDriver();
        }
        driver.manage().window().maximize();

    }
    @Parameters({"a","b"})
    @Test
    public void test(String a,String b) throws InterruptedException {
        //WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        //driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys(a);
        driver.findElement(By.id("password")).sendKeys(b);
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(3000);
        driver.close();
    }
}
