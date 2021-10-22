package Pages;

import Utility.Helper;
//import gherkin.lexer.He;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ContactUs extends Helper {
    private RemoteWebDriver driver;
    private boolean isValid = false;

    public ContactUs(RemoteWebDriver _driver) {

        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    @FindBy(css = "#contactUs-inquiryType[name='enquirySubj']")
    WebElement selectSubject;

    @FindBy(css = "#contactUs-inquiryType[name='enquiryType']")
    WebElement selectReason;

    @FindBy(css = "#givenNameContainer")
    WebElement txtName;
    @FindBy(css = "#familyNameContainer")
    WebElement txtLastName;
    @FindBy(css = "#emailContainer")
    WebElement txtEmail;
    @FindBy(css = "#commentsContainer")
    WebElement txtComments;

    @FindBy(css = "#contact-legalAgeConfirmation")
    WebElement chkAgeConfirm;

    @FindBy(css = "#submitButton[type='submit']")
    WebElement btnSubmit;

    @FindBy(css = "svg#star.loadingIcon")
    WebElement lblLoading;

    @FindBy(css = "div.clearfix.component.formElementV2")
    WebElement lblConform;


    @FindBy(xpath = "//div[@class='clearfix component formElementV2']//span")
    WebElement lblConformMsg;

    @FindBy(css = "#firstName_Err>p")
    WebElement lblfirstnameErr;

    @FindBy(css = "#lastName_Err>p")
    WebElement lblLastnameErr;

    @FindBy(css = "#email_Err>p")
    WebElement emailErr;

    @FindBy(css = "#commentError>p")
    WebElement lblCommentErr;

    @FindBy(css = "#legalAgeConfirmation_Err>p")
    WebElement legalConfErr;

    @FindBy(xpath = "//p[@class='small']/a[2]")
    WebElement lnkTermsOfUse;

    @FindBy(xpath = "//p[@class='small']/a[1]")
    WebElement lnkPrivacyNotice;

    @FindBy(xpath = "//p[@class='small']/a[3]")
    WebElement lnkCookiesNotice;

    @FindBy(css = "p.small")
    WebElement lblBottom;

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public boolean isValid() {
        return isValid;
    }

    public boolean isNameErrorDisplay() {
        return lblfirstnameErr.isDisplayed();
    }

    public boolean isLegalAgeErrorDisplay() {
        return legalConfErr.isDisplayed();
    }

    public boolean isLastNameErrorDisplay() {
        return lblLastnameErr.isDisplayed();
    }

    public boolean isEmailErrorDisplay() {
        return emailErr.isDisplayed();
    }

    public boolean isCommentErrorDisplay() {
        return lblCommentErr.isDisplayed();
    }

    public void SelectReason(String reason) {
        Helper.selectFromDDn(reason, selectReason);
    }

    public void SelectSubject(String subject) {
        Helper.selectFromDDn(subject, selectSubject);
    }

    public void enterNameEmailAndComments(String name, String lastName, String email, String Comments) throws InterruptedException {
        Helper.scrollDownPage(driver, 1);
        Helper.EnterText(driver,txtName.findElement(By.tagName("input")),name);
        Helper.EnterText(driver,txtLastName.findElement(By.tagName("input")),lastName);
        Helper.EnterText(driver,txtEmail.findElement(By.tagName("input")),email);
        if (!Comments.trim().isEmpty())
            Helper.EnterText(driver,txtComments.findElement(By.tagName("textarea")),Comments);

        if (!Comments.trim().isEmpty()) {

            Helper.click(driver,chkAgeConfirm);
        }

    }

    public void enterDetailsWithoutAgeConfirm(String name, String lastName, String email, String Comments) throws InterruptedException {
        Helper.scrollDownPage(driver, 1);
        Helper.EnterText(driver,txtName.findElement(By.tagName("input")),name);
        Helper.EnterText(driver,txtLastName.findElement(By.tagName("input")),lastName);
        Helper.EnterText(driver,txtEmail.findElement(By.tagName("input")),email);
        Helper.EnterText(driver,txtComments.findElement(By.tagName("textarea")),Comments);
    }

    public void hitSubmit() {

        btnSubmit.submit();
        if (isValid)
            while (driver.findElements(By.cssSelector("svg#star.loadingIcon")).size() > 0) {
            }

    }

    public boolean VerifySuccessContactUS() {
        return lblConform.isDisplayed();
    }

    public String getMessage() {
        return lblConform.getText();
    }

    public RemoteWebDriver navTermsOfUse() throws InterruptedException {

        Helper.scrollDownPage(driver, 3);
        WebElement element = lblBottom.findElement(By.xpath("//a[@class='optInLinks'][2]"));
        while (!element.isDisplayed()) {
            Helper.downKeyOnPage(driver, 1);
        }
        Helper.click(driver, element);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //Thread.sleep(5000);
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return driver;
    }

    public boolean IsNavigateTermsOfUse(RemoteWebDriver driver) {
        System.out.println(driver.getCurrentUrl());
        System.out.println("https://www.unilever.com.br/legal/");
        return driver.getCurrentUrl().contains("https://www.unilever.com.br/legal/");
    }

    public RemoteWebDriver navPrivacyNotice() throws InterruptedException {
        Helper.scrollDownPage(driver, 3);
        WebElement element = lblBottom.findElement(By.xpath("//a[@class='optInLinks'][1]"));
        while (!element.isDisplayed()) {
            Helper.downKeyOnPage(driver, 2);
        }
        Helper.click(driver, element);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return driver;
    }

    public boolean IsNavigatePrivacyNotice(RemoteWebDriver driver) {
        System.out.println(driver.getCurrentUrl());
        System.out.println("https://www.unilevernotices.com/brazil/portuguese/privacy-notice/notice.html");
        return driver.getCurrentUrl().contains("https://www.unilevernotices.com/brazil/portuguese/privacy-notice/notice.html");
    }

    public RemoteWebDriver navCookiesNotice() throws InterruptedException {
        Helper.scrollDownPage(driver, 3);
        WebElement element = lblBottom.findElement(By.xpath("//a[@class='optInLinks'][3]"));
        while (!element.isDisplayed()) {
            Helper.downKeyOnPage(driver, 1);
        }
        Helper.click(driver, element);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //Thread.sleep(2000);
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return driver;
    }

    public boolean IsNavigateCookiesNotice(RemoteWebDriver driver) {
        System.out.println(driver.getCurrentUrl());
        System.out.println("https://www.unilevernotices.com/brazil/portuguese/cookie-notice/notice.html");
        return driver.getCurrentUrl().contains("https://www.unilevernotices.com/brazil/portuguese/cookie-notice/notice.html");
    }
}
