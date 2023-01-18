package day13;

import org.junit.Test;
import utilities.TestBase;

public class C05_WebDriverException extends TestBase {

    @Test
    public void webDriverExceptionTest() {
        /*
        WebDriverException
        When you close the browser, but still want to use that in correctly
        When the versions of the driver and browsers are not compatible

        Solution
        Your design should be good. We should use singleton Driver to prevent this exception
        Keep drivers up to date that is compatible with the  browser version

        WebDriver Exception
        Driver versiyonlari ve browser versiyonlari ayni veya yakin olmadiginda alinir.
        Driver(Browser) kapattiktan sonra tekrar kullanmak istediginiz durumlarda alinabilir.

        Solution:
        Framework designinin guzel kurulmuş olması gerekir, ornegin Driver sinifinda birden farza driver.quit() olmamali
         */
    }
}
