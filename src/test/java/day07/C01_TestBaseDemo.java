package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    /*
    UTILITIES:
    - Utilities tekrar tekrar kullanacagimiz methodlari veya classlari koydugumuz paketin adidir.
        - TestBase -> BUGUN
        - Driver -> Sonra ogrenecegiz...
        - ExcelUtil -> Sonra...
        - Configuration -> Sonra...

     -Utilities paketinde Test caseler yazilmaz.
     -Sadece tekrar kullanilabilecek destek siniflari (support class) olusturulur.
     -Bu support classlar test caselerin yazilmasini hizlandirir.

     */

    @Test
    public void test01(){
//        techproeducation anasayfasina git ve title in Bootcamps kelimesini icerdigini test edelim.
        driver.get("https://www.techproeducation.com");
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Bootcamps"));
    }

}
