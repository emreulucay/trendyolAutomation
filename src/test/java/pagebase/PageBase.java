package pagebase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testsuites.BaseTest;

public class PageBase extends BaseTest {


    public PageBase pageOpen(String value) {
        driver.get(value);
        return this;
    }

    public PageBase info(String value) {
        System.out.println(value);
        return this;
    }

    public PageBase click(By by) {
        findElement(by).click();
        return this;
    }

    public PageBase sendKey(By by, String value){
        findElement(by).sendKeys(value);
        return this;
    }

    public WebElement find(By Locator){
        return driver.findElement(Locator);
    }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public PageBase controlMethod(String value, By by)  {
        WebElement element = findElement(by);
        Assert.assertEquals(element.getText(),value);
        info("Sayfa onaylandı: " + element.getText());
        return this;
    }
    public WebElement findElement(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        WebElement webElement = webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated(by));
        webDriverWait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                webElement);
        return webElement;
    }
}