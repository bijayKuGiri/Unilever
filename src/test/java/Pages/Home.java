package Pages;


import Utility.Helper;
import lombok.var;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Home {

    private final RemoteWebDriver driver;

    public Home(RemoteWebDriver _driver) {
        //Helper.WaitForPageLoad(_driver,60);
        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    //String active_carousel = "//div[@class='cmp-carousel__content']/div[@class='cmp-carousel__item cmp-carousel__item--active']";
    String active_carousel = "//div[@class='cmp-carousel__content']/div[@class='cmp-carousel__item cmp-carousel__item--active']//div[@data-cmp-is='image']";
    String selectedCountry = "";
    String getSiteText = "";
    WebElement faqElement;
    WebElement ProdDropdownElement;

    List<String> productImgsBefore;
    List<String> productImgsAfter;
    Boolean prdTabValidation = false;

    @FindBy(css = "ul.o-navbar-dropdown-menu")
    WebElement HeaderNavigationProduct;

    @FindBy(css = "div.cmp-experiencefragment.cmp-experiencefragment--header")
    WebElement Header;

    @FindBy(css = "ul.cmp-navigation__group")
    WebElement HeaderNavigationItems;

    @FindBy(css = "div.searchbar-button")
    WebElement SearchBarButton;

    @FindBy(css = "div.cmp-tabs>ol.cmp-tabs__tablist")
    WebElement TabSwitch;

    @FindBy(css = "div.cmp-tabs__tabpanel.cmp-tabs__tabpanel--active")
    WebElement TabPanel;

    @FindBy(css = "div.pagelist.list")
    WebElement PageList;

    @FindBy(css = "div.productcarousel.carousel")
    WebElement ProductCarousel;

    @FindBy(css = "div.cmp-experiencefragment--footer")
    WebElement Footer;

    @FindBy(css = "div.ot-sdk-row")
    WebElement CookieConsentBanner;

    @FindBy(css = "button.closeButton.acceptButton")
    WebElement CookieAcceptButtonInCH;

    @FindBy(xpath = "//a[text()='© 2021 Copyright Unilever ']")
    WebElement lnkCopyWrite;

   /* @FindBy(css = "div.search-list-label")
    WebElement searchResult;*/

    @FindBy(css = "img[title='Magnum Logo']")
    WebElement Magnumlogo;

    @FindBy(css = ".cmp-accordion__title")
    WebElement lnkNutritionDetails;

    @FindBy(css = "button.cmp-button[data-target='#searchmodal']")
    WebElement icnSearch;

    @FindBy(css = "#searchInput")
    WebElement txtSearch;

    @FindBy(css = ".search-bar-btn")
    WebElement lblSearch;

    @FindBy(css = "section.kr-summary-section>div")
    WebElement summarySection;

    @FindBy(css = "#onetrust-button-group>#onetrust-pc-btn-handler")
    WebElement lnkManageSettings;

@FindBy(css = ".ot-pc-footer>.ot-btn-container>.ot-pc-refuse-all-handler")
    WebElement btnRefuseAll;

    @FindBy(css = "button.cmp-carousel__action.cmp-carousel__action--next>span.cmp-carousel__action-icon")
    WebElement carouselNavigateNext;


    @FindBy(css = "div.cmp-carousel__content")
    WebElement carouselContent;

    @FindBy(xpath = "//footer//div[@class='container responsivegrid'][1]")
    WebElement footerContainer;

    @FindBy(xpath = "//footer//li[contains(@data-cmp-data-layer,'ContactUs') or contains(@data-cmp-data-layer,'Contact Us') or contains(@data-cmp-data-layer,'contato')]")
    WebElement contactUs;

    @FindBy(css = "div.kr-right-review-area>a")
    WebElement lblWriteReview;

    @FindBy(css = ".container.responsivegrid.cmp-container--language-selector")
    WebElement languageSelector;

    @FindBy(xpath = "//footer//a[contains(@href,'facebook')]")
    WebElement lnkFacebook;

    @FindBy(xpath = "//footer//a[contains(@href,'vk')]")
    WebElement lnkVK;

    @FindBy(xpath = "//footer//a[contains(@href,'instagram')]")
    WebElement lnkInstagram;

    @FindBy(xpath = "//footer//a[contains(@href,'twitter')]")
    WebElement lnkTwitter;

    @FindBy(xpath = "//a[normalize-space()='Magnum Oversized Towels']")
    WebElement lnkMagnumOverSizedTowel;

    @FindBy(xpath = "//a[normalize-space()='Artigos']")
    WebElement lnkArticle;

    @FindBy(xpath = "//li//div[@class='cmp-teaser__image']//img")
    WebElement imgArticle;

    @FindBy(xpath = "//div[@class='productcarousel carousel c-related-products--fixed']")
    WebElement lnkFeatureProduct;

    @FindBy(xpath = "//div[contains(@class,'button cmp-container--back-to-top')] //button/span")
    WebElement btnBackToTop;

    @FindBy(xpath = "//a[contains(@href,'country')]//span")
    WebElement lnkSelectCountry;

    @FindBy(xpath = "//a[contains(@href,'frequentes') or contains(@href,'FAQ')]//span")
    WebElement lnkFAQ;

    @FindBy(xpath = "//a[contains(@href,'sitemap')]//span")
    WebElement lnkSiteMap;

    @FindBy(xpath = "//div[@class='productcarousel__root']")
    WebElement prodCarousal;

    @FindBy(xpath = "//button[@class='productcarousel__btn productcarousel__btn--next']")
    WebElement prodCarousalNext;

    @FindBy(xpath = "//button[@class='productcarousel__btn productcarousel__btn--prev']")
    WebElement prodCarousalPrev;

    @FindBy(xpath = "//div[@data-cmp-hook-accordion='panel']//div[@class='container responsivegrid']")
    WebElement nutritionDetails;

    @FindBy(xpath = "//ol[@role='tablist' and @class='cmp-tabs__tablist']//parent::div")
    WebElement productTabImages;

    @FindBy(xpath = "//li[@class='o-quick-panel c-product-listing-v2-quickview clearfix active']/div/div/div[2]/div[3]/a")
    WebElement FindOutMoreButton;

    public void IsHeaderDisplayed() {
        Assert.assertTrue("Header is displayed", Header.isDisplayed());
    }

    public void IsSearchButtonDisplayed() {
        Assert.assertTrue("Search is displayed", SearchBarButton.isDisplayed());
    }

    public void IsHeaderNavigationItemsDisplayed() {
        Assert.assertTrue("HeaderNavigationItems are displayed", HeaderNavigationItems.isDisplayed());
    }

    public void IsTabSwitchDisplayed() {
        Assert.assertTrue("TabSwitch is displayed", TabSwitch.isDisplayed());
    }

    public void IsTabPanelDisplayed() {
        Assert.assertTrue("TabPanel is displayed", TabPanel.isDisplayed());
    }

    public void IsPageListDisplayed() {
        Assert.assertTrue("pageList is displayed", PageList.isDisplayed());
    }

    public void IsProductCarouselDisplayed() {
        Assert.assertTrue("ProductCarousel is displayed", ProductCarousel.isDisplayed());
    }

    public void IsFooterDisplayed() {
        Assert.assertTrue("Footer is displayed", Footer.isDisplayed());
    }

    //public void IsCookieConsentBannerDisplayed() {
    //Assert.assertTrue("CookieConsentBanner is displayed",CookieConsentBanner.isDisplayed());
    //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", CookieConsentBanner);
    //Assert.assertTrue("Cookie Consent Banner should displayed",CookieConsentBanner.isDisplayed());
    //}

    public List<Boolean> selectLanguage() {
        ArrayList<Boolean> results = new ArrayList<>();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", languageSelector);
        var langItems = languageSelector.findElements(By.cssSelector(".cmp-button"));
        for (int i = 0; i < langItems.size(); i++) {
            var Items = languageSelector.findElements(By.cssSelector(".cmp-button"));
            String url = Items.get(i).getAttribute("href");
            WebElement parent = Items.get(i).findElement(By.xpath(".."));
            if (parent.getAttribute("class").contains("selector"))
                continue;
            Helper.scrollAndClick(driver, Items.get(i));
            results.add(driver.getCurrentUrl().contains(url));

        }
        return results;
    }

    public List<String> getProductImages() {
        List<String> imgSrc = new ArrayList<>();
        var tabElements = productTabImages.findElements(By.xpath("//div[@class='container responsivegrid']//img"))
                .stream().filter(WebElement::isDisplayed).collect(Collectors.toList());
        for (WebElement element : tabElements
        ) {
            imgSrc.add(element.getAttribute("src"));

        }
        return imgSrc;
    }

    public List<String> getProductImages(WebElement item) {
        List<String> imgSrc = new ArrayList<>();
        var tabElements = item.findElements(By.xpath("//parent::ol//parent::div//div[@class='container responsivegrid']//img"))
                .stream().filter(WebElement::isDisplayed).collect(Collectors.toList());
        for (WebElement element : tabElements
        ) {
            imgSrc.add(element.getAttribute("src"));

        }
        return imgSrc;
    }

    public void navigateProductTabs() {
        var tabItems = driver.findElements(By.xpath("//ol[@role='tablist' and @class='cmp-tabs__tablist']"))
                .stream().filter(ele -> ele.findElements(By.tagName("li")).size() > 1)
                .collect(Collectors.toList());
        for (WebElement element : tabItems) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        }
    }

    public void selectProductTabs() throws InterruptedException {
        var tabItems = driver.findElements(By.xpath("//ol[@role='tablist' and @class='cmp-tabs__tablist']"))
                .stream().filter(ele -> ele.findElements(By.tagName("li")).size() > 1)
                .collect(Collectors.toList());

        for (var item : tabItems) {
            var tabElements = item.findElements(By.tagName("li"));
            Helper.scrollAndClick(driver, tabElements.get(0));
            System.out.println("There count of available tabs are " + tabElements.size());
            for (WebElement tabElement : tabElements) {
                productImgsBefore = getProductImages(item);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tabElement);
                System.out.println(tabElement.getAttribute("aria-selected"));
                if (tabElement.getAttribute("aria-selected").equalsIgnoreCase("false")) {
                    System.out.println(tabElement.getText() + " going to selected");
                    Helper.scrollAndClick(driver, tabElement);
                }
                Thread.sleep(3000);
                productImgsAfter = getProductImages();
                prdTabValidation = productImgsAfter != productImgsBefore;
            }

        }
    }

    public void VerifyProductImages() {
        Assert.assertTrue(prdTabValidation);
    }

    public List<WebElement> getCarouselList() {
        if (driver.findElements(By.cssSelector("div.cmp-carousel__content")).size() == 0) {
            return new ArrayList<>();
        } else {

            return carouselContent
                    .findElements(By.xpath("//div[@class='cmp-carousel__content']/div[contains(@id,'carousel')]"));
        }

    }

    public void clickOnNutritionLnk() {
        Helper.scrollAndClick(driver, lnkNutritionDetails);
    }

    public void VerifyTheNutritionDetails() {
        Assert.assertTrue("Expected nutrition Details should display", nutritionDetails.isDisplayed());
        var elements = nutritionDetails.findElements(By.xpath("//div[contains(@class,'productInfoItem')]" +
                "//*[contains(@class,'product-info-item')][not(descendant::*)]"));
        for (WebElement item :
                elements) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", item);
            System.out.println(item.getText());
        }
    }

    public List<WebElement> getProductCarouselList() {
        return prodCarousal
                .findElements(By.xpath("//div[@class='productcarousel__cardscontainer']//h3")).stream().filter(WebElement::isDisplayed)
                .collect(Collectors.toList());

    }

    public void verifyRotation(List<WebElement> elements) throws InterruptedException {
        for (int i = 0; i < elements.size(); i++) {
            var itemSelected = carouselContent.findElement(By.xpath(active_carousel)).getAttribute("data-cmp-src");
            Helper.scrollAndClick(driver, carouselNavigateNext);
            Thread.sleep(2000);
            var itemSelected_Current = carouselContent.findElement(By.xpath(active_carousel)).getAttribute("data-cmp-src");
            Assert.assertNotEquals(itemSelected, itemSelected_Current);
        }
    }

    public void verifyProductCarouselRotation() throws InterruptedException {

        while (prodCarousalPrev.isEnabled()) {
            Helper.scrollAndClick(driver, prodCarousalPrev);
        }
        var currentItems = getProductCarouselList();
        if (currentItems.size() == driver.findElements(By.xpath("//div[@class='productcarousel__cardscontainer']//div[contains(@id,'productcarousel')]")).size())
            return;


        while (prodCarousalNext.isEnabled()) {
            Helper.scrollAndClick(driver, prodCarousalNext);
            Thread.sleep(5000);
            var newItems = getProductCarouselList();
            System.out.println(currentItems.size());
            System.out.println(newItems.size());
            Assert.assertNotEquals(newItems, currentItems);
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

    public List<WebElement> getProducts() {
        return driver.findElements(By.xpath("//div[contains(@class,'button button--primary') or contains(@class,'button button--secondary')]//a"));
        ////a[@class='cmp-button' and not(@target)]//span[@class='cmp-button__text']
    }

    public List<String> getLinkText() {
        List<String> linkTxt = new ArrayList<>();
        List<WebElement> links = HeaderNavigationItems.findElements(By.tagName("li"));
        for (WebElement var : links) {
            linkTxt.add(var.findElement(By.tagName("a")).getAttribute("href"));
        }
        return linkTxt;
    }

    public List<WebElement> getLink() {
        return HeaderNavigationItems.findElements(By.tagName("li"));
    }

    public List<WebElement> getFooterLink() {
        return footerContainer.findElements(By.tagName("li"));
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
        return Magnumlogo.isDisplayed();
    }

    public String logoText() {
        return Magnumlogo.getAttribute("alt");
    }


   /* public void getScreenShot() throws InterruptedException, IOException {
        System.out.println(logo.getAttribute("src"));
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, logo);
        ImageIO.write(screenshot.getImage(), "PNG", new File(System.getProperty("user.dir") + "Logo.png"));
        Thread.sleep(2000);
    }*/

    public ContactUs navContactUs() {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", contactUs);
        //Helper.click(driver, contactUs);
//        contactUs.click();
        Helper.scrollAndClick(driver,contactUs);
        return new ContactUs(driver);
    }

    /*private void getElementUsingTab(Integer count){
        WebElement webElement = driver.findElement(By.xpath("//html"));
        for (int i = 0; i <= count; i++) {
            webElement.sendKeys(Keys.TAB);
        }
        WebElement currentElement = driver.switchTo().activeElement();
        currentElement.sendKeys(Keys.ENTER);
    }

    public void navContactUsUsingKeyboard() {
        getElementUsingTab(32);

    }
    public void SelectReasonUsingKeyBoard() throws InterruptedException {
        getElementUsingTab(10);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(5000);
        actions.sendKeys("Question").perform();
        actions.sendKeys(Keys.ENTER).perform();


    }
*/
    public void selectSiteMap() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lnkSiteMap);
        Helper.click(driver, lnkSiteMap);
        Thread.sleep(5000);
    }

    public void selectFAQ() throws InterruptedException {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lnkFAQ);
//        Helper.click(driver, lnkFAQ);
        Helper.scrollAndClick(driver, lnkFAQ);
        Thread.sleep(5000);
        Helper.WaitForPageLoad(driver, 60);
    }

    public void selectAnySite() {
        ////a[@class='cmp-list__item-link']
        List<WebElement> lstElements = driver.findElements(By.xpath("//div[@id='contentWrapperSection']//a"));
        Random rand = new Random();
        int upperbound = lstElements.size() - 1;
        int int_random = rand.nextInt(upperbound);
        WebElement element = lstElements.get(int_random);
        getSiteText = driver.getCurrentUrl();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.executeScript("arguments[0].click();", element);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

    }

    public boolean verifySitemapRedirection() {
        return !driver.getCurrentUrl().equals(getSiteText);
    }


    public void selectFAQAns() {
        List<WebElement> lstElements = driver.findElements(By.cssSelector("span.cmp-accordion__icon"));
        Random rand = new Random();
        int upperbound = lstElements.size() - 1;
        int int_random = rand.nextInt(upperbound);
        faqElement = lstElements.get(int_random);
        /*((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", faqElement);
        driver.executeScript("arguments[0].click();", faqElement);*/
        Helper.scrollAndClick(driver, faqElement);
    }

    public boolean isAnswerDisplay() {
        return faqElement.findElement(By.xpath("parent::button/parent::*[self::h1 or self::h2 or self::h3]/following-sibling::div")).isDisplayed();
    }

    public void clickCrossMark() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", faqElement);
        driver.executeScript("arguments[0].click();", faqElement);
    }

    public RemoteWebDriver selectCountry() {
        Helper.scrollAndClick(driver, lnkSelectCountry);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        List<WebElement> lstElements = driver.findElements(By.xpath("//a[@class='cmp-languagenavigation__item-link']"));
        Random rand = new Random();
        int upperbound = lstElements.size() - 1;
        int int_random = rand.nextInt(upperbound);
        selectedCountry = lstElements.get(int_random).getText();
        Helper.scrollAndClick(driver, lstElements.get(int_random));
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
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

    public void CookieAcceptClick() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", CookieAcceptButtonInCH);
        Helper.click(driver, CookieAcceptButtonInCH);

    }
    public boolean isHeaderCausalDisplay() {
        return carouselContent.isDisplayed();
    }

    public RemoteWebDriver navFacebook() {
        Helper.scrollAndClick(driver, lnkFacebook);
        var tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        return driver;
    }

    public RemoteWebDriver navVK() {
        Helper.scrollAndClick(driver, lnkVK);
        var tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        return driver;
    }

    public RemoteWebDriver navSocialSite(String siteName) {

        Helper.scrollAndClick(driver, driver.findElement(By.xpath("//footer//a[contains(@href,'" + siteName + "')]")));
        var tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        return driver;
    }

    public void navArticlePageByImg() {
        /*((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", imgArticle);
        Helper.click(driver, imgArticle);*/
        Helper.scrollAndClick(driver, imgArticle);
    }

    public boolean IsUrlContainArgos() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(lnkFeatureProduct));
        return driver.getCurrentUrl().contains("artigos");
    }

    public boolean IsNavigateFacebook(RemoteWebDriver driver) {
        return driver.getCurrentUrl().contains("facebook.com");
    }

    public boolean IsNavigateVK(RemoteWebDriver driver) {
        return driver.getCurrentUrl().contains("vk.com");
    }

    public Review navReview() {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section.kr-summary-section")));
        Helper.clickItem(driver, summarySection);
        //summarySection.click();
        //driver.executeScript("arguments[0].click();",summarySection);
        Helper.scrollAndClick(driver, lblWriteReview);
        var review = new Review(driver);
        review.WaitForReviewPageToLoad(15);
        return review;
    }

    public RemoteWebDriver navTwitter() {
        Helper.scrollAndClick(driver, lnkTwitter);
        var tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        return driver;
    }

    public boolean IsNavigateTwitter(RemoteWebDriver driver) {
        return driver.getCurrentUrl().contains("twitter.com");
    }

    public void search(String productName) throws InterruptedException {
        Helper.click(driver, icnSearch);
        Helper.EnterText(driver, txtSearch, productName);
        Helper.click(driver, lblSearch);
        Thread.sleep(5000);
        var item = Helper.FindElement(driver, By.xpath("//div[@class='search-list-label']"), 120);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(item));
        Assert.assertTrue(item.isDisplayed());

    }

    public int getSearchCount() {

        var item = Helper.findElement(driver, By.xpath("//div[@class='search-list-label']"), 60);
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(item.getText());
        if (m.find())
            System.out.println(m.group(0));
        return Integer.parseInt(m.group(0));
        //return driver.findElements(By.cssSelector(".search-list-label")).size();
    }


    public boolean IsNavigateToIfoodPage() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return driver.getCurrentUrl().contains("https://www.ifood.com");
    }

    public void isProductCarousalDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(prodCarousal));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", prodCarousal);
        Assert.assertTrue("Expected Product Carousal should displayed", prodCarousal.isDisplayed());
    }

    public MagnumTowel navMagnumOversizeTowel() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(lnkMagnumOverSizedTowel)).click();
        return new MagnumTowel(driver);
    }

    public Article navArticlePage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(lnkArticle)).click();
        return new Article(driver);
    }

    public RemoteWebDriver NavTermsUse() {
        var element = footerContainer.findElements(By.tagName("li"));
        Helper.scrollAndClick(driver, element.get(3).findElement(By.tagName("a")));
        var tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        return driver;

    }

    public RemoteWebDriver NavCookiesNotice() {
        var element = footerContainer.findElement(By.xpath("//li[contains(@data-cmp-data-layer,'cookie-notice')]"));
        Helper.scrollAndClick(driver, element.findElement(By.tagName("a")));
        var tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        return driver;

    }

    public RemoteWebDriver NavPrivacyNotice() {
        var element = footerContainer.findElement(By.xpath("//li[contains(@data-cmp-data-layer,'privacy-notice')] "));
        Helper.scrollAndClick(driver, element.findElement(By.tagName("a")));
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        return driver;

    }

    public RemoteWebDriver NavSignUp() throws InterruptedException {
        var element = driver.findElements(By.xpath("//footer//a[contains(@href,'inscreva-se')]"));
        Helper.scrollAndClick(driver, element.get(0));
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        Helper.clickItem(driver, driver.findElement(By.xpath("//div[@class='cmp-text']//h1[text()='Inscreva-se']")));
        Helper.downKeyOnPage(driver, 20);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='form-paragraph-info']")));
        return driver;

    }

    public static void PressDownKey(RemoteWebDriver driver) {
        while (driver.findElements(By.xpath("//div[@class='cmp-text']//h1")).size() > 0) {
            driver.findElement(By.cssSelector("div#Content")).sendKeys(Keys.ARROW_DOWN);

        }
    }

    public boolean IsNavigateTermsOfUse(RemoteWebDriver driver) {
        return driver.getCurrentUrl().contains("https://www.unilever.com.br/legal/");
    }

    public boolean IsNavigatePrivacyNotice(RemoteWebDriver driver) {
        return driver.getCurrentUrl().contains("privacy-notice");
    }

    public boolean IsNavigateCookiesNotice(RemoteWebDriver driver) {
        return driver.getCurrentUrl().contains("cookie-notice");
    }

    public PDP GoToPDPPage(RemoteWebDriver _driver) {
        var lstProducts = getProductCarouselList();
        Random rand = new Random();
        int upperbound = lstProducts.size() - 1;
        int int_random = rand.nextInt(upperbound);
        Helper.scrollAndClick(_driver, lstProducts.get(int_random));
        return new PDP(_driver);
    }

    public ProductListing GoToProductListingPage(RemoteWebDriver _driver) {
        List<String> linkTxt = new ArrayList<>();
        List<WebElement> links = HeaderNavigationItems.findElements(By.tagName("li"));
        for (WebElement item : links) {
            linkTxt.add(item.findElement(By.tagName("a")).getAttribute("href"));
            if (item.findElement(By.tagName("a")).getAttribute("href").contains("products")
                    | item.findElement(By.tagName("a")).getAttribute("href").contains("produtos")) {
                item.click();
                break;
            }
        }
        return new ProductListing(_driver);
    }

    public ProductListing GotoRandomProductListingPage(RemoteWebDriver _driver) {
        Actions actions = new Actions(_driver);
        //WebElement HeaderNavigationProduct =  _driver.findElement(By.cssSelector("ul.o-navbar-dropdown-menu");
        actions.moveToElement(HeaderNavigationProduct).perform();
        List<WebElement> lstElements = driver.findElements(By.cssSelector("li.o-navbar-item.o-navbar-tier2-item"));
        Random rand = new Random();
        int upperbound = lstElements.size() - 1;
        int int_random = rand.nextInt(upperbound);
        ProdDropdownElement = lstElements.get(int_random);
        /*((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ProdDropdownElement);
        driver.executeScript("arguments[0].click();", ProdDropdownElement);*/
        Helper.click(driver, ProdDropdownElement);
        return new ProductListing(_driver);

    }

    public MagnumDelivery GoToMagnumDeliveryPage(RemoteWebDriver _driver) {
        List<String> linkTxt = new ArrayList<>();
        List<WebElement> links = HeaderNavigationItems.findElements(By.tagName("li"));
        for (WebElement item : links) {
            linkTxt.add(item.findElement(By.tagName("a")).getAttribute("href"));
            if (item.findElement(By.tagName("a")).getAttribute("href").contains("magnum-delivery")) {
                item.click();
                break;
            }
        }
        return new MagnumDelivery(_driver);
    }

    public void ClickOnBuyNow(RemoteWebDriver _driver) {
        var buyItems = _driver.findElements(By.cssSelector("button.cartwire.btn-primary"));
        Random rand = new Random();
        int upperbound = buyItems.size() - 2;
        int int_random = rand.nextInt(upperbound);
        Helper.scrollAndClick(_driver,buyItems.get(int_random));
        //buyItems.get(int_random).click();
    }

    public String selectVendor(RemoteWebDriver _driver) throws InterruptedException {
        Helper.WaitForPageLoad(_driver,20);
        WebElement tblVendorLst = _driver.findElement(By.cssSelector("#cwRetailsTbl"));
        var items=tblVendorLst.findElements(By.tagName("a"));
        Random rand = new Random();
        int upperbound = items.size() - 1;
        int int_random = rand.nextInt(upperbound);
        String navUrl=items.get(int_random).getAttribute("href");
        Helper.scrollAndClick(_driver,items.get(int_random));
        Helper.WaitForPageLoad(_driver,20);
        Thread.sleep(3000);
        return  navUrl;
    }


    public Boolean verifyBuyPopup(RemoteWebDriver _driver) {

        if (_driver.findElements(By.cssSelector("h2.cw_product_title")).size() > 0)
            return true;
        else
            return false;
    }

    public void ClickOnQuickView(RemoteWebDriver _driver) {
        var quickView = _driver.findElements(By.cssSelector("button.quick-view-btn"));
        Random rand = new Random();
        int upperbound = quickView.size() - 2;
        int int_random = rand.nextInt(upperbound);
        Helper.scrollClick(_driver,quickView.get(int_random));
        //buyItems.get(int_random).click();
    }

    public Boolean verifyQuickViewpopup(RemoteWebDriver _driver) {

        if (_driver.findElements(By.cssSelector("h2.c-product-listing-v2-quickview__productname")).size() > 0)
            return true;
        else
            return false;
    }

    public PDP ClickOnFindOutMoreButton(RemoteWebDriver _driver) {
        Helper.click(driver, FindOutMoreButton);
        return new PDP(_driver);

    }

    public boolean isNoResultDisplay() {
         return driver.findElements(By.cssSelector("p.no-results-suggestion__description")).size()>0;
    }

    public String navSuggestionList() {
        var items=driver.findElements(By.cssSelector(".search-result-card"));
        Random rand = new Random();
        int upperbound = items.size() - 1;
        int int_random = rand.nextInt(upperbound);

        var targetElement= items.get(int_random).findElement(By.cssSelector(".search-image>a"));
        String hrefTxt=targetElement.getAttribute("href");
        Helper.scrollAndClick (driver,items.get(int_random).findElement(By.cssSelector(".search-image>a")));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        return hrefTxt;
    }

    public RemoteWebDriver getActiveWindow(){
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        return driver;
    }
}
