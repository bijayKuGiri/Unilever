package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class BackToTopSteps extends BaseUtilities{
    private BaseUtilities base;
    private Home _home;
    private RemoteWebDriver _driver;

    public BackToTopSteps(BaseUtilities base) {

        this.base = base;
        _driver = base._driver;
    }

    @When("i try to click on Back To Start button")
    public void i_try_to_click_on_back_to_start_button() {
        _home=new Home(_driver);
        _home.BackToStartClick();
    }

    @Then("the page should redirect to the top of the Home page")
    public void the_page_should_redirect_to_the_top_of_the_home_page() {
        Assert.assertTrue( _home.isHeaderCrausalDisplay());
    }
}
