package org.example.models;

import org.example.models.baseModels.AruodasApartmentBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class AruodasAptRent extends AruodasApartmentBase {
    public String interestedChange;
    public String interestedAuction;
    public int yearOfConstruction;

    public AruodasAptRent(String municipality, String settlement, String microdistrict, String street, String description, String photos, String youtubeLink, int price, String phoneNumber, String email, int houseNumber, int aptNumber, String rcNumber, int area, int numberOfRooms, int aptFloor, int totalBuildingFloorNumber, String buildingType, String equipment, String heating, String features, String energyClass, String interestedChange, String interestedAuction, int yearOfConstruction) {
        super(municipality, settlement, microdistrict, street, description, photos, youtubeLink, price, phoneNumber, email, houseNumber, aptNumber, rcNumber, area, numberOfRooms, aptFloor, totalBuildingFloorNumber, buildingType, equipment, heating, features, energyClass);
        this.interestedChange = interestedChange;
        this.interestedAuction = interestedAuction;
        this.yearOfConstruction = yearOfConstruction;
    }

    @Override
    public void fillFields() {
        super.fillFields();

        ifInterestedChange();
        ifInterestedAuction();
        fillYearOfConstruction();
    }

    public void fillYearOfConstruction() {
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[18]/div[1]/span[1]/span/input"));
        inputField.sendKeys(String.valueOf(yearOfConstruction));
    }

    public void ifInterestedChange() {
        List<WebElement> interestedChangeLabel = driver.findElements(By.className("form-field-input-container")).get(1).findElements(By.className("input-style-checkbox"));
        if (interestedChange.equals("Taip")) {
            interestedChangeLabel.forEach(WebElement::click);
        }

    }

    public void ifInterestedAuction() {
        List<WebElement> interestedChangeLabel = driver.findElements(By.className("form-field-input-container")).get(2).findElements(By.className("input-style-checkbox"));
        if (interestedChange.equals("Taip")) {
            interestedChangeLabel.forEach(WebElement::click);
        }
    }


}
