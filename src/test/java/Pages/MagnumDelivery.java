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

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MagnumDelivery {
    private final RemoteWebDriver driver;

    public MagnumDelivery(RemoteWebDriver _driver) {
        Helper.WaitForPageLoad(_driver, 60);
        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    @FindBy(css = "div.container_par_1.parsys")
    WebElement FoodpandaIcon;

    @FindBy(css = "div.container_par_3.parsys")
    WebElement GrabmartIcon;

    public void validatePageNavigationToFoodpandaIcon() {
        Assert.assertTrue("Foodpanda icon should displayed", FoodpandaIcon.isDisplayed());
    }

    public void validatePageNavigationToGrabmartIcon() {
        Assert.assertTrue("Grabmart icon should displayed", GrabmartIcon.isDisplayed());
    }

    public RemoteWebDriver ClickOnFoodpandaicon() {
        Helper.click(driver, FoodpandaIcon);
        var tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        return driver;

    }

    public RemoteWebDriver ClickOnGrabmartIcon() {
        Helper.click(driver, GrabmartIcon);
        var tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        return driver;

    }

    public boolean IsNavigateToFoodpandaPage(RemoteWebDriver driver) {
        return driver.getCurrentUrl().contains("foodpanda.sg");
    }

    public boolean IsNavigateToGrabmartPage(RemoteWebDriver driver) {
        return driver.getCurrentUrl().contains("www.grab.com");
    }
}


