package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage extends BaseTest {

    public RadioButtonPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "label[for='yesRadio']")
    public WebElement yesRadioButton;

    @FindBy(css = "label[for='impressiveRadio']")
    public WebElement impressiveRadioButton;

    @FindBy(css = "label[for='noRadio']")
    public WebElement noRadioButton;

    @FindBy(className = "text-success")
    public List<WebElement> successMessageList;

    //--------------------------------------------

    public void clickOnYesRadioButton() {
        scrollToElement(yesRadioButton);
        yesRadioButton.click();
    }

    public void clickOnImpressiveRadioButton() {
        scrollToElement(impressiveRadioButton);
        impressiveRadioButton.click();
    }

    public void clickOnNoRadioButton() {
        scrollToElement(noRadioButton);
        noRadioButton.click();
    }

    public String getSuccessMessage() {
        return successMessageList.get(0).getText();
    }



}
