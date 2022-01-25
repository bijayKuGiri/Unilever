package Steps;

import Base.BaseUtilities;
import Pages.ContactUs;
import Pages.Home;
//import gherkin.formatter.model.ScenarioOutline;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class VerifyContactUs  {

    private Home _home;
    private ContactUs _contact;
    SoftAssert softAssert = new SoftAssert();
    private RemoteWebDriver _driver;

    public VerifyContactUs(BaseUtilities base) {
        _driver = base._driver;
    }


    @When("navigate to contact us page and fill the details {},{},{} and {}")
    public void navigateToContactUsPageAndFillTheDetailsNameLastnameEmailAndComment(String name, String lastname,
                                                                                    String email, String Comment) throws InterruptedException {
        _home = new Home(_driver);
        _contact = _home.navContactUs();
        _contact.SelectReason("Question");
        _contact.SelectSubject("Business");
        _contact.enterNameEmailAndComments(name, lastname, email, Comment);

    }

    @Then("user should get message based on {} Criteria")
    public void user_should_get_message_based_on_valid(String Criteria) {
        switch (Criteria) {
            case "Valid":
                _contact.setValid(true);
                _contact.hitSubmit();
                _contact.clickConfirm();
                Assert.assertTrue(_contact.VerifySuccessContactUS());
                System.out.println(_contact.getMessage());
                break;
            case "NameMissing":
                _contact.hitSubmit();
                Assert.assertTrue(_contact.isNameErrorDisplay());
                break;
            case "lastnameMissing":
                _contact.hitSubmit();
                Assert.assertTrue(_contact.isLastNameErrorDisplay());
                break;
            case "emailMissing":
            case "inValidEmail":
                _contact.hitSubmit();
                Assert.assertTrue(_contact.isEmailErrorDisplay());
                break;
            case "commentMissing":
                _contact.hitSubmit();
                Assert.assertTrue(_contact.isCommentErrorDisplay());
                Assert.assertTrue(_contact.isLegalAgeErrorDisplay());
                break;

            case "ageConfirmMissing":
                _contact.hitSubmit();
                Assert.assertTrue(_contact.isLegalAgeErrorDisplay());
                break;
            default:
                System.out.println("No Criteria");
        }
    }


    @When("navigate to contact us page and without Age confirmation fill the details {},{},{} and {}")
    public void navigateToContactUsPageAndWithoutAgeConfirmationFillTheDetailsNameLastnameEmailAndComment(String name, String lastname,
                                                                                                          String email, String Comment) throws InterruptedException {
        _home = new Home(_driver);
        _contact = _home.navContactUs();
        _contact.SelectReason("Question");
        _contact.SelectSubject("Business");
        _contact.enterDetailsWithoutAgeConfirm(name, lastname, email, Comment);
    }

    @Given("navigate to contact us page for Concern")
    public void navigate_to_contact_us_page_for_concern() {
        _home = new Home(_driver);
        _contact = _home.navContactUs();
        _contact.SelectReason("Concern");
        _contact.SelectSubject("Business");
    }
    @When("fill the details {},{},{} and {}")
    public void fill_the_details_name_lastname_email_and_comment(String name,String lastname,
                                                                 String email, String Comment) throws InterruptedException {
        _contact.enterNameEmailAndComments(name, lastname, email, Comment);
    }
    @When("filling the details {},{},{},{},{},{},{},{},{},{} and {} for a product")
    public void fillDetailsForProduct(String name,String lastname,String email, String productname,String barcode,String code,
                                      String uploadfile, String duration,String buyingMode,String retailer, String Comment) throws InterruptedException {
        _contact.enterDetailsForProduct(name, lastname, email, productname,barcode,code,uploadfile,duration,buyingMode,retailer,Comment);
    }

    @Given("navigate to contact us page for Concern on Product")
    public void navigate_to_contact_us_page_for_concern_on_product() {
        _home = new Home(_driver);
        _contact = _home.navContactUs();
        _contact.SelectReason("Concern");
        _contact.SelectSubject("Product");
    }
    /*@When("using keyboard navigate to contact us page and fill the details {},{},{} and {}")
    public void navigate_to_contact_us_page_and_fill_the_details_using_keyboard(String name, String lastname,
                                                                                String email, String Comment) throws InterruptedException {
        _home = new Home(base._driver);
        _home.navContactUsUsingKeyboard();
        Thread.sleep(3000);
        _home.SelectReasonUsingKeyBoard();
        //_contact.SelectSubject("Business");
    }
    @Then("user should get appropriate message based on <Criteria> Criteria")
    public void user_should_get_appropriate_message_based_on_criteria_criteria() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }*/
}
