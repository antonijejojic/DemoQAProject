package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BaseTest {

    public WebTablesPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement getAddButton;

    @FindBy(id = "firstName")
    public WebElement getFirstNameField;

    @FindBy(id = "lastName")
    public WebElement getLastNameField;

    @FindBy(id = "userEmail")
    public WebElement getEmailField;

    @FindBy(id = "age")
    public WebElement getAgeField;

    @FindBy(id = "salary")
    public WebElement getSalaryField;

    @FindBy(id = "department")
    public WebElement getDepartmentField;

    @FindBy(id = "submit")
    public WebElement getSubmitButton;

    @FindBy(css = "span[id^='delete-record']")
    public List<WebElement> deleteButtons;

    @FindBy(className = "rt-tr-group")
    public List<WebElement> rowContent;

    @FindBy(className = "rt-td")
    public List<WebElement> cell;

    //----------------------------------


    public void clickOnAddButton() {
        getAddButton.click();
    }

    public void inputFirstName(String firstName) {
        getFirstNameField.clear();
        getFirstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        getLastNameField.clear();
        getLastNameField.sendKeys(lastName);
    }

    public void inputEmail(String email) {
        getEmailField.sendKeys(email);
    }

    public void inputAge(String age) {
        getAgeField.clear();
        getAgeField.sendKeys(age);
    }

    public void inputSalary(String salary) {
        getSalaryField.clear();
        getSalaryField.sendKeys(salary);
    }

    public void inputDepartment(String department) {
        getDepartmentField.clear();
        getDepartmentField.sendKeys(department);
    }

    public void clickOnSubmitButton() {
        getSubmitButton.click();
    }

    public void clickOnDeleteButton() {
        deleteButtons.get(0).click();
    }
















}
