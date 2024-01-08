package org.example.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AruodasSellApt extends AruodasBase {

    public int houseNumber;
    public int aptNumber;
    public String rcNumber;
    public int area;
    public int numberOfRooms;
    public int aptFloor;
    public int totalBuildingFloorNumber;
    public int yearOfConstruction;
    public String buildingType;
    public String equipment;
    public String heating;
    public String features;
    public String energyClass;
    public String interestedChange;
    public String interestedAuction;


    public AruodasSellApt(String municipality, String settlement, String microdistrict, String street, String description, String photos, String youtubeLink, int price, String phoneNumber, String email, int houseNumber, int aptNumber, String rcNumber, int area, int numberOfRooms, int aptFloor, int totalBuildingFloorNumber, int yearOfConstruction, String buildingType, String equipment, String heating, String features, String energyClass, String interestedChange, String interestedAuction) {
        super(municipality, settlement, microdistrict, street, description, photos, youtubeLink, price, phoneNumber, email);
        this.houseNumber = houseNumber;
        this.aptNumber = aptNumber;
        this.rcNumber = rcNumber;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.aptFloor = aptFloor;
        this.totalBuildingFloorNumber = totalBuildingFloorNumber;
        this.yearOfConstruction = yearOfConstruction;
        this.buildingType = buildingType;
        this.equipment = equipment;
        this.heating = heating;
        this.features = features;
        this.energyClass = energyClass;
        this.interestedChange = interestedChange;
        this.interestedAuction = interestedAuction;
    }

    @Override
    public void fillFields() {
        super.fillFields();

        fillHouseNumber();
        fillAptNumber();
        fillRCNumber();
        fillArea();
        fillRoomNr();
        fillFloor();
        fillYearOfConstruction();
        selectBuildingType();
        selectEquipment();
        selectHeatingCheckBox();
        selectAptFeatures();
        selectEnergyClass();
        ifInterestedChange();
        ifInterestedAuction();
    }

    public void fillHouseNumber() {
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/input"));
        inputField.sendKeys(String.valueOf(houseNumber));
    }

    public void fillAptNumber() {
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[8]/span[1]/input"));
        inputField.sendKeys(String.valueOf(aptNumber));
    }

    public void fillRCNumber() {
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[12]/div[1]/input"));
        inputField.sendKeys(rcNumber);
    }

    public void fillArea() {
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"fieldFAreaOverAll\"]"));
        inputField.sendKeys(String.valueOf(area));
    }

    public void fillRoomNr() {
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[15]/div/span/input"));
        inputField.sendKeys(String.valueOf(numberOfRooms));
    }

    public void fillFloor() {
        WebElement firstDropDown = driver.findElement(By.xpath("//*[@id=\"fieldRow_FFloor\"]/div[1]/span[2]/span"));
        firstDropDown.click();

        WebElement firstDropDownInputField = driver.findElement(By.xpath("//*[@id=\"fieldRow_FFloor\"]/div[1]/span[2]/ul/li[5]/input"));
        firstDropDownInputField.sendKeys(String.valueOf(aptFloor));

        WebElement secondDropDown = driver.findElement(By.xpath("//*[@id=\"fieldRow_FHouseHeight\"]/span[1]/span"));
        secondDropDown.click();

        WebElement secondDropDownInputField = driver.findElement(By.xpath("//*[@id=\"fieldRow_FHouseHeight\"]/span[1]/ul/li[10]/input"));
        secondDropDownInputField.sendKeys(String.valueOf(totalBuildingFloorNumber));

    }

    public void fillYearOfConstruction() {
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[17]/div[1]/span[1]/span/input"));
        inputField.sendKeys(String.valueOf(yearOfConstruction));
    }

    public void selectBuildingType() {
        List<WebElement> listOfTypes = driver.findElements(By.className("input-buttons-wrapper")).get(1).findElements(By.className("input-button-text"));

        listOfTypes.stream()
                .filter(t -> t.getText().contains(buildingType))
                .findFirst()
                .ifPresent(WebElement::click);

    }

    public void selectEquipment() {
        List<WebElement> listOfTypes = driver.findElements(By.className("input-buttons-wrapper")).get(2).findElements(By.className("input-button-text"));

        listOfTypes.stream()
                .filter(t -> t.getText().contains(equipment))
                .findFirst()
                .ifPresent(WebElement::click);

    }

    public void selectHeatingCheckBox() {
        List<WebElement> listOfTypes = driver.findElements(By.className("input-style-checkbox")).get(5).findElements(By.tagName("label"));

        for (String type : splitString(heating)) {
            listOfTypes.stream()
                    .filter(t -> t.getText().equals(type))
                    .forEach(WebElement::click);

        }
    }

    public void selectAptFeatures() {
        WebElement extendFeatures = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[25]/span"));
        extendFeatures.click();

        List<WebElement> findLiElements = driver.findElements(By.className("input-style-checkbox"));

        List<WebElement> findLabelElements = findLiElements.stream()
                .flatMap(optionGroup -> optionGroup.findElements(By.tagName("label")).stream())
                .toList();

        for (String feature : splitString(features)) {
            findLabelElements.stream()
                    .filter(t -> t.getText().equals(feature))
                    .forEach(WebElement::click);
        }
    }

    public void selectEnergyClass() {
        List<WebElement> listOfTypes = driver.findElements(By.className("input-buttons-wrapper")).get(5).findElements(By.className("input-button-text"));

        listOfTypes.stream()
                .filter(t -> t.getText().equals(energyClass))
                .findFirst()
                .ifPresent(WebElement::click);
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
