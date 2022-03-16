package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{


    @Test
    public void loginSuccess(){

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("esimakova1984@gmail.com","Tcbvfrjdf1");
        app.getHelperUser().submitLogin();
        app.getHelperUser().submitOk();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }



}
