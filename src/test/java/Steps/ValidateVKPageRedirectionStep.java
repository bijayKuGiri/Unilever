package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ValidateVKPageRedirectionStep{

    private Home _home;
    private RemoteWebDriver _driver;
    public ValidateVKPageRedirectionStep(BaseUtilities base) {

        _driver= base._driver;
    }
    @When("i try to click on VK icon")
    public void i_try_to_click_on_VK_link() throws InterruptedException {
        _home=new Home(_driver);
        _driver = _home.navVK();
    }
    @Then("the page should redirect to VK page")
    public void the_page_should_redirect_to_VK_page() {
        Assert.assertTrue(_home.IsNavigateVK(_driver));
    }
}
