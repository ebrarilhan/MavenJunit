package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_PromptAlert extends TestBase {

    @Test
    public void promptAlertTest() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //3. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(5000);

        // uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Ebrar");
        Thread.sleep(5000);

        // OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

        // ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();//"You entered: Ebrar"
        String expectedResult = "Ebrar";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
