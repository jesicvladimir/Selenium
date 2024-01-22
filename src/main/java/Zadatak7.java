import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak7 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

        WebElement practiceButton= driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();

        WebElement usernameField=driver.findElement(By.id("username"));
        usernameField.sendKeys("student1");

        WebElement passwordField=driver.findElement(By.id("password"));
        passwordField.sendKeys("Password123");

        WebElement submitButton=driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        logOutButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(submitButton.isDisplayed());

        WebElement fail = driver.findElement(By.id("error"));
        String fail1= fail.getText();

        Assert.assertEquals(fail1, "Your username is invalid!");
    }
}
