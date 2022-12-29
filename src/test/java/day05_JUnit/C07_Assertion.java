package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Assertion {

    /*
    assertTrue(True)--->Passed
    assertTrue(False)--->Failed

    assertFalse(False)--->Passed
    assertFalse(True)--->Failed
     */

    /*
    https://www.amazon.com adresine gidin
    Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    => Sayfa başlığının “amazon oldugunu test edin
    => amazon resminin görüntülendiğini (isDisplayed()) test edin
    Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    wrongTitleTest  => Sayfa basliginin “amazon” olmadigini dogrulayin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.amazon.com adresine gidin
        driver.get("https://www.amazon.com ");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


    @Test
    public void test01(){
        //=> Sayfa başlığının “amazon oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }


    @Test
    public void test02(){
        //=> amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement sayfaResmi = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(sayfaResmi.isDisplayed());
    }


    @Test
    public void test03(){
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());
    }


    @Test
    public void test04(){
        //wrongTitleTest  => Sayfa basliginin “amazon” olmadigini dogrulayin
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

}
