package Pages;


import Utility.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;


public class Home {

    //private Helper _helper;
    //private String filePath="config.xml";
    private RemoteWebDriver driver;

    public Home(RemoteWebDriver _driver) {

        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    String active_carousel = "//div[@class='cmp-carousel__content']/div[@class='cmp-carousel__item cmp-carousel__item--active']";
    @FindBy(xpath = "//header")
    WebElement header;

    @FindBy(xpath = "//a[text()='© 2021 Copyright Unilever']")
    WebElement lnkCopyWrite;

    @FindBy(css = "img[title='Magnum Logo']")
    WebElement logo;

    @FindBy(css = "button.cmp-button[data-target='#searchmodal']")
    WebElement icnSearch;

    @FindBy(css = "#searchInput")
    WebElement txtSearch;

    @FindBy(css = ".search-bar-btn")
    WebElement lblSearch;

    @FindBy(css = "section.kr-summary-section")
    WebElement summarySection;

    @FindBy(css = "button.cmp-carousel__action.cmp-carousel__action--next>span.cmp-carousel__action-icon")
    WebElement carouselNavigateNext;

    @FindBy(css = "div.cmp-carousel__content")
    WebElement carouselContent;

    @FindBy(xpath = "//footer//div[@class='container responsivegrid'][1]")
    WebElement footerContainer;

    @FindBy(xpath = "//div[@class='container responsivegrid']//span[@class='cmp-list__item-title'][1]")
    WebElement contactUs;

    @FindBy(css = "div.kr-right-review-area>a")
    WebElement lblWriteReview;


    @FindBy(xpath = "//footer//a[@class='cmp-button' and contains(@href,'facebook')]")
    WebElement lnkFacebook;

    @FindBy(xpath = "//footer//a[@class='cmp-button' and contains(@href,'twitter')]")
    WebElement lnkTwitter;

    @FindBy(css = "a.cmp-button")
    WebElement products;

    @FindBy(css = "div.no-results")
    WebElement noResults;

    public boolean isNoResultDisplay(){
        return noResults.isDisplayed();
    }

    public List<WebElement> getCarouselList() {
        return carouselContent
                .findElements(By.xpath("//div[@class='cmp-carousel__content']/div[contains(@id,'carousel')]"));

    }

    public void verifyRotation(List<WebElement> elements) throws InterruptedException {
        for (int i = 0; i < elements.size(); i++) {
            WebElement itemSelected = carouselContent.findElement(By.xpath(active_carousel));
            carouselNavigateNext.click();
            Thread.sleep(2000);
            WebElement itemSelected_Current = carouselContent.findElement(By.xpath(active_carousel));
            Assert.assertNotEquals(itemSelected, itemSelected_Current);
        }

    }

    public void clickLogo() throws InterruptedException {

        Helper.click(driver, logo);
        //logo.click();
    }

    public List<WebElement> getProducts() {
        List<WebElement> lstProducts = driver.findElements(By.xpath("//div[contains(@class,'button button--primary') or contains(@class,'button button--secondary') ]"));
        return lstProducts;
    }

    public List<String> getLinktext() {
        List<String> linkTxt = new ArrayList<String>();
        List<WebElement> links = header.findElements(By.tagName("li"));
        for (WebElement var : links) {
            linkTxt.add(var.findElement(By.tagName("a")).getAttribute("href"));
        }
        return linkTxt;
    }

    public List<String> getfooterLinktext() {
        List<String> linkTxt = new ArrayList<String>();
        List<WebElement> links = footerContainer.findElements(By.tagName("li"));
        for (WebElement var : links) {
            linkTxt.add(var.findElement(By.tagName("a")).getAttribute("href"));
        }
        return linkTxt;
    }

    public String getHeader() {
        return driver.getTitle();
    }

    public boolean IsCopyRightExist() {
        return lnkCopyWrite.isDisplayed();
    }

    public boolean IsSummeryExist() {
        return summarySection.isDisplayed();
    }

    public boolean IsLogoImageDisplayed() {
        return logo.isDisplayed();
    }
    public String logoText() {
        return logo.getAttribute("alt");
    }


    public void getScreenShot() throws InterruptedException, IOException {
        //WebElement webElement = driver.findElement(By.cssSelector("img[title='Magnum Logo']"));
        System.out.println(logo.getAttribute("src"));
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, logo);
        ImageIO.write(screenshot.getImage(), "PNG", new File(System.getProperty("user.dir") + "Logo.png"));
        Thread.sleep(2000);
    }

    public ContactUs navContactUs() {
        contactUs.click();
        return new ContactUs(driver);
    }

    public RemoteWebDriver navFacebook() throws InterruptedException {
        lnkFacebook.click();
        Thread.sleep(5000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return driver;
    }

    public boolean IsNavigateFacebook(RemoteWebDriver driver) {
        return driver.getCurrentUrl().contains("facebook.com");
    }

    public Review navReview() {
        WebDriverWait wait= new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section.kr-summary-section"))).click();
        //summarySection.click();
        Helper.click(driver, lblWriteReview);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        return new Review(driver);
    }

    public RemoteWebDriver navTwitter() throws InterruptedException {
        lnkTwitter.click();
        Thread.sleep(5000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return driver;
    }

    public boolean IsNavigateTwitter(RemoteWebDriver driver) {
        return driver.getCurrentUrl().contains("twitter.com");
    }

    public void searchfn(String productName) {
        icnSearch.click();
        txtSearch.sendKeys(productName);
        lblSearch.click();
        while (driver.findElements(By.cssSelector(".search-list-label")).size() != 1) {
        }
    }

    public int getSearchCount() {
        return driver.findElements(By.cssSelector(".search-result-card")).size();
    }
}
