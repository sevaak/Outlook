package factory;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static constants.EmailComposeConstants.*;
import static constants.LandingPageConstants.*;

public class OutlookFactory {
    private WindowsDriver driver;

    public OutlookFactory(WindowsDriver windowsDriver) {
        this.driver = windowsDriver;
    }

    public WebElement activationWindow() {
        return driver.findElementByClassName(activationWindowClassName);
    }

    public WebElement acceptableWindow() {
        return driver.findElementByClassName(acceptableWindowClassName);
    }

    public WebElement acceptButton(){
        return driver.findElementByName(acceptButton);
    }

    public List<WebElement>closeButtons(){
        return driver.findElementsByName(windowCloseButton);
    }


    public WebElement menuInbox() {
        return driver.findElementByXPath(inboxXpath);
    }

    public WebElement menuDrafts() {
        return driver.findElementByXPath(draftXpath);
    }

    public WebElement menuDelete() {
        return driver.findElementByXPath(deleteXpath);
    }

    public WebElement contextElement() {
        return driver.findElementByName(contextMenu);
    }

    public WebElement emailComposeButton() {
        return driver.findElementByName(newEmailButton);
    }

    public WebElement mailToEditText() {
        return driver.findElementByAccessibilityId(toMailEditId);
    }

    public WebElement mailSendButton() {
        return driver.findElementByAccessibilityId(sendButtonId);
    }

    public WebElement closeWindow() {
        return driver.findElementByName(windowCloseButtonName);
    }

    public WebElement yesButtonInPopUp() {
        return driver.findElementByName("Yes");
    }

    public WebElement subjectEditText() {
        return driver.findElementByAccessibilityId("4101");
    }

    public WebElement mailText() {
        return driver.findElementByClassName("_WwG");
    }

    public List<WebElement> receivedMails() {
        return driver.findElementsByClassName("LeafRow");
    }

    public WebElement openedMail() {
        return driver.findElementByAccessibilityId(openedMailId);
    }

    public WebElement replySendButton(){
        return driver.findElementByName("Send");
    }
    public WebElement openedMailBody() {
        return driver.findElementByAccessibilityId("Body");
    }

    public WebElement replyWindow(){
        return driver.findElementByClassName("_WwG");

    }

    public WebElement replyButton(){
        return driver.findElementByName("Reply");
    }

    public WebElement deleteButton(){
        return driver.findElementByName("Delete");
    }



}
