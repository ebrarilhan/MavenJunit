package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    //testbase i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum.
    //TestBase testBase = new TestBase(): --> YAPILAMAZ>
    //amacim bu sinifi extend etmek ve icindeki hazir methodlari kullanmak.


    // driver objesini olustur. driver ya public ya da protected olmalidir. sebebi ise child classlarda
    //gorulebilir olmasidir.
    protected static WebDriver driver;

    //setUp
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //tearDown
    @After
    public void tearDown(){
        driver.quit();
    }

}
