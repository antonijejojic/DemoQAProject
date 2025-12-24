package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStoreLoginPage extends BaseTest {

    public BookStoreLoginPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userName")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "lastname")
    public WebElement lastnameField;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(id = "submit")
    public WebElement logoutButton;

    @FindBy(id = "userName-value")
    public WebElement loggedUserName;

    @FindBy(id = "name")
    public WebElement errorMessage;

    //----------------------------------

    public void inputUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

}
