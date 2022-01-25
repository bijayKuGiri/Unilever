package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.PDP;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.List;

public class UberEatsPageNavigationSteps
{
    private RemoteWebDriver _driver;
    private PDP _pdp;

    public UberEatsPageNavigationSteps(BaseUtilities base) {
        this._driver = base._driver;
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

