package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SideBar;
import Pages.TextBoxPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    String cardName = "Elements";
    String sideBarItem = "Text Box";
    String textBoxExpectedURL = "https://demoqa.com/text-box";

    String userName = "Petar Petrovic";
    String userEmail = "petar@petrovic.com";
    String userCurrentAddress = "Petra Petrovica 1";
    String userPermanentAddress = "Petrovica Petra 2";
    String invalidUserEmail = "petar petrovic";

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
        textBoxPage = new TextBoxPage();
        scrollToElement(homePage.getCard(cardName));
        homePage.getCard(cardName).click();
        sideBar.clickOnSideBarItem(sideBarItem);
    }


    @Test
    public void userCanSubmitData() throws InterruptedException {
        Assert.assertEquals(driver.getCurrentUrl(), textBoxExpectedURL);

        textBoxPage.inputUserName(userName);
        textBoxPage.inputUserEmail(userEmail);
        textBoxPage.inputUserCurrentAddress(userCurrentAddress);
        textBoxPage.inputUserPermanentAddress(userPermanentAddress);
        scrollToElement(textBoxPage.submitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertTrue(textBoxPage.outputPlaceHolder.isDisplayed());
        Assert.assertTrue(textBoxPage.userNameOutput.getText().contains(userName));
        Assert.assertTrue(textBoxPage.userEmailOutput.getText().contains(userEmail));
        Assert.assertTrue(textBoxPage.userCurrentAddressOutput.getText().contains(userCurrentAddress));
        Assert.assertTrue(textBoxPage.userPermanentAddressOutput.getText().contains(userPermanentAddress));

    }

    @Test
    public void userCannotSubmitDataWithInvalidEmail() {
        textBoxPage.inputUserName(userName);
        textBoxPage.inputUserEmail(invalidUserEmail);
        textBoxPage.inputUserCurrentAddress(userCurrentAddress);
        textBoxPage.inputUserPermanentAddress(userPermanentAddress);
        scrollToElement(textBoxPage.submitButton);
        textBoxPage.clickOnSubmitButton();

        // Verify that an email input error is displayed.
        Assert.assertTrue(textBoxPage.userEmailInputError.isDisplayed());
        // Verify that the output placeholder is not displayed.
        Assert.assertFalse(textBoxPage.outputPlaceHolder.isDisplayed());


    }

    @Test
    public void userCanSubmitDataWithoutName() throws InterruptedException {
        textBoxPage.inputUserEmail(userEmail);
        textBoxPage.inputUserCurrentAddress(userCurrentAddress);
        textBoxPage.inputUserPermanentAddress(userPermanentAddress);
        scrollToElement(textBoxPage.submitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertTrue(this.textBoxPage.userEmailOutput.getText().contains(this.userEmail));
        Assert.assertTrue(this.textBoxPage.userCurrentAddressOutput.getText().contains(this.userCurrentAddress));
        Assert.assertTrue(this.textBoxPage.userPermanentAddressOutput.getText().contains(this.userPermanentAddress));
    }


    @Test
    public void userCanSubmitDataWithoutCurrentAddress() throws InterruptedException {
        textBoxPage.inputUserName(userName);
        textBoxPage.inputUserEmail(userEmail);
        textBoxPage.inputUserPermanentAddress(userPermanentAddress);
        scrollToElement(textBoxPage.submitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertTrue(this.textBoxPage.userNameOutput.getText().contains(this.userName));
        Assert.assertTrue(this.textBoxPage.userEmailOutput.getText().contains(this.userEmail));
        Assert.assertTrue(this.textBoxPage.userPermanentAddressOutput.getText().contains(this.userPermanentAddress));
    }

    @Test
    public void userCanSubmitDataWithoutPermanentAddress() throws InterruptedException {
        textBoxPage.inputUserName(userName);
        textBoxPage.inputUserEmail(userEmail);
        textBoxPage.inputUserCurrentAddress(userCurrentAddress);
        scrollToElement(textBoxPage.submitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertTrue(this.textBoxPage.userNameOutput.getText().contains(this.userName));
        Assert.assertTrue(this.textBoxPage.userEmailOutput.getText().contains(this.userEmail));
        Assert.assertTrue(this.textBoxPage.userCurrentAddressOutput.getText().contains(this.userCurrentAddress));
    }



    @AfterMethod
    public void clearData() {
        driver.manage().deleteAllCookies();
    }

}
