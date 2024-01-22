package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1

        driver.get("https://practicetestautomation.com/");

        WebElement practice= driver.findElement(By.id("menu-item-20"));
        practice.click();

        WebElement login = driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"));
        login.click();

        WebElement username=driver.findElement(By.id("username"));
        username.sendKeys("student1");

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        WebElement submit=driver.findElement(By.id("submit"));
        submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(submit.isDisplayed());

        WebElement fail = driver.findElement(By.id("error"));
        String fail1= fail.getText();

        Assert.assertEquals(fail1, "Your username is invalid!");

        //2

        driver.get("https://practicetestautomation.com/");
        practice= driver.findElement(By.id("menu-item-20"));
        practice.click();

        login = driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"));
        login.click();

        username=driver.findElement(By.id("username"));
        username.sendKeys("student");

        password=driver.findElement(By.id("password"));
        password.sendKeys("Password1");

        submit=driver.findElement(By.id("submit"));
        submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(submit.isDisplayed());
        Assert.assertEquals(fail1, "Your username is invalid!");

        //3

        driver.get("https://practicetestautomation.com/");
        practice= driver.findElement(By.id("menu-item-20"));
        practice.click();

        login = driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"));
        login.click();

        username=driver.findElement(By.id("username"));
        username.sendKeys("student1");

        password=driver.findElement(By.id("password"));
        password.sendKeys("Password1");

        submit=driver.findElement(By.id("submit"));
        submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(submit.isDisplayed());
        Assert.assertEquals(fail1, "Your username is invalid!");

        //4

        driver.get("https://practicetestautomation.com/");
        practice= driver.findElement(By.id("menu-item-20"));
        practice.click();

        login = driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"));
        login.click();

        username=driver.findElement(By.id("username"));
        username.sendKeys("STUDENT");

        password=driver.findElement(By.id("password"));
        password.sendKeys("PASSWORD123");

        submit=driver.findElement(By.id("submit"));
        submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(submit.isDisplayed());
        Assert.assertEquals(fail1, "Your username is invalid!");

        //5

        driver.get("https://practicetestautomation.com/");
        practice= driver.findElement(By.id("menu-item-20"));
        practice.click();

        login = driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"));
        login.click();

        username=driver.findElement(By.id("username"));
        username.sendKeys("student");

        password=driver.findElement(By.id("password"));
        password.sendKeys("password123");

        submit=driver.findElement(By.id("submit"));
        submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(submit.isDisplayed());
        Assert.assertEquals(fail1, "Your username is invalid!");


    }
}
