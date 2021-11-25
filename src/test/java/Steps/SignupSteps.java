package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.SignUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class SignupSteps extends BaseUtilities {

    private Home _home;
    private SignUp signUp;
    private RemoteWebDriver _driver;
    public SignupSteps(BaseUtilities base) {

        _driver= base._driver;
    }

    @And("navigate to signup page")
    public void navigate_to_signup_page() {
        _home=new Home(_driver);
        _driver=_home.NavSignUp();
    }
    @When("enter all the details and submit")
    public void enter_all_the_details_and_submit() {
        signUp=new SignUp(_driver);
        signUp.SignUpWithDetails("test","lat Test","test@test.com",
                "11051980","","56990-123",true);
    }
    @Then("it should submit and redirect to confirmation page.")
    public void it_should_submit_and_redirect_to_confirmation_page() {
        signUp.isConfirmOkDisplay();
        signUp.clickOkBtn();
    }

    @When("enter all the details without name and submit")
    public void enter_all_the_details_without_name_and_submit() {
        signUp=new SignUp(_driver);
        signUp.SignUpWithDetails("","lat Test","test@test.com",
                "11051980","9000000043","56990-123",true);
    }
    @Then("it should display validation message with respect to name")
    public void it_should_display_validation_message_with_respect_to_name() {
        Assert.assertTrue(signUp.ValidationForNameDisplay());
    }

    @When("enter all the details without lastname and submit")
    public void enter_all_the_details_without_lastname_and_submit() {
        signUp=new SignUp(_driver);
        signUp.SignUpWithDetails("test","","test@test.com",
                "11051980","9000000043","56990-123",true);
    }
    @Then("it should display validation message with respect to lastname")
    public void it_should_display_validation_message_with_respect_to_lastname() {
        Assert.assertTrue(signUp.ValidationForLastNameDisplay());
    }

    @When("enter all the details without email and submit")
    public void enter_all_the_details_without_email_and_submit() {
        signUp=new SignUp(_driver);
        signUp.SignUpWithDetails("test","lat Test","",
                "11051980","9000000043","56990-123",true);
    }
    @Then("it should display validation message with respect to email")
    public void it_should_display_validation_message_with_respect_to_email() {
        Assert.assertTrue(signUp.ValidationForEmailDisplay());
    }

    @When("enter all the details without DOB and submit")
    public void enter_all_the_details_without_dob_and_submit() {
        signUp=new SignUp(_driver);
        signUp.SignUpWithDetails("test","lat Test","test@test.com",
                "","9000000043","56990-123",true);
    }
    @Then("it should display validation message with respect to DOB")
    public void it_should_display_validation_message_with_respect_to_dob() {
        Assert.assertTrue( signUp.ValidationForDOBDisplay());
    }

    @When("enter all the details without zipcode and submit")
    public void enter_all_the_details_without_zipcode_and_submit() {
        signUp=new SignUp(_driver);
        signUp.SignUpWithDetails("test","lat Test","test@test.com",
                "11051980","9000000043","",true);
    }
    @Then("it should display validation message with respect to zipcode")
    public void it_should_display_validation_message_with_respect_to_zipcode() {
        Assert.assertTrue(signUp.ValidationForZipCodeDisplay());
    }
}
