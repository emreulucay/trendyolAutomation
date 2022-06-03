package deleteproduct;

import login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagebase.PageBase;

import java.util.List;

public class DeleteProduct extends PageBase {

    public static By sil = By.cssSelector("i[class=\"i-trash\"]");
    public static By silmekontrol = By.xpath("//span[contains(text(),'Sepetinde ürün bulunmamaktadır.')]");

    public WebDriverWait wait;

    public DeleteProduct(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    public DeleteProduct deleteProductMethod()throws InterruptedException{

        click(sil);
        List<WebElement> secondsil = driver.findElements(By.xpath("//button[contains(text(),\"Sil\")]"));
        secondsil.get(0).click();

        return this;

    }

    public DeleteProduct controlToDelete(String value) throws InterruptedException {
        Thread.sleep(2000);
        controlMethod(value, silmekontrol);
        Thread.sleep(2000);

        return this;
    }


}
