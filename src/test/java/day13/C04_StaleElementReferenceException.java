package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {

    /*
    ENGELS
    Stale Element means the element is no longer fresh. It is old and no longer available
    When the element is no longer fresh on the page and you try to use it
    When the element is detached from the DOM
    When the element is removed after session started

    Solution:
    Relocate the same element again. You can use a new variable name as well.
    Example:
     */

    /*
    Stale Element = eski, kullanılamaz durumda, kullanım artık elverişli degil
    -Sayfayi yenilediğinizde (refresh())
    -Sayfada ileri geri gittimizde

    COZUM:
    Elementi tekrar bulmak
     */



    @Test
    public void staleElementReferenceExceptionTest1() {
        driver.get("https://www.techproeducation.com");

        //LMS LOGIN linkine tiklayin
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLoginLink.click();

        //Sayfanin URL'inin "lms" icerdigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));

        //Tekrar anasayfaya gelin ve "LMS LOGIN" sayfasina tekrar gidin.
        driver.navigate().back();
        lmsLoginLink.click();//org.openqa.selenium.StaleElementReferenceException:

        //lsmLoginLink linkini sayfa yenilendikten sonra kullandigimiz icin exception aldik
    }
    @Test
    public void staleElementReferenceExceptionTest2() {
        driver.get("https://www.techproeducation.com");

        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));

        lmsLoginLink.click();

        driver.navigate().refresh();

        lmsLoginLink.click();
    }
}
