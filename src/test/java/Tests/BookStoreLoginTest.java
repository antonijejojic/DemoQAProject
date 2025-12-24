package Tests;

import Base.BaseTest;
import Pages.BookStoreLoginPage;
import Pages.HomePage;
import Pages.SideBar;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookStoreLoginTest extends BaseTest {

    // Variables
    String cardName = "Book Store Application";
    String sideBarItem = "Login";
    String bookStoreLoginExpectedURL = "https://demoqa.com/login";

    String validUsername = "JSmith";
    String validPassword = "123Abc#4";
    String inValidUsername = "username";
    String inValidPassword = "password";

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        bookStoreLoginPage = new BookStoreLoginPage();
        homePage = new HomePage();
        sideBar = new SideBar();

        scrollToElement(homePage.getCard(cardName));
        homePage.getCard(cardName).click();
        sideBar.clickOnSideBarItem(sideBarItem);
    }





    @Test
    public void userCanLogin() {


        Assert.assertEquals(driver.getCurrentUrl(), bookStoreLoginExpectedURL);
        // Enter valid username and password
        bookStoreLoginPage.inputUsername(validUsername);
        bookStoreLoginPage.inputPassword(validPassword);
        bookStoreLoginPage.clickOnLoginButton();

        Assert.assertTrue(bookStoreLoginPage.logoutButton.isDisplayed());
        // Verify the logged-in username matches the valid username
        Assert.assertEquals(bookStoreLoginPage.loggedUserName.getText(), validUsername);

    }

    @Test
    public void userCanNotLoginWithInValidUsername(){

        Assert.assertEquals(driver.getCurrentUrl(), bookStoreLoginExpectedURL);
        // Enter invalid username but valid password
        bookStoreLoginPage.inputUsername(inValidUsername);
        bookStoreLoginPage.inputPassword(validPassword);
        bookStoreLoginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), bookStoreLoginExpectedURL);
        // Verify error message is displayed and correct
        Assert.assertTrue(bookStoreLoginPage.errorMessage.isDisplayed());
        Assert.assertEquals(bookStoreLoginPage.errorMessage.getText(), "Invalid username or password!");


    }

    @Test
    public void userCanNotLoginWithInValidPassword(){

        Assert.assertEquals(driver.getCurrentUrl(), bookStoreLoginExpectedURL);
        // Enter invalid username and invalid password
        bookStoreLoginPage.inputUsername(validUsername);
        bookStoreLoginPage.inputPassword(inValidPassword);
        bookStoreLoginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), bookStoreLoginExpectedURL);
        Assert.assertTrue(bookStoreLoginPage.errorMessage.isDisplayed());

    }

    @Test
    public void userCanNotLoginWithInValidCredentials(){

        Assert.assertEquals(driver.getCurrentUrl(), bookStoreLoginExpectedURL);
        // Enter valid username but invalid password
        bookStoreLoginPage.inputUsername(inValidUsername);
        bookStoreLoginPage.inputPassword(inValidPassword);
        bookStoreLoginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), bookStoreLoginExpectedURL);
        Assert.assertTrue(bookStoreLoginPage.errorMessage.isDisplayed());
        Assert.assertEquals(bookStoreLoginPage.errorMessage.getText(), "Invalid username or password!");

    }


    @AfterMethod
    public void clearData() {
        driver.manage().deleteAllCookies();
    }





}