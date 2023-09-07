package Tests;

import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import Utility.BaseDriver;
import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
    public void Test_PayInvaild() {
        driver.get("https://www.e-junkie.com/wiki/demo/paypal");
        WebElement addCard = driver.findElement(By.xpath("(//a[@class='btn'])[2]"));
        addCard.click();
        driver.switchTo().frame(0);
        WebElement dibitCart = driver.findElement(By.cssSelector("button[data-option='CC']"));
        dibitCart.click();
        WebElement payBtn = driver.findElement(By.className("Pay-Button"));
        payBtn.click();
        WebElement mej = driver.findElement(By.id("SnackBar"));
        Assert.assertTrue(mej.isDisplayed());
    }

    @Test
    public void Test_WithInvaildCard() {
        driver.get("https://www.e-junkie.com/wiki/demo/paypal");
        WebElement addCard = driver.findElement(By.xpath("(//a[@class='btn'])[2]"));
        addCard.click();
        driver.switchTo().frame(0);
        WebElement dibitCart = driver.findElement(By.cssSelector("button[data-option='CC']"));
        dibitCart.click();
        WebElement email = driver.findElement(By.cssSelector("[placeholder='Email']"));
        email.sendKeys("asdf@gmail.com");
        WebElement confirm_email = driver.findElement(By.cssSelector("[placeholder='Confirm Email']"));
        confirm_email.sendKeys("asdf@gmail.com");
        WebElement name = driver.findElement(By.cssSelector("[placeholder='Name On Card']"));
        name.sendKeys("ahmet");
        WebElement optional = driver.findElement(By.cssSelector("[placeholder='Optional']"));
        optional.sendKeys("12345678");
        WebElement addres1 = driver.findElement(By.cssSelector("[placeholder='Address Line 1']"));
        addres1.sendKeys("istanbul");
        WebElement addres2 = driver.findElement(By.cssSelector("[autocomplete='address-2']"));
        addres2.sendKeys("istanbul");
        WebElement city = driver.findElement(By.cssSelector("[placeholder='City']"));
        city.sendKeys("istanbul");
        WebElement select = driver.findElement(By.cssSelector("[autocomplete='state']"));
        Select menu = new Select(select);
        menu.selectByValue("AZ");
        WebElement postKodu = driver.findElement(By.cssSelector("[placeholder='ZIP/Postal Code']"));
        postKodu.sendKeys("49856");
        WebElement text = driver.findElement(By.xpath("//textarea[@type='text']"));
        text.sendKeys("kitab");
        WebElement cardNum = driver.findElement(By.cssSelector("[autocomplete='cc-number']"));
        cardNum.sendKeys("4544545454545454");
        WebElement cardvalued = driver.findElement(By.cssSelector("[autocomplete='cc-exp']"));
        cardvalued.sendKeys("0225");
        WebElement csc = driver.findElement(By.cssSelector("[autocomplete='cc-csc']"));
        csc.sendKeys("122");
        WebElement payBtn = driver.findElement(By.className("Pay-Button"));
        payBtn.click();
        WebElement mej = driver.findElement(By.xpath("//span[text()='The credit card number is invalid.']"));
        Assert.assertTrue(mej.isDisplayed());
    }

    @Test
    public void Test_Succesful_Payment(){
        driver.get("https://www.e-junkie.com/wiki/demo/paypal");
        WebElement addCard = driver.findElement(By.xpath("(//a[@class='btn'])[2]"));
        addCard.click();
        driver.switchTo().frame(0);
        WebElement dibitCart = driver.findElement(By.cssSelector("button[data-option='CC']"));
        dibitCart.click();
        WebElement email = driver.findElement(By.cssSelector("[placeholder='Email']"));
        email.sendKeys("asdf@gmail.com");
        WebElement confirm_email = driver.findElement(By.cssSelector("[placeholder='Confirm Email']"));
        confirm_email.sendKeys("asdf@gmail.com");
        WebElement name = driver.findElement(By.cssSelector("[placeholder='Name On Card']"));
        name.sendKeys("ahmet");
        WebElement optional = driver.findElement(By.cssSelector("[placeholder='Optional']"));
        optional.sendKeys("12345678");
        WebElement addres1 = driver.findElement(By.cssSelector("[placeholder='Address Line 1']"));
        addres1.sendKeys("istanbul");
        WebElement addres2 = driver.findElement(By.cssSelector("[autocomplete='address-2']"));
        addres2.sendKeys("istanbul");
        WebElement city = driver.findElement(By.cssSelector("[placeholder='City']"));
        city.sendKeys("istanbul");
        WebElement select = driver.findElement(By.cssSelector("[autocomplete='state']"));
        Select menu = new Select(select);
        menu.selectByValue("AZ");
        WebElement postKodu = driver.findElement(By.cssSelector("[placeholder='ZIP/Postal Code']"));
        postKodu.sendKeys("49856");
        WebElement text = driver.findElement(By.xpath("//textarea[@type='text']"));
        text.sendKeys("kitab");
        WebElement cardNum = driver.findElement(By.cssSelector("[autocomplete='cc-number']"));
        cardNum.sendKeys("4242 4242 4242 4242");
        WebElement cardvalued = driver.findElement(By.cssSelector("[autocomplete='cc-exp']"));
        cardvalued.sendKeys("1223");
        WebElement csc = driver.findElement(By.cssSelector("[autocomplete='cc-csc']"));
        csc.sendKeys("000");
        WebElement payBtn = driver.findElement(By.className("Pay-Button"));
        payBtn.click();
        WebElement mej = driver.findElement(By.xpath("//span[text()=' your order is confirmed. Thank you!']"));
        Assert.assertTrue(mej.isDisplayed());
    }

    @Test
    public void Test_ContactUs(){
        driver.get("https://www.e-junkie.com/wiki/demo/paypal");
        WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
        contactUs.click();
        WebElement contacName = driver.findElement(By.id("contact_name"));
        contacName.sendKeys("alim");
        WebElement contacEmail = driver.findElement(By.id("contact_email"));
        contacEmail.sendKeys("alim@gmail.com");
        WebElement send = driver.findElement(By.xpath("//button[text()='Send']"));
        send.click();
        WebElement mesj = driver.findElement(By.xpath("//div[text()='Sorry, failed to send message']"));
        System.out.println(mesj.getText());
        Assert.assertTrue(mesj.isDisplayed());
    }
}
