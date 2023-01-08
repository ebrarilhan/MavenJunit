package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;
import java.util.Set;

public class C04_Cookies extends TestBase{

    @Test
    public void handleCookiesTest() {

//        Class: Cookies
//        Method: handleCookies
//        Amazona git
        driver.get("https://www.amazon.com");

//        1.toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies();//toplam cerez sayisi
        int cookieSayisi = allCookies.size();
        System.out.println("Sayfada " + cookieSayisi + "adet cookie var ");

//        3. Bir Cookie yi ismiyle bul
        System.out.println("COOKIEYI ISMIYLE CAGIRIYORUM : " +driver.manage().getCookieNamed("i18n-prefs"));

        //tum cerezleri yazdiralim
        // allCookies.stream().forEach(t-> System.out.println(t.getName()));-----LAMBDA
        for (Cookie eachCookie : allCookies) {
            System.out.println("COOKIE  :" + eachCookie);//COOKIE'NIN TAMAMINI YAZDIK
            System.out.println("COOKIE ISIMLERI : " + eachCookie.getName());//
        }

        //4. Yeni bir cookie ekle
        Cookie favoriCookiem = new Cookie("canim cikolatam be","frambuazli-Cikolata");//COOKIE OLUSTU
        driver.manage().addCookie(favoriCookiem);
        waitFor(3);
        System.out.println("Yeni Cookie Sayisi : "+driver.manage().getCookies().size());

//        5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id");

//        6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        System.out.println("Cookie Sayisi : "+driver.manage().getCookies().size());
    }
}
