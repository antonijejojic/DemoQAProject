package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BaseTest {

    public TextBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement userNameInput;

    @FindBy(id = "userEmail")
    public WebElement userEmailInput;

    @FindBy(id = "currentAddress")
    public WebElement userCurrentAddressInput;

    @FindBy(id = "permanentAddress")
    public WebElement userPermanentAddressInput;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(className = "field-error")
    public WebElement userEmailInputError;

    @FindBy(id = "output")
    public WebElement outputPlaceHolder;

    @FindBy(id = "name")
    public WebElement userNameOutput;

    @FindBy(id = "email")
    public WebElement userEmailOutput;

    @FindBy(css = "p[id = 'currentAddress']")
    public WebElement userCurrentAddressOutput;

    @FindBy(css = "p[id = 'permanentAddress']")
    public WebElement userPermanentAddressOutput;

    //--------------------------------------------

    public void inputUserName(String userName) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
    }

    public void inputUserEmail(String userEmail) {
        userEmailInput.clear();
        userEmailInput.sendKeys(userEmail);
    }

    public void inputUserCurrentAddress(String userCurrentAddress) {
        userCurrentAddressInput.clear();
        userCurrentAddressInput.sendKeys(userCurrentAddress);
    }

    public void inputUserPermanentAddress(String userPermanentAddress) {
        userPermanentAddressInput.clear();
        userPermanentAddressInput.sendKeys(userPermanentAddress);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }
}
