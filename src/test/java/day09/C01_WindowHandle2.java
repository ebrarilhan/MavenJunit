package day09;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase{


    @Test
    public void windowHandleTest() {

//        https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String window1Handle = driver.getWindowHandle();

//        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualWindows1Text = driver.findElement(By.xpath("//*[.='Opening a new window']")).getText();
        String expectedWindows1Text = "Opening a new window";
        Assert.assertEquals(expectedWindows1Text, actualWindows1Text);

//        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualWindowTitle = driver.getTitle();
        String expectedWindowTitle = "The Internet";
        Assert.assertEquals(expectedWindowTitle, actualWindowTitle);

//        Click Here butonuna basın.
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        // driver.findElement(By.linkText("Click Here")).click();//Alternatif
        waitFor(3);

        //IKINCI PENCERE ACILIR VE IKINCI PENCEREDE ISLEM YAPMAK ISTEDIGIMDEN O PENCEREYE GECIS YAPMALIYIZ

//        Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        switchToWindow(1);//driver artik ikinci pencerede
        String actualNewWindowTitle = driver.getTitle();
        String expectedNewWindowTitle = "New Window";
        Assert.assertEquals(expectedNewWindowTitle, actualNewWindowTitle);
    }
}
