package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;


public class ArticlePageRedirectionStep extends BaseUtilities {

    private Home _home;
    private final RemoteWebDriver _driver;
    public ArticlePageRedirectionStep(BaseUtilities base) {
        _driver= base._driver;
    }

    @When("i try to click on article image")
    public void i_try_to_click_on_article_image() {
        _home=new Home(_driver);
        _home.navArticlePageByImg();
    }
    @Then("the page should redirect to Article page")
    public void the_page_should_redirect_to_article_page() {
        Assert.assertTrue("Expected page should redirect to Article Page",_home.IsUrlContainArtigos());
    }
}
