package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {


    WebDriver driver;

    //eger test sinifinda birden fazla method olusturulmussa before kullanilir.
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest(){
        //Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10
        //YIL ICIN:

        //1. Locate dropdown element.
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

        //2. Select objesi olustur.
        Select selectYear = new Select(year);

        //3. Select objesini kullanarak uc farkli sekilde secim yapabilirim
        selectYear.selectByIndex(22); //secenek sirasi 0'dan baslar. 0 ilk elementi alir. 2000 yili 23. sirada
        //o yuzden 22 yazdik

        //AY ICIN:
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("0");//option'in value degeri ile secim yapilabilir.
        //January icin value degeri 0'dir. bu, degeri string icinde kabul eder.

        //GUN ICIN:
        WebElement day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);
        selectDay.selectByVisibleText("10"); //case sensitive'dir. yani buyuk kucuk harf onemlidir.
        //direkt girmek istedigimiz degeri string olarak yazariz. ne istiyorsak onun gorunumunu yazariz.

    }


    @Test
    public void printAllTest(){
        //Tum eyalet isimlerini konsola yazdiralim.
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        List<WebElement> states = stateDropdown.getOptions();

        for (WebElement eachState: states){
            System.out.println(eachState.getText());
        }

        //2. yol lambda ile:
        states.stream().forEach(t-> System.out.println(t.getText()));

    }

    @Test
    public void getSelectedOptionsTest(){
        //State dropdownindaki varsayilan secili secenegin "Select a State" oldugunu verify edelim.
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        String varsayilanText = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State",varsayilanText);
    }

    @After
    public void tearDown(){
      driver.close();
    }



    /*
    1. What is dropdown? Dropdown nedir?
    Dropdown liste olusturmak icin kullanilir.

    2. How to handle dropdown elements? Dropdown nasil automate edilir?
    -Dropdown'i locate ederim.
    -Select objesi olustururum.
    -Select objesi ile istedigim secenegi secerim.
    NOT: Select objesi olusturma nedenim, dropdownlarin Select classi ile olusturulmasidir.

    3. Tum dropdown seceneklerini nasil print ederiz?
    -Tum dropdown elementlerini getOptions() methodu ile listeye koyariz.
    -Sonra secenekleri loop ile yazdirabiliriz.

    4.Bir secenegin secili oldugunu otomate etmek icin ne yapilir?
    Ornek: Gun olarak 10'u sectik ama ya secilmediyse?
    getFirstSelectedOption() methodu secili olan secenegi return eder.

     */






}
