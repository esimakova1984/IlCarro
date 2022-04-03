package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogoutPresent()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess(){

        int index = (int) (System.currentTimeMillis()/1000)%36000;
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrartionForm("Ekaterin","Simakva", "esimakova"+index+"@gmail.com","Tcbvfrjdf1");
        //app.getHelperUser().checkPolicy();
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        app.getHelperUser().pause(1000);
        Assert.assertEquals(app.getHelperUser().checkMessage(),"You are logged in success");

    }

    @Test
    public void registrationSuccessModel(){

        int index = (int) (System.currentTimeMillis()/1000) % 36000;//сначала нужно указать индекс

        User user = new User()
                .withName("Ekaterin")
                .withLastName("Simakva")
                .withEmail("esimakova"+index+"@gmail.com")
                .withPassword("Tcbvfrjdf1");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrartionForm(user);
        //app.getHelperUser().checkPolicy();
        app.getHelperUser().checkPolicyXY();//этот метод для  экранф расширеного на максимуме
        app.getHelperUser().submit();
        //app.getHelperUser().pause(1000);
        Assert.assertEquals(app.getHelperUser().checkMessage(),"You are logged in success");

    }

    @Test
    public void registrationWrongPasswordModel(){
        User user = new User()
                .withName("Ekterin")
                .withLastName("Siakva")
                .withEmail("esikova@gmail.com")
                .withPassword("cbvfrjd");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrartionForm(user);
        app.getHelperUser().checkPolicyXY();//этот метод для  экранф расширеного на максимуме
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isErrorPaswordDisplayedSize());
        Assert.assertTrue(app.getHelperUser().isErrorPaswordDisplayedFormat());
        Assert.assertFalse(app.getHelperUser().isYallaButtonActive());
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotClickable());

    }

    @Test
    public void registrationSuccessNew(){

        int index = (int) (System.currentTimeMillis()/1000)%36000;
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrartionForm("Ekaterina","Simakva", "esimakova"+index+"@gmail.com","Tcbvfrjdf1");
        //app.getHelperUser().checkPolicy();
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        app.getHelperUser().pause(1000);
        Assert.assertEquals(app.getHelperUser().checkMessage(),"You are logged in success");
    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().submitOk();
    }
}
