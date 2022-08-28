package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TransferFundFunctionalityTest {

    WebDriver driver;

    @Given("User navigate to ZeroBank2 website")
    public void user_navigate_to_zero_bank2_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://zero.webappsecurity.com/login.html");

    }

    @When("User login to ZeroBank2 with valid username2 and password2")
    public void user_login_to_zero_bank2_with_valid_username2_and_password2() {
        WebElement loginInput = driver.findElement(By.id("user_login"));
        loginInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys("password");

        WebElement signInButton = driver.findElement(By.name("submit"));
        signInButton.click();

        driver.navigate().back();
    }

    @Then("User click on OnlineBanking2")
    public void user_click_on_online_banking2() {
        WebElement onlineBankingButton = driver.findElement(By.id("online-banking"));
        onlineBankingButton.click();
    }

    @Then("User go to TransferFund tab")
    public void user_go_to_transfer_fund_tab() {
        WebElement transferFundTab = driver.findElement(By.id("transfer_funds_link"));
        transferFundTab.click();
    }

    @Then("User should select from account")
    public void user_should_select_from_account() {
        WebElement fromAccountDropdown = driver.findElement(By.id("tf_fromAccountId"));
        Select selectFromAccount = new Select(fromAccountDropdown);
        selectFromAccount.selectByVisibleText("Savings(Avail. balance = $ 1000)");
    }

    @Then("User should select to account")
    public void user_should_select_to_account() {
        WebElement toAccountDropdown = driver.findElement(By.id("tf_toAccountId"));
        Select selectToAccount = new Select(toAccountDropdown);
        selectToAccount.selectByVisibleText("Credit Card(Avail. balance = $ -265)");
    }

    @Then("User should enter {string}")
    public void user_should_enter(String amount) {
        WebElement amountInput = driver.findElement(By.id("tf_amount"));
        amountInput.sendKeys(amount);
    }

    @Then("User should fill the {string}")
    public void user_should_fill_the_description(String description) {
        WebElement descriptionInput = driver.findElement(By.id("tf_description"));
        descriptionInput.sendKeys(description);
    }

    @Then("User should click continue button")
    public void user_click_on_continue_button() {
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"btn_submit\"]"));
        continueButton.click();
    }

    @Then("User should click submit button")
    public void user_click_on_submit_button() {
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"btn_submit\"]"));
        submitButton.click();
    }

    @Then("User should see success text")
    public void user_should_see_success_text() {
        WebElement successText = driver.findElement(By.cssSelector("div[class='alert alert-success']"));

        Assert.assertTrue(successText.getText().toLowerCase().contains("success"));

    }

}
