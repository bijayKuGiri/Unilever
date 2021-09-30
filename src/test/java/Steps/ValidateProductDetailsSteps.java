package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Utility.Helper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    public void it_should_navigate_to_product_details_page() throws InterruptedException {

        Assert.assertTrue(lstProducts.size()>0,"Expected more than 0 products should be available on the page");
        Random rand = new Random();
        int upperbound = lstProducts.size();
        int int_random = rand.nextInt(upperbound);
        Helper.click(_driver,lstProducts.get(int_random));
        //lstProducts.get(int_random).click();
        //Thread.sleep(5000);
        Assert.assertTrue(_home.IsSummeryExist());
//        int count=2;
//        for (WebElement element:lstProducts) {
//            while (!element.isDisplayed()){
//                Helper.scrollDownPage(_driver,count);
//            }
//            element.click();
//            Thread.sleep(5000);
//           // _driver.navigate().back();
//            _home.clickLogo();
//            Thread.sleep(5000);
//            count+=1;
//        }
    }
}
