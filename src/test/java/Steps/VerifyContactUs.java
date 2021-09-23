package Steps;

import Base.BaseUtilities;
import Pages.ContactUs;
import Pages.Home;
//import gherkin.formatter.model.ScenarioOutline;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class VerifyContactUs extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private ContactUs _contact;
    SoftAssert softAssert=new SoftAssert();
    private RemoteWebDriver _driver;

    public VerifyContactUs(BaseUtilities base) {
        this.base = base;
        _driver=base._driver;
    }


    @When("navigate to contact us page and fill the details {},{},{} and {}")
    public void navigateToContactUsPageAndFillTheDetailsNameLastnameEmailAndComment(String name,String lastname,
                                                                                    String email,String Comment) throws InterruptedException {
        _home=new Home(base._driver);
        _contact=_home.navContactUs();
        _contact.SelectReason("Question");
        _contact.SelectSubject("Business");
        _contact.enterNameEmailAndComments(name,lastname,email,Comment);

    }
    @Then("user should get message based on {} Criteria")
    public void user_should_get_message_based_on_valid(String Criteria) {
        switch (Criteria){
            case "Valid":
                Assert.assertTrue(_contact.VerifySuccessContactUS());
                System.out.println(_contact.getMessage());
                break;
            case "NameMissing":
                Assert.assertTrue(_contact.isNameErrorDisplay());
                break;
            case "lastnameMissing":
                Assert.assertTrue(_contact.isLastNameErrorDisplay());
                break;
            case "emailMissing":
            case "inValidEmail":
                Assert.assertTrue(_contact.isEmailErrorDisplay());
                break;
            case "commentMissing":
                Assert.assertTrue(_contact.isCommentErrorDisplay());
                Assert.assertTrue(_contact.isLegalAgeErrorDisplay());
                break;
            default:
                System.out.println("No Criteria");
        }
    }


}
