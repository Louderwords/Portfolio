Feature: Add address to account

  Scenario Outline:

    Given zarejestrowany użytkownik loguje się na swoje konto
    When użytkownik dodaje adres z <alias> <address> <city> <postalcode> <phone> do konta
    Then zakończenie testu

    Examples:

    |alias|address|city|postalcode|phone|
    |'New Address'|'3 Maja'|Warszawa|50-055 |123456789|
