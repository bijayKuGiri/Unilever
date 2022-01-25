package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ValidateInstagramSteps {

    private Home _home;
    private RemoteWebDriver _driver;
    public ValidateInstagramSteps(BaseUtilities base) {

        _driver= base._driver;
    }

    @When("i try to click on Instagram link")
    public void i_try_to_click_on_instagram_link() {
        _home=new Home(_driver);
        _driver= _home.navSocialSite("instagram");
    }
    @Then("the page should redirect to InstagramPage")
    public void the_page_should_redirect_to_instagram_page() {
        Assert.assertTrue("Expected Url should Redirect to Instagram Page",
                _driver.getCurrentUrl().contains("instagram"));
    }
}
