package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions2 extends TestBase {

    //Class: Actions2
    //Method : hoverOver() and test the following scenario:
    //Amazon a gidelim https://www.amazon.com/
    //Sag ust bolumde bulunan “Account & Lists” menüsüne git
    //“Account” secenegine tikka
    //Acilan sayfanin Title in “Your Account” icerdigini dogrula

    @Test
    public void hoverOverTest(){

        /*
        MANUAL:
        1. Amazon home sayfasina git
        2. Account & list e uzerinde bekle -mouse over veya hover over
        3.Acilan pencerede Account linkine tokla
        4.Acilan sayfanin Title inin, Your Account oldugunu dogrula
         */

        //1.
        driver.get("https://www.amazon.com/");

        //2.
        Actions actions = new Actions(driver);
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        waitFor(1);
        actions.moveToElement(accountList).perform();
        waitFor(3);

        //3.
        driver.findElement(By.xpath("//*[text()='Account']")).click();

        //4.
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
}
