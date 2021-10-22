package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class VerifySearchSteps extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private RemoteWebDriver _driver;

    public VerifySearchSteps(BaseUtilities base) {

        this.base = base;
        _driver = base._driver;
    }

    @When("i navigate to search page and search for a product")
    public void i_navigate_to_search_page_and_search_for_a_product() {
        _home = new Home(_driver);
        _home.search("Magnum Vegan Almonds");
    }

    @Then("it should shows the products in Results")
    public void it_should_shows_the_products_in_results() {
        Assert.assertTrue(_home.getSearchCount()>=1,"Expected search result should show one or more products");
    }

    @When("i navigate to search page and search for a  wrong product")
    public void iNavigateToSearchPageAndSearchForAWrongProduct() {
        _home = new Home(_driver);
        _home.search("invalidbhhsbhddh");
    }

    @Then("it should not shows any products in Results")
    public void itShouldNotShowsAnyProductsInResults() {
        Assert.assertTrue(_home.isNoResultDisplay());
    }
}
