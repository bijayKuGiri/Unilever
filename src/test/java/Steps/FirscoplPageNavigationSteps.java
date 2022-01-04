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

public class FirscoplPageNavigationSteps extends BaseUtilities {
    private PDP _pdp;
    private BaseUtilities base;
    private Home _home;
    private List<WebElement> elements;

    public FirscoplPageNavigationSteps(BaseUtilities base) {
        this.base = base;
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
