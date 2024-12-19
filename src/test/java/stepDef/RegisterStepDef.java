package stepDef;

import config.EnvTarget;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.home.HomePage;
import pages.register.ElementLocatorRegister;
import pages.register.RegisterPage;

import java.time.Duration;

public class RegisterStepDef extends EnvTarget {

    @Given("^User in on Parabank home page$")
    public void userInOnParabankHomePage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlLogin);

        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ElementLocatorRegister.LOGIN_PANEL
                )
        );
    }

    @When("^User click register link button$")
    public void userClickRegisterLinkButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickRegisterButton();
    }

    @Then("^User is in register page$")
    public void userIsInRegisterPage() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ElementLocatorRegister.REGISTER_TITLE
                )
        );
    }

    @When("^User input (.*) and (.*)$")
    public void userInputName(String firstName, String lastName) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillNameRegisterForm(firstName, lastName);
    }

    @And("^User input address detail like (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void userInputAddressDetail(String address, String city, String state, String zipCode, String phoneNumber, String ssn) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillAddressRegisterForm(address, city, state, zipCode, phoneNumber, ssn);
    }

    @And("^User fill valid (.*) and (.*)$")
    public void userFillValidUsernameAndPassword(String username, String password) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.userFillValidUsernameAndPassword(username, password);
    }

    @And("^User input password confirmation (.*)$")
    public void userInputPasswordConfirmation(String password) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.userInputPasswordConfirmation(password);
    }

    @When("^User click register button$")
    public void userClickRegisterButton() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickRegisterButton();
    }

    @Then("^User register (.*)$")
    public void userRegisterSuccessfully(String status) {
        RegisterPage registerPage = new RegisterPage(driver);
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        if (status.equals("success")) {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            ElementLocatorRegister.LOGOUT_BUTTON
                    )
            );
            registerPage.clickLogoutButton();
        } else if (status.equals("failed")) {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            ElementLocatorRegister.USERNAME_ALREADY_EXIST
                    )
            );
        }
        driver.quit();
    }

    @And("^User input invalid password confirmation (.*)$")
    public void userInputInvalidPasswordConfirmation(String repeatPassword) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.userInputPasswordConfirmation(repeatPassword);
    }

    @Then("^User get error password did not match$")
    public void userGetErrorPasswordDidNotMatch() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ElementLocatorRegister.ERROR_PASSWORD_NOT_MATCH
                )
        );

        driver.quit();
    }
}
