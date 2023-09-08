package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;
    // her zaman ilk basta calisiyor , cagirlmasina gerek yok
    static{
        driver = new ChromeDriver();
        // sayfa tam aclimasina 20 saniye bekle
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        // elmantlari arama icin 20 saniye bekliyor
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    public static void bekleVeKapat(){
        MyFunc.Wait(5);
        driver.quit();
    }
}
