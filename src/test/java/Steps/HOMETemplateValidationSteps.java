package Steps;

import Base.BaseUtilities;
import Utility.Helper;
import Pages.Home;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HOMETemplateValidationSteps extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;

    public HOMETemplateValidationSteps(BaseUtilities base) {

        this.base = base;
        _driver = base._driver;
    }

    @When("Verifying Home Page Template")
    public void verifying_home_page_template() {
        System.out.println("Verifying Home Page Template");
        _home=new Home(base._driver);
    }

    @Then("Home Page Details should be displayed")
    public void Home_Page_should_be_displayed() {
        _home.IsHeaderDisplayed();
        _home.IsLogoImageDisplayed();
        _home.IsSearchButtonDisplayed();
        _home.IsHeaderNavigationItemsDisplayed();
        _home.IsTabSwitchDisplayed();
        _home.IsTabPanelDisplayed();
        _home.IsPageListDisplayed();
        _home.IsProductCarouselDisplayed();
        _home.IsFooterDisplayed();

    }


}

