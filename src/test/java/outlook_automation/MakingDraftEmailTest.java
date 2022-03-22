package outlook_automation;

import factory.OutlookFactory;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static constants.EmailComposeConstants.mail;
import static constants.EmailComposeConstants.subjectText;
import static constants.TextMessages.draftMailText;

public class MakingDraftEmailTest extends BaseTest {

    @Test
    public void draftTest() throws MalformedURLException, InterruptedException {
        outlookFactory = new OutlookFactory(helper.getNewEmailWindowFocus(outlookSession));
        helper.newEmailCompose(mail, subjectText, draftMailText);
        helper.closeNewMailWindowPopUpForDraft();
        outlookFactory = new OutlookFactory(outlookSession);
        outlookFactory.menuDrafts().click();
    }
}
