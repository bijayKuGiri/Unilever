package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BuyNowSteps {

    private Home _home;
    private RemoteWebDriver _driver;
    private String tagUrl;

    public BuyNowSteps(BaseUtilities base) {
        _driver = base._driver;
    }

    @When("click on the buy now button in product carousal")
    public void click_on_the_buy_now_button_in_product_carousal() {
        _home=new Home(_driver);
        _home.ClickOnBuyNow(_driver);
    }
    @Then("the respective page should be open.")
    public void the_respective_page_should_be_open() {
        Assert.assertTrue("Expected Buy Now pop up should visible",
                _home.verifyBuyPopup(_driver));
    }

    @When("Select the vendor from the list")
    public void select_the_vendor_from_the_list() throws InterruptedException {
        tagUrl= _home.selectVendor(_driver);
    }
    @Then("it should redirect to the vendor page")
    public void it_should_redirect_to_the_vendor_page() {

        System.out.printf(_driver.getCurrentUrl());
        System.out.println(tagUrl);
        Assert.assertTrue("",_home.getActiveWindow().getCurrentUrl().equalsIgnoreCase(tagUrl));
    }
}
