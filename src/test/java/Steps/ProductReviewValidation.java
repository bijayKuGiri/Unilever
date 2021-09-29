package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.Review;
import Utility.Helper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ValidateProductReviewSteps extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private RemoteWebDriver _driver;
    private List<WebElement> lstProducts;
    private Review review;
    public ValidateProductReviewSteps(BaseUtilities base) {

        this.base = base;
        _driver= base._driver;
    }
    @When("i navigate to a product and select the Review section")
    public void i_navigate_to_a_product_and_select_the_review_section() throws InterruptedException {
        _home=new Home(_driver);
        lstProducts= _home.getProducts();
        Random rand = new Random();
        int upperbound = lstProducts.size();
        int int_random = rand.nextInt(upperbound);
        lstProducts.get(int_random).click();
        Thread.sleep(5000);
        review=_home.navReview();
        Thread.sleep(5000);
    }
    @Then("it should navigate to Product Review Page")
    public void it_should_navigate_to_product_review_page_page() throws InterruptedException {

        review.enterReview();
        Assert.assertTrue(review.isThanksMsgDisplay());
        System.out.println(review.getMsgText());
    }
}
