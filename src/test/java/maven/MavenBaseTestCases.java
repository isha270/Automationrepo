package maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenBaseTestCases {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.close();

    }
}
