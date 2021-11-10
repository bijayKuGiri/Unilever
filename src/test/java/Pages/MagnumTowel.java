package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MagnumTowel {
    private final RemoteWebDriver driver;
    private List<WebElement> items;

    public MagnumTowel(RemoteWebDriver _driver) {

        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    @FindBy(xpath = "//div[@class='cmp-embed-video__playicon']")
    WebElement videoArea;

    @FindBy(xpath = "//div[@class='ytp-copylink-icon']")
    WebElement lnkCopy;


    @FindBy(xpath = "//div[@class='cmp-embed-video__playicon']")
    WebElement iconPlayVideo;

    @FindBy(xpath = "//div[@class='cmp-media-gallery-v2__loadmore js-media-gallery-v2__loadmore']//button")
    WebElement btnLoadMore;

    public void Play() {
        iconPlayVideo.click();
        //WebDriverWait wait = new WebDriverWait(driver, 2);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ytp-copylink-icon']")));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Mais vídeos']")));
    }

    public void clickBtnLoadMore() {
        items = getImageList();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", btnLoadMore);
        driver.executeScript("arguments[0].click();", btnLoadMore);
//        btnLoadMore.click();
    }

    public void ValidateVideo() {
        var size = driver.findElements(By.tagName("iframe")).size();
        if (size>0){
            driver.switchTo().frame(0);
        }
        Assert.assertTrue(driver.findElements(By.xpath("//video")).size()>0);
    }

    private List<WebElement> getImageList() {
        return driver
                .findElements(By.xpath("//picture//img")).stream().filter(el -> el.isDisplayed())
                .collect(Collectors.toList());

    }

    public void ValidateImage() {
        Assert.assertTrue(getImageList().size() > items.size());
    }
}
