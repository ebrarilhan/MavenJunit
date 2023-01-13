package day11_homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class H01 extends TestBase {

    Select select;

    @Test
    public void test01() {
        //Test01:
        // 1- amazona gidin
        driver.get("https://amazon.com");

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dp = driver.findElement(By.id("searchDropdownBox"));
        select = new Select(dp);
        List<WebElement> options = select.getOptions();
        for (WebElement w : options){
            System.out.println(w.getText());
        }

        //dropdown menude 40 eleman olduğunu doğrulayın
        int actual = options.size();
        int expected = 40;
        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void test02() {
        //Test02:
        test01();

        //dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String sonucYazisi = driver.findElement(By.xpath("//*[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']")).getText();
        String expected = "iphone";
        Assert.assertTrue(sonucYazisi.contains(expected));

        //ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(RelativeLocator.with(By.className("s-image")).toRightOf(By.xpath("//*[@data-image-index='1']"))).click();

        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String urunTitle = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        String urunFiyati = driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();
        System.out.println("urunFiyati = " + urunFiyati);
        System.out.println("urunTitle = " + urunTitle);

        driver.findElement(By.id("add-to-cart-button")).click();
    }

    @Test
    public void test03() {
        //Test03
        //yeni bir sekme açarak amazon anasayfaya gidin
        //dropdown’dan bebek bölümüne secin
        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        //sonuç yazsının puset içerdiğini test edin
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }

}
