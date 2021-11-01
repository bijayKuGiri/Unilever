package Steps;

import Base.BaseUtilities;
import Pages.Article;
import Pages.Home;
import Pages.MagnumTowel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;

public class VerifyArticleRedirectionSteps extends BaseUtilities {

    private Article article;
    private final RemoteWebDriver _driver;

    public VerifyArticleRedirectionSteps(BaseUtilities base) {

        //this.base = base;
        _driver = base._driver;
    }

    @And("navigate to the Article Page")
    public void navigate_to_the_article_page() {
        Home _home = new Home(_driver);
        article = _home.navArticlePage();
    }
    @When("i click on any article image")
    public void i_click_on_any_article_image() {
        article.navigateToImgUrl();
    }
    @Then("it should redirect to Article page")
    public void it_should_redirect_to_article_page() {
        article.validatePageNavigationToArticle();
    }
}
