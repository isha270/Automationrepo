package testng;

import iRetryAnalyzer.rerunFailedTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

public class assertion {
    @Test(retryAnalyzer = rerunFailedTestCases.class)
    public void Test1() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        WebElement e= driver.findElement(By.xpath("//div[@class='login_logo']"));
        Assert.assertEquals(e.getText(),"abz");
      /*  Thread.sleep(3000);
        driver.close();*/
    }
}
