package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.Review;
import Utility.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ProductReviewValidation extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private RemoteWebDriver _driver;
    private List<WebElement> lstProducts;
    private Review review;
    public ProductReviewValidation(BaseUtilities base) {

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
        review=_home.navReview();

    }
    @Then("it should navigate to Product Review Page")
    public void it_should_navigate_to_product_review_page_page(){

//        review.enterReview();
        Assert.assertTrue(review.isThanksMsgDisplay());
        System.out.println(review.getMsgText());
    }

    @And("Fill the Details")
    public void fillTheDetails() throws InterruptedException {
        review.enterReview();
        review.setValid(true);
        review.submit();
    }


    @When("Fill the details without Rating")
    public void fill_the_details_without_rating() {
        review.setRatingRequired(false);
        review.setUrReview("Customer reviews build something known as social proof, a phenomenon that" +
                " states people are influenced by those around them. This might include friends and family, industry experts" +
                " and influencers, or even internet strangers.Social proof can push customers who are on the fence about " +
                "buying a product to make a purchase (or consider other alternatives). ");
        review.setReviewTitle("Review Testing");
        review.setNickName("Automation Test");
        review.setEmail("test@gmail.com");
        review.setTermAndCondition(true);
        review.setValid(false);
        review.enterReviewDetails();

    }
    @Then("it should display validation message for Rating")
    public void it_should_display_validation_message_for_rating() {
        review.submit();
        Assert.assertTrue(review.isRatingMsgDisplay());
    }




    @When("Fill the details without Review Title")
    public void fill_the_details_without_review_title() {
        review.setRatingRequired(true);
        review.setUrReview("Customer reviews build something known as social proof, a phenomenon that" +
                " states people are influenced by those around them. This might include friends and family, industry experts" +
                " and influencers, or even internet strangers.Social proof can push customers who are on the fence about " +
                "buying a product to make a purchase (or consider other alternatives). ");
        review.setReviewTitle("");
        review.setNickName("Automation Test");
        review.setEmail("test@gmail.com");
        review.setTermAndCondition(true);
        review.setValid(false);
        review.enterReviewDetails();
    }
    @Then("it should display validation message for Review Title")
    public void it_should_display_validation_message_for_review_title() {
        review.submit();
        Assert.assertTrue(review.isReviewTitleMsgDisplay());
    }



    @When("Fill the details without Nick Name")
    public void fill_the_details_without_nick_name() {
        review.setRatingRequired(true);
        review.setUrReview("Customer reviews build something known as social proof, a phenomenon that" +
                " states people are influenced by those around them. This might include friends and family, industry experts" +
                " and influencers, or even internet strangers.Social proof can push customers who are on the fence about " +
                "buying a product to make a purchase (or consider other alternatives). ");
        review.setReviewTitle("Reviw Product");
        review.setNickName("");
        review.setEmail("test@gmail.com");
        review.setTermAndCondition(true);
        review.setValid(false);
        review.enterReviewDetails();
    }
    @Then("it should display validation message for Nick Name")
    public void it_should_display_validation_message_for_nick_name() {
        review.submit();
        Assert.assertTrue(review.isNickNameMsgDisplay());
    }



    @When("Fill the details without Email")
    public void fill_the_details_without_email() {
        review.setRatingRequired(true);
        review.setUrReview("Customer reviews build something known as social proof, a phenomenon that" +
                " states people are influenced by those around them. This might include friends and family, industry experts" +
                " and influencers, or even internet strangers.Social proof can push customers who are on the fence about " +
                "buying a product to make a purchase (or consider other alternatives). ");
        review.setReviewTitle("Reviw Product");
        review.setNickName("Testing");
        review.setEmail("");
        review.setTermAndCondition(true);
        review.setValid(false);
        review.enterReviewDetails();
    }
    @Then("it should display validation message for Email")
    public void it_should_display_validation_message_for_email() {
        review.submit();
        Assert.assertTrue(review.isEmailMsgDisplay());
    }

    @When("Fill the details without agreement")
    public void fill_the_details_without_agreement() {
        review.setRatingRequired(true);
        review.setUrReview("Customer reviews build something known as social proof, a phenomenon that" +
                " states people are influenced by those around them. This might include friends and family, industry experts" +
                " and influencers, or even internet strangers.Social proof can push customers who are on the fence about " +
                "buying a product to make a purchase (or consider other alternatives). ");
        review.setReviewTitle("Reviw Product");
        review.setNickName("Testing");
        review.setEmail("");
        review.setTermAndCondition(false);
        review.setValid(false);
        review.enterReviewDetails();
    }
    @Then("it should display validation message for agreement")
    public void it_should_display_validation_message_for_agreement() {
        review.submit();
        Assert.assertTrue(review.isTermAndConditionMsgDisplay());
    }
}
