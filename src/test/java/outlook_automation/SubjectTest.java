package outlook_automation;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static constants.LandingPageConstants.attributeName;
import static constants.LandingPageConstants.attributeSubject;

public class SubjectTest extends BaseTest {


    @Test
    public void reply() {
        replyMail();
        deleteMail();
    }


    @Test
    public void searchWithSubjectName() {
        outlookFactory.menuInbox().click();
        findMailBySubject("it's a mail for Inbox");
        System.out.println(outlookFactory.openedMailBody().getText());
        outlookFactory.menuDrafts().click();
        findMailBySubject("it's a mail for Drafts");
        System.out.println(outlookFactory.openedMailBody().getText());
        outlookFactory.menuDelete().click();
        findMailBySubject("it's a mail for Delete");
        System.out.println(outlookFactory.openedMailBody().getText());
    }


    public void findMailBySubject(String subjectName) {
        List<WebElement> mailsList = outlookFactory.receivedMails();
        for (int i = 0; i < mailsList.size(); i++) {
            if (mailsList.get(i).getAttribute(attributeName).contains(attributeSubject + subjectName)) {
                mailsList.get(i).click();
                outlookFactory.openedMail().click();

            }
        }
    }
}


