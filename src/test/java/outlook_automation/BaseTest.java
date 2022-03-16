package outlook_automation;

import Utils.Helpers;
import factory.OutlookFactory;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static constants.LandingPageConstants.*;
import static constants.Messages.ElementNotFoundMessage;

public class BaseTest {
    protected static WindowsDriver outlookSession;
    protected static OutlookFactory outlookFactory;


    @BeforeClass
    public void setup() {
        DesiredCapabilities outlookCapabilities = new DesiredCapabilities();
        outlookCapabilities.setCapability(appCap, outlookPath);
        outlookCapabilities.setCapability(waitAppCap, 5);
        try {
            outlookSession = new WindowsDriver<WindowsElement>(new URL(hubHost), outlookCapabilities);
            outlookFactory = new OutlookFactory(outlookSession);
            closeActivationWindow();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void clickOnMail(WebElement menuElement) {
        menuElement.click();
        outlookFactory.contextElement().click();
        List<WebElement> mailsList = outlookFactory.receivedMails();
        mailsList.get(0).click();

    }

    public WebElement selectMail(int mailNumber) {
//        outlookFactory.contextElement().click();
        List<WebElement> mailsList = outlookFactory.receivedMails();
        mailsList.get(mailNumber).click();
        return mailsList.get(mailNumber);
    }


    public void replyMail() {
        selectMail(0);
        Actions move = new Actions(outlookSession);
        move.contextClick(selectMail(0))
                .build()
                .perform();
        move.click(outlookFactory.replyButton())
                .build()
                .perform();
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        outlookFactory.replyWindow().click();
        outlookFactory.replyWindow().sendKeys(Keys.ENTER);
        outlookFactory.replyWindow().sendKeys(selectAll);
        outlookFactory.replyWindow().sendKeys(Keys.DELETE);
        outlookFactory.replyWindow().sendKeys("Automated Reply");
        outlookFactory.replySendButton().click();
    }

    public void deleteMail() {
        selectMail(0);
        Actions move = new Actions(outlookSession);
        move.contextClick(selectMail(0))
                .build()
                .perform();
        move.click(outlookFactory.deleteButton())
                .build()
                .perform();
    }

    public void closeActivationWindow() {
        try {
            if (outlookFactory.activationWindow().isDisplayed()) {
                outlookFactory.activationWindow().click();
                outlookFactory.closeButtons().get(1).click();
            }
            if (outlookFactory.acceptableWindow().isDisplayed()) {
                outlookFactory.acceptButton().click();
            }
        } catch (Exception e) {
            System.out.println(ElementNotFoundMessage);
        }
    }

    @AfterClass
    public void tearDown() {
        outlookSession.quit();
    }
}
