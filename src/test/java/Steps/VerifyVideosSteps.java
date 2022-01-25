package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.MagnumTowel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;

public class VerifyVideosSteps {

    private MagnumTowel magnumTowel;
    private final RemoteWebDriver _driver;

    public VerifyVideosSteps(BaseUtilities base) {
        _driver = base._driver;
    }

    @And("navigate to the video contain tab")
    public void navigate_to_the_video_contain_tab() {
        Home _home = new Home(_driver);
        magnumTowel = _home.navMagnumOversizeTowel();
    }

    @When("i try to play the video")
    public void i_try_to_play_the_video()  {
        magnumTowel.Play();
    }

    @Then("the video should visible")
    public void theVideoShouldVisible() {
        magnumTowel.ValidateVideo();
    }
}
