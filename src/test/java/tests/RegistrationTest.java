package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @Test
    public void registrationSuccess(){

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrartionForm("Ekaterina","Simakova","esimakova1984@gmail.com","Tcbvfrjdf1");
        //click(By.xpath("//*[@id='terms-of-use']"));
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }
}
