package Steps;

import Base.BaseUtilities;
import Pages.ContactUs;
import Pages.Home;
import Utility.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class VerifyPrivacyNoticeSteps {

    private Home _home;
    private ContactUs _contact;
    private RemoteWebDriver _driver;
    public VerifyPrivacyNoticeSteps(BaseUtilities base) {
        _driver= base._driver;
    }

    @When("i try to click on PrivacyNotice link")
    public void iTryToClickOnPrivacyNoticeLink() throws InterruptedException {
        _contact.SelectReason("Question");
        _contact.SelectSubject("Business");
        _driver=_contact.navPrivacyNotice();
    }

    @And("Navigate to ContactUS Page")
    public void navigateToContactUSPage() {
        _home=new Home(_driver);
        _contact=_home.navContactUs();
    }

    @Then("the page should redirect to PrivacyNotice page")
    public void thePageShouldRedirectToPrivacyNoticePage() {
        Assert.assertTrue(_contact.IsNavigatePrivacyNotice(_driver));
    }

    @When("i try to click on PrivacyNotice link in home page")
    public void i_try_to_click_on_privacy_notice_link_in_home_page() {
        _home = new Home(_driver);
        _driver = _home.NavPrivacyNotice();
    }
    @Then("the page should redirect to PrivacyNotice page from home page")
    public void the_page_should_redirect_to_privacy_notice_page_from_home_page() {
        Assert.assertTrue(_home.IsNavigatePrivacyNotice(_driver));
    }
}
