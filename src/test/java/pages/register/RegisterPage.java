package pages.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver webDriver;

    public RegisterPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void fillNameRegisterForm(String firstName, String lastName) {
        webDriver.findElement(ElementLocatorRegister.FIRST_NAME_FIELD).sendKeys(firstName);
        webDriver.findElement(ElementLocatorRegister.LAST_NAME_FIELD).sendKeys(lastName);
    }

    public void fillAddressRegisterForm(
            String street,
            String city,
            String state,
            String zipCode,
            String phoneNumber,
            String ssn
    ) {
        webDriver.findElement(ElementLocatorRegister.ADDRESS_FIELD).sendKeys(street);
        webDriver.findElement(ElementLocatorRegister.ADDRESS_CITY_FIELD).sendKeys(city);
        webDriver.findElement(ElementLocatorRegister.ADDRESS_STATE_FIELD).sendKeys(state);
        webDriver.findElement(ElementLocatorRegister.ADDRESS_ZIPCODE_FIELD).sendKeys(zipCode);
        webDriver.findElement(ElementLocatorRegister.PHONE_NUMBER_FIELD).sendKeys(phoneNumber);
        webDriver.findElement(ElementLocatorRegister.SSN_FIELD).sendKeys(ssn);
    }

    public void userFillValidUsernameAndPassword(String username, String password) {
        webDriver.findElement(ElementLocatorRegister.USERNAME_FIELD).sendKeys(username);
        webDriver.findElement(ElementLocatorRegister.PASSWORD_FIELD).sendKeys(password);
    }

    public void userInputPasswordConfirmation(String password) {
        webDriver.findElement(ElementLocatorRegister.REPEAT_PASSWORD_FIELD).sendKeys(password);
    }

    public void clickRegisterButton() {
        webDriver.findElement(ElementLocatorRegister.REGISTER_BUTTON).click();
    }

    public void clickLogoutButton() {
        webDriver.findElement(ElementLocatorRegister.LOGOUT_BUTTON).click();
    }
}
