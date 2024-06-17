package pl.coderslab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

    private final WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void myAddress() {
        //Wejście na stronę z adresami użytkownika
        WebElement address = this.driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span"));
        address.click();
    }

}
