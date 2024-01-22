import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        for (int i = 0; i < 5; i++) {
            js.executeScript("window.open()");
        }

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(listaTabova.get(0));
        driver.get("https://www.youtube.com/");

        driver.switchTo().window(listaTabova.get(1));
        driver.get("https://www.google.com/");

        driver.switchTo().window(listaTabova.get(2));
        driver.get("https://www.linkedin.com/");

        driver.switchTo().window(listaTabova.get(3));
        driver.get("https://www.joberty.com/");

        driver.switchTo().window(listaTabova.get(4));
        driver.get("https://www.stackoverflow.com/");

        driver.switchTo().window(listaTabova.get(5));
        driver.get("https://www.youtube.com/");
    }
}
