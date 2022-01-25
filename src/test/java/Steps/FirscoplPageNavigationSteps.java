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

public class FirscoplPageNavigationSteps {
    private PDP _pdp;
    private Home _home;
    private List<WebElement> elements;
    private RemoteWebDriver _driver;

    public FirscoplPageNavigationSteps(BaseUtilities base) {
        this._driver = base._driver;
    }

    @And("user redirected to PDP page")
    public void i_navigate_to_a_pdp_page() {
        Home _home=new Home(_driver);
        _pdp= _home.GoToPDPPage(_driver);

    }

    @When("click on Frisco.pl link")
    public void i_try_to_click_on_Friscopl_link() throws InterruptedException {
        _pdp.validatePageNavigationToFriscologo();
        _driver = _pdp.ClickOnFriscologo();

    }

    @Then("it should open Firsco.pl site in next tab")
    public void Friscopl_link_should_be_opened_in_next_tab() throws InterruptedException {
        Assert.assertTrue(_pdp.IsNavigateToFriscoplPage(_driver));

    }
}
