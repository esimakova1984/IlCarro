package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{


    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogoutPresent()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void loginSuccess(){

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("esimakova1984@gmail.com","Tcbvfrjdf1");
        app.getHelperUser().submit();
        app.getHelperUser().pause(1000);
        Assert.assertEquals(app.getHelperUser().checkMessage(),"Logged in success");
    }

    @Test
    public void loginSuccessModel(){

        User user = new User().withEmail("esimakova1984@gmail.com").withPassword("Tcbvfrjdf1");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        app.getHelperUser().pause(1000);
        Assert.assertEquals(app.getHelperUser().checkMessage(),"Logged in success");
    }

    @Test
    public void loginSuccessNew(){

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("esimakova1984@gmail.com","Tcbvfrjdf1");
        app.getHelperUser().submit();
        app.getHelperUser().pause(1000);
        Assert.assertEquals(app.getHelperUser().checkMessage(),"Logged in success");

    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().submitOk();
    }


}
