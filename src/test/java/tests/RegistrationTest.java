package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @Test
    public void registrationSuccess(){
        click(By.xpath("//*[@href='/login?url=%2Fsearch']"));
        click(By.xpath("//*[text()='Click here']"));
        type(By.xpath("//*[@id='name']"), "Ekaterina");
        type(By.xpath("//*[@id='lastName']"), "Simakova");
        type(By.xpath("//*[@id='email']"), "esimakova1984@gmail.com");
        type(By.xpath("//*[@id='password']"), "Tcbvfrjdf1");
        click(By.xpath("//*[@id='terms-of-use']"));
        click(By.xpath("//*[text()='Y’alla!']"));
        isElementPresent(By.xpath("//*[href='/logout?url=%2Fsearch']"));
    }
}
