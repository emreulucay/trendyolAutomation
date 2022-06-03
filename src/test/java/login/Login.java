package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagebase.PageBase;

import static java.lang.Thread.sleep;

public class Login extends PageBase {

    // sayfada yapacağımız işlemlerin locaterlarını buraya yazıyoruz.
    public static By gender = By.xpath("//span[@class='homepage-popup-gender']");
    public static By grs = By.xpath("//p[contains(text(),'Giriş Yap')]");
    public static By email = By.xpath("//input[@id='login-email']");
    public static By password = By.xpath("//input[@id='login-password-input']");
    public static By grsyap = By.xpath("//button[@type='submit']");
    public static By cerez = By.xpath("//button[contains(text(),'KABUL ET')]");
    public static By grsonay = By.xpath("(//p[@class='link-text'])[1]");


    //web sayfasında işlemler yapılırken driver ın bekleme süresini ayarlar.

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    //test sınıfının test1 fonksiyonundan gelen url değerini alıp, pageBase sınıfındaki pageOpen fonksiyonuna gönderir.
    public Login openPage(String value) {
        pageOpen(value);
        return this;
    }

    // Giriş yapılana kadar gerçekleşecek tüm adımları bu metodun içinde yazıyoruz.
    public Login loginMethod(String email1, String pass1) throws InterruptedException {
        Thread.sleep(4000);
        click(cerez);
        //click(gender);
        Thread.sleep(1000);
        click(grs);
        //hoverMenu(value);
        Thread.sleep(1000);
        sendKey(email, email1);
        Thread.sleep(1000);
        sendKey(password, pass1);
        Thread.sleep(1000);
        click(grsyap);
        return this;
    }

    public Login controlToApproval(String value) throws InterruptedException {
        Thread.sleep(2000);
        controlMethod(value, grsonay);
        Thread.sleep(2000);

        return this;
    }


}