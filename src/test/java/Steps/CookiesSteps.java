package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Utility.Helper;
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

public class CookiesSteps extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private List<WebElement> elements;
    private RemoteWebDriver _driver;

    public CookiesSteps(BaseUtilities base) {

        this._driver = base._driver;
    }

    @When("verify the bottom for cookie popup")
    public void verify_the_bottom_for_cookie_popup() {
        Helper.WaitForPageLoad(_driver,60);
        System.out.println("Waiting for Page to Load");
    }
    @Then("it should be visible once the page got loaded")
    public void it_should_be_visible_once_the_page_got_loaded() {
        Assert.assertTrue(Helper.isCookieDispaly(_driver));
    }
    @Given("The site is Up")
    public void the_site_is_up() throws ParserConfigurationException, IOException, SAXException {
        Helper.NavigateToApp(_driver);
    }

    @Given("the cookie popup is visible")
    public void the_cookie_popup_is_visible() {
        Assert.assertTrue(Helper.isCookieDispaly(_driver));
    }
    @When("click on the accept all button")
    public void click_on_the_accept_all_button() {
        Helper.handleCookie(_driver);
    }
    @Then("the popup should disable")
    public void the_popup_should_disable() {
        Assert.assertFalse(Helper.isCookieDispaly(_driver));
    }
}
