package Pages;

import Utility.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.stream.Collectors;

public class PDP {
    private final RemoteWebDriver driver;

    public PDP(RemoteWebDriver _driver) {
        Helper.WaitForPageLoad(_driver, 60);
        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    @FindBy(css = "div.product-media-gallary")
    WebElement ProductImage;

    @FindBy(css = "div.product-info-item-wrapper>h1")
    WebElement ProductName;

    @FindBy(css = "div.rr-widget-container.kr-star-percentage.kr-has-rp.kr-inline-widget.kr-star-widget")
    WebElement ReviewRatingSection;

    @FindBy(css = "button.cmp-accordion__button")
    WebElement NutritionalInformation;

    @FindBy(css = "div.pagelist.list.product-list.aem-GridColumn.aem-GridColumn--default--12")
    WebElement PageListComponent;

    @FindBy(css = "div.kr-readpanel-header.kr-panel")
    WebElement ReviewReadPanelHeader;

    @FindBy(css = "div.kr-readpanel-reviews.kr-panel")
    WebElement ReviewReadPanelReviews;

    public void validatePageNavigationToProductImage() {
        Assert.assertTrue("Product Image is displayed",ProductImage.isDisplayed());
    }

    public void validatePageNavigationToProductName() {
        Assert.assertTrue("Product name is displayed",ProductName.isDisplayed());
    }

    public void validatePageNavigationToProductDescription() {
        var items=driver.findElements(By.cssSelector("div.product-info-item__item"))
                        .stream().filter(WebElement::isDisplayed).collect(Collectors.toList());

        Assert.assertTrue("Expected Description should be available",items.size()==1);
    }

    public void validatePageNavigationToProductReviewRatingSection() {
        Assert.assertTrue("Product Review rating should displayed",ReviewRatingSection.isDisplayed());
    }

    public void validatePageNavigationToProductNutritionalInformationSection() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", NutritionalInformation);
        Assert.assertTrue("Product Nutritional Information should displayed",NutritionalInformation.isDisplayed());
    }

    public void validatePageNavigationToProductPageListComponent() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", PageListComponent);
        Assert.assertTrue("Product PageList component should displayed",PageListComponent.isDisplayed());
    }

    public void validatePageNavigationToProductReadReviewPanelHeader() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ReviewReadPanelHeader);
        Assert.assertTrue("Product Read Review Panel Header should displayed",ReviewReadPanelHeader.isDisplayed());
    }

    public void validatePageNavigationToProductReadReviewPanelReviews() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ReviewReadPanelReviews);
        Assert.assertTrue("Product Read Review Panel Reviews should displayed",ReviewReadPanelReviews.isDisplayed());
    }
}
