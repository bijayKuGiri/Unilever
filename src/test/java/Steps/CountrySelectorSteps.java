package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class CountrySelectorSteps extends BaseUtilities {
    private BaseUtilities base;
    private Home _home;
    private RemoteWebDriver _driver;

    public CountrySelectorSteps(BaseUtilities base) {

        this.base = base;
        _driver = base._driver;
    }

    @When("i try to click on Select Your Country link in footer")
    public void i_try_to_click_on_select_your_country_link_in_footer() {
        _home=new Home(_driver);
        _driver= _home.selectCountry();

    }
    @Then("the Country Selector page should be displayed")
    public void the_country_selector_page_should_be_displayed() {
        Assert.assertTrue(_home.isCountrySelected());
    }
}
