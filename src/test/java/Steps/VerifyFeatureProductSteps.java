package Steps;

import Base.BaseUtilities;
import Pages.Article;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;

public class VerifyFeatureProductSteps extends BaseUtilities {

    private Article article;
    private final RemoteWebDriver _driver;

    public VerifyFeatureProductSteps(BaseUtilities base) {

        //this.base = base;
        _driver = base._driver;
    }

    @When("click on feature product link")
    public void click_on_feature_product_link() {
        article=new Article(_driver);
        article.clickFeatureProduct();
    }
    @Then("it should redirect to Feature product Page")
    public void it_should_redirect_to_feature_product_page() {
        article.validatePageNavigationToProduct();
    }
}
