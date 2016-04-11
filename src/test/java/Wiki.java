import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;

/**
 * Created by дима on 07.04.2016.
 */
public class Wiki extends TestCase {
    private By google = By.id("lst-ib");
    private By wiki=By.id("rso");
    private By input=By.id("searchInput");
    private String string ="wikipedia";
    private String string1 ="apple";
    private String string2 ="pepper";
    private static FirefoxDriver driver;
    private WebElement findInput;
    private WebElement element;
    public static void delay() {
        try {
            Thread.sleep(2000);
            // any action
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        this.driver.get("http://google.com");
        System.out.println(this.driver.getCurrentUrl());
        WebElement findGoogle=driver.findElement(google);
        findGoogle.sendKeys(string);
        findGoogle.submit();
        Wiki.delay();
        WebElement findWiki=driver.findElement(wiki);
        Wiki.delay();
        findWiki.click();
        Wiki.delay();

    }
    @Test
    public void testApple() throws Exception {

        findInput=driver.findElement(input);
        findInput.sendKeys(string1);
        findInput.submit();
        Wiki.delay();
        assertEquals("Apple - Wikipedia, the free encyclopedia",driver.getTitle());
        System.out.println(driver.getTitle());


    }

    @Test
    public void testPepper() throws Exception {

        findInput=driver.findElement(input);
        findInput.sendKeys(string2);
        findInput.submit();
        Wiki.delay();
        assertEquals("Pepper - Wikipedia, the free encyclopedia",driver.getTitle());
        System.out.println(driver.getTitle());



    }

    @AfterClass
    public void tearDown() throws Exception{
        this.driver.quit();
    }
}

