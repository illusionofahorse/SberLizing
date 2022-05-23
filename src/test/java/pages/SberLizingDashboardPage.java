package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class SberLizingDashboardPage extends CommonMethods {
    public SberLizingDashboardPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(linkText = "Подобрать по параметрам")
    public WebElement pickByParamBtn;

}
