package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;


public class Article {
    private final RemoteWebDriver driver;

    public Article(RemoteWebDriver _driver) {

        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    String imgPath = "//div[@id='contentWrapperSection']//div[@class='cmp-container']//div[@class='list']//ul//div[@class='cmp-teaser__image']";

    @FindBy(xpath = "//div[@class='productcarousel carousel c-related-products--fixed']")
    WebElement lnkFeatureProduct;

    @FindBy(css = ".cmp-accordion__title")
    WebElement lnkNutritionDetails;

    public void navigateToImgUrl() {
        List<WebElement> imgItems = driver.findElements(By.xpath(imgPath));
        Random randomizer = new Random();
        imgItems.get(randomizer.nextInt(imgItems.size())).click();
    }

    public void validatePageNavigationToArticle(){
        Assert.assertTrue(lnkFeatureProduct.isDisplayed());
    }

    public void clickFeatureProduct(){
        lnkFeatureProduct.click();
    }

    public void validatePageNavigationToProduct(){
        Assert.assertTrue(lnkNutritionDetails.isDisplayed());
    }
}
