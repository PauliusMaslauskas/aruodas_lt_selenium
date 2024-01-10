package org.example.models;

import org.example.models.baseModels.AruodasApartmentBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AruodasAptSell extends AruodasApartmentBase {

    public int yearOfConstruction;

    public AruodasAptSell(String municipality, String settlement, String microdistrict, String street, String description, String photos, String youtubeLink, int price, String phoneNumber, String email, int houseNumber, int aptNumber, String rcNumber, int area, int numberOfRooms, int aptFloor, int totalBuildingFloorNumber, String buildingType, String equipment, String heating, String features, String energyClass, int yearOfConstruction) {
        super(municipality, settlement, microdistrict, street, description, photos, youtubeLink, price, phoneNumber, email, houseNumber, aptNumber, rcNumber, area, numberOfRooms, aptFloor, totalBuildingFloorNumber, buildingType, equipment, heating, features, energyClass);
        this.yearOfConstruction = yearOfConstruction;
    }

    @Override
    public void fillFields() {
        super.fillFields();

        fillYearOfConstruction();
    }

    public void fillYearOfConstruction() {
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[17]/div[1]/span[1]/span/input"));
        inputField.sendKeys(String.valueOf(yearOfConstruction));
    }
}
