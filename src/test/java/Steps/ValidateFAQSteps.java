package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ValidateFAQSteps extends BaseUtilities {
    private BaseUtilities base;
    private Home _home;
    private RemoteWebDriver _driver;

    public ValidateFAQSteps(BaseUtilities base) {

        this.base = base;
        _driver = base._driver;
    }

    @And("navigate to FAQ page")
    public void navigate_to_faq_page() throws InterruptedException {
        _home=new Home(_driver);
        _home.selectFAQ();
    }

    @When("i try to click on + icon")
    public void i_try_to_click_on_icon() {
        _home.selectFAQAns();
    }

    @Then("the answer should be visible")
    public void the_answer_should_be_visible() {
        Assert.assertTrue(_home.isAnswerDisplay());
    }

    @When("i try to click on cross * icon")
    public void i_try_to_click_on_cross_icon() {
        _home.clickCrossMark();
    }

    @Then("the answer should be hidden again")
    public void the_answer_should_be_hidden_again() {
        Assert.assertFalse(_home.isAnswerDisplay());
    }
}
