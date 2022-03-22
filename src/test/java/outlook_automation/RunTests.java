package outlook_automation;

import factory.OutlookFactory;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static constants.EmailComposeConstants.subjectText;
import static constants.TextMessages.sendMailText;
import static constants.TextMessages.sendTo;

public class RunTests extends BaseTest {

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
    public void newEmailTest() throws MalformedURLException, InterruptedException {
        outlookFactory = new OutlookFactory(helper.getNewEmailWindowFocus(outlookSession));
        helper.newEmailCompose(sendTo, subjectText, sendMailText);
        outlookFactory.mailSendButton().click();
    }


}
