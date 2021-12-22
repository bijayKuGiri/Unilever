package Pages;

import Utility.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.stream.Collectors;

public class ProductListing {
    private final RemoteWebDriver driver;

    public ProductListing(RemoteWebDriver _driver) {
        Helper.WaitForPageLoad(_driver, 60);
        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

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

}
