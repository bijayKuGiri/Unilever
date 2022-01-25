package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.MagnumTowel;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CampaignGallerySteps {

    private BaseUtilities base;
    private MagnumTowel magnumTowel;
    private RemoteWebDriver _driver;

    public CampaignGallerySteps(BaseUtilities base) {

        this.base = base;
        _driver = base._driver;
    }

    @When("i click on load more")
    public void i_click_on_load_more() {
        magnumTowel=new MagnumTowel(_driver);
        magnumTowel.clickBtnLoadMore();

    }
    @Then("the more images should load to the page")
    public void the_more_images_should_load_to_the_page() {
        magnumTowel.ValidateImage();
    }
}
