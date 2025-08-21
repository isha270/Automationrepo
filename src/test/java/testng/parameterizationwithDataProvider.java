package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class parameterizationwithDataProvider {
    @DataProvider(name = "test-data")
    public Object[][] data(){
        return new Object[][]{
                {"standard_user","secret_sauce" }
        };
    }
    @Test(dataProvider="test-data")
    public void test(String a,String b) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys(a);
        driver.findElement(By.id("password")).sendKeys(b);
        driver.findElement(By.id("login-button")).click();


    }
}
