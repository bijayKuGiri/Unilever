package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;


public class LanguageSelectionStep extends BaseUtilities {

    List<Boolean> results;
    RemoteWebDriver _driver;

    public LanguageSelectionStep(BaseUtilities base) {
        _driver = base._driver;
    }

    @When("click on the language selector in button")
    public void click_on_the_language_selector_in_button() {
        Home _home = new Home(_driver);
        results = _home.selectLanguage();
    }

    @Then("the selected language should be changed in the page.")
    public void the_selected_language_should_be_changed_in_the_page() {
        for (var item :
                results) {
            Assert.assertTrue(item);
        }
    }
}
