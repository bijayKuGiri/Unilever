package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Utility.Helper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class ValidateProductDetailsSteps extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private RemoteWebDriver _driver;
    private List<WebElement> lstProducts;
    public ValidateProductDetailsSteps(BaseUtilities base) {

        this.base = base;
        _driver= base._driver;
    }
    @When("verifying the Products")
    public void verifying_the_products() {
        _home=new Home(_driver);
        lstProducts= _home.getProducts();
    }
    @Then("it should navigate to Product Details Page")
    public void it_should_navigate_to_product_details_page() {

        Assert.assertTrue(lstProducts.size()>0,"Expected more than 0 products should be available on the page");
        Random rand = new Random();
        int upperbound = lstProducts.size();
        int int_random = rand.nextInt(upperbound);
        Helper.click(_driver,lstProducts.get(int_random));
        Assert.assertTrue(_home.IsSummeryExist());

    }
}
