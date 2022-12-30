package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle01 extends TestBase {


    @Test
    public void handleWindowTest() throws InterruptedException {

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //once ilk sayfanin id sini alalim.
        String window1Handle = driver.getWindowHandle();

        //Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        String window1Text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",window1Text);

        //Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        String window1Title = driver.getTitle();
        Assert.assertEquals("The Internet",window1Title);

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);

        //BU NOKTADA 2 PENCERE DE ACIKTIR. VE BEN IKINCISINE GECIS YAPMAK ISTIYORUM.
        //bunun icin driver.getWindowHandles(); ile tum pencerelerin idlerini alirim
        Set<String> allWindowHandles = driver.getWindowHandles();//{window1Handle, window2Handle}
        System.out.println(allWindowHandles);
        for (String eachHandle : allWindowHandles){
            if (!eachHandle.equals(window1Handle)){
                driver.switchTo().window(eachHandle);
                break;
            }
        }

        //artik bu noktada driver 2. pencerededir.

        //Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
        String window2Title = driver.getTitle();
        Assert.assertEquals("New Window",window2Title);

        //Sayfadaki textin "New Window" olduğunu doğrulayın.
        String window2Text = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("New Window",window2Text);

        //ikinci sayfadayken onun da idsini aliyorumlazim olur belki diye
        String window2Handle = driver.getWindowHandle();

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın.
        Thread.sleep(3000);
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet",window1Title);

        //2. windowa tekrar gecelim.
        driver.switchTo().window(window2Handle);
        Thread.sleep(3000);

        //1. windowa tekrar gecelim.
        driver.switchTo().window(window1Handle);

    }





}
