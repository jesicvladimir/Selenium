package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;



public class Herokuapp {

    WebDriver driver;
    WebDriverWait wait;

    WebElement usernameField;

    WebElement passwordField;

    String username, password;

    WebElement formAuthentication;

    WebElement loginButton;
    WebElement dropdown;

    WebElement dropdownMenu;

    WebElement dynamicCont;
    WebElement clickHere;

    WebElement typos;
    WebElement dissappearingElements;







    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        username="tomsmith";
        password="SuperSecretPassword!";

    }

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 10)
    public void formAuthentication(){
        formAuthentication= driver.findElement(By.linkText("Form Authentication"));
        formAuthentication.click();
        usernameField= driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
        passwordField=driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        loginButton= driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        WebElement logOutButtonAssert= driver.findElement(By.cssSelector(".button.secondary.radius"));
        Assert.assertTrue(logOutButtonAssert.isDisplayed());

    }


    @Test (priority = 20)
    public void dropdown() throws InterruptedException {
        dropdown=driver.findElement(By.linkText("Dropdown"));
        dropdown.click();
        Thread.sleep(3000);
        dropdownMenu=driver.findElement(By.id("dropdown"));
        dropdownMenu.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/dropdown");

    }

    @Test (priority = 30)
    public void dynamicContent() throws InterruptedException {
        dynamicCont=driver.findElement(By.linkText("Dynamic Content"));
        dynamicCont.click();
        Thread.sleep(3000);
        clickHere=driver.findElement(By.linkText("click here"));
        clickHere.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/dynamic_content?with_content=static");

    }

    @Test (priority = 40)
    public void Typos(){
        typos= driver.findElement(By.linkText("Typos"));
        typos.click();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/typos");
    }

    @Test (priority = 50)
    public void dissapearingElementss(){
        dissappearingElements=driver.findElement(By.linkText("Disappearing Elements"));
        dissappearingElements.click();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/disappearing_elements");


    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }





}
