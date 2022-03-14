package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/olegnarushevich/QA_32_automation/lessons/Phonebook/chromedriver");
        wd.manage().window();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/");
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        if(text != null) {
            WebElement emailInput = wd.findElement(locator);
            emailInput.click();
            emailInput.clear();
            emailInput.sendKeys(text);
        }
    }
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }
}
