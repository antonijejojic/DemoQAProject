package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.RadioButtonPage;
import Pages.SideBar;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    String cardName = "Elements";
    String sideBarItem = "Radio Button";
    String radioButtonExpectedURL = "https://demoqa.com/radio-button";

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
        radioButtonPage = new RadioButtonPage();
        scrollToElement(homePage.getCard(cardName));
        homePage.selectCard(cardName);
        sideBar.clickOnSideBarItem(sideBarItem);
    }

    @Test
    public void userCanClickOnYesRadioButton() {
        radioButtonPage.clickOnYesRadioButton();
        Assert.assertEquals(radioButtonPage.yesRadioButton.getText(), radioButtonPage.getSuccessMessage());
        Assert.assertEquals(driver.getCurrentUrl(), radioButtonExpectedURL);
    }

    @Test
    public void userCanClickOnImpressiveRadioButton() {
        radioButtonPage.clickOnImpressiveRadioButton();
        // Verify that no success message appears.
        Assert.assertEquals(radioButtonPage.impressiveRadioButton.getText(), radioButtonPage.getSuccessMessage());
        Assert.assertEquals(driver.getCurrentUrl(), radioButtonExpectedURL);
    }

    @Test
    public void userCannotClickOnNoRadioButton() {
        radioButtonPage.clickOnNoRadioButton();
        Assert.assertTrue(radioButtonPage.successMessageList.isEmpty());
        Assert.assertEquals(driver.getCurrentUrl(), radioButtonExpectedURL);

    }

    @Test
    public void userCannotSelectMultipleButtons() {
        radioButtonPage.clickOnYesRadioButton();
        radioButtonPage.clickOnImpressiveRadioButton();
        radioButtonPage.clickOnNoRadioButton();
        Assert.assertEquals(radioButtonPage.impressiveRadioButton.getText(), radioButtonPage.getSuccessMessage());
        Assert.assertEquals(radioButtonPage.successMessageList.size(), 1);
    }

    @AfterMethod
    public void clearData() {
        driver.manage().deleteAllCookies();
    }


}
