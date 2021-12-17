package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.PDP;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PDPTemplateValidationSteps extends BaseUtilities {

    private PDP _pdp;
    public PDPTemplateValidationSteps(BaseUtilities base) {
        _driver= base._driver;
    }

    @When("i navigate to a PDP page")
    public void i_navigate_to_a_pdp_page() {
        Home _home=new Home(_driver);
        _pdp= _home.GoToPDPPage(_driver);
    }

    @Then("Product Details should be displayed")
    public void product_details_should_be_displayed() {
        _pdp.validatePageNavigationToProductImage();
        _pdp.validatePageNavigationToProductReviewRatingSection();
        _pdp.validatePageNavigationToProductDescription();
        _pdp.validatePageNavigationToProductName();
        _pdp.validatePageNavigationToProductNutritionalInformationSection();
        _pdp.validatePageNavigationToProductPageListComponent();
        _pdp.validatePageNavigationToProductReadReviewPanelHeader();
        _pdp.validatePageNavigationToProductReadReviewPanelReviews();
    }



}
