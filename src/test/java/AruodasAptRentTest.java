import org.example.models.AruodasAptRent;
import org.example.models.Helper;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AruodasAptRentTest {

    public static WebDriver driver;
    public static String pageUrl = "https://www.aruodas.lt/ideti-skelbima/?obj=4";

    @BeforeClass
    public static void beforeClass() {
        Helper.driverInit(pageUrl);
    }

    @Test
    public void testAllFieldsValid() {
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
    public void getWebsite() {
        driver.get(pageUrl);
    }


    @AfterMethod
    public void wait1S() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}