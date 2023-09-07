package Tests;

import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import Utility.BaseDriver;
import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class E_kitabSepeteEkleme extends BaseDriver {

    @Test
    public void Test_PromoCode() {
        driver.get("https://www.e-junkie.com/wiki/demo/paypal");
        WebElement addCard = driver.findElement(By.xpath("(//a[@class='btn'])[2]"));
        addCard.click();
        driver.switchTo().frame(0);
        WebElement promoCode = driver.findElement(By.xpath("//button[@class='Apply-Button Show-Promo-Code-Button']"));
        MyFunc.Wait(2);
        promoCode.click();
        WebElement inputPromoCode = driver.findElement(By.className("Promo-Code-Value"));
        inputPromoCode.sendKeys("123" + Keys.ENTER);
        WebElement invalid = driver.findElement(By.xpath("//span[contains(text(), 'Invalid promo code')]"));
        Assert.assertTrue(invalid.isDisplayed());

    }

    @Test
    public void Test_PayInvaild(){
        driver.get("https://www.e-junkie.com/wiki/demo/paypal");
        WebElement addCard = driver.findElement(By.xpath("(//a[@class='btn'])[2]"));
        addCard.click();
        driver.switchTo().frame(0);
        WebElement dibitCart = driver.findElement(By.cssSelector("button[data-option='CC']"));
        dibitCart.click();
        WebElement payBtn = driver.findElement(By.className("Pay-Button"));
        payBtn.click();
        WebElement mej = driver.findElement(By.id("SnackBar"));
        Assert.assertTrue("uyri ayni anda gozkmedi",mej.isDisplayed());
    }
}
