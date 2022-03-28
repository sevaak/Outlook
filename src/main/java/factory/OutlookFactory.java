package factory;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constants.EmailComposeConstants.*;
import static constants.LandingPageConstants.*;
import static constants.PluginConstants.*;


public class OutlookFactory {
    private WindowsDriver driver;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public OutlookFactory(WindowsDriver windowsDriver) {
        this.driver = windowsDriver;
    }

    public WebElement activationWindow() {
        return driver.findElementByClassName(activationWindowClassName);
    }

    public WebElement acceptableWindow() {
        return driver.findElementByClassName(acceptableWindowClassName);
    }

    public WebElement acceptButton() {
        return driver.findElementByName(acceptButton);
    }

    public List<WebElement> closeButtons() {
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

    public WebElement mailToEditTextNew() {
        return driver.findElementByAccessibilityId(toMailEditId);
    }

    public WebElement mailSendButton() {
        return driver.findElementByAccessibilityId(sendButtonId);
    }

    public WebElement closeWindow() {
        return driver.findElementByName(windowCloseButtonName);
    }

    public WebElement yesButtonInPopUp() {
        return driver.findElementByName(popUpYesName);
    }

    public WebElement subjectEditText() {
        return driver.findElementByAccessibilityId(subjectEditAccessibilityId);
    }

    public WebElement mailText() {
        return driver.findElementByClassName(mailTextClassName);
    }

    public String titleBar() {
        String title = driver.findElementByClassName("NetUIOfficeCaption").getText();
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(title);
        return matcher.toString();
    }

    public List<WebElement> receivedMails() {
        return driver.findElementsByClassName(receivedMailsClassName);
    }

    public WebElement openedMail() {
        return driver.findElementByAccessibilityId(openedMailId);
    }

    public WebElement replySendButton() {
        return driver.findElementByName(replySendButtonName);
    }

    public WebElement openedMailBody() {
        return driver.findElementByAccessibilityId(openedMailClassName);
    }

    public WebElement replyWindow() {
        return driver.findElementByClassName("_WwG");

    }

    public WebElement replyButton() {
        return driver.findElementByName(replyButtonName);
    }

    public WebElement deleteButton() {
        return driver.findElementByName(deleteButtonName);
    }

    public WebElement closePopUp() {
        return driver.findElementByClassName(closeNewMailPopUpWindow);
    }


    //Zero Plugin
    public WebElement zeroMoveItem() {
        return driver.findElementByName(zeroMoveName);
    }

    public List<WebElement> headerGroups() {
        return driver.findElementsByClassName(headerGroupsClassName);
    }

    public WebElement zeroMoveContext() {
        return driver.findElementByClassName(zeroMoveContextMenuClassName);
    }

    public List<WebElement> zeroMoveSuggestedGroupItems() {
        return driver.findElementsByXPath(zeroMoveContextSuggestedGroupElementsXpath);
    }

    public List<WebElement> zeroMoveRecentGroupItems() {
        return driver.findElementsByXPath(zeroMoveContextRecentGroupElementsXpath);
    }


}
