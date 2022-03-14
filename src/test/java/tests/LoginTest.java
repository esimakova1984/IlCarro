package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{


    @Test
    public void loginSuccess(){
        click(By.xpath("//*[@href='/login?url=%2Fsearch']"));
        type(By.xpath("//*[@id='email']"), "esimakova1984@gmail.com");
        type(By.xpath("//*[@id='password']"), "Tcbvfrjdf1");
        click(By.xpath("//*[text()='Y’alla!']"));
        isElementPresent(By.xpath("//*[href='/logout?url=%2Fsearch']"));
    }



}
