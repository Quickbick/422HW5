import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class IDoShopping {
    WebDriver driver;

    @BeforeEach
    void setUp(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown(){
        //driver.quit();
    }

    @Test
    void PassClassByPurchase(){
        driver.get("https://store.steampowered.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement searchBar = driver.findElement(By.cssSelector("#store_nav_search_term"));
        searchBar.sendKeys("Persona 5 Tactica");
        searchBar.sendKeys(Keys.RETURN);
        WebElement firstItem = driver.findElement(By.cssSelector("#search_resultsRows > a:nth-child(1)"));
        firstItem.click();
        WebElement addToCart = driver.findElement(By.className("btn_green_steamui"));
        addToCart.click();
        //Steam takes you to cart when you add something, but this should do it anyway in case it doesn't
        WebElement cart = driver.findElement(By.id("cart_link"));
        cart.click();
    }

}
