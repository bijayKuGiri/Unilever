package Utility;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import javax.management.InvalidApplicationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class Helper {

    public static String filePath = "src/test/resources/config.xml";
    public static String jsonfilePath = "src/test/resources/environment.json";

    public static String getNodeValue(String path, String nodeName) {
        try {
            DocumentBuilderFactory dBfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dBfactory.newDocumentBuilder();
            Document document = builder.parse(new File(path));
            document.getDocumentElement().normalize();
            return document.getElementsByTagName(nodeName).item(0).getTextContent();
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

    private static String getEnv() {
        return getUrl(getNodeValue(filePath, "environment"));
    }

    public static void NavigateToUAT(RemoteWebDriver _driver) {
        String url = getEnv();
        if (Objects.equals(url, "_testEnv")) {
            System.out.println("Please set the env value in Config file");
            return;
        }
        _driver.navigate().to(url);
        _driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        _driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        handleCookie(_driver);
    }

    public static void NavigateToApp(RemoteWebDriver _driver) {
        String url = getEnv();
        if (Objects.equals(url, "_testEnv")) {
            System.out.println("Please set the env value in Config file");
            return;
        }
        _driver.navigate().to(url);
        _driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        _driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }

    public static WebElement FindElement(WebDriver webDriver, By by, int timeout) {
        int iSleepTime = 1000;
        for (int i = 0; i < timeout; i += iSleepTime) {
            var oWebElements = webDriver.findElements(by);
            if (oWebElements.size() > 0) {
                return oWebElements.get(0);
            } else {
                try {
                    Thread.sleep(iSleepTime);
                    System.out.println(String.format("%s: Waited for %d milliseconds.[%s]", new java.util.Date().toString(), i + iSleepTime, by));
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        // Can't find 'by' element. Therefore throw an exception.
        String sException = String.format("Can't find %s after %d milliseconds.", by, timeout);
        throw new RuntimeException(sException);
    }

    /*public boolean waitForJStoLoad() {
        WebDriverWait wait = new WebDriverWait(_driver, 30);
        // wait for jQuery to load
        ExpectedConditions<Boolean> jQueryLoad = new ExpectedConditions<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)executeJavaScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    return true;
                }
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return executeJavaScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }*/

    public static void scrollAndClick(RemoteWebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.executeScript("arguments[0].click();", element);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }

    public static void selectFromDDn(RemoteWebDriver driver, String Value, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
        Select se = new Select(element);
        se.selectByValue(Value);
    }

    public static void click(RemoteWebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            Actions action = new Actions(driver);
            action.moveToElement(element).click().perform();
        } catch (ElementClickInterceptedException ex) {
            handleCookie(driver);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
            Actions action = new Actions(driver);
            action.moveToElement(element).click().perform();
        }
    }

    public static void clickItem(RemoteWebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }

    public static Boolean isCookieDisplay(RemoteWebDriver driver) {
        //WaitForPageLoad(driver,60);
        return driver.findElement(By.cssSelector("div#onetrust-button-group-parent>div>button#onetrust-accept-btn-handler")).isDisplayed();
        /*var item= Helper.findElementIfExist(driver,By.cssSelector("div#onetrust-button-group-parent>div>button#onetrust-accept-btn-handler"));
        return item != null;*/
    }

    public static void handleCookie(RemoteWebDriver _driver) {
        if (_driver.findElements(By.cssSelector("div#onetrust-button-group-parent>div>button#onetrust-accept-btn-handler")).size() <= 0)
            return;
        if (!_driver.findElement(By.cssSelector("div#onetrust-button-group-parent>div>button#onetrust-accept-btn-handler")).isDisplayed())
            return;
        WebElement webElement = _driver.findElement(By.cssSelector("div#onetrust-button-group-parent>div>button#onetrust-accept-btn-handler"));
        /*Actions actions = new Actions(_driver);
        actions.moveToElement(webElement);
        actions.click().perform();*/
        clickItem(_driver,webElement);
        while (_driver.findElement(By.cssSelector("div#onetrust-button-group-parent")).isDisplayed()) {
        }

    }

    public static void EnterText(RemoteWebDriver driver, WebElement element, String value) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(value);
        } catch (ElementClickInterceptedException ex) {
            handleCookie(driver);
            click(driver, element);
            element.sendKeys(value);
        }
    }

   /* public static void scrollUpPage(RemoteWebDriver driver, int timesToScroll) throws InterruptedException {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_UP);
        for (int i = 0; i < timesToScroll; i++) {
            action.perform();
            Thread.sleep(1000);
        }
    }*/

    public static void scrollDownPage(RemoteWebDriver driver, int timesToScroll) throws InterruptedException {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN);
        for (int i = 0; i < timesToScroll; i++) {
            action.perform();
            Thread.sleep(1000);
        }
    }

    public static void downKeyOnPage(RemoteWebDriver driver, int timesToScroll) throws InterruptedException {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN);
        for (int i = 0; i < timesToScroll; i++) {
            action.perform();
            //Thread.sleep(1000);
        }
    }

    public static void WaitForPageLoad(RemoteWebDriver _driver, int timeOutSec) {
        var wait = new WebDriverWait(_driver, timeOutSec);
        wait.until(wd -> ((JavascriptExecutor) _driver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public static void WaitForElementToExistAndVisible(WebElement element) throws InterruptedException, InvalidApplicationException {
        var ct = 0;
        do {
            ++ct;
            Thread.sleep(1000);
        } while (!element.isDisplayed() && ct < 200);
        if (element.isDisplayed() && !element.isEnabled()) {
            throw new InvalidApplicationException(element + " must be visible and Enable");
        }
    }

    public static WebElement findElementIfExist(RemoteWebDriver _driver, By by) {
        var elements = _driver.findElements(by);
        return (elements.size() >= 1) ? elements.get(1) : null;
    }

    public static WebElement findElement(RemoteWebDriver _driver, By by, int timeOutInSec) {
        if (timeOutInSec <= 0) return _driver.findElement(by);
        var wait = new WebDriverWait(_driver, timeOutInSec);
        return wait.until(drv -> drv.findElement(by));
    }

    public static String getUrl(String environmentDetails) {

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(jsonfilePath));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get(environmentDetails);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return "";
        }

    }


}
