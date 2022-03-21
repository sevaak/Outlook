package outlook_automation;

import factory.OutlookFactory;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static constants.EmailComposeConstants.subjectText;
import static constants.LandingPageConstants.appTopLevelCap;
import static constants.LandingPageConstants.localHost;
import static constants.TextMessages.sendMailText;
import static constants.TextMessages.sendTo;

public class RunTests extends BaseTest {
    private WindowsDriver newMailSession;

    @Test(priority = 1)
    public void searchWithSubjectName() {
        outlookFactory.menuInbox().click();
        findMailBySubject();
        System.out.println(outlookFactory.openedMailBody().getText());
        outlookFactory.menuDrafts().click();
        findMailBySubject();
        System.out.println(outlookFactory.openedMailBody().getText());
        outlookFactory.menuDelete().click();
        findMailBySubject();
        System.out.println(outlookFactory.openedMailBody().getText());
    }

    @Test(priority = 2)
    public void replyAndDeleteTest() throws InterruptedException {
        replyMail();
        deleteMail();
    }


    @Test(priority = 3)
    public void newEmail() throws MalformedURLException, InterruptedException {
        outlookFactory.menuInbox().click();
        outlookFactory.emailComposeButton().click();
        Thread.sleep(1000);
        List<String> mailWindowHandles = outlookSession.getWindowHandles().stream().toList();
        String handleElement = mailWindowHandles.get(0);
        DesiredCapabilities newEmailCaps = new DesiredCapabilities();
        newEmailCaps.setCapability(appTopLevelCap, handleElement);
        newMailSession = new WindowsDriver<WindowsElement>(new URL(localHost), newEmailCaps);
        Assert.assertNotNull(newMailSession);
        outlookFactory = new OutlookFactory(newMailSession);
        outlookFactory.mailToEditText().sendKeys(sendTo);
        outlookFactory.subjectEditText().sendKeys(subjectText);
        outlookFactory.mailText().click();
        outlookFactory.mailText().sendKeys(sendMailText);
        outlookFactory.mailSendButton().click();

    }


}
