package org.example.models.baseModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AruodasApartmentBase extends AruodasBase {

    public int houseNumber;
    public int aptNumber;
    public String rcNumber;
    public int area;
    public int numberOfRooms;
    public int aptFloor;
    public int totalBuildingFloorNumber;
    public String buildingType;
    public String equipment;
    public String heating;
    public String features;
    public String energyClass;


    public AruodasApartmentBase(String municipality, String settlement, String microdistrict, String street, String description, String photos, String youtubeLink, int price, String phoneNumber, String email, int houseNumber, int aptNumber, String rcNumber, int area, int numberOfRooms, int aptFloor, int totalBuildingFloorNumber, String buildingType, String equipment, String heating, String features, String energyClass) {
        super(municipality, settlement, microdistrict, street, description, photos, youtubeLink, price, phoneNumber, email);
        this.houseNumber = houseNumber;
        this.aptNumber = aptNumber;
        this.rcNumber = rcNumber;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.aptFloor = aptFloor;
        this.totalBuildingFloorNumber = totalBuildingFloorNumber;
        this.buildingType = buildingType;
        this.equipment = equipment;
        this.heating = heating;
        this.features = features;
        this.energyClass = energyClass;
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
        selectBuildingType();
        selectEquipment();
        selectHeatingCheckBox();
        selectAptFeatures();
        selectEnergyClass();
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
        checkBoxFilter(heating);

    }

    public void selectAptFeatures() {
        WebElement extendFeatures = driver.findElement(By.cssSelector("#newObjectForm > ul > li.field-extra-row-closed > span"));
        extendFeatures.click();

        checkBoxFilter(features);
    }

    private void checkBoxFilter(String features) {
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


}
