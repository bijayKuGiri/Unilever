package Utility;

import jdk.jfr.Timespan;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.management.InvalidApplicationException;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Helper {

    public static String filePath = "src/test/resources/config.xml";

    public static String getNodeValue(String path, String nodeName) throws ParserConfigurationException, IOException, SAXException {
        try {
            DocumentBuilderFactory dBfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dBfactory.newDocumentBuilder();
            Document document = builder.parse(new File(path));
            document.getDocumentElement().normalize();
            return document.getElementsByTagName(nodeName).item(0).getTextContent();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }

    }

    public static void NavigateToUAT(RemoteWebDriver _driver) throws ParserConfigurationException, IOException, SAXException {
        //_driver.navigate().to(getNodeValue(filePath,"uat"));
        _driver.navigate().to(getNodeValue(filePath, "uatcred"));
        _driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        _driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //handleCookie(_driver);
        if (_driver.findElement(By.cssSelector("div#onetrust-button-group-parent")).isDisplayed()) {
            WebElement webElement = _driver.findElement(By.cssSelector("div#onetrust-button-group-parent"));
            Actions actions = new Actions(_driver);
            actions.moveToElement(webElement);
            actions.click().perform();
            while (_driver.findElement(By.cssSelector("div#onetrust-button-group-parent")).isDisplayed()) {
            }
        }

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

    public static void selectFromDDn(RemoteWebDriver driver,String Value, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
        Select se = new Select(element);
        se.selectByValue(Value);
    }

    public static void click(RemoteWebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
            Actions action = new Actions(driver);
            action.moveToElement(element).click().perform();
        } catch (ElementClickInterceptedException ex) {
            if (driver.findElement(By.cssSelector("div#onetrust-button-group-parent")).isDisplayed()) {
                WebElement webElement = driver.findElement(By.cssSelector("div#onetrust-button-group-parent"));
                Actions actions = new Actions(driver);
                actions.moveToElement(webElement);
                actions.click().perform();
                while (driver.findElement(By.cssSelector("div#onetrust-button-group-parent")).isDisplayed()) {
                }
            }
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
            Actions action = new Actions(driver);
            action.moveToElement(element).click().perform();
        }
    }

    public static void handleCookie(RemoteWebDriver driver) {
        if (driver.findElements(By.xpath("//div[@id='onetrust-banner-sdk']")).size() > 0)
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).submit();
    }

    public static void EnterText(RemoteWebDriver driver, WebElement element, String value) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(value);
        } catch (ElementClickInterceptedException ex) {
            if (driver.findElement(By.cssSelector("button[id='onetrust-accept-btn-handler']")).isDisplayed()) {
                WebElement webElement = driver.findElement(By.cssSelector("button[id='onetrust-accept-btn-handler']>font>font"));
                Actions actions = new Actions(driver);
                actions.moveToElement(webElement);
                actions.click().perform();
                while (driver.findElement(By.cssSelector("div#onetrust-button-group-parent")).isDisplayed()) {
                }
            }

            click(driver, element);
            element.sendKeys(value);
        }
    }

    public static void scrollUpPage(RemoteWebDriver driver, int timesToScroll) throws InterruptedException {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_UP);
        for (int i = 0; i < timesToScroll; i++) {
            action.perform();
            Thread.sleep(1000);
        }
    }

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
            Thread.sleep(1000);
        }
    }

    public static void WaitForPageLoad(RemoteWebDriver _driver, int timeOutSec) {
        var wait = new WebDriverWait(_driver, timeOutSec);
        wait.until(wd -> ((JavascriptExecutor) _driver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public static void WaitForElementToExistAndVisible(RemoteWebDriver _driver, WebElement element) throws InterruptedException, InvalidApplicationException {
        var ct = 0;
        do {
            ++ct;
            Thread.sleep(1000);
        } while (!element.isDisplayed() && ct < 200);
        if (element.isDisplayed() && !element.isEnabled()) {
            throw new InvalidApplicationException(element + " must be visible and Enable");
        }
    }

    public static WebElement findElementIfExist(RemoteWebDriver _driver,By by){
        var elements=_driver.findElements(by);
        return (elements.size()>=1)?elements.get(1):null;
    }

    public static WebElement findElement(RemoteWebDriver _driver,By by,int timeOutInSec){
        if(timeOutInSec<=0)return _driver.findElement(by);
        var wait = new WebDriverWait(_driver, timeOutInSec);
        return wait.until(drv ->drv.findElement(by));
    }


}
