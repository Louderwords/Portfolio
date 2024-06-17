package pl.coderslab.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.*;

import java.io.IOException;


public class BuyProductStep {

    private WebDriver driver;

    @Given("zalogowany użytkownik znajduje się na stronie sklepu")

    public void logInToAccount(){
        this.driver = new ChromeDriver();
        MainPage mainPage = new MainPage(this.driver);
        mainPage.goToLoginPage();

        LoginPage loginpage = new LoginPage(this.driver);
        loginpage.loginToAccount();

    }

    @When("użytkownik dokonuje zakupu produktu w rozmiarze {word} i ilości {int}")

    public void buyProduct(String rozmiar, int ilosc) {

        ClothesPage clothesPage = new ClothesPage(this.driver);
        clothesPage.BuyProduct(rozmiar,ilosc);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(this.driver);
        shoppingCartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(this.driver);
        checkoutPage.Checkout();

        try {
            checkoutPage.screenShot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        checkoutPage.priceConfirmation();

    }

    @Then("Zakończenie testu")

    public void closeBrowser() {
        //this.driver.quit();
    }

    }

