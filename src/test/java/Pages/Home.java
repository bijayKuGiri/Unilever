package Pages;


import Utility.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class Home {

    private final RemoteWebDriver driver;

    public Home(RemoteWebDriver _driver) {

        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    String active_carousel = "//div[@class='cmp-carousel__content']/div[@class='cmp-carousel__item cmp-carousel__item--active']";
    String selectedCountry = "";
    String getSiteText = "";
    WebElement faqElement;
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

    @FindBy(xpath = "//button[@class='productcarousel__btn productcarousel__btn--next']")
    WebElement prCarouselNavigateNext;

    @FindBy(css = "div.cmp-carousel__content")
    WebElement carouselContent;

    @FindBy(xpath = "//footer//div[@class='container responsivegrid'][1]")
    WebElement footerContainer;

    @FindBy(xpath = "//div[@class='container responsivegrid']//span[@class='cmp-list__item-title'][1]")
    WebElement contactUs;

    @FindBy(css = "div.kr-right-review-area>a")
    WebElement lblWriteReview;


    @FindBy(xpath = "//footer//a[@class='cmp-image__link' and contains(@href,'facebook') and not(@disabled)]//picture//img")
    WebElement lnkFacebook;

    @FindBy(xpath = "//footer//a[@class='cmp-image__link' and contains(@href,'twitter')]//picture//img")
    WebElement lnkTwitter;

    @FindBy(css = "a.cmp-button")
    WebElement products;

    @FindBy(css = "div.no-results")
    WebElement noResults;

    @FindBy(xpath = "//img[@alt='From bean to bite']")
    WebElement imgArticle;

    @FindBy(xpath = "//div[@class='productcarousel carousel c-related-products--fixed']")
    WebElement lnkFeatureProduct;

    @FindBy(xpath = "//div[contains(@class,'button cmp-container--back-to-top')] //button/span")
    WebElement btnBackToTop;

    @FindBy(xpath = "//a[contains(@href,'country')]//span")
    WebElement lnkSelectCountry;

    @FindBy(xpath = "//a[contains(@href,'frequentes')]//span")
    WebElement lnkFAQ;

    @FindBy(xpath = "//a[contains(@href,'sitemap')]//span")
    WebElement lnkSiteMap;

    @FindBy(xpath = "//div[@class='productcarousel__root']")
    WebElement prodCarousal;

    @FindBy(xpath = "//button[@class='productcarousel__btn productcarousel__btn--next']")
    WebElement prodCarousalNext;

    public boolean isNoResultDisplay() {
        return noResults.isDisplayed();
    }

    public List<WebElement> getCarouselList() {
        return carouselContent
                .findElements(By.xpath("//div[@class='cmp-carousel__content']/div[contains(@id,'carousel')]"));

    }

    private List<WebElement> getProductCarouselList() {
        return prodCarousal
                .findElements(By.xpath("//div[@role='displaycard']")).stream().filter(el -> el.findElement(By.tagName("h3")).isDisplayed())
                .collect(Collectors.toList());

    }

    public void verifyRotation(List<WebElement> elements) throws InterruptedException {
        for (int i = 0; i < elements.size(); i++) {
            WebElement itemSelected = carouselContent.findElement(By.xpath(active_carousel));
            //carouselNavigateNext.click();
            Helper.click(driver, carouselNavigateNext);
            Thread.sleep(2000);
            WebElement itemSelected_Current = carouselContent.findElement(By.xpath(active_carousel));
            Assert.assertNotEquals(itemSelected, itemSelected_Current);
        }
    }

    public void verifyProductCarouselRotation() throws InterruptedException {
        var currentItems=getProductCarouselList();
        while (prodCarousalNext.isEnabled()){
            Helper.click(driver,prodCarousalNext);
            Thread.sleep(5000);
            var newItems=getProductCarouselList();
            System.out.println(currentItems.size());
            System.out.println(newItems.size());
            Assert.assertTrue(!(Objects.equals( currentItems,newItems)));
        }

    }


    public void getFirstCarousel(List<WebElement> elements) throws InterruptedException {
        for (int i = 0; i < elements.size(); i++) {
            WebElement itemSelected = carouselContent.findElement(By.xpath(active_carousel));
            if (itemSelected.findElement(By.tagName("a")).getAttribute("href").contains("ifoodbr")) {
                itemSelected.click();
                break;
            }
            carouselNavigateNext.click();
            Thread.sleep(2000);

        }

    }

    public void clickLogo() {

        Helper.click(driver, logo);
        //logo.click();
    }

    public List<WebElement> getProducts() {
        return driver.findElements(By.xpath("//div[contains(@class,'button button--primary') or contains(@class,'button button--secondary')]//a"));
    }

    public List<String> getLinkText() {
        List<String> linkTxt = new ArrayList<>();
        List<WebElement> links = header.findElements(By.tagName("li"));
        for (WebElement var : links) {
            linkTxt.add(var.findElement(By.tagName("a")).getAttribute("href"));
        }
        return linkTxt;
    }

    public List<String> getFooterLinkText() {
        List<String> linkTxt = new ArrayList<>();
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(summarySection));
        return summarySection.isDisplayed();
    }

    public boolean IsLogoImageDisplayed() {
        return logo.isDisplayed();
    }

    public String logoText() {
        return logo.getAttribute("alt");
    }


    public void getScreenShot() throws InterruptedException, IOException {
        System.out.println(logo.getAttribute("src"));
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, logo);
        ImageIO.write(screenshot.getImage(), "PNG", new File(System.getProperty("user.dir") + "Logo.png"));
        Thread.sleep(2000);
    }

    public ContactUs navContactUs() {
        Helper.click(driver, contactUs);
        return new ContactUs(driver);
    }

    public void selectSiteMap() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lnkSiteMap);
        Helper.click(driver, lnkSiteMap);
        Thread.sleep(5000);
    }

    public void selectFAQ() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lnkFAQ);
        Helper.click(driver, lnkFAQ);
        Thread.sleep(5000);

    }

    public void selectAnySite() throws InterruptedException {
        List<WebElement> lstElements = driver.findElements(By.xpath("//div[@id='contentWrapperSection']//a[@class='cmp-list__item-link']"));
        Random rand = new Random();
        int upperbound = lstElements.size() - 1;
        int int_random = rand.nextInt(upperbound);
        WebElement element=lstElements.get(int_random);
        getSiteText = element.getText();
        Helper.scrollUpPage(driver,3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        Actions action = new Actions(driver);
        action.moveToElement(element).doubleClick().perform();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

    }

    public boolean verifySitemapRedirection(){
        System.out.println(driver.getCurrentUrl());
        System.out.println("+++++++++"+getSiteText);
        return driver.getCurrentUrl().contains(getSiteText);
    }

    public void selectFAQAns() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.cmp-accordion__icon")));
        List<WebElement> lstElements = driver.findElements(By.cssSelector("span.cmp-accordion__icon"));
        Random rand = new Random();
        int upperbound = lstElements.size() - 1;
        int int_random = rand.nextInt(upperbound);
        faqElement = lstElements.get(int_random);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", faqElement);
        //Helper.click(driver,faqElement);
        faqElement.click();
    }

    public boolean isAnswerDisplay(){
         return faqElement.findElement(By.xpath("parent::button/parent::h2/following-sibling::div")).isDisplayed();
    }

    public void clickCrossMark(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", faqElement);
        Helper.click(driver,faqElement);
    }

    public RemoteWebDriver selectCountry() {
        JavascriptExecutor js;
        js = driver;
        js.executeScript("arguments[0].scrollIntoView();", lnkSelectCountry);
        Helper.click(driver, lnkSelectCountry);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        List<WebElement> lstElements = driver.findElements(By.xpath("//a[@class='cmp-languagenavigation__item-link']"));
        Random rand = new Random();
        int upperbound = lstElements.size() - 1;
        int int_random = rand.nextInt(upperbound);
        selectedCountry = lstElements.get(int_random).getText();
        Helper.click(driver, lstElements.get(int_random));
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        return driver;
    }

    public boolean isCountrySelected() {
        if (Objects.equals(selectedCountry, "Brazil"))
            return driver.getTitle().contains("Magnum Brasil");
        else
            return !driver.getTitle().contains("Magnum Brasil");
    }


    public void BackToStartClick() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", btnBackToTop);
        Helper.click(driver, btnBackToTop);

    }

    public boolean isHeaderCrausalDisplay() {
        return carouselContent.isDisplayed();
    }

    public RemoteWebDriver navFacebook() throws InterruptedException {
        //lnkFacebook.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lnkFacebook);
        Helper.click(driver, lnkFacebook);
        Thread.sleep(5000);
        /*ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));*/
        return driver;
    }

    public void navArticlePageByImg() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", imgArticle);
        Helper.click(driver, imgArticle);
    }

    public boolean IsUrlContainArtigos() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(lnkFeatureProduct));
        return driver.getCurrentUrl().contains("artigos");
    }

    public boolean IsNavigateFacebook(RemoteWebDriver driver) {
        return driver.getCurrentUrl().contains("facebook.com");
    }

    public Review navReview() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section.kr-summary-section")));

        Helper.click(driver, summarySection);
        Helper.click(driver, lblWriteReview);
        Review review = new Review(driver);
        review.WaitForReviewPageToLoad(15);
        return review;
    }

    public RemoteWebDriver navTwitter() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lnkFacebook);
        lnkTwitter.click();
        //Helper.click(driver,lnkTwitter);
        Thread.sleep(2000);
        /*ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));*/
        return driver;
    }

    public boolean IsNavigateTwitter(RemoteWebDriver driver) {
        return driver.getCurrentUrl().contains("twitter.com");
    }

    public void search(String productName) {
        Helper.click(driver, icnSearch);
        Helper.EnterText(driver, txtSearch, productName);
        Helper.click(driver, lblSearch);
        while (driver.findElements(By.cssSelector(".search-list-label")).size() != 1) {
        }
    }

    public int getSearchCount() {
        return driver.findElements(By.cssSelector(".search-result-card")).size();
    }

    public boolean IsNavigateToIfoodPage() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return driver.getCurrentUrl().contains("https://www.ifood.com");
    }

    public void isProductCarousalDisplayed() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", prodCarousal);
        Assert.assertTrue(prodCarousal.isDisplayed(),"Expected Product Carousal should displayed");
    }
}
