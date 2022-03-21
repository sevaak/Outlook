package outlook_automation;


import factory.OutlookFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static constants.EmailComposeConstants.*;
import static constants.TextMessages.draftMailText;

public class MakingDraftEmailTest extends BaseTest {


    @Test
    public void draftTest() throws MalformedURLException, InterruptedException {
        outlookFactory = new OutlookFactory(helper.getNewEmailWindowFocus(outlookSession));
        outlookFactory.mailToEditText().sendKeys(mail);
        outlookFactory.subjectEditText().sendKeys(subjectText);
        outlookFactory.mailText().click();
        outlookFactory.mailText().sendKeys(draftMailText);
        outlookFactory.closeWindow().click();
        outlookFactory.yesButtonInPopUp().click();
        outlookFactory = new OutlookFactory(outlookSession);
        outlookFactory.menuDrafts().click();

    }

    @AfterClass
    public void quit() {
        outlookSession.quit();
    }
}
