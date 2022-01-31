package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Utility.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class CookieBehaviorValidationSteps {
    private Home _home;
    private List<WebElement> elements;
    private RemoteWebDriver _driver;

    public CookieBehaviorValidationSteps(BaseUtilities base) {

        this._driver = base._driver;
    }

    @Given("The site is Up and navigate to cookie banner in footer")
    public void the_site_is_up_and_navigate_to_banner() throws ParserConfigurationException, IOException, SAXException {
        Helper.NavigateToApp(_driver);
        Helper.WaitForPageLoad(_driver,60);
        System.out.println("Waiting for Page to Load");
        Assert.assertTrue(Helper.isCookieDisplay(_driver));
    }

    @When("click on the accept button")
    public void clickOnTheAcceptButton() {
        Helper.handleCookie(_driver);
    }

    @And("again load the site")
    public void againLoadTheSite() {
       // _driver.quit();
        //Helper.setUp_withoutClearCookie(_driver);
        Helper.NavigateToApp(_driver);
        Helper.WaitForPageLoad(_driver,60);
        System.out.println("Waiting for Page to Load again");
    }

    @Then("check the popup should not be visible again")
    public void checkThePopupShouldNotBeVisibleAgain() {
        Assert.assertFalse(Helper.verifyNoCookieBannerVisible(_driver));
    }
}
