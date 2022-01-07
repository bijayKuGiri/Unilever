package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.PDP;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class UberEatsPageNavigationSteps extends BaseUtilities {
    private PDP _pdp;
    private BaseUtilities base;
    private Home _home;
    private List<WebElement> elements;

    public UberEatsPageNavigationSteps(BaseUtilities base) {
        this.base = base;
    }


    @When("click on Uber Eats link")
    public void i_try_to_click_on_UberEats_link() throws InterruptedException {
        _pdp.validatePageNavigationToUberEatslogo();
        _driver = _pdp.ClickOnUberEatslogo();

    }

    @Then("it should open Uber Eats site in next tab")
    public void UberEats_link_should_be_opened_in_next_tab() throws InterruptedException {
        Assert.assertTrue(_pdp.IsNavigateToUberEatsPage(_driver));

    }
}

