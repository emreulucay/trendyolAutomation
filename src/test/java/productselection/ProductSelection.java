package productselection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagebase.PageBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProductSelection extends PageBase {

    // sayfada yapacağımız işlemlerin locaterlarını buraya yazıyoruz.
    //public static By secim = By.xpath(" //span[contains(text(),'Galaxy M12 128GB Siyah Cep Telefonu (Samsung Türki')]");


    public WebDriverWait wait;

    public ProductSelection(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);
    }


    public ProductSelection productSelectionMethod() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"image-overlay-header\"]"));
        elements.get(1).click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Thread.sleep(2000);
/**
 *      public void returnSelectedTab(Integer sekme) {
 *         Set<String> allWindows = driver.getWindowHandles();
 *         Iterator<String> i = allWindows.iterator();
 *         ArrayList<String> tabName = new ArrayList();
 *         while (i.hasNext()) {
 *             String childwindow = (String) i.next();
 *             tabName.add(childwindow);
 *         }
 *         driver.switchTo().window((String) tabName.get(sekme - 1));
 *     }
 */

        return this;

    }
}
