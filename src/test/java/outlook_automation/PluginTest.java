package outlook_automation;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PluginTest extends BaseTest {

    @Test
    public void move2Folder() {
        Assert.assertTrue(outlookFactory.headerGroups().get(2).isDisplayed());
        Actions move = new Actions(outlookSession);
        move.contextClick(selectMail(0)).build().perform();
        Assert.assertTrue(outlookFactory.zeroMoveItem().isEnabled());
        move.click(outlookFactory.zeroMoveItem()).build().perform();
        Assert.assertTrue(outlookFactory.zeroMoveContext().isDisplayed());
        outlookFactory.zeroMoveSuggestedGroupItems().get(1).click();
//        outlookFactory.zeroMoveRecentGroupItems().get(0).click();

    }

}
