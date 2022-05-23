package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class CarMarketplacePage extends CommonMethods {
    public CarMarketplacePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[@aria-label='Город']")
    public WebElement cityField;

    @FindBy(xpath = "//label[@aria-label='Город']/following-sibling::div/div/div/label")
    public List<WebElement> cityCheckBox;

    @FindBy(xpath = "//label[@aria-label='Марка']")
    public WebElement brandField;

    @FindBy(xpath = "//label[@aria-label='Марка']/following-sibling::div/div/div/label")
    public List<WebElement> brandCheckBox;

    @FindBy(xpath = "//label[@aria-label='Модель']")
    public WebElement modelField;

    @FindBy(xpath = "//label[@aria-label='Модель']/following-sibling::div/div/div/label")
    public List<WebElement> modelCheckBox;

    @FindBy(xpath = "//label[text() = 'Только авто со скидкой']/preceding-sibling::*")
    public WebElement discountCheckBox;

    //место для слайдера


    @FindBy(xpath = "//*[contains(text() , 'Привод')]/following-sibling::div/div/label")
    public List<WebElement> carWheelDriveType;

    @FindBy(xpath = "//*[contains(text() , 'Коробка передач')]/following-sibling::div/div/label")
    public List<WebElement> carTransmissionType;

    @FindBy(xpath = "//*[contains(text() , 'Тип кузова')]/following-sibling::div/div/label")
    public List<WebElement> carBodyType;

    @FindBy(xpath = "(//div[@role='slider'])[1]")
    public WebElement enginePowerSlider;

    @FindBy(xpath = "((//div[@role='slider'])[1]/div/div[2])[1]")
    public WebElement enginePowerSliderMin;

    @FindBy(xpath = "((//div[@role='slider'])[1]/div/div[3])")
    public WebElement enginePowerSliderMax;

    @FindBy(xpath = "(//div[@role='slider'])[2]")
    public WebElement engineVolumeSlider;

    @FindBy(xpath = "((//div[@role='slider'])[2]/div/div[2])")
    public WebElement engineVolumeSliderMin;

    @FindBy(xpath = "((//div[@role='slider'])[2]/div/div[3])")
    public WebElement engineVolumeSliderMax;

    @FindBy(xpath = "//*[contains(text() , 'Тип топлива')]/following-sibling::div/div/label")
    public List<WebElement> carFuelType;

    @FindBy(xpath = "//span[contains(text() , 'Цвет')]/preceding-sibling::input")
    public WebElement carColorField;

    @FindBy(xpath = "//*[contains(text() , 'Цвет')]/following-sibling::div/div/div/div/label")
    public List<WebElement> carColorType;

    @FindBy(linkText = "Показать все предложения")
    public WebElement showAllSuggBtn;

//********************************************************************************

    @FindBy(xpath = "//div[@class='car-card__item-section']/div/a/div/div")
    public WebElement carItem;

    @FindBy(xpath = "//div[1][@class='car-card__item-section']/div/a/div/div")
    public List<WebElement> carItemList;


}
