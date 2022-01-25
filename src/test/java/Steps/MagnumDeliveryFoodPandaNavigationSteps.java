package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.MagnumDelivery;
import Pages.PDP;
import Pages.ProductListing;
import Utility.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.List;

public class MagnumDeliveryFoodPandaNavigationSteps {
    private MagnumDelivery _magnumdelivery;
    private RemoteWebDriver _driver;
    private Home _home;
    private List<WebElement> elements;

    public MagnumDeliveryFoodPandaNavigationSteps(BaseUtilities base) {
        _driver = base._driver;
    }

    //@And("user redirected to Magnum Delivery page")
    //public void i_navigate_to_a_magnum_delivery_page() {
      //  Home _home = new Home(_driver);
        //_magnumdelivery = _home.GoToMagnumDeliveryPage(_driver);

    //}

    @When("user click on Foodpanda image")
    public void i_try_to_click_on_foodpanda_icon() throws InterruptedException {
        _magnumdelivery.validatePageNavigationToFoodpandaIcon();
        _driver = _magnumdelivery.ClickOnFoodpandaicon();

    }

    @Then("it should open foodpanda in next tab")
    public void Foodpanda_link_should_be_opened_in_next_tab() throws InterruptedException {
        Assert.assertTrue(_magnumdelivery.IsNavigateToFoodpandaPage(_driver));

    }

}
