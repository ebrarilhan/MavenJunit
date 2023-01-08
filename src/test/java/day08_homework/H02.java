package day08_homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class H02 extends TestBase {

    //https://testcenter.techproeducation.com/index.php?page=multiple-windows
    //Title in ‘Windows’ oldugunu test edin
    //Click here a tiklayin
    //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin

    @Test
    public void test(){

        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        //Title in ‘Windows’ oldugunu test edin
        System.out.println("driver.getTitle() = " + driver.getTitle());
        Assert.assertEquals("Windows",driver.getTitle());

        //Click here a tiklayin
        driver.findElement(By.linkText("Click Here")).click();

        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));

        System.out.println("driver.getTitle() = " + driver.getTitle());
        Assert.assertEquals("New Window",driver.getTitle());

    }

}
