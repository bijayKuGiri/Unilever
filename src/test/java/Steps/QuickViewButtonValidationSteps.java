package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.PDP;
import Pages.ProductListing;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

public class QuickViewButtonValidationSteps extends BaseUtilities {

    private Home _home;
    private PDP _pdp;
    private RemoteWebDriver _driver;

    public QuickViewButtonValidationSteps(BaseUtilities base) {
        _driver = base._driver;
    }
    @And("click on the Quick View button in product carousal")
    public void click_on_the_Quick_View_button_in_product_carousal() {
        _home=new Home(_driver);
        _home.ClickOnQuickView(_driver);
    }

    @When("i try to click on Find Out More button in Quick View popup")
    public void the_quick_view_popup_should_be_displayed() {
        Assert.assertTrue("Expected Quick view pop up should visible",
                _home.verifyQuickViewpopup(_driver));
        _pdp = _home.ClickOnFindOutMoreButton(_driver);
    }
    //public void iTryToClickOnFindOutMoreButtoninPopup() {
        //_pdp = _home.ClickOnFindOutMoreButton(_driver);
    //}

    @Then("the respective PDP page should be open")
    public void the_respective_PDP_page_should_be_displayed() {
        _pdp.validatePageNavigationToProductImage();
    }
}