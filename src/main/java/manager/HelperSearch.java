package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMonth(String city, String dateFrom, String dateTo) {
        typeCity(city);
        selectPeriod(dateFrom,dateTo);
        
        

    }
private void selectPeriod(String dateFrom, String dateTo){
    click(By.id("dates"));
    String[] from = dateFrom.split("/");
    for (int i = 0; i < from.length; i++) {
        String el = from[1];
        click(By.xpath("//*[text()=' "+ el +" ']"));
        break;
    }
    String[] to = dateTo.split("/");
    for (int i = 0; i < to.length; i++) {
        String el = to[1];
        click(By.xpath("//*[text()=' "+ el +" ']"));
        break;
    }

}
    private void typeCity(String city) {
        type(By.id("city"),city);
        pause(5000);
        click(By.cssSelector(".pac-item"));

    }


    public boolean isListOfcarsAppeared() {
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".car-container.ng-star-inserted"))));
       return isElementPresent(By.cssSelector(".car-container.ng-star-inserted"));
    }

    public void searchCurrentMonthInPast(String city, String dateFrom, String dateTo) {
        typeCity(city);
        typePeriodInPast(dateFrom, dateTo);
    }

    private void typePeriodInPast(String dateFrom, String dateTo) {
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.id("dates"))));
        wd.findElement(By.id("dates")).sendKeys("2/10/2022 - 4/20/2022");
    }

    public boolean isWarningMessageOnThePage() {
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".error"))));
        return isElementPresent((By.cssSelector(".error")));
    }
}
