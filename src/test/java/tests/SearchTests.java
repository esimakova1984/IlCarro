package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    @Test
    public void searchCurrentMonth(){
        app.getSearch().searchCurrentMonth("Tel Aviv", "4/10/22", "4/20/22");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfcarsAppeared());
    }

    @Test
    public void searchCurrentMonthInPast(){
        app.getSearch().searchCurrentMonthInPast("Tel Aviv","2/10/2022","4/20/2022");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotClickable());
        Assert.assertTrue(app.getSearch().isWarningMessageOnThePage());
    }

}
