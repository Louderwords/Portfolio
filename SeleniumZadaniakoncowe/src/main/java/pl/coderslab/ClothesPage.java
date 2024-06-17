package pl.coderslab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ClothesPage {

    private final WebDriver driver;

    public ClothesPage(WebDriver driver) {
        this.driver = driver;
        //Wejście na stronę z ubraniami
        this.driver.findElement(By.id("category-3")).click();

    }

    public void BuyProduct(String rozmiar,int ilosc) {
        //Wejście na stronę produktu "Hummingbird Printed Sweater"
        driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div[2]/article/div/div[2]/h2/a")).click();

        // Sprawdź czy rabat na produkt wynosi 20%
        WebElement discountLabel = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[2]"));
        String discount = discountLabel.getText();
        if (discount.equals("SAVE 20%")) {
            System.out.println("Rabat na produkt wynosi 20%.");
        } else {
            System.out.println("Rabat na produkt nie wynosi 20%.");
        }

        // Wybierz rozmiar
        WebElement sizeDropdown = driver.findElement(By.id("group_1"));
        sizeDropdown.sendKeys(rozmiar);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.stalenessOf(sizeDropdown));

        // Wybierz ilość produktu
        WebElement quantityInput = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/span[3]/button[1]/i"));

        for (int i = 1; i < ilosc; i++) {
            quantityInput.click();
        }

       // Przejdź do podsumowania
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")).click();

        WebDriverWait checkoutWait = new WebDriverWait(driver, Duration.ofMillis(700));
        checkoutWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"))).click();

    }
}
