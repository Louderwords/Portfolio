package pl.coderslab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
        this.driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    public void goToLoginPage() {
        //Przejście ze strony głównej na stronę logowania
        WebElement signInButton = this.driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        signInButton.click();
    }

}