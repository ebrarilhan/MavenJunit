package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    //Class : FileExistTest
    //Method : isExist
    //Masa ustunden bir dosyanın varligini test et

    @Test
    public void isExistTest(){
        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);
        //C:\Users\vysl\IdeaProjects\B103Maven_Junit

        String userHOME = System.getProperty("user.home");
        System.out.println(userHOME);
        //C:\Users\vysl

        //logo.jpeg indirip masaustune kaydedelim.
        //logo dosyasi su an masaustunde : \Users\vysl\Masaüstü
//        String dosyaYolu = userHOME + "/Desktop/logo.jpeg";

//        //windowslar icin asagidaki gibi de kabul edebilir.
//        String dosyaYolu = userHOME + "\\Desktop\\logo.jpeg";

//        System.out.println(dosyaYolu);
//
//        boolean isExists = Files.exists(Paths.get(dosyaYolu));//dosya var ise true, yok ise false return eder.
//        Assert.assertTrue(isExists);

        /*
        1. fail -> PATH YANLIS : dosya masa ustunde degil, dosya adi yanlis, yada arada onedrive gibi ex dosyalar olarak
         */



        //bende onedrive nedeniyle su sekilde kabul ediyor.
        //C:\Users\vysl\OneDrive\Masaüstü\logo.jpeg

        String benimYolum = userHOME+"\\OneDrive\\Masaüstü\\logo.jpeg";
        Assert.assertTrue(Files.exists(Paths.get(benimYolum)));



    }
}
