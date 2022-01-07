package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.PDP;
import Pages.ProductListing;
import Utility.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductFindOutMoreButtonValidationSteps extends BaseUtilities{

    private PDP _pdp;
    public ProductFindOutMoreButtonValidationSteps(BaseUtilities base) {_driver= base._driver;}

    @And("click on Find out more button, redirected to PDP page")
    public void iTryToClickOnFindOutMoreButton() {
        ProductListing _prodLst = new ProductListing(_driver);
        _pdp = _prodLst.ClickOnFindOutMoreButton(_driver);
        _pdp.validatePageNavigationToProductImage();
    }

}
