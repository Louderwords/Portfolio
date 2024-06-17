package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.DashboardPage;
import pl.coderslab.LoginPage;
import pl.coderslab.MainPage;
import pl.coderslab.NewAddressPage;
import static org.junit.Assert.*;

public class AddAddressStep {

    private WebDriver driver;

    @Given("zarejestrowany użytkownik loguje się na swoje konto")

    public void logInToAccount(){
        this.driver = new ChromeDriver();
        MainPage mainPage = new MainPage(this.driver);
        mainPage.goToLoginPage();

        LoginPage loginpage = new LoginPage(this.driver);
        loginpage.loginToAccount();

    }

    @When("użytkownik dodaje adres z {string} {string} {word} {word} {word} do konta") 

    public void addAddress(String alias,String address,String city,String postalcode,String phone) {

        DashboardPage dashboardPage = new DashboardPage(this.driver);
        dashboardPage.myAddress();

        NewAddressPage newAddressPage = new NewAddressPage(this.driver);
        newAddressPage.AddAddress(alias,address,city,postalcode,phone);

        //Sprawdzenie czy nowy adres został dodany
        try {
            WebElement successAlert = this.driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));
            assertEquals("Address successfully added!", successAlert.getText());
        } catch (NoSuchElementException ex) {
            fail("Alert o sukcesie się nie pojawił");
        }

        //Sprawdzenie czy dodany adres jest poprawny
        String expectedNewAddress = alias + "\n" + "John Smith\n" + address + "\n" + city + "\n" + postalcode + "\n" + "United Kingdom" + "\n" + phone;

        WebElement addedAddressElement = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[2]/article/div[1]"));
        String addedAddress = addedAddressElement.getText();

        assertEquals(expectedNewAddress, addedAddress);

    }

    @Then("zakończenie testu")
    public void testCleanup() {
        //Usunięcie dodanego adresu
        driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]/span")).click();
        //Sprawdzenie czy adres został usunięty
        try {
            WebElement successAlert = this.driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));
            assertEquals("Address successfully deleted!", successAlert.getText());
        } catch (NoSuchElementException ex) {
            fail("Alert o sukcesie się nie pojawił");
        }

        //this.driver.quit();
    }

}

