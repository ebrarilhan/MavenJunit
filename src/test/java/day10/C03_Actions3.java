package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions3 extends TestBase {

    //Class: ActionClass3
    //Method : scrollUpDown()
    //https://techproeducation.com a git
    //Sayfanin altına doğru gidelim
    //Sonra sayfanın üstüne doğru gidelim

    @Test
    public void scrollUpDown(){
        //1.
        driver.get("https://techproeducation.com");

        //2. asagi inme
        Actions actions = new Actions(driver);

//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //2. yol:
        waitFor(3);
        actions
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();

        waitFor(3);
        //3. yol: arrow down page down'dan daha az mesafe aldirir.
        actions
                .sendKeys(Keys.ARROW_DOWN).perform();
        waitFor(3);

        //3. yukari cikma
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(3);
        //veya
        actions.sendKeys(Keys.ARROW_UP).perform();
        waitFor(3);


        // NOT: sag sol icin de :
//        actions.sendKeys(Keys.ARROW_RIGHT).perform();
//        actions.sendKeys(Keys.ARROW_LEFT).perform();

    }

}
