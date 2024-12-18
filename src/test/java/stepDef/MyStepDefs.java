package stepDef;

import config.EnvTarget;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        //wait.until(driver -> driver.getCurrentUrl().equals(urlLogin));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id='loginPanel']/p[2]")
                )
        );
    }

    @When("^User click register link button$")
    public void userClickRegisterLinkButton() {
        driver.findElement(By.xpath("//a[contains(@href, 'register')]")).click();
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
        driver.findElement(By.id("customer.firstName")).sendKeys("Yun");
        driver.findElement(By.name("customer.lastName")).sendKeys("Edwi");
    }

    @And("^User input address detail$")
    public void userInputAddressDetail() {
        driver.findElement(By.id("customer.address.street")).sendKeys("Jalan");
        driver.findElement(By.id("customer.address.city")).sendKeys("Jakarta");
        driver.findElement(By.id("customer.address.state")).sendKeys("Jakarta");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("12345");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("08123456789");
        driver.findElement(By.id("customer.ssn")).sendKeys("123456789");
    }

    @And("^User fill valid username and password$")
    public void userFillValidUsernameAndPassword() {
        driver.findElement(By.id("customer.username")).sendKeys("Yuni01");
        driver.findElement(By.id("customer.password")).sendKeys("123456");
    }

    @And("^User input password confirmation$")
    public void userInputPasswordConfirmation() {
        driver.findElement(By.id("repeatedPassword")).sendKeys("123456");
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
        driver.findElement(By.id("repeatedPassword")).sendKeys("1234567");
    }

    @Then("^User get error password did not match$")
    public void userGetErrorPasswordDidNotMatch() {
        driver.findElement(By.xpath("//*[@id='repeatedPassword.errors']"));
        driver.quit();
    }
}
