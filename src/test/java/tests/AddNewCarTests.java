package tests;

import lombok.SneakyThrows;
import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogoutPresent()){
            app.getHelperUser().login(new User().withEmail("esimakova1984@gmail.com").withPassword("Tcbvfrjdf1"));
        }

    }
    @SneakyThrows
    @Test
    public void addNewCarSuccess(){
        int index = (int) (System.currentTimeMillis()/1000)%36000;

        Car car = Car.builder()// create new object in LOMBOK without "new"
                .address("Tel Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2022")
                .engine("2.5")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .carClass("C")
                .fuelConsumption("6.5")
                .carRegistrationNumber("100-22-"+index)
                .price("65")
                .distanceIncluded("500")
                .features("Type of features")
                .about("Very good car")
                .build();

        app.carHelper().openCarForm();
        app.carHelper().fillCarForm(car);
        app.carHelper().attachPhoto("/Users/olegnarushevich/QA_32_automation/lessons/IlCarro/Screen Shot 2022-03-29 at 18.35.10.png");
        app.carHelper().submit();//the button is in parent class HelperBase, because this button is used in many classes
        Assert.assertTrue(app.carHelper().isCarAdded());

    }
}
