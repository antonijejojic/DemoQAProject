package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SideBar extends BaseTest {


    public SideBar() {
        PageFactory.initElements(driver, this);
    }

    // List of all sidebar menu items
    @FindBy(css = "li[id^='item']")
    public List<WebElement> sideBarItemsList;

    //--------------------------------------------

    // This method scrolls to a sidebar item and clicks it by its visible text
    public void clickOnSideBarItem(String sideBarItemName) {
        for (int i = 0; i < this.sideBarItemsList.size(); ++i) {
            if (sideBarItemsList.get(i).getText().equals(sideBarItemName)) {
                scrollToElement(sideBarItemsList.get(i));
                sideBarItemsList.get(i).click();
                break;
            }
        }
    }

}
