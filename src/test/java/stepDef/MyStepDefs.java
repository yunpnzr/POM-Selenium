package stepDef;

import config.EnvTarget;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.home.HomePage;
import pages.register.RegisterPage;

import java.time.Duration;

public class MyStepDefs extends EnvTarget {

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
                        By.xpath("//*[@id='loginPanel']/p[2]")
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
                        By.xpath("//h1[contains(text(), 'Signing up is easy!')]")
                )
        );
    }

    @When("^User input name$")
    public void userInputName() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillNameRegisterForm(
                "Yun",
                "Edwi"
        );
    }

    @And("^User input address detail$")
    public void userInputAddressDetail() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillAddressRegisterForm(
                "Jalan",
                "Jakarta",
                "Jakarta",
                "12345",
                "08123456789",
                "123456789"
        );
    }

    @And("^User fill valid username and password$")
    public void userFillValidUsernameAndPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.userFillValidUsernameAndPassword(
                "Yuni04",
                "123456"
        );
    }

    @And("^User input password confirmation$")
    public void userInputPasswordConfirmation() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.userInputPasswordConfirmation("123456");
    }

    @When("^User click register button$")
    public void userClickRegisterButton() {
        driver.findElement(By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input")).click();
    }

    @Then("^User register successfully$")
    public void userRegisterSuccessfully() {
        driver.findElement(By.xpath("//a[contains(@href, 'logout')]"));
        driver.quit();
    }

    @And("^User input invalid password confirmation$")
    public void userInputInvalidPasswordConfirmation() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.userInputPasswordConfirmation("1234567");
    }

    @Then("^User get error password did not match$")
    public void userGetErrorPasswordDidNotMatch() {
        driver.findElement(By.xpath("//*[@id='repeatedPassword.errors']"));
        driver.quit();
    }
}
