package testng;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class dataProviderusingexcel {
    @DataProvider(name = "test-data")
    public Object[][] data() throws IOException {
        Object[][] arrayObject=getexceldata("C:\\Users\\test.xlsx","2024-09-25");
        return arrayObject;
    }
    public static Object[][] getexceldata(String s, String sheetName) throws IOException {
        FileInputStream f= new FileInputStream(s);
        Workbook wb= new XSSFWorkbook(f);
        Sheet sh=wb.getSheet(sheetName);
        int rows=sh.getPhysicalNumberOfRows();
        int cols=sh.getRow(0).getLastCellNum();
        Object[][] data= new Object[rows-1][cols];
        for(int i=1;i<rows;i++){
            Row r=sh.getRow(i);
            for(int j=0;j<cols;j++){
                Cell c=r.getCell(j);
                data[i-1][j]=c.toString();

            }
        }
        return data;


    }

    @Test(dataProvider = "test-data")
    public void test(String a, String b) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys(a);
        driver.findElement(By.id("password")).sendKeys(b);
        driver.findElement(By.id("login-button")).click();


    }
}
