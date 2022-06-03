package gotobasket;

import addbasket.AddBasket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagebase.PageBase;

import java.util.TreeMap;

public class GoToBasket extends PageBase {

    // sayfada yapacağımız işlemlerin locaterlarını buraya yazıyoruz.
    public static By  sepetegit = By.cssSelector("i[class=\"i-bagg-orange hover-icon\"]");
    public static By  sptonay = By.cssSelector("div[class=\"pb-summary-box\"]");


    public WebDriverWait wait;

    public GoToBasket(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);
    }

    public GoToBasket goToBasketMethod() throws InterruptedException {

        click(sepetegit);
        Thread.sleep(2000);

        return  this;
    }

    public boolean controlToBasketPage(){

        return find(sptonay).isDisplayed();
    }
}
