package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class GooglePage extends CommonMethods {


    @FindBy(xpath = "//input[@title='Поиск']")
    public WebElement searchField;

    public GooglePage() {
        PageFactory.initElements(driver, this);
    }
}
