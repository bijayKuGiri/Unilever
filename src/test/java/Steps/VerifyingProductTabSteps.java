package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;

public class VerifyingProductTabSteps extends BaseUtilities {
    //private BaseUtilities base;
    private Home _home;
    private final RemoteWebDriver _driver;

    public VerifyingProductTabSteps(BaseUtilities base) {

        //this.base = base;
        _driver = base._driver;
    }


    @Given("navigate to Product tab switch")
    public void navigate_to_product_tab_switch() {
        _home=new Home(_driver);
        _home.navigateProductTabs();

    }
    @When("try to click on Product next tab")
    public void try_to_click_on_product_next_tab() {
        _home.selectProductTabs();
    }
    @Then("it should be switched to Next Product tab")
    public void it_should_be_switched_to_next_product_tab() throws InterruptedException {
        _home.VerifyProductImages();
    }


}
