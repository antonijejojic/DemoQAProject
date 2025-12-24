package Tests;

import Base.BaseTest;
import Pages.CheckBoxPage;
import Pages.HomePage;
import Pages.SideBar;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {

    String cardName = "Elements";
    String sideBarItem = "Check Box";
    String checkBoxExpectedURL = "https://demoqa.com/checkbox";

    @BeforeMethod
    // This method sets up the test environment before each test method:
    // 1. Initializes the ChromeDriver instance.
    // 2. Sets implicit wait to allow elements to load dynamically.
    // 3. Navigates to the demo QA home page.
    // 4. Initializes the required page objects for the test.
    // 5. Scrolls to the specified card on the home page and clicks it.
    // 6. Clicks on the specified sidebar menu item to navigate to the desired page.
    // This setup ensures that every test starts from the correct page with all necessary elements ready.

    public void pageSetUp() {
        driver = new ChromeDriver();
       // driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        homePage = new HomePage();
        sideBar = new SideBar();
        checkBoxPage = new CheckBoxPage();
        scrollToElement(homePage.getCard(cardName));
        homePage.selectCard(cardName);
        sideBar.clickOnSideBarItem(sideBarItem);
    }

    @Test
    public void userCanExpandTreeStructure() {
        checkBoxPage.clickOnExpandAllButton();
        Assert.assertEquals(checkBoxPage.checkBoxesList.size(), 17);
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxExpectedURL);
    }

    @Test
    public void userCanCollapseTreeStructure() throws InterruptedException {
        checkBoxPage.clickOnExpandAllButton();
        // Verify total number of checkboxes is 17.
        Assert.assertEquals(checkBoxPage.checkBoxesList.size(), 17);
        checkBoxPage.clickOnCollapseAllButton();
        // Verify that only the root checkbox remains visible (total count = 1).
        Assert.assertEquals(checkBoxPage.checkBoxesList.size(), 1);
    }

    @Test
    public void userCanSelectAllCheckBoxesAtOnce() {
        checkBoxPage.clickOnExpandAllButton();
        checkBoxPage.clickOnCheckBox("Home");
        Assert.assertEquals(checkBoxPage.checkBoxesList.size(), 17);
    }

    @Test
    public void userCanSelectAnyCheckbox() throws InterruptedException {
        checkBoxPage.clickOnExpandAllButton();
        Thread.sleep(1000L);
        // Tracks if the clicked checkbox was successfully added to the selected list
        boolean exists = false;

        for (int i = 0; i < checkBoxPage.checkBoxesList.size(); ++i) {
            scrollToElement(checkBoxPage.checkBoxesList.get(i));
            checkBoxPage.clickOnCheckBox(checkBoxPage.checkBoxesList.get(i).getText());
            Thread.sleep(1000L);

            for (int j = 0; j < checkBoxPage.selectedBoxesList.size(); ++j) {
                if (checkBoxPage.checkBoxesList.get(i).getText().equalsIgnoreCase(checkBoxPage.selectedBoxesList.get(j).getText())) {
                    exists = true;
                    break;
                }
                Assert.assertTrue(exists);
            }
        }
    }


    @AfterMethod
    public void clearData() {
        driver.manage().deleteAllCookies();
    }


}
