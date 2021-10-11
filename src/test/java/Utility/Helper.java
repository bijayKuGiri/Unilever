package Utility;

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
        if(_driver.findElement(By.cssSelector("div#onetrust-button-group-parent")).isDisplayed()){
            WebElement webElement=_driver.findElement(By.cssSelector("div#onetrust-button-group-parent"));
            Actions actions = new Actions(_driver);
            actions.moveToElement(webElement);
            actions.click().perform();
            while(_driver.findElement(By.cssSelector("div#onetrust-button-group-parent")).isDisplayed()){}
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

    public static void selectFromDDn(String Value, WebElement element) {
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
            if(driver.findElement(By.cssSelector("div#onetrust-button-group-parent")).isDisplayed()){
                WebElement webElement=driver.findElement(By.cssSelector("div#onetrust-button-group-parent"));
                Actions actions = new Actions(driver);
                actions.moveToElement(webElement);
                actions.click().perform();
                while(driver.findElement(By.cssSelector("div#onetrust-button-group-parent")).isDisplayed()){}
            }
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
            Actions action = new Actions(driver);
            action.moveToElement(element).click().perform();
        }
    }

    public static void handleCookie(RemoteWebDriver driver){
        if(driver.findElements(By.xpath("//div[@id='onetrust-banner-sdk']")).size()>0)
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).submit();
    }
    public static void EnterText(RemoteWebDriver driver, WebElement element,String value) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(value);
        } catch (ElementClickInterceptedException ex) {
            if(driver.findElement(By.cssSelector("button[id='onetrust-accept-btn-handler']")).isDisplayed()){
                WebElement webElement=driver.findElement(By.cssSelector("button[id='onetrust-accept-btn-handler']>font>font"));
                Actions actions = new Actions(driver);
                actions.moveToElement(webElement);
                actions.click().perform();
                while(driver.findElement(By.cssSelector("div#onetrust-button-group-parent")).isDisplayed()){}
            }

            click(driver,element);
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


}
