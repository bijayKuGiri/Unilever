package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.ProductListing;
import Utility.Helper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductListingPageValidationSteps extends BaseUtilities {

    public ProductListing prodLst;
    public ProductListingPageValidationSteps(BaseUtilities base) {_driver= base._driver;}

    @When("I navigate to a Product Listing page")
    public void i_navigate_to_a_product_listing_page() {
        Home _home=new Home(_driver);
        prodLst= _home.GoToProductListingPage(_driver);
    }

    @Then("Product Listing Details should be displayed")
    public void product_Listing_details_should_be_displayed() {
        prodLst.IsDisplayedHeroSection();
        prodLst.IsDisplayedAnchorLinkNavigation();
        prodLst.IsDisplayedText();
        prodLst.IsDisplayedSmallTabImages();
        prodLst.IsDisplayedBigTabImages();
        prodLst.IsDisplayedButtons();

    }
}



