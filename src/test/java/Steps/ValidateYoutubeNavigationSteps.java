package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ValidateYoutubeNavigationSteps extends BaseUtilities {
    private RemoteWebDriver _driver;
    public ValidateYoutubeNavigationSteps(BaseUtilities base) {

        _driver= base._driver;
    }

    @When("i try to click on Youtube link")
    public void i_try_to_click_on_youtube_link() {
        Home _home=new Home(_driver);
        _driver= _home.navSocialSite("youtube");
    }
    @Then("the page should redirect to Youtube Page")
    public void the_page_should_redirect_to_youtube_page() {
        Assert.assertTrue("Expected Url should Redirect to Youtube Page",
                _driver.getCurrentUrl().contains("youtube"));
    }
}
