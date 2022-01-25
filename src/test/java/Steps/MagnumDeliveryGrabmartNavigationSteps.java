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

public class MagnumDeliveryGrabmartNavigationSteps extends BaseUtilities {
    private MagnumDelivery _magnumdelivery;
    private RemoteWebDriver _driver;
    private Home _home;
    private List<WebElement> elements;

    public MagnumDeliveryGrabmartNavigationSteps(BaseUtilities base) {
        _driver = base._driver;
    }

    @And("user redirected to Magnum Delivery page")
    public void i_navigate_to_a_magnum_delivery_page() {
        Home _home = new Home(_driver);
        _magnumdelivery = _home.GoToMagnumDeliveryPage(_driver);

    }

    @When("user click on Grabmart image on magnum delivery page")
    public void i_try_to_click_on_Grabmart_icon() throws InterruptedException {
        _magnumdelivery.validatePageNavigationToGrabmartIcon();
        _driver = _magnumdelivery.ClickOnGrabmartIcon();

    }

    @Then("it should open Grabmart in next tab")
    public void Grabmart_link_should_be_opened_in_next_tab() throws InterruptedException {
        Assert.assertTrue(_magnumdelivery.IsNavigateToGrabmartPage(_driver));

    }

}
