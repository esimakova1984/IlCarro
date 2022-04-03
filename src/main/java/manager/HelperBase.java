package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text){
        if(text != null) {
            WebElement emailInput = wd.findElement(locator);
            emailInput.click();
            emailInput.clear();
            emailInput.sendKeys(text);
        }
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void pause(int mlsec){
        try {
            Thread.sleep(mlsec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void submit() {
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.elementToBeClickable(wd.findElement(By.cssSelector("[type='submit']"))));
        click(By.cssSelector("[type='submit']"));
    }
}
