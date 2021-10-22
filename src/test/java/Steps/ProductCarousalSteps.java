package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ProductCarousalSteps extends BaseUtilities {
    private Home _home;
    private final RemoteWebDriver _driver;

    public ProductCarousalSteps(BaseUtilities base) {
        _driver = base._driver;
    }

    @When("verifying the product carousel rotation")
    public void verifying_the_product_carousel_rotation() {
        _home=new Home(_driver);
        _home.isProductCarousalDisplayed();
    }
    @Then("product carousel should be work as expected")
    public void product_carousel_should_be_work_as_expected() throws InterruptedException {
        _home.verifyProductCarouselRotation();
    }
}
