package Pages;

import Utility.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class Review {
    private RemoteWebDriver driver;

    public Review(RemoteWebDriver _driver) {

        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

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

    @FindBy(css = "p.kr-thanks-message-entityName")
    WebElement lblThanksMsg;

    @FindBy(css = "li.kr-thanks-message>span")
    WebElement lblMsg;

    private void fillStar() {
        Random rand = new Random();
        int upperbound = chkStar.findElements(By.tagName("input")).size();
        int int_random = rand.nextInt(upperbound);

        for (int i = 1; i <= int_random; i++) {
            chkStar.findElements(By.tagName("input")).get(i).click();
        }
    }

    public void enterReview() throws InterruptedException {
        fillStar();
        txtReviewTitle.sendKeys("Review Testing");
        txtYourReview.sendKeys("For Testing purpose only" +
                "For Testing purpose only" +
                "For Testing purpose only" +
                "For Testing purpose onlyFor Testing purpose only" +
                "For Testing purpose only" +
                "For Testing purpose only" +
                "For Testing purpose only" +
                "For Testing purpose only" +
                "For Testing purpose only" +
                "");
        txtNickName.sendKeys("Automatic");
        txtEmail.sendKeys("Test@test.com");
        chkTermCondition.click();
        btnSubmit.click();
        Thread.sleep(5000);

    }

    public boolean isThanksMsgDisplay() {
        return lblThanksMsg.isDisplayed();
    }

    public String getMsgText(){
        return lblMsg.getText();
    }

}
