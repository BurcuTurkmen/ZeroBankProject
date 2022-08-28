package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class NewPayeeFunctionalityTest {

    WebDriver driver;

    @Given("navigate to ZeroBank website")
    public void navigate_to_zero_bank_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://zero.webappsecurity.com/login.html");
    }

    @When("User login to ZeroBank with valid username and password")
    public void user_login_to_zero_bank_with_valid_username_and_password() {
        WebElement loginInput = driver.findElement(By.id("user_login"));
        loginInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys("password");

        WebElement signInButton = driver.findElement(By.name("submit"));
        signInButton.click();

        driver.navigate().back();

    }

    @Then("User click on OnlineBanking")
    public void user_click_on_online_banking() {
        WebElement onlineBankingButton = driver.findElement(By.id("online-banking"));
        onlineBankingButton.click();
    }

    @When("User go to PayBills tab")
    public void user_go_to_pay_bills_tab() {
        WebElement payBills = driver.findElement(By.id("pay_bills_link"));
        payBills.click();
    }

    @When("User go to AddNewPayee tab")
    public void user_go_to_add_new_payee_tab() {
        WebElement addNewPayeeTab = driver.findElement(By.linkText("Add New Payee"));
        addNewPayeeTab.click();
    }

    @Then("User should add {string}")
    public void user_should_add(String payeeName) {
        WebElement addPayeeName = driver.findElement(By.id("np_new_payee_name"));
        addPayeeName.sendKeys(payeeName);
    }

    @Then("User should fill {string}, {string}, {string}")
    public void user_should_fill(String payeeAddress, String account, String payeeDetails) {
       WebElement payeeAddressInput = driver.findElement(By.id("np_new_payee_address"));
       payeeAddressInput.sendKeys(payeeAddress);

       WebElement accountInput = driver.findElement(By.id("np_new_payee_account"));
       accountInput.sendKeys(account);

       WebElement payeeDetailsInput = driver.findElement(By.id("np_new_payee_details"));
       payeeAddressInput.sendKeys(payeeDetails);
    }

    @Then("User click on Add Button")
    public void user_click_on_add_button() {
        WebElement addButton = driver.findElement(By.id("add_new_payee"));
        addButton.click();
    }

    @Then("User should see success message")
    public void user_should_see_success_message() {
        WebElement successMessage = driver.findElement(By.id("alert_content"));
        System.out.println("Success Message: " + successMessage.getText());

        String expectedMessage = "The new payee Xfinity was successfully created.";

        Assert.assertTrue(successMessage.getText().toLowerCase().contains("success"));
        Assert.assertEquals(successMessage.getText(), expectedMessage);

        driver.quit();
    }

}
