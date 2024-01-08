package org.example.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AruodasBuyApt extends AruodasBase {
    public String realEstateType;

    public AruodasBuyApt(String municipality, String settlement, String microdistrict, String street, String description, String photos, String youtubeLink, int price, String phoneNumber, String email, String realEstateType) {
        super(municipality, settlement, microdistrict, street, description, photos, youtubeLink, price, phoneNumber, email);
        this.realEstateType = realEstateType;
    }
    @Override
    public void fillFields() {
        super.fillFields();

        fillrealEstateType();
    }
    public void fillrealEstateType() {

        try {
            WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/span"));
            dropDown.click();

            List<WebElement> dropDownContent = driver.findElements(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/ul/li"));
            dropDownContent.stream()
                    .filter(d -> d.getText().startsWith(realEstateType))
                    .findFirst()
                    .ifPresent(WebElement::click);

        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Real Estate Type Does Not Exist Or Is No Available");
        }
    }
}
