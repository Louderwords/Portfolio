package pl.coderslab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToAccount() {
        //Wpisanie loginu użytkownika
        WebElement login = this.driver.findElement(By.id("field-email"));
        login.sendKeys("test@mystore.pl");
        //Wpisanie hasła użytkownika
        WebElement password = this.driver.findElement(By.id("field-password"));
        password.sendKeys("Store123!@");
        //Kliknięcie przycisku logowania
        WebElement submit = this.driver.findElement(By.id("submit-login"));
        submit.click();
    }
}