package test1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class GoogleSearchTest {

    private WebDriver driver;

    @Before
    public  void setUp(){

        System.setProperty("webdriver.opera.driver","./src/test/resources/operaDriver/operaDriver.exe");

        driver = new OperaDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com");
    }

    @Test
    public void testGooglePage(){

        WebElement searchBox = driver.findElement(By.name("q"));

        searchBox.clear();

        searchBox.sendKeys("quality-stream Software Test Automation");

        searchBox.submit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertEquals("quality-stream Software Test Automation - Buscar con Google", driver.getTitle());

    }
    @After
    public void tearDown(){

        driver.quit();

    }

}
