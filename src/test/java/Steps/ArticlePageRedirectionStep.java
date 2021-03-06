package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

@Slf4j
public class ArticlePageRedirectionStep {

    private Home _home;
    private final RemoteWebDriver _driver;
    public ArticlePageRedirectionStep(BaseUtilities base) {
        _driver= base._driver;
    }

    @When("i try to click on article image")
    public void i_try_to_click_on_article_image() {
        _home=new Home(_driver);
        log.info("Navigate to Article page by clicking on image");
        _home.navArticlePageByImg();
    }
    @Then("the page should redirect to Article page")
    public void the_page_should_redirect_to_article_page() {
        log.info("Verifying the page navigation");
        Assert.assertTrue("Expected page should redirect to Article Page",_home.IsUrlContainArgos());
    }
}
