package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LogoValidation extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    SoftAssert softAssert=new SoftAssert();

    public LogoValidation(BaseUtilities base) {
        this.base = base;
    }


    @When("verifying all the links")
    public void verifying_all_the_links() {
        System.out.println("Verifying the Element on the Page");
        _home=new Home(base._driver);
    }
    @Then("All the elements should placed appropriately")
    public void all_the_elements_should_placed_appropriately() throws IOException, InterruptedException {

        softAssert.assertEquals(_home.getHeader(),"Homepage | Magnum Brasil");
        softAssert.assertTrue(_home.IsLogoImageDisplayed());
        softAssert.assertTrue(_home.IsCopyRightExist());
        System.out.println(_home.logoText());

    }

    @When("verifying logo")
    public void verifying_logo() {
        System.out.println("Verifying the Element on the Page");
        _home=new Home(base._driver);
    }
    @Then("Logo should be visible")
    public void logo_should_be_visible() {
        Assert.assertTrue(_home.IsLogoImageDisplayed());
    }
}
