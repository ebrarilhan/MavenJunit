package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions4 extends TestBase {

    //Class: Action4
    //Method: dragAndDropTest
    //Given user is on https://jqueryui.com/droppable/
    //And user moves the target element(Drag me to my target) in to  destination(Drop here)
    //yani surukleyip birakmamizi istiyor.


    @Test
    public void dragAndDropTest() {
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0); //asagidakiler iframe icinde old icin
        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement hedef = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(kaynak,hedef).perform();
    }


    //2. YOL:
    @Test
    public void clickAndHoldTest() {
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement hedef = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.
                clickAndHold(kaynak).//kaynagi tut
                moveToElement(hedef).//hedefe koy
                build().//onceki methodlarin iliskisini kur/guclendir.
                //bunun kullanilmasi sart degildir ancak tercih ve tavsiye edilir.
                perform();//islemi gerceklestir
    }


    //3 YOL: ozel koordinatlara surukleme
    @Test
    public void moveByOffsetTest() {
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.
                clickAndHold(kaynak).//kaynagi tut
                moveByOffset(430,30).
                release().//kaynagi birak
                build().
                perform();
    }
}
