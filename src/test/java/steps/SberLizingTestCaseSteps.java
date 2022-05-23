package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import utils.CommonMethods;
import utils.Constants;


public class SberLizingTestCaseSteps extends CommonMethods {

    public String carItemText;

    @Given("user navigates to search website")
    public void user_navigates_to_search_website() {
        driver.get(getsearchWebsite());
    }

    @When("user typed {string} in the search field")
    public void user_typed_in_the_search_field(String string){

        click(google.searchField);
        sendText(google.searchField, string);
        google.searchField.sendKeys(Keys.ENTER);
    }

    @Then("user navigated to {string} website")
    public void user_navigated_to_website(String string) {
        WebElement firstLink = driver.findElement(By.xpath("(//h3[contains(text(),'"+string+"')]/parent::a)[1]"));
        click(firstLink);
        Assert.assertEquals(Constants.WRONG_PAGE_ERROR_MESSAGE, driver.getCurrentUrl(),getSberLizingUrl());

    }

    @Given("user picked up the car by parameters")
    public void user_picked_up_the_car_by_parameters() throws InterruptedException {
        click(sberLizingDashboard.pickByParamBtn);
        click(carmarcetplace.cityField);
        clickRadioOrCheckbox(carmarcetplace.cityCheckBox, getCity());
        Thread.sleep(2000);
        click(carmarcetplace.brandField);
        clickRadioOrCheckbox(carmarcetplace.brandCheckBox, getBrand());
        Thread.sleep(2000);
        click(carmarcetplace.modelField);
        clickRadioOrCheckbox(carmarcetplace.modelCheckBox, getModel());

        if(carmarcetplace.discountCheckBox.isEnabled()) {
            click(carmarcetplace.discountCheckBox);
        }
        Thread.sleep(2000);
        setHValue(carmarcetplace.enginePowerSlider,carmarcetplace.enginePowerSliderMin,
                carmarcetplace.enginePowerSliderMax,200, 239);
        Thread.sleep(2000);
        clickRadioOrCheckbox(carmarcetplace.carWheelDriveType, getCarWheelDriveType());
        clickRadioOrCheckbox(carmarcetplace.carTransmissionType, getCarTransmissionType());
        clickRadioOrCheckbox(carmarcetplace.carBodyType, getCarBodyType());
        scrollToElement(carmarcetplace.carTransmissionType);
        clickRadioOrCheckbox(carmarcetplace.carFuelType, getCarFuelType());
        click(carmarcetplace.carColorField);
        Thread.sleep(2000);
        clickRadioOrCheckbox(carmarcetplace.carColorType, getCarColorType());
    }

    @When("user pressed show all suggestions")
    public void user_pressed_show_all_suggestions() {
        click(carmarcetplace.showAllSuggBtn);
    }

    @When("user chose a car from the list")
    public void user_chose_a_car_from_the_list() {
        carItemText = getElementTextFromList(carmarcetplace.carItemList,0);
        click(carmarcetplace.carItemList.get(0));
    }

    @Then("selected car has the same brand that presented in list")
    public void selected_car_has_the_same_brand_that_presented_in_list() {
        Assert.assertTrue("Car validation passed",carItemText.contains(carmarcetplace.carItem.getText()));

    }
}



