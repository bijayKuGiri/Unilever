package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.Assert;

public class VerifySearchSteps {

    private Home _home;
    private RemoteWebDriver _driver;
    private String url;

    public VerifySearchSteps(BaseUtilities base) {
        _driver = base._driver;
    }

    @When("i navigate to search page and search for a product")
    public void i_navigate_to_search_page_and_search_for_a_product() throws InterruptedException {
        _home = new Home(_driver);
        _home.search("Magnum");


    }

    @Then("it should shows the products in Results")
    public void it_should_shows_the_products_in_results()  {
        Assert.assertTrue("Expected search result should show one or more products",_home.getSearchCount()>0);
        //Assert.assertTrue(_home.getErrorCount()==0,"Expected no error message should display");
    }
    @When("click on any product of the product list")
    public void click_on_any_product_of_the_product_list() {
        url=_home.navSuggestionList();
    }
    @Then("it should navigate to the product details.")
    public void it_should_navigate_to_the_product_details() {
        Assert.assertTrue("",_driver.getCurrentUrl().equals(url));
    }

    @When("i navigate to search page and search for a  wrong product")
    public void iNavigateToSearchPageAndSearchForAWrongProduct() throws InterruptedException {
        _home = new Home(_driver);
        _home.search("invalidbhhsbhddh");
    }

    @Then("it should not shows any products in Results")
    public void itShouldNotShowsAnyProductsInResults() {
        //Assert.assertEquals(_home.getSearchCount()== 0, "Expected search result should show one or more products");
        Assert.assertTrue(_home.isNoResultDisplay());
    }

    @When("click on any product of the suggestion list")
    public void getSuggestionList() {
        url=_home.navSuggestionList();
    }
    @Then("it should navigate to the suggestion product details.")
    public void ValidateSuggestionListNavigation() {
        Assert.assertTrue("",_driver.getCurrentUrl().equals(url));
    }
}
