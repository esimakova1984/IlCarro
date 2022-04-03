package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperUser helperUser;
    CarHelper car;
    HelperSearch search;

    public void init(){
        wd = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/olegnarushevich/QA_32_automation/lessons/Phonebook/chromedriver");
        wd.manage().window();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/");
        helperUser = new HelperUser(wd);
        car = new CarHelper(wd);
        search = new HelperSearch(wd);

    }

    public void stop(){
        //wd.quit();
    }

    public HelperUser getHelperUser(){
        return helperUser;
    }
    public CarHelper carHelper(){
        return car;
    }

    public HelperSearch getSearch() {
        return search;
    }
}
