package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class SiteMapSteps extends BaseUtilities {
    private BaseUtilities base;
    private Home _home;
    private RemoteWebDriver _driver;

    public SiteMapSteps(BaseUtilities base) {

        this.base = base;
        _driver = base._driver;
    }
    @And("i try to click on Sitemap link")
    public void i_try_to_click_on_sitemap_link() throws InterruptedException {
        _home=new Home(_driver);
        _home.selectSiteMap();
    }
    @When("click on any link on sitemap page")
    public void click_on_any_link_on_sitemap_page() throws InterruptedException {
        _home.selectAnySite();
    }
    @Then("the page should redirect to Sitemap page")
    public void the_page_should_redirect_to_sitemap_page() {
        Assert.assertTrue(_home.verifySitemapRedirection());
    }
}
