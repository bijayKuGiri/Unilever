package Steps;

import Base.BaseUtilities;
import Pages.ContactUs;
import Pages.Home;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class VerifyCookiesNoticeSteps {

    private Home _home;
    private ContactUs _contact;
    private RemoteWebDriver _driver;
    public VerifyCookiesNoticeSteps(BaseUtilities base) {
        _driver= base._driver;
    }
    @Given("Navigate to Contactus Page")
    public void navigate_to_contactus_page() {
        _home=new Home(_driver);
        _contact=_home.navContactUs();
    }
    @When("i try to click on CookiesNotice link")
    public void i_try_to_click_on_cookies_notice_link() throws InterruptedException {
        _contact.SelectReason("Question");
        _contact.SelectSubject("Business");
        //Helper.scrollDownPage(_driver,1);
        //Thread.sleep(2000);
        //Helper.scrollDownPage(_driver,1);
        _driver=_contact.navCookiesNotice();
    }
    @Then("the page should redirect to CookiesNotice page")
    public void the_page_should_redirect_to_cookies_notice_page() {
        Assert.assertTrue(_contact.IsNavigateCookiesNotice(_driver));
    }

    @When("i try to click on CookiesNotice link in Home Page")
    public void i_try_to_click_on_cookies_notice_link_in_home_page() {
        _home=new Home(_driver);
        _driver=_home.NavCookiesNotice();
    }
    @Then("the page should redirect to CookiesNotice page from Home Page")
    public void the_page_should_redirect_to_cookies_notice_page_from_home_page() {
        Assert.assertTrue(_home.IsNavigateCookiesNotice(_driver));
    }
}
