package pages.register;

import org.openqa.selenium.By;

import java.security.PublicKey;

public class ElementLocatorRegister {
    //field input
    public static final By FIRST_NAME_FIELD = By.id("customer.firstName");
    public static final By LAST_NAME_FIELD = By.id("customer.lastName");
    public static final By ADDRESS_FIELD = By.id("customer.address.street");
    public static final By ADDRESS_CITY_FIELD = By.id("customer.address.city");
    public static final By ADDRESS_STATE_FIELD = By.id("customer.address.state");
    public static final By ADDRESS_ZIPCODE_FIELD = By.id("customer.address.zipCode");
    public static final By PHONE_NUMBER_FIELD = By.id("customer.phoneNumber");
    public static final By SSN_FIELD = By.id("customer.ssn");
    public static final By USERNAME_FIELD = By.id("customer.username");
    public static final By PASSWORD_FIELD = By.id("customer.password");
    public static final By REPEAT_PASSWORD_FIELD = By.id("repeatedPassword");

    //button
    public static final By REGISTER_BUTTON = By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input");
    public static final By LOGIN_BUTTON = By.xpath("//a[contains(@href, 'login')]");
    public static final By LOGOUT_BUTTON = By.xpath("//a[contains(@href, 'logout')]");

    //title
    public static final By REGISTER_TITLE = By.xpath("//h1[contains(text(), 'Signing up is easy!')]");
    public static final By LOGIN_PANEL = By.xpath("//*[@id='loginPanel']/p[2]");

    //alert
    public static final By ERROR_PASSWORD_NOT_MATCH = By.xpath("//*[@id='repeatedPassword.errors']");

}
