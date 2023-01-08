package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {

    //    3 yeni window ac ve title larini verify et
//    3 yeni tab ac ve title larini verify et

    @Test
    public void newWindowHandleTest() {

        //TechproEducation sayfasinin titlenin "Techpro Education" metnini icerdigini test edin
        driver.get("https://www.techproeducation.com");
        String techproHandle = driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        waitFor(3);

        //Yeni bir pencerede Amazon sayfasini acip titlenin "Amazon" metnini icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);//-Yeni pencere olusturur / - Oraya gecis yapar
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //Yeni bir pencerede Linkedin sayfasini acip titlenin "LinkedIn" metnini icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);//-Yeni pencere olusturur / - Oraya gecis yapar
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        waitFor(3);
        //DRIVER SUAN LINKEDINDE

        //TECHPRO SAYFASINA GITMEK ICIN TEKRAR
        //ASAGIDAKI KODU YAZMALIYIZ
        driver.switchTo().window(techproHandle);
        //DRIVER TECHPRODA
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
    }
}
