package addbasket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagebase.PageBase;


public class AddBasket extends PageBase {

    // sayfada yapacağımız işlemlerin locaterlarını buraya yazıyoruz.
    public static By sepeteekle = By.xpath("//div[@class=\"add-to-basket-button-text\"]");
    public static By klksynekletxt =By.xpath("//span[contains(text(),'Koleksiyona Ekle')]");


    public WebDriverWait wait ;
    public AddBasket(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);
    }

    public AddBasket addBasketMethod() throws InterruptedException {

        Thread.sleep(2000);
        click(sepeteekle);
        Thread.sleep(2000);

        return this;

    }

    public AddBasket controlToProductPage(String value) throws InterruptedException {

        controlMethod(value,klksynekletxt);
        Thread.sleep(2000);

        return this;
    }


}
