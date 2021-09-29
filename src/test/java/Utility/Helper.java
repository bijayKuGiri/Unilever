package Utility;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

//import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import java.awt.event.ActionEvent;
//import java.beans.PropertyChangeListener;
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
    }

    public static void selectFromDDn(String Value, WebElement element) {
        Select se = new Select(element);
        se.selectByValue(Value);
    }

    public static void click(RemoteWebDriver driver, WebElement element) {
//        try {
//            element.findElement(By.tagName("input")).click();
//        } catch (Exception e) {
//            JavascriptExecutor executor = (JavascriptExecutor) driver;
//            executor.executeScript("arguments[0].click();", element);
//        }
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            element.click();

        } catch (ElementClickInterceptedException ex) {
            if(driver.findElements(By.cssSelector("div#onetrust-button-group-parent")).size()>0)
                driver.findElement(By.cssSelector("div#onetrust-button-group-parent")).click();
            Actions action = new Actions(driver);
            action.moveToElement(element).click().perform();
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
