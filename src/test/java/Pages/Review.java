package Pages;

import Utility.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Review {
    private RemoteWebDriver driver;
    private boolean isValid = false;
    private boolean isRatingRequired = true;
    private String reviewTitle = new String();
    private String urReview = new String();
    private String nickName = new String();
    private String email = new String();
    private boolean termAndCondition = true;


    @FindBy(css = "#kr-reviewTitle.kr-text-field")
    WebElement txtReviewTitle;

    @FindBy(css = "#kr-reviewTxt.kr-textarea")
    WebElement txtYourReview;

    @FindBy(css = "#kr-nckName.kr-text-field")
    WebElement txtNickName;

    @FindBy(css = "#kr-email.kr-email-review.kr-text-field")
    WebElement txtEmail;

    @FindBy(css = "span.checkmark")
    WebElement chkTermCondition;

    @FindBy(css = "#kr-button")
    WebElement btnSubmit;

    @FindBy(css = "div.postReviewStarRating.starRatingsContainer.star-rating")
    WebElement chkStar;

    @FindBy(css = "#kr-rating-error")
    WebElement chkStarMsg;

    @FindBy(css = "#kr-title-error")
    WebElement txtReviewTitleMsg;

    @FindBy(css = "#kr-nickname-error")
    WebElement txtNickNameMsg;

    @FindBy(css = "#kr-email")
    WebElement txtEmailMsg;

    @FindBy(css = "#kr-termandconditions-error")
    WebElement chkTermCondMsg;

    @FindBy(css = "li.kr-thanks-message>h3")
    WebElement lblThanksMsg;

    @FindBy(css = "li.kr-thanks-message>span")
    WebElement lblMsg;


    @FindBy(css = "#kr-comment-max-error")
    WebElement divUrCommentMaxError;

    @FindBy(css = "#kr-comment-min-error")
    WebElement divUrCommentMinError;



    public boolean isRatingRequired() {
        return isRatingRequired;
    }

    public void setRatingRequired(boolean ratingRequired) {
        isRatingRequired = ratingRequired;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getUrReview() {
        return urReview;
    }

    public void setUrReview(String urReview) {
        this.urReview = urReview;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTermAndCondition() {
        return termAndCondition;
    }

    public void setTermAndCondition(boolean termAndCondition) {
        this.termAndCondition = termAndCondition;
    }


    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Review(RemoteWebDriver _driver) {

        PageFactory.initElements(_driver, this);
        driver = _driver;
    }


    private void fillStar() {
        Random rand = new Random();
        int upperbound = chkStar.findElements(By.tagName("input")).size();
        int int_random = rand.nextInt(upperbound);

        for (int i = 1; i <= int_random; i++) {
            Helper.click(driver, chkStar.findElements(By.tagName("input")).get(i));
        }
    }

    public void enterReview() {
        fillStar();
        Helper.EnterText(driver, txtReviewTitle, "Review Testing");
        Helper.EnterText(driver, txtYourReview, "Customer reviews build something known as social proof, a phenomenon that" +
                " states people are influenced by those around them. This might include friends and family, industry experts" +
                " and influencers, or even internet strangers.Social proof can push customers who are on the fence about " +
                "buying a product to make a purchase (or consider other alternatives). ");
        //txtReviewTitle.sendKeys("Review Testing");
        /*txtYourReview.sendKeys("Customer reviews build something known as social proof, a phenomenon that" +
                " states people are influenced by those around them. This might include friends and family, industry experts" +
                " and influencers, or even internet strangers.Social proof can push customers who are on the fence about " +
                "buying a product to make a purchase (or consider other alternatives). ");
        //While there are many different forms " +
        //"of social proof (like influencer campaigns and company partnerships), customer reviews have a special place " +
        //"in shoppers’ hearts. ");*/
//        txtNickName.sendKeys("Automatic");
//        txtEmail.sendKeys("Test@test.com");
        //chkTermCondition.click();
        Helper.EnterText(driver, txtNickName, "Automatic");
        Helper.EnterText(driver, txtEmail, "Test@test.com");
        Helper.click(driver, chkTermCondition);
    }

    public void enterReviewDetails() {
        if (isRatingRequired)
            fillStar();
        Helper.EnterText(driver, txtReviewTitle, reviewTitle);
        Helper.EnterText(driver, txtYourReview, urReview);
        Helper.EnterText(driver, txtNickName, nickName);
        Helper.EnterText(driver, txtEmail, email);
        if (termAndCondition)
            Helper.click(driver, chkTermCondition);
    }


    public void submit() {
        Helper.click(driver,btnSubmit);
        //btnSubmit.click();
        if (isValid()) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(lblThanksMsg));
        }

    }

    public boolean isThanksMsgDisplay() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(lblThanksMsg));
        return lblThanksMsg.isDisplayed();
    }

    public boolean isRatingMsgDisplay() {

        return chkStarMsg.isDisplayed();
    }
    public boolean isUrReviewMaxMsgDisplay() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(divUrCommentMaxError));
        System.out.println(divUrCommentMaxError.getText());
        return divUrCommentMaxError.isDisplayed();
    }
    public boolean isUrReviewMinMsgDisplay() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(divUrCommentMinError));
        return divUrCommentMinError.isDisplayed();
    }

    public boolean isReviewTitleMsgDisplay() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(txtReviewTitleMsg));
        return txtReviewTitleMsg.isDisplayed();
    }

    public boolean isEmailMsgDisplay() {
        return txtEmailMsg.isDisplayed();
    }

    public boolean isTermAndConditionMsgDisplay() {
        return chkTermCondMsg.isDisplayed();
    }

    public boolean isNickNameMsgDisplay() {
        return txtNickNameMsg.isDisplayed();
    }

    public String getMsgText() {
        return lblMsg.getText();
    }

}
