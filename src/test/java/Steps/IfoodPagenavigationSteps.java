package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.List;

public class IfoodPagenavigationSteps {
    private RemoteWebDriver _driver;
    private Home _home;
    private List<WebElement> elements;

    public IfoodPagenavigationSteps(BaseUtilities base) {
        this._driver = base._driver;
    }


    @When("verifying the ifood link on  carousel")
    public void verifying_the_ifood_link_on_carousel() throws InterruptedException {
        _home=new Home(_driver);
        elements= _home.getCarouselList();
        _home.getFirstCarousel(elements);
    }
    @Then("it should navigate to ifood page")
    public void it_should_navigate_to_ifood_page() throws InterruptedException {
        Assert.assertTrue(_home.IsNavigateToIfoodPage());
    }

}
