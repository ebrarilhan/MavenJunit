package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions5 extends TestBase {

    //Create a class: Action5
    //Create a method keyboardActions

    //Google a gidin https://www.google.com
    //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
    //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
    //Ve ENTER tusuna bas

    @Test
    public void keyboardActionsTest(){
        driver.get("https://www.google.com");

        //cerezleri kabul ediyorum.
        driver.findElement(By.xpath("//*[text()='Alles accepteren']")).click();

        WebElement aramaKutusu = driver.findElement(By.name("q"));

//        aramaKutusu.sendKeys("iphone x fiyatlari"
//                + Keys.ENTER);

        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu,Keys.SHIFT). //arama kutusunun ustundeyken shift tusuna bas
                sendKeys("iphone x fiyatlari"). //shifte basiliyken yazi yaz
                keyUp(aramaKutusu,Keys.SHIFT). //shift tusuna basmayi birak
                sendKeys(" cok pahali!" + Keys.ENTER). //yaziyi yaz ve entera bas
                build(). //birden fazla actions kullanacagimiz zaman yazmamiz oneriir
                perform();
    }

}
