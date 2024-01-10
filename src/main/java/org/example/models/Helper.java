package org.example.models;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.example.models.baseModels.AruodasBase.driver;

public class Helper {

    public static void driverInit(String url) {
        if(driver != null){
            return;
        }
        driver = new ChromeDriver();
        driver.get(url);

        acceptCookies(url);
    }

    public static void acceptCookies(String url) {
        driver.get(url);
        driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
    }

}
