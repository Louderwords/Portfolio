package pl.coderslab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage {

    private final WebDriver driver;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void AddAddress(String alias,String address,String city,String postalcode,String phone) {
        //Kliknięcie w "+ Create new address"
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span")).click();
        //Wpisanie nazwy nowego adresu
        WebElement customerAlias = driver.findElement(By.id("field-alias"));
        customerAlias.clear();
        customerAlias.sendKeys(alias);
        //Wpisanie ulicy
        WebElement customerAddress = driver.findElement(By.id("field-address1"));
        customerAddress.clear();
        customerAddress.sendKeys(address);
        //Wpsanie miasta
        WebElement customerCity = driver.findElement(By.id("field-city"));
        customerCity.clear();
        customerCity.sendKeys(city);
        //Wpisanie kodu pocztowego
        WebElement customerPostcode = driver.findElement(By.id("field-postcode"));
        customerPostcode.clear();
        customerPostcode.sendKeys(postalcode);
        //Wybranie państwa
        WebElement dropdown = driver.findElement(By.id("field-id_country"));
        Select country = new Select(dropdown);
        country.selectByVisibleText("United Kingdom");
        //Wpisanie numeru telefonu
        WebElement customerPhone = driver.findElement(By.id("field-phone"));
        customerPhone.clear();
        customerPhone.sendKeys(phone);
        //Zapisanie nowego adresu
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")).click();
    }
}
