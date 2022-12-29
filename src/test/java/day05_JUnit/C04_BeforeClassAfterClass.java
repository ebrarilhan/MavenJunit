package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {

    /*
        @BeforeClass ve @AfterClass notasyonlari sadece static methodlar icin calisir.
    @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test methodlarinin hepsini ayni anda
    calistirip en son @AfterClass'i calistiririz.
        Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After'i kullanir.
     */

    @BeforeClass
    public static void setUp(){
        System.out.println("Butun Test Methodlarindan Once Calisti.");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Butun Test Methotlarindan Sonra Calisti.");
    }

    @Before
    public void setUp01(){
        System.out.println("Her Test Methodundan Once Calisir.");
    }

    @After
    public void tearDown01(){
        System.out.println("Her Test Methodundan Sonra Calisir.");
    }

    @Test
    public void test01(){
        System.out.println("Ilk Test");
    }

    @Test
    public void test02(){
        System.out.println("Ikinci Test");
    }

    @Test
    @Ignore // eger bir testi calistirmak istemezsek bu sekilde kullanabiliriz.
    public void test03(){
        System.out.println("Ucuncu Test");
    }

}
