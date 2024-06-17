package pl.coderslab;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class CheckoutPage {

    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;

    }

    public void Checkout() {

        driver.findElement(By.name("confirm-addresses")).click(); //Potwierdzenie adresu zamówienia

        driver.findElement(By.id("delivery_option_8")).submit(); //Wybranie rodzaju dostawy

        driver.findElement(By.name("confirmDeliveryOption")).click(); //Potwierdzenie rodzaju dostawy

        driver.findElement(By.id("payment-option-1")).click(); //Wybranie rodzaju płatności

        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click(); //Akceptacja regulaminu i warunków

        driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).click(); //Potwierdzenie płatności

    }


    //Zrobienie Screenshot'a podsumowania zamówienia
    public void screenShot() throws IOException {
        String imageNew = "C:\\Users\\Tomek\\Pictures\\Screenshots\\image" + new Random().nextInt(1000000) + ".png";
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(imageNew));
        }

    public void priceConfirmation() {

        //Zapisanie kwoty do zapłaty z podsumowania zamówienia
        WebElement price = driver.findElement(By.className("price"));
        String orderPrice = price.getText();

        driver.findElement(By.className("account")).click(); //Przejście do konta użytkownika

        driver.findElement(By.id("history-link")).click();  //Przejście do historii zamówień

        //Zapisanie kwoty do zapłaty z hostorii zamówień
        WebElement HistoryPrice = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/table/tbody/tr[1]/td[2]"));
        String orderHistoryPrice = HistoryPrice.getText();

        //Porówanie kwoty z podsumowania z kwotą z historii zamówień
        assert orderPrice.equals(orderHistoryPrice);

        //Sprawdzenie czy zamówienie ma status "Awaiting check payment"
        WebElement status = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/table/tbody/tr[1]/td[4]/span"));
        String orderStatus = status.getText();
        if (orderStatus.equals("Awaiting check payment")) {
            System.out.println("Zamówienie oczekuje na zapłatę");
        } else {
            System.out.println("Zamówienie nie posiada statusu oczekiwania na zapłatę");
        }

    }

}







