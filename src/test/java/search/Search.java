package search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagebase.PageBase;

public class Search extends PageBase {

    // sayfada yapacağımız işlemlerin locaterlarını buraya yazıyoruz.
    public static By searchtext = By.className("search-box");
    public static By ara = By.className("search-icon");
    public static By aramaonay = By.xpath("//h1[contains(text(),'samsung akıllı cep telefonu')]");
    public static By renkgec = By.cssSelector("div[class=\"popup-heading\"]");

    public WebDriverWait wait ;
    public Search(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);
    }

    public Search searchMethod(String arama1) throws InterruptedException{

        sendKey(searchtext,arama1);
        Thread.sleep(2000);
        click(ara);
        Thread.sleep(2000);
        //click(renkgec);
        Thread.sleep(2000);

        return this;

    }

    public Search controlToSearch(String value) throws InterruptedException {

        controlMethod(value,aramaonay);
        Thread.sleep(2000);

        return this;
    }

}
