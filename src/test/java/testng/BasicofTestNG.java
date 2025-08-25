package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BasicofTestNG {
    @Test
    public void Test1() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.close();
       
    }

}
