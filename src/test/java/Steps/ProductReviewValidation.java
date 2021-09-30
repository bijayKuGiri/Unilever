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
        int upperbound = lstProducts.size()-1;
        int int_random = rand.nextInt(upperbound);
        Helper.click(_driver,lstProducts.get(int_random));
        //lstProducts.get(int_random).click();
        review=_home.navReview();

    }
    @Then("it should navigate to Product Review Page")
    public void it_should_navigate_to_product_review_page_page(){
        Assert.assertTrue(review.isThanksMsgDisplay());
        System.out.println(review.getMsgText());
    }

    @And("Fill the Details")
    public void fillTheDetails() throws InterruptedException {
        review.setRatingRequired(true);
        review.setUrReview("Customer reviews build something known as social proof, a phenomenon that" +
                " states people are influenced by those around them. This might include friends and family, industry experts" +
                " and influencers, or even internet strangers.Social proof can push customers who are on the fence about " +
                "buying a product to make a purchase (or consider other alternatives). ");
        review.setReviewTitle("Review Testing");
        review.setNickName("Automation Test");
        review.setEmail("test@gmail.com");
        review.setTermAndCondition(true);
        review.setValid(true);
        review.enterReviewDetails();
        review.submit();


        /*review.enterReview();
        review.setValid(true);
        review.submit();*/
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
        review.setReviewTitle(new String());
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

    @When("Fill the details with wrong email")
    public void fill_the_details_with_wrong_email() {
        review.setRatingRequired(true);
        review.setUrReview("Customer reviews build something known as social proof, a phenomenon that" +
                " states people are influenced by those around them. This might include friends and family, industry experts" +
                " and influencers, or even internet strangers.Social proof can push customers who are on the fence about " +
                "buying a product to make a purchase (or consider other alternatives). ");
        review.setReviewTitle("Reviw Product");
        review.setNickName("Testing");
        review.setEmail("abcdefgh.cmmc");
        review.setTermAndCondition(true);
        review.setValid(false);
        review.enterReviewDetails();
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

    @And("Fill the details without your Review")
    public void fillTheDetailsWithoutYourReview() {
        review.setRatingRequired(true);
        review.setUrReview(new String());
        review.setReviewTitle("Review Product");
        review.setNickName("Testing");
        review.setEmail("test@gmail.com");
        review.setTermAndCondition(false);
        review.setValid(false);
        review.enterReviewDetails();
    }

    @Then("it should display validation message for minimum Your Review")
    public void itShouldDisplayValidationMessageForYourReview() {
        review.submit();
        Assert.assertTrue(review.isUrReviewMinMsgDisplay());
    }

    @And("Fill the details with your Review more than five hundred char")
    public void fillTheDetailsWithYourReviewMoreThanChar() {
        review.setRatingRequired(true);
        review.setUrReview("Customer reviews build something known as social proof, a phenomenon that" +
                        " states people are influenced by those around them. This might include friends and family, industry experts" +
                        " and influencers, or even internet strangers.Social proof can push customers who are on the fence about " +
                        "buying a product to make a purchase (or consider other alternatives). "+
                        "While there are many different forms " +
                        "of social proof (like influencer campaigns and company partnerships), customer reviews have a special place " +
                        "in shoppers’ hearts. ");
        review.setReviewTitle("Review Product");
        review.setNickName("Testing");
        review.setEmail("test@gmail.com");
        review.setTermAndCondition(false);
        review.setValid(false);
        review.enterReviewDetails();
    }

    @Then("it should display validation message for maximum Your Review")
    public void itShouldDisplayValidationMessageForMaximumYourReview() {
        review.submit();
        Assert.assertTrue(review.isUrReviewMaxMsgDisplay());
    }


}
