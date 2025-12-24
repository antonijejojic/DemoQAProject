package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPage extends BaseTest {

    public CheckBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "rct-option-collapse-all")
    public WebElement collapseAllButton;

    @FindBy(css = "button[title='Expand all']")
    public WebElement expandAllButton;

    // Parent element containing all checkboxes
    @FindBy(id = "tree-node")
    public WebElement checkBoxesListParent;

    // List of currently selected checkboxes text (green labels)
    @FindBy(className = "text-success")
    public List<WebElement> successMessageList;

    // Dynamic list of selected checkboxes
    public List<WebElement> selectedBoxesList;

    // List of all checkbox elements
    public List<WebElement> checkBoxesList;

    //--------------------------------------------

    public void clickOnExpandAllButton() {
        this.expandAllButton.click();
        this.checkBoxesList = checkBoxesListParent.findElements(By.cssSelector(".rct-title"));
    }

    public void clickOnCollapseAllButton() {
        collapseAllButton.click();
        checkBoxesList = checkBoxesListParent.findElements(By.cssSelector(".rct-title"));
    }

    public void clickOnCheckBox(String checkBoxTitle) {
        for (int i = 0; i < this.checkBoxesList.size(); ++i) {
            if (checkBoxesList.get(i).getText().equals(checkBoxTitle)) {
                checkBoxesList.get(i).click();
                selectedBoxesList = driver.findElements(By.className("text-success"));
                break;
            }
        }

    }























}
