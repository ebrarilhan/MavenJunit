package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    /*
    How do you find the number of iframe on a page? Bir sayfadaki toplan iframe sayisini basil buluruz?
    ***Iframe ler iframe tagi kullanılarak oluşturulur. Bu durumda find elements by frame locatorini kullanarak tum iframeleri bulurum
    ***driver.findElements(By.tagName(“iframe”));
    ***driver.findElements(By.xpath(“//iframe”));
    ————————————
    Explain how you can switch back from a main page? Tekrar ana sayfaya nasil donersin?
    ***2 farkli yol vardır.
    ***defaultContent yada parentFrame metotlarını kullarak gecis yapabiliriz.
    ———————————-
    What is the difference between defaultContent and parentFrame? defaultContent ve parentFrame arasindaki farklar nelerdi?
    *** Oncelikle her ikiside framein misina cikmamizi saglar. Ama defaultContent direk ana sayfaya atlatır, parentFrame ise bir üst seviyeye atlatir
    —————————————
    What might be the reason for your test case to fail?Bir test case in fail etme sebepleri neler olabilir?
    Yanlis locator. Cozum : Tekrar elementi locate etmek. Değişken element var ise ona gore dynamic bir xpath yazarız.
    Wait / Syncronization /Bekleme problemi: Cozum : implicit wait de yeterli sure oldugundan emin oluruz. O sureyi arttırabiliriz. 30 saniye verilebilir. Explicit wait kullanilabilir(sonra gorecegiz).
    Iframe. Cozum : switch to iframe
    Alert. Cozum : switch to alert
    New window(Yeni pencere) : switch to window

     */

    @Test
    public void iframeTest(){

        //https://testcenter.techproeducation.com/index.php?page=iframe sayfasina gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        String anaMetin = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).
                getText(); //burada nokta kullandik ama text() de kullanabilirdik. ayni islevi gorur.
        String expectedText = "black border";
        Assert.assertTrue(anaMetin.contains(expectedText));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim.

        //‘Applications lists’ elementi iframe in icindedir. Bu nedenle iframe switch yapmamiz sarttir.
        driver.switchTo().frame(0);// ilk iframe e gecis yaptigimiz icin indexi 0dir.
        String actualResult = driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
        String expectedResult = "Applications lists";
        Assert.assertEquals(expectedResult,actualResult);

//        Alternatif olarak altdaki secenekler de kullanilabilir
//        Assert.assertTrue(expectedText1.contains(icMetin));
//        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Applications lists']")).isDisplayed());

        //Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
        //driver hala iframin icinde oldugu icin oncelikle iframe disina cikmamiz gerekiyor.
        //bunun icin driver.switchTo().defaultContent(); veya parentFrame(); kullanabiliriz.

        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));

    }

}
