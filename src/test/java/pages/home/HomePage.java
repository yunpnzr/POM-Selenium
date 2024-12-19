package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    /*public void DirectRegisterPage(WebDriver driver) {
        this.driver = driver;
    }*/

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //locator
    By registerButton = By.xpath("//a[contains(@href, 'register')]");

    //register method
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
}
