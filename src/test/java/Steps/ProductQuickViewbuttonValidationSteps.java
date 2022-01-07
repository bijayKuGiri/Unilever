package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.ProductListing;
import Utility.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductQuickViewbuttonValidationSteps extends BaseUtilities{

    public ProductListing prodLst;
    public ProductQuickViewbuttonValidationSteps(BaseUtilities base) {_driver= base._driver;}

    @And("navigate to any random Product listing page")
    public void i_navigate_to_any_product_listing_page() {
        Home _home=new Home(_driver);
        prodLst= _home.GotoRandomProductListingPage(_driver);
    }

    @When("i try to click on Quick view button for any product")
    public void iTryToClickOnQuickViewButtonForAnyProduct() {
        prodLst.ClickOnQuickView(_driver);
    }

    @Then("Popup should open on the same tab with Product name, detail and other buttons")
    public void popupShouldOpenOnTheSameTabWithProductNameDetailAndOtherButtons() {
        prodLst.IsDisplayedQuickViewPopup();
    }
}
