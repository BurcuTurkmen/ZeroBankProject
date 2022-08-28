package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PurchaseForeignCurrencyTest {

    WebDriver driver;

    @Given("User navigate to ZeroBank1 website")
    public void user_navigate_to_zero_bank1_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://zero.webappsecurity.com/login.html");
    }

    @When("User login to ZeroBank1 with valid username1 and password1")
    public void user_login_to_zero_bank1_with_valid_username1_and_password1() {
        WebElement loginInput = driver.findElement(By.id("user_login"));
        loginInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys("password");

        WebElement signInButton = driver.findElement(By.name("submit"));
        signInButton.click();

        driver.navigate().back();
    }

    @Then("User click on OnlineBanking1")
    public void user_click_on_online_banking1() {
        WebElement onlineBankingButton = driver.findElement(By.id("online-banking"));
        onlineBankingButton.click();
    }

    @Then("User go to PayBills1 tab")
    public void user_go_to_pay_bills1_tab() {
        WebElement payBills = driver.findElement(By.id("pay_bills_link"));
        payBills.click();
    }

    @Then("User click on PurchaseForeignCurrencyTab")
    public void user_click_on_purchase_foreign_currency_tab() {
        WebElement purchaseForeignCurrencyTab = driver.findElement(By.linkText("Purchase Foreign Currency"));
        purchaseForeignCurrencyTab.click();
    }

    @Then("User should select currency type")
    public void user_should_select_currency_type() {
        WebElement currencyDropdown =driver.findElement(By.id("pc_currency"));
        Select selectCurrency = new Select(currencyDropdown);
        selectCurrency.selectByVisibleText("Australia (dollar)");
    }

    @Then("User should enter the {string}")
    public void user_should_enter_the(String amount) {
        WebElement amountInput = driver.findElement(By.id("pc_amount"));
        amountInput.sendKeys(amount);
    }

    @Then("User should select the calculation currency")
    public void user_should_select_the_calculation_currency() {
        WebElement calculationCurrencyRadioButton = driver.findElement(By.id("pc_inDollars_true"));
        calculationCurrencyRadioButton.click();
    }

    @When("User click on calculate cost button")
    public void user_click_on_calculate_cost_button() {
        WebElement calculateCostButton = driver.findElement(By.id("pc_calculate_costs"));
        calculateCostButton.click();
    }

    @Then("User should see the conversion amount")
    public void user_should_see_the_conversion_amount() {
        WebElement conversionAmountResult = driver.findElement(By.id("pc_conversion_amount"));

        boolean isDisplayedText = conversionAmountResult.isDisplayed();
        //System.out.println(conversionAmountResult);
    }

    @Then("User click on purchase button")
    public void user_click_on_purchase_button() {
        WebElement purchaseButton = driver.findElement(By.id("purchase_cash"));
        purchaseButton.click();
    }

    @Then("User should see confirmation message")
    public void user_should_see_confirmation_message() {
        WebElement confirmationMessage = driver.findElement(By.id("alert_content"));
        System.out.println("Success Message: " + confirmationMessage.getText());

        String expectedMessage = "Foreign currency cash was successfully purchased.";

        Assert.assertTrue(confirmationMessage.getText().toLowerCase().contains("success"));
        Assert.assertEquals(confirmationMessage.getText(), expectedMessage);

        driver.quit();

    }

}
