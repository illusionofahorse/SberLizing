package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {
    protected static WebDriver driver;

    public static void openBrowser(){
    ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static byte[] takeScreenshot(String filename) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte[] picBytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(
                    Constants.SCREENSHOT_FILEPATH + filename + " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void clickRadioOrCheckbox(List<WebElement> radioOrcheckbox, String value) {

        String actualValue;

        for (WebElement el : radioOrcheckbox) {
            actualValue = el.getText().trim();
            if (!el.isSelected() && el.isEnabled() && actualValue.equals(value)) {
                click(el);
                break;
            }
        }
    }

    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void scrollToElement(List<WebElement> elements){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elements.get(0));
    }

    public static String getElementTextFromList(List<WebElement> elements, int index){
        return elements.get(index).getText();
    }

    public static String getCity(){
        ConfigReader.readProperties(Constants.TESTDATA_FILEPATH);
        return ConfigReader.getPropertyValue("City");
    }

    public static String getBrand(){
        ConfigReader.readProperties(Constants.TESTDATA_FILEPATH);
        return ConfigReader.getPropertyValue("Brand");
    }

    public static String getModel(){
        ConfigReader.readProperties(Constants.TESTDATA_FILEPATH);
        return ConfigReader.getPropertyValue("Model");
    }

    public static String getCarWheelDriveType(){
        ConfigReader.readProperties(Constants.TESTDATA_FILEPATH);
        return ConfigReader.getPropertyValue("CarWheelDriveType");
    }

    public static String getCarTransmissionType(){
        ConfigReader.readProperties(Constants.TESTDATA_FILEPATH);
        return ConfigReader.getPropertyValue("CarTransmissionType");
    }

    public static String getCarBodyType(){
        ConfigReader.readProperties(Constants.TESTDATA_FILEPATH);
        return ConfigReader.getPropertyValue("CarBodyType");
    }

    public static String getCarFuelType(){
        ConfigReader.readProperties(Constants.TESTDATA_FILEPATH);
        return ConfigReader.getPropertyValue("CarFuelType");
    }

    public static String getCarColorType(){
        ConfigReader.readProperties(Constants.TESTDATA_FILEPATH);
        return ConfigReader.getPropertyValue("CarColorType");
    }

    public static String getSberLizingUrl(){
        return ConfigReader.getPropertyValue("SberLizingUrl");
    }

    public static String getsearchWebsite(){
        return ConfigReader.getPropertyValue("searchWebsite");
    }

    public static void setHValue(WebElement slider, WebElement sliderMinBtn, WebElement sliderMaxBtn,double value1, double value2) {
        double minValue = Double.parseDouble(slider.getAttribute("aria-valuemin"));
        double maxValue = Double.parseDouble(slider.getAttribute("aria-valuemax"));
        int sliderW = slider.getSize().getWidth();
        Actions action = new Actions(driver);
        action.dragAndDropBy(sliderMinBtn, (int) ((value1-minValue) * sliderW / (maxValue - minValue)),0).build().perform();
        action.dragAndDropBy(sliderMaxBtn, (int) -((maxValue-value2) * sliderW / (maxValue - minValue)),0).build().perform();

    }

}
