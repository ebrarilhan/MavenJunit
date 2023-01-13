package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    /*
    TimeOutException:
    Explicit wait kullanildiginda, ve element bulunamadiginda alinir.
    Explicit wait & yanlis locator-> timeout
    Explicit wait & doğru locator & sure yeterli degil -> timeout
    Explicit wait & dogru locator & sure yeterli & iframe var ->  time out

    Solution:
    -Sureyi arttirmak
    -Farkli explicit kullanmak: wait visibilityOfElementLocated YERINE presenceOfElementLocated. Yada javascript executor da ki waiter sayfa geçişlerini beklemek icin kullanabilirim
    -Locatori tekrar kontrol etmek
    -Frameworkunde hazir reusable method lar var Bu durumda timeoutexception aldigimda hızlıca o metotlar yardımıyla problemi cozebiliyoruz
     */

    /*
    ENGELS:
    TimeOutException:
    If you use explicit wait and wait time is not enough/locator still incorrect then TimeOutException
    Simply put, wait time is over but the commend is not completed

    Solution:
    -Increase the wait time
    -Try using different wait. For example try using javascript executor wait for the page to load. This is also a dynamic wait
    -I have different explicit waits in my Reusable util class. I have javascript executor wait as well. ReusableMethods.waitForPageToLoad(1);
    -Case by case, I prefer different explicit waits to maximize the performance of the automation script
     */


    //TimeOutException explicit wait kullandimda ve locator bulunamadiginda alirim

    @Test
    public void timeOutExceptionTest(){
        driver.get("https://www.techproeducation.com");
//        Explit wait icin olusturdugumuz methodlardan birini kullanalim
//        Parametre 1: beklemek istedigim element, Parametre 2: Max sure
//        waitForVisibility(By.xpath("//input[@type='searchh']"),25)//org.openqa.selenium.TimeoutException:
//                .sendKeys("QA"+ Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS ID")));//org.openqa.selenium.TimeoutException:
    }


}
