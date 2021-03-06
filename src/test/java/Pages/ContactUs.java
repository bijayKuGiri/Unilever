package Pages;

import Utility.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ContactUs extends Helper {
    private final RemoteWebDriver driver;
    private boolean isValid = false;

    public ContactUs(RemoteWebDriver _driver) {
        super(utils);
        Helper.WaitForPageLoad(_driver, 60);
        PageFactory.initElements(_driver, this);
        driver = _driver;

    }

   /* @FindBy(css = "#contactUs-inquiryType[name='enquirySubj']")
    WebElement selectSubject;*/

    @FindBy(xpath = "//select[@name='enquirySubj']")
    WebElement selectSubject;

    /*@FindBy(css = "#contactUs-inquiryType[name='enquiryType']")
    WebElement selectReason;*/
    @FindBy(xpath = "//select[@name='enquiryType']")
    WebElement selectReason;

    @FindBy(css = "#givenNameContainer")
    WebElement txtName;
    @FindBy(css = "#familyNameContainer")
    WebElement txtLastName;
    @FindBy(css = "#emailContainer")
    WebElement txtEmail;
    @FindBy(css = "#commentsContainer")
    WebElement txtComments;

    @FindBy(css = "#productName")
    WebElement txtProductName;
    @FindBy(css = "#barCode")
    WebElement txtProductBarCode;
    @FindBy(css = "#productionCode")
    WebElement txtProductionCode;
    @FindBy(css = "#uploadFile")
    WebElement lnkFileUpload;
    @FindBy(css = "#contactUs-productUsage")
    WebElement ddnProductUse;
    @FindBy(css = "#contactUs-purchasedFrom")
    WebElement ddnBuyingMode;
    @FindBy(css = "#retailerName")
    WebElement txtRetailer;
    @FindBy(css = "#contact-legalAgeConfirmation")
    WebElement chkAgeConfirm;

    @FindBy(css = "#submitButton[type='submit']")
    WebElement btnSubmit;

 /*   @FindBy(css = "svg#star.loadingIcon")
    WebElement lblLoading;*/

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


    @FindBy(css = "p.small")
    WebElement lblBottom;

    public void setValid(boolean valid) {
        isValid = valid;
    }

    /*public boolean isValid() {
        return isValid;
    }*/

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
        Helper.selectFromDDn(driver, reason, selectReason);
    }


    public void SelectSubject(String subject) {
        Helper.selectFromDDn(driver, subject, selectSubject);
    }
    /*public void SelectSubjectUsingKeyBoard(String subject) {
        Helper.selectFromDDn(driver, subject, selectSubject);
    }*/

    private Boolean isEmailConfirmDisplay(){
        return driver.findElements(By.cssSelector("#confirmGrp>div>div>#confirmButton")).size()>0;
    }
    public void clickConfirm(){
        if(isEmailConfirmDisplay())
            driver.findElement(By.cssSelector("#confirmGrp>div>div>#confirmButton")).click();
    }

    public void enterNameEmailAndComments(String name, String lastName, String email, String Comments) throws InterruptedException {
        Helper.scrollDownPage(driver, 1);
        Helper.EnterText(driver, txtName.findElement(By.tagName("input")), name);
        Helper.EnterText(driver, txtLastName.findElement(By.tagName("input")), lastName);
        Helper.EnterText(driver, txtEmail.findElement(By.tagName("input")), email);
        if (!Comments.trim().isEmpty())
            Helper.EnterText(driver, txtComments.findElement(By.tagName("textarea")), Comments);

        if (!Comments.trim().isEmpty()) {
            Helper.scrollAndClick(driver, chkAgeConfirm);
        }

    }

    public void enterDetailsWithoutAgeConfirm(String name, String lastName, String email, String Comments) throws InterruptedException {
        Helper.scrollDownPage(driver, 1);
        Helper.EnterText(driver, txtName.findElement(By.tagName("input")), name);
        Helper.EnterText(driver, txtLastName.findElement(By.tagName("input")), lastName);
        Helper.EnterText(driver, txtEmail.findElement(By.tagName("input")), email);
        Helper.EnterText(driver, txtComments.findElement(By.tagName("textarea")), Comments);
    }

    public void hitSubmit() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", btnSubmit);
        driver.executeScript("arguments[0].click();", btnSubmit);
        //btnSubmit.click();
//        if (isValid)
//            while (driver.findElement(By.cssSelector("svg#star.loadingIcon")).isDisplayed()) {
//            }

    }

    public boolean VerifySuccessContactUS() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(lblConform));
        return lblConform.isDisplayed();
    }

    public String getMessage() {
        return lblConformMsg.getText();
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
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        return driver;
    }

    public boolean IsNavigateTermsOfUse(RemoteWebDriver driver) {
        System.out.println(driver.getCurrentUrl());
        System.out.println("https://www.unilever.com.br/legal/");
        return driver.getCurrentUrl().contains("https://www.unilever.com.br/legal/");
    }

    public RemoteWebDriver navPrivacyNotice() throws InterruptedException {
        Helper.scrollDownPage(driver, 3);
        WebElement element = lblBottom.findElement(By.xpath("//a[contains(@href,'privacy-notice')]"));
        Helper.scrollAndClick(driver, element);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        return driver;
    }

    public boolean IsNavigatePrivacyNotice(RemoteWebDriver driver) {
        return driver.getCurrentUrl().contains("privacy-notice");
    }

    public RemoteWebDriver navCookiesNotice() throws InterruptedException {
        Helper.scrollDownPage(driver, 3);
        WebElement element = lblBottom.findElement(By.xpath("//a[@class='optInLinks'][3]"));
        while (!element.isDisplayed()) {
            Helper.downKeyOnPage(driver, 1);
        }
        Helper.scrollAndClick(driver, element);
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        return driver;
    }

    public boolean IsNavigateCookiesNotice(RemoteWebDriver driver) {
        return driver.getCurrentUrl().contains("cookie-notice");
    }

    public void enterDetailsForProduct(String name, String lastName, String email, String productname, String barcode,
                                       String code, String uploadfile, String duration, String buyingMode,String retailer ,String Comments) throws InterruptedException {
        Helper.scrollDownPage(driver, 1);
        Helper.EnterText(driver, txtName.findElement(By.tagName("input")), name);
        Helper.EnterText(driver, txtLastName.findElement(By.tagName("input")), lastName);
        Helper.EnterText(driver, txtEmail.findElement(By.tagName("input")), email);
        Helper.EnterText(driver, txtProductName, productname);
        Helper.EnterText(driver, txtProductBarCode, barcode);
        Helper.EnterText(driver, txtProductionCode, code);
        //lnkFileUpload.sendKeys(uploadfile);
        Helper.selectFromDDn(driver,duration,ddnProductUse);
        Helper.selectFromDDn(driver,buyingMode,ddnBuyingMode);
        Helper.EnterText(driver, txtRetailer, retailer);
        if (!Comments.trim().isEmpty())
            Helper.EnterText(driver, txtComments.findElement(By.tagName("textarea")), Comments);

        if (!Comments.trim().isEmpty()) {
            Helper.scrollAndClick(driver, chkAgeConfirm);
        }
    }
}
