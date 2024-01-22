import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak9 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");

        Thread.sleep(10000);

        WebElement cartBeforeAdding = driver.findElement(By.id("nav-cart-count"));
        String cartNumber = cartBeforeAdding.getText();
        Assert.assertEquals(cartNumber, "0");

        WebElement cartButton1 = driver.findElement(By.id("nav-cart"));
        cartButton1.click();

        WebElement emptyCart = driver.findElement(By.cssSelector(".a-row.sc-your-amazon-cart-is-empty"));
        Assert.assertTrue(emptyCart.isDisplayed());

        driver.navigate().back();

        WebElement book = driver.findElement(By.id("productTitle"));
        String bookTitleToBeAdded = book.getText();

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        WebElement successfulMessage = driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS"));
        Assert.assertTrue(successfulMessage.isDisplayed());


        WebElement cartAfterAdding = driver.findElement(By.id("nav-cart-count"));
        cartNumber = cartAfterAdding.getText();
        Assert.assertEquals(cartNumber, "1");


        WebElement cartButton2 = driver.findElement(By.id("nav-cart"));
        cartButton2.click();

        WebElement bookInCart = driver.findElement(By.className("a-truncate-cut"));
        String bookTitleInCart = bookInCart.getText();

        Assert.assertEquals(bookTitleToBeAdded, bookTitleInCart);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        WebElement cartAfterRemoving = driver.findElement(By.id("nav-cart-count"));
        cartNumber = cartAfterRemoving.getText();
        Assert.assertEquals(cartNumber, "0");

        WebElement emptyCart1 = driver.findElement(By.cssSelector(".a-row.sc-your-amazon-cart-is-empty"));
        Assert.assertTrue(emptyCart1.isDisplayed());

    }
}
