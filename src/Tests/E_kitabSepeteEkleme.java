package Tests;
import org.junit.Assert;
import org.junit.Test;
import Utility.BaseDriver;
import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class E_kitabSepeteEkleme extends BaseDriver {

    @Test
    public void Test_PromoCode(){
        driver.get("https://www.e-junkie.com/wiki/demo/paypal");
        WebElement addCard = driver.findElement(By.linkText("Add to Cart"));
        addCard.click();
        WebElement promoCode = driver.findElement(By.linkText("Add Promo Code"));
        promoCode.click();
        WebElement inputPromoCode = driver.findElement(By.className("Promo-Code-Value"));
        inputPromoCode.sendKeys("123" + Keys.ENTER);
        WebElement invalid = driver.findElement(By.cssSelector("[id='SnackBar']>span"));
        Assert.assertTrue(invalid.getText().contains("Invaid promo code"));

    }
}
