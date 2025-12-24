package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PracticeFormPage extends BaseTest {

    public PracticeFormPage() {
        PageFactory.initElements(driver,this);
    }




    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(css = ".custom-control.custom-radio.custom-control-inline")
    public List<WebElement> radioButtons;

    @FindBy(id = "userNumber")
    public WebElement numberField;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateField;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthDropdown;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearDropdown;

    @FindBy(className = "react-datepicker__day")
    public List<WebElement> dayOptions;

    @FindBy(id = "currentAddress")
    public WebElement addressField;

    @FindBy(id = "subjectsInput")
    public WebElement subjectField;

    @FindBy(css = ".subjects-auto-complete__option")
    public List<WebElement> subjects;

    @FindBy(css = "label.custom-control-label")
    public List<WebElement> hobbies;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement modalTitle;

    //----------------------------------

    public void enterFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void selectGender(String gender) {
        for (WebElement radio : radioButtons) {
            if (radio.getText().equalsIgnoreCase(gender)) {
                radio.click();
                break;
            }
        }
    }

    public void enterMobileNumber(String number) {
        numberField.clear();
        numberField.sendKeys(number);
    }

    public void setDateOfBirth(String month, String year, String day) {
        dateField.click();

        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText(month);

        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText(year);

        for (WebElement d : dayOptions) {
            if (d.getText().equals(day)) {
                d.click();
                break;
            }
        }
    }

    public void enterSubject(String subject) {
        subjectField.sendKeys(subject);
        subjectField.sendKeys(Keys.ENTER);
    }

    public void selectHobby(String hobby) {
        for (WebElement h : hobbies) {
            if (h.getText().equalsIgnoreCase(hobby)) {
                h.click();
                break;
            }
        }
    }

    public void enterAddress(String address) {
        addressField.sendKeys(address);
    }

    public void clickSubmit() {
        submitButton.click();
    }














}
