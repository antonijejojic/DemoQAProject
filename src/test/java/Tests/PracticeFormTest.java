package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.PracticeFormPage;
import Pages.SideBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeFormTest extends BaseTest {

    String cardName = "Forms";
    String sideBarItem = "Practice Form";
    String practiceFormExpectedURL = "https://demoqa.com/automation-practice-form";

    String firstName = "Marko";
    String lastName = "Markovic";
    String email = "marko@test.com";
    String gender = "Male";
    String mobileNumber = "0612345678";
    String birthMonth = "May";
    String birthYear = "2000";
    String birthDay = "15";
    String subject = "Maths";
    String hobby = "Sports";
    String address = "Bulevar Kralja Aleksandra";




    @BeforeMethod
    // This method sets up the test environment before each test method:
    // 1. Initializes the ChromeDriver instance.
    // 2. Sets implicit wait to allow elements to load dynamically.
    // 3. Navigates to the demo QA home page.
    // 4. Initializes the required page objects for the test.
    // 5. Scrolls to the specified card on the home page and clicks it.
    // 6. Clicks on the specified sidebar menu item to navigate to the desired page.
    // This setup ensures that every test starts from the correct page with all necessary elements ready.

    public void pageSetUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      //  driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        this.homePage = new HomePage();
        this.sideBar = new SideBar();
        this.practiceFormPage = new PracticeFormPage();

        scrollToElement(homePage.getCard(cardName));
        homePage.getCard(cardName).click();
        sideBar.clickOnSideBarItem(sideBarItem);
    }

    @Test
    public void userCanSubmitPracticeForm() {

        Assert.assertEquals(driver.getCurrentUrl(), practiceFormExpectedURL);

        practiceFormPage.enterFirstName(firstName);
        practiceFormPage.enterLastName(lastName);
        practiceFormPage.enterEmail(email);
        practiceFormPage.selectGender(gender);
        practiceFormPage.enterMobileNumber(mobileNumber);
        practiceFormPage.setDateOfBirth(birthMonth, birthYear, birthDay);
        practiceFormPage.enterSubject(subject);
        practiceFormPage.selectHobby(hobby);
        practiceFormPage.enterAddress(address);

        scrollToElement(practiceFormPage.submitButton);
        practiceFormPage.clickSubmit();

        // Wait for the confirmation modal to appear.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(practiceFormPage.modalTitle));

        Assert.assertTrue(practiceFormPage.modalTitle.isDisplayed());
        Assert.assertEquals(practiceFormPage.modalTitle.getText(), "Thanks for submitting the form" );

        WebElement table = driver.findElement(By.className("table-responsive"));
        Assert.assertTrue(table.getText().contains("Marko Markovic"));
        Assert.assertTrue(table.getText().contains("marko@test.com"));
        Assert.assertTrue(table.getText().contains("Male"));


    }




    @AfterMethod
    public void clearData() {
        driver.manage().deleteAllCookies();
    }




}
