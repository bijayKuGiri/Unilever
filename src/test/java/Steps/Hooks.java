package Steps;

import Base.BaseUtilities;
import Utility.Helper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.util.Objects;

public class Hooks extends BaseUtilities {

    private final BaseUtilities utils;
    private RemoteWebDriver _driver;

    public Hooks(BaseUtilities baseUtilities){
        utils=baseUtilities;
    }

    @After
    public void TearDown(Scenario scenario){
        if(scenario.isFailed()){
            Allure.addAttachment(scenario.getName(),
                    new ByteArrayInputStream(((TakesScreenshot)_driver)
                            .getScreenshotAs(OutputType.BYTES)));
        }
        if(_driver!=null){
            _driver.quit();

        }
        System.out.println("Tear down process done");
    }

    @Before
    public void Initialize() {
        System.out.println("Initialise process Start");
        String OS = System.getProperty("os.name").toLowerCase();
        SelectBrowser(Browsertype.CHROME,OS);
        utils._driver=_driver;
    }

    public void SelectBrowser(Browsertype browser,String OS) {

        if(browser==Browsertype.CHROME) {
            /*System.setProperty("webdriver.chrome.silentOutput","true");
            if (OS.contains("win"))
                System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\ChromeDriver\\windows.exe");
            else if(OS.contains("mac"))
                System.setProperty("webdriver.chrome.driver", ".//src//main//resources//ChromeDriver//mac64m1");
            else if(OS.contains("nix") || OS.contains("nux") || OS.contains("aix"))
                System.setProperty("webdriver.chrome.driver", ".//src//main//resources//ChromeDriver//linux");*/
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT_AND_NOTIFY);
            options.addArguments("enable-automation");
            if(Objects.requireNonNull(Helper.getNodeValue(Helper.filePath, "headless")).equalsIgnoreCase("yes"))
                options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-extensions");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--disable-gpu");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            _driver = new ChromeDriver(options);
            _driver.manage().deleteAllCookies();
            Helper.WaitForPageLoad(_driver,60);
            //_driver.manage().window().maximize();
        }
        else if(browser==Browsertype.EDGE) {
            System.out.println("Initialise Edge Browser");
        }
        else if(browser==Browsertype.FIREFOX) {
            System.out.println("Initialise Firefox Browser");
        }
        else{
            Assert.fail("Please Select a Browser");
        }

    }


}

enum Browsertype{
    CHROME,
    FIREFOX,
    EDGE
}
