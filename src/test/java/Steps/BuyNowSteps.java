package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BuyNowSteps extends BaseUtilities {

    private Home _home;
    private RemoteWebDriver _driver;

    public BuyNowSteps(BaseUtilities base) {
        _driver = base._driver;
    }

    @When("click on the buy now button in product carousal")
    public void click_on_the_buy_now_button_in_product_carousal() {
        _home=new Home(_driver);
        _home.ClickOnBuynow(_driver);
    }
    @Then("the respective page should be open.")
    public void the_respective_page_should_be_open() {
        Assert.assertTrue("Expected Buy Now pop up should visibel",
                _home.verifyBuyNowpopup(_driver));
    }
}
