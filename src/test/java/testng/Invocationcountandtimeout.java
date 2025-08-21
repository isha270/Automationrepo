package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Invocationcountandtimeout {
    @Test(invocationCount = 2)
    public void test1() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.close();

    }
    @Test(invocationCount = 3,invocationTimeOut = 1000)
    public void test2() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        //Thread.sleep(3000);
        driver.close();

    }
}
