package day08_homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class H01 extends TestBase {

    //Bir class olusturun: IframeOdev
    //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
    //sayfadaki toplam iframe sayısını bulunuz.
    //Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
    //Paragrafdaki yaziyi silelim
    //Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
    //Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim


    @Test
    public void test(){

        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        //sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframeler = driver.findElements(By.tagName("iframe"));
        System.out.println("iframelerin sayisi = " + iframeler.size());

        //Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
        String actual = driver.findElement(By.xpath("//*[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        String expected = "Editor";
        Assert.assertTrue(actual.contains(expected));

        //Paragrafdaki yaziyi silelim
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement textArea = driver.findElement(By.xpath("//*[@id='tinymce']"));
        textArea.clear();

        //Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
        textArea.sendKeys("iframein icindeyim");

        //Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();

        String actualText = driver.findElement(By.linkText("Elemental Selenium")).getText();
        String expectedText = "Elemental Selenium";
        Assert.assertEquals(expectedText,actualText);
    }


}
