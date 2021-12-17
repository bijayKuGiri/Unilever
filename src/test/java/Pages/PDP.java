package Pages;

import Utility.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
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

//    @FindBy(css = "div.product-info-item-wrapper[1]")
   /* @FindBy(css = "div.product-info-item__item")
    WebElement ProductDescription;*/

    @FindBy(css = "div.rr-widget-container.kr-star-percentage.kr-has-rp.kr-inline-widget.kr-star-widget")
    WebElement ReviewRatingSection;

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
}
