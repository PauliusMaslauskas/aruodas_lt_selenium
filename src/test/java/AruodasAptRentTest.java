import org.example.models.AruodasAptRent;
import org.example.models.baseModels.AruodasBase;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AruodasAptRentTest {

    public static WebDriver driver;

    @BeforeClass
    public static void beforeClass(){
        driver = new ChromeDriver();
        AruodasBase.driver = driver;
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=4");
        accpetCookies();
    }

    @Test
    public void testAllFieldsValid(){
        AruodasAptRent aruodasAptRent = new AruodasAptRent(
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
                10,
                10,
                "1111-1111-1111:1111",
                20,
                2,
                2,
                9,
                "Blokinis",
                "Pamatai",
                "Dujinis, Centrinis, Elektra",
                "Pirtis, Terasa, Balkonas, Internetas, Buto dalis, Signalizacija",
                "A+",
                "Taip",
                "Taip1",
                1998
        );

        aruodasAptRent.fillFields();

    }


    @BeforeMethod
    public void getWebsite(){
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=4");
    }

    public static void accpetCookies() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=4");
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