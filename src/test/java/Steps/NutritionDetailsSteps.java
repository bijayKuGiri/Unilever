package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Utility.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.var;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class NutritionDetailsSteps {

    private final RemoteWebDriver _driver;
    private Home _home;

    public NutritionDetailsSteps(BaseUtilities base) {
        this._driver = base._driver;
    }

    @And("Navigate to a product")
    public void navigate_to_a_product() {
        _home=new Home(_driver);
        var lstProducts= _home.getProducts();
        Assert.assertTrue(lstProducts.size()>0,"Expected more than 0 products should be available on the page");
        Helper.scrollAndClick(_driver, lstProducts.get(1));
        Assert.assertTrue(_home.IsSummeryExist());
    }
    @When("i try to click on nutrition details")
    public void i_try_to_click_on_nutrition_details() {
        _home.clickOnNutritionLnk();
    }
    @Then("nutrition details should be displayed")
    public void nutrition_details_should_be_displayed() {
        _home.VerifyTheNutritionDetails();
    }
}
