package Pages;

import Utility.Helper;
import lombok.var;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.stream.Collectors;

public class ProductListing {
    private final RemoteWebDriver driver;

    public ProductListing(RemoteWebDriver _driver) {
        Helper.WaitForPageLoad(_driver, 60);
        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    @FindBy(xpath = "//li[@class='o-quick-panel c-product-listing-v2-quickview clearfix active']/div/div/div[2]/div[3]/a")
    WebElement FindOutMoreButton;

    @FindBy(css = "li.o-quick-panel.c-product-listing-v2-quickview.clearfix.active")
    WebElement QuickViewPopup;

    @FindBy(css = "div.teaser")
    WebElement HeroSection;

    @FindBy(css = "div.container.responsivegrid.anchor-link__navigation")
    WebElement AnchorLinkNavigation;

    @FindBy(css = "div.text.demo-composite.aem-GridColumn.aem-GridColumn--default--12")
    WebElement Text;

    @FindBy(css = "div.tabimage.image.aem-GridColumn--default--none.aem-GridColumn.aem-GridColumn--offset--default--0.aem-GridColumn--default--4")
    WebElement SmallTabImages;

    @FindBy(css = "div.tabimage.image.aem-GridColumn--default--none.aem-GridColumn.aem-GridColumn--default--8.aem-GridColumn--offset--default--0")
    WebElement BigTabImages;

    @FindBy(css = "div.button.button--secondary.demo-composite.aem-GridColumn.aem-GridColumn--default--12")
    WebElement Buttons;

    public void IsDisplayedHeroSection() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(HeroSection));
        Assert.assertTrue("HeroSection is displayed",HeroSection.isDisplayed());
    }

    public void IsDisplayedAnchorLinkNavigation() {
        Assert.assertTrue("AnchorLinkNavigation is displayed",AnchorLinkNavigation.isDisplayed());
    }

    public void IsDisplayedText() {
        Assert.assertTrue("Text is displayed",Text.isDisplayed());
    }

    public void IsDisplayedSmallTabImages() {
        Assert.assertTrue("SmallTabImages is displayed",SmallTabImages.isDisplayed());
    }

    public void IsDisplayedBigTabImages() {
        Assert.assertTrue("BigTabImages is displayed",BigTabImages.isDisplayed());
    }

    public void IsDisplayedButtons() {
        Assert.assertTrue("Buttons is displayed",Buttons.isDisplayed());
    }

    public void ClickOnQuickView(RemoteWebDriver _driver) {
        var quickview = _driver.findElements(By.cssSelector("button.quick-view-btn"));
        Random rand = new Random();
        int upperbound = quickview.size() - 2;
        int int_random = rand.nextInt(upperbound);
        Helper.scrollClick(_driver,quickview.get(int_random));
        //buyItems.get(int_random).click();
    }

    public void IsDisplayedQuickViewPopup(){Assert.assertTrue("QuickViewPopup is displayed",QuickViewPopup.isDisplayed());}

    public PDP ClickOnFindOutMoreButton(RemoteWebDriver _driver) {
        Helper.click(driver, FindOutMoreButton);
        return new PDP(_driver);

    }
}
