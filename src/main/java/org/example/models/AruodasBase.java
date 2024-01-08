package org.example.models;

import org.openqa.selenium.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;


public abstract class AruodasBase {

    public static WebDriver driver;
    public String municipality;
    public String settlement;
    public String microdistrict;
    public String street;
    public String description;
    public String photos;
    public String youtubeLink;
    public int price;
    public String phoneNumber;
    public String email;


    public AruodasBase(String municipality, String settlement, String microdistrict, String street, String description, String photos, String youtubeLink, int price, String phoneNumber, String email) {
        this.municipality = municipality;
        this.settlement = settlement;
        this.microdistrict = microdistrict;
        this.street = street;
        this.description = description;
        this.photos = photos;
        this.youtubeLink = youtubeLink;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void fillFields() {
        locationFieldTimeBuffer();
        filldescription();
        fillphotos();
        fillyoutubeLink();
        fillprice();
        fillphoneNumber();
        fillEmail();
        last3CheckBox();
    }

    public void fillMunicipality() {

        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[3]/span[1]/span"));
        dropDown.click();

        WebElement selectMunicipality = driver.findElement(By.className("dropdown-input-search-value"));
        selectMunicipality.sendKeys(municipality);

        List<WebElement> dropDownContent = driver.findElements(By.xpath("//*[@id=\"regionDropdown\"]/li"));

        for (WebElement option : dropDownContent) {
            if (option.getText().startsWith(municipality)) {
                option.click();
                break;
            }
        }
    }

    public void fillSettlement() {
        try {
            WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"district\"]/span"));
            dropDown.click();

            List<WebElement> dropDownContent = driver.findElements(By.className("input-width-wide")).get(1).findElements(By.tagName("ul"));

            List <WebElement> filterUl = dropDownContent.stream()
                    .filter(ul -> ul.getAttribute("class").contains("dropdown-input-values-address"))
                    .toList();

            filterUl.get(0).findElements(By.tagName("li"))
                    .stream()
                    .filter(li -> li.getText().contains(settlement))
                    .findFirst()
                    .ifPresent(WebElement::click);

        } catch (org.openqa.selenium.ElementNotInteractableException e) {
            System.out.println("Settlement Field Is Preselected Or Is No Available");
        }
    }

    public void fillstreet() {

        try {
            WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"streetField\"]/span[1]/span[2]"));
            dropDown.click();

            List<WebElement> dropDownContent = driver.findElements(By.className("input-width-wide")).get(3).findElements(By.tagName("ul"));

            List <WebElement> filterUlList = dropDownContent.stream()
                    .filter(ul -> ul.getAttribute("class").contains("dropdown-input-values-address"))
                    .toList();

            filterUlList.get(0).findElements(By.tagName("li"))
                    .stream()
                    .filter(li -> li.getText().contains(street))
                    .findFirst()
                    .ifPresent(WebElement::click);

        } catch (org.openqa.selenium.ElementNotInteractableException e) {
            System.out.println("Street Field Is Preselected Or Is No Available");
        }

    }

    public void fillmicrodistrict() {

        try {
            WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"quartalField\"]/span[1]/span[2]"));
            dropDown.click();

            List<WebElement> microDistricts = driver.findElements(By.className("dropdown-input-values-address")).get(2).findElements(By.tagName("li"));

            microDistricts.stream()
                    .filter(m -> m.getText().contains(microdistrict))
                    .findFirst()
                    .ifPresent(WebElement::click);

        } catch (org.openqa.selenium.ElementNotInteractableException e) {
            System.out.println("Microdistrict Field Is Preselected Or Is No Available");
        }

    }

    public void filldescription() {
        WebElement descriptionField = driver.findElement(By.name("notes_lt"));
        descriptionField.sendKeys(description);
    }

    public void fillphotos() {
        File resourceFile = new File("C:\\Users\\pauli\\IdeaProjects\\aruodas_test_cases\\src\\main\\resources\\img\\" + photos);
        WebElement imageInput = driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input"));
        imageInput.sendKeys(resourceFile.getAbsolutePath());
    }

    public void fillyoutubeLink() {
        WebElement youtubeField = driver.findElement(By.name("Video"));
        youtubeField.sendKeys(youtubeLink);

    }

    public void fillprice() {
        WebElement priceField = driver.findElement(By.id("priceField"));
        priceField.sendKeys(String.valueOf(price));

    }

    public void fillphoneNumber() {
        WebElement phoneField = driver.findElement(By.name("phone"));
        phoneField.sendKeys(phoneNumber);

    }

    public void fillEmail() {
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys(email);
    }

    public void last3CheckBox() {
        List<WebElement> ul = driver.findElement(By.id("newObjectForm")).findElements(By.tagName("li"));
        try {
            ul.get(ul.size() - 5).findElement(By.tagName("span")).click();
            Thread.sleep(500);
            ul.get(ul.size() - 4).findElement(By.tagName("span")).click();
            Thread.sleep(500);
            ul.get(ul.size() - 3).findElements(By.tagName("span")).get(1).click();
        } catch (InterruptedException e) {
            System.out.println("Check Box Error");
        }
    }

    public void locationFieldTimeBuffer() {
        try {
            fillMunicipality();
            Thread.sleep(500);
            fillSettlement();
            Thread.sleep(500);
            fillmicrodistrict();
            Thread.sleep(500);
            fillstreet();
        } catch (InterruptedException e) {
            System.out.println("Fill Location Time Buffer Out Of Order");
        }
    }

    public static List <String> splitString(String splitString){
        return  Arrays.stream(splitString.split(","))
                .map(String::trim)
                .toList();
    }
}
