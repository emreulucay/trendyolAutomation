package testsuites;

import addbasket.AddBasket;
import deleteproduct.DeleteProduct;
import gotobasket.GoToBasket;
import login.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import productselection.ProductSelection;
import search.Search;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    // global olarak webdriver tipinde driver tanımı yapıldı ve url tanımlandı.
    public WebDriver driver;
    public static String URL = "https://www.trendyol.com/";
    private Assert Assertions;

    // oluşturulan driver ın chrome driver olacağı belirlendi, bu metodla ilk başta chromedriver ın çalıştırılması sağlanır.
    @BeforeSuite
    public void beforeSuite() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 2);
        chromePrefs.put("profile.default_content_settings.javascript", 1);
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
        chromePrefs.put("safebrowsing.enabled", true);
        chromePrefs.put("network.cookie.cookieBehavior", 2);

        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        //options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("detach", false);
        options.setExperimentalOption("prefs", chromePrefs);

        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        //options.setCapability("enableVNC", true);
        //options.setCapability("version", "67.0");

        options.addArguments("disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--test-type");
        options.addArguments("--disable-extensions");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--enable-javascript");
        options.addArguments("--start-maximized");
        options.merge(options);
        this.driver = new ChromeDriver(options);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {
        Login login = new Login(driver);
        String email = "emreulucay04@outlook.com";
        String pass = "Qwerty123456";
        login
                .openPage(URL)
                .loginMethod(email, pass)
                .controlToApproval("Hesabım");
    }

    @Test
    public void test2() throws InterruptedException {
        Search search = new Search(driver);
        String arama = "samsung akıllı cep telefonu";
        search
                .searchMethod(arama)
                .controlToSearch(arama);
    }

    @Test
    public void test3() throws InterruptedException {
        ProductSelection productselection = new ProductSelection(driver);
        productselection
                .productSelectionMethod();

    }

    @Test
    public void test4() throws InterruptedException {
        AddBasket addbasket = new AddBasket(driver);
        String sayfaonay = "Koleksiyona Ekle";
        addbasket
                .controlToProductPage(sayfaonay)
                .addBasketMethod();
    }

    @Test
    public void test5() throws InterruptedException {
        GoToBasket goToBasket = new GoToBasket(driver);
        goToBasket
                .goToBasketMethod();
        Assertions.assertTrue(goToBasket.controlToBasketPage(),"Sayfa onaylandı : Sepetim");
    }

    @Test
    public void test6() throws InterruptedException {
        DeleteProduct deleteProduct = new DeleteProduct(driver);
        String silmeonay = "Sepetinde ürün bulunmamaktadır.";
        deleteProduct
                .deleteProductMethod()
                .controlToDelete(silmeonay);
    }
}
