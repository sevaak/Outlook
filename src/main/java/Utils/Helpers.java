package Utils;

import factory.OutlookFactory;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static constants.LandingPageConstants.appTopLevelCap;
import static constants.LandingPageConstants.localHost;

public class Helpers {
    private WindowsDriver firstSessionDriver;
    private OutlookFactory outlookFactory;

    public Helpers(WindowsDriver oldDriver) {
        this.firstSessionDriver = oldDriver;

    }

    public void newEmailCompose(String recipient, String subject, String mailText) {
        outlookFactory.mailToEditText().sendKeys(recipient);
        outlookFactory.subjectEditText().sendKeys(subject);
        outlookFactory.mailText().click();
        outlookFactory.mailText().sendKeys(mailText);

    }


    public WindowsDriver getNewEmailWindowFocus(WindowsDriver oldDriver) throws InterruptedException, MalformedURLException {
        outlookFactory = new OutlookFactory(oldDriver);
        outlookFactory.menuInbox().click();
        outlookFactory.emailComposeButton().click();
        Thread.sleep(1000);
        List<String> mailWindowHandles = oldDriver.getWindowHandles().stream().toList();
        String handleElement = mailWindowHandles.get(0);
        DesiredCapabilities newEmailCaps = new DesiredCapabilities();
        newEmailCaps.setCapability(appTopLevelCap, handleElement);
        WindowsDriver newDriver = new WindowsDriver<WindowsElement>(new URL(localHost), newEmailCaps);
        outlookFactory = new OutlookFactory(newDriver);
        return newDriver;
    }


    public WindowsDriver getMainSession(WindowsDriver oldDriver) {
        List<String> mailWindowHandles = oldDriver.getWindowHandles().stream().toList();
        System.out.println(mailWindowHandles.size());
        for (int i = 0; i < mailWindowHandles.size(); i++) {
            System.out.println(mailWindowHandles.get(i));
        }
        return oldDriver;
    }

    public void closeNewMailWindowPopUpForDraft() {
        outlookFactory.closeWindow().click();
        if (outlookFactory.closePopUp().isDisplayed()) {
            outlookFactory.closePopUp().click();
            outlookFactory.yesButtonInPopUp().click();
        }
    }
}
