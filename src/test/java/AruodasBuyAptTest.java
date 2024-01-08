import org.example.models.AruodasBuyApt;
import org.example.models.AruodasSellApt;
import org.example.models.AruodasBase;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AruodasBuyAptTest {

    public static WebDriver driver;

    @BeforeClass
    public static void beforeClass(){
        driver = new ChromeDriver();
        AruodasBase.driver = driver;
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=1");
        accpetCookies();
    }

    @Test
    public void allFieldsValid(){
        AruodasBuyApt aruodasBuyApt = new AruodasBuyApt(
                "Vilnius",
                "Vilniaus m.",
                "Bajorai",
                "A. Gustaičio g.",
                "Puikus Butas",
                "paskaita.png",
                "https://www.youtube.com/watch?v=w7Xqzji5p_0",
                100,
                "64736093",
                "emeilas@gnail.com",
                "Patalpos pirkti"
        );

        aruodasBuyApt.fillFields();
    }

    @BeforeMethod
    public void getWebsite(){
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=1");
    }

    public static void accpetCookies() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=1");
        driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
    }

    @AfterMethod
    public void wait1S(){
        try {Thread.sleep(1000);} catch (InterruptedException e) {}
    }

    @AfterClass
    public void afterClass(){
        // driver.quit();
    }
}