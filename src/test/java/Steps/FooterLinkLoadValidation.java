package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Utility.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.var;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FooterLinkLoadValidation {

    private Home _home;
    private RemoteWebDriver _driver;
    private List<String> linkTxt = new ArrayList<String>();
    private int footerLinks = 0;

    public FooterLinkLoadValidation(BaseUtilities base) {
        _driver = base._driver;
    }

    @Given("The site is Up & Running")
    public void the_site_is_up_and_running() throws ParserConfigurationException, IOException, SAXException {
        //Helper. helper=new Helper();
        Helper.NavigateToUAT(_driver);
        _home = new Home(_driver);
        System.out.println("Given");

    }

    @When("i try to get the footer links")
    public void i_try_to_get_the_footer_links() {
        System.out.println("When");
        linkTxt=_home.getFooterLinkText();
        footerLinks = _home.getFooterLink().size();
    }

    @Then("All the footer link should load within {int} second")
    public void all_the_footer_link_should_load_within_second(Integer timeSecond) {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Then");
        for (int i = 0; i < footerLinks; i++) {
            long start = System.currentTimeMillis();
            Helper.click(_driver, _home.getFooterLink().get(i));
            Helper.WaitForPageLoad(_driver, 60);
            long finish = System.currentTimeMillis();
            long totalTime = finish - start;
            softAssert.assertTrue((0.001 * totalTime) <= timeSecond, "Page should load within " + timeSecond);
            System.out.println("Loading time is ..." + (0.001 * totalTime));
            softAssert.assertTrue(_driver.getCurrentUrl().contains(linkTxt.get(i)),
                    "Expected link should contain the text");
            var tabs2 = new ArrayList<>(_driver.getWindowHandles());
            if (tabs2.size() > 1) {
                _driver.switchTo().window(tabs2.get(1));
                _driver.close();
            }

            _driver.switchTo().window(tabs2.get(0));

        }
    }
}
