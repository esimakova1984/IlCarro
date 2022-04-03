package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//*[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//*[@id='email']"), email);
        type(By.xpath("//*[@id='password']"), password);
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//*[@id='email']"), user.getEmail());
        type(By.xpath("//*[@id='password']"), user.getPassword());
    }



    public void submitOk() {
        if (isElementPresent(By.xpath("//*[text()='Ok']"))) {
            click(By.xpath("//*[text()='Ok']"));
        }
    }

    public boolean isLoginRegistrationSuccess() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//*[text()=' Sign up ']"));
    }

    public void fillRegistrartionForm(String name, String lastname, String email, String password) {
        type(By.id("name"), name);
        type(By.id("lastName"), lastname);
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillRegistrartionForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }


    public String checkMessage() {
        new WebDriverWait(wd, 5)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container h2"))));

        return wd.findElement(By.cssSelector(".dialog-container h2")).getText();
    }

    public boolean isLogoutPresent() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }

    public void checkPolicy() {

        click(By.cssSelector("label[for='terms-of-use']"));
    }

    public void checkPolicyXY() {
        WebElement lebel = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rect = lebel.getRect();
        int offSetX = rect.getWidth() / 2;
        int offSetY = rect.getHeight() / 2;

        Actions actions = new Actions(wd);
        actions.moveToElement(lebel).release().perform();//Селениум нводит курсор на необходимый элеиент(lebel)
        actions.moveByOffset(-offSetX, -offSetY).click().release().perform();//тут селениум наводит курсор от точки которую мы нашли выше уже на установленные нами координтаы и кликает по нему
    }

    public boolean isErrorPaswordDisplayedSize() {
        Boolean firstChild = new WebDriverWait(wd, 5)
                .until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector("div.error div:first-child")), "Password must contain minimum 8 symbols"));
        return firstChild;
    }

    public boolean isErrorPaswordDisplayedFormat() {
        Boolean lastChild = new WebDriverWait(wd, 5)
                .until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector("div.error div:last-child")), "Password must contain 1 uppercase letter, 1 lowercase letter and one number"));

        return lastChild;
     }

    public boolean isYallaButtonActive() {
        return wd.findElement(By.cssSelector("[type='submit']")).isEnabled();
    }

    public boolean isYallaButtonNotClickable() {
        return isElementPresent(By.cssSelector("button[disabled]"));
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submit();
        submitOk();
    }

}

