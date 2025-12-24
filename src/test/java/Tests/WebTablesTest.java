package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SideBar;
import Pages.WebTablesPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Base.BaseTest.driver;

public class WebTablesTest extends BaseTest {

    String cardName = "Elements";
    String sideBarItem = "Web Tables";
    String webTablesExpectedURL = "https://demoqa.com/webtables";

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
      //  driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        homePage = new HomePage();
        sideBar = new SideBar();
        webTablesPage = new WebTablesPage();
        scrollToElement(homePage.getCard(cardName));
        homePage.selectCard(cardName);
        sideBar.clickOnSideBarItem(sideBarItem);
    }

    public void addRecord(String firstName, String lastName, String email, String salary, String department, String age) {
        webTablesPage.clickOnAddButton();
        webTablesPage.inputFirstName(firstName);
        webTablesPage.inputLastName(lastName);
        webTablesPage.inputAge(age);
        webTablesPage.inputEmail(email);
        webTablesPage.inputSalary(salary);
        webTablesPage.inputDepartment(department);
        webTablesPage.clickOnSubmitButton();
    }

    // Delete all existing records to start with an empty table.
    public void deleteAllRecords() {
        int j = webTablesPage.deleteButtons.size();
        for (int i = 0; i < j; i++) {
            webTablesPage.clickOnDeleteButton();
        }
    }

    @Test
    public void userCanAddRecord() {
        Assert.assertEquals(driver.getCurrentUrl(), webTablesExpectedURL);

        String firstName = "John";
        String lastName = "Smith";
        String email = "jsmith@mail.com";
        String age = "35";
        String salary = "30000";
        String department = "Sales";

        deleteAllRecords();

        addRecord(firstName, lastName, email, salary, department, age);

        Assert.assertTrue(webTablesPage.rowContent.get(0).getText().contains(firstName));
        Assert.assertTrue(webTablesPage.rowContent.get(0).getText().contains(lastName));
        Assert.assertTrue(webTablesPage.rowContent.get(0).getText().contains(age));
        Assert.assertTrue(webTablesPage.rowContent.get(0).getText().contains(email));
        Assert.assertTrue(webTablesPage.rowContent.get(0).getText().contains(salary));
        Assert.assertTrue(webTablesPage.rowContent.get(0).getText().contains(department));
    }

    @Test
    public void userCanAddMultipleRecordsManually() {
        String firstName1 = "Michael";
        String lastName1 = "Scott";
        String email1 = "m.scott@mail.com";
        String age1 = "47";
        String salary1 = "100000";
        String department1 = "Regional manager";
        //-----------
        String firstName2 = "Dwight";
        String lastName2 = "Schrutte";
        String email2 = "beetfarmer@mail.com";
        String age2 = "45";
        String salary2 = "270000";
        String department2 = "Sales";
        //-----------
        String firstName3 = "Kelly";
        String lastName3 = "Kapoor";
        String email3 = "julia.roberts@mail.com";
        String age3 = "32";
        String salary3 = "125000";
        String department3 = "Customer service";
        //-----------

        deleteAllRecords();

        addRecord(firstName1, lastName1, email1, salary1, department1, age1);
        addRecord(firstName2, lastName2, email2, salary2, department2, age2);
        addRecord(firstName3, lastName3, email3, salary3, department3, age3);

        Assert.assertTrue(webTablesPage.rowContent.get(0).getText().contains(firstName1));
        Assert.assertTrue(webTablesPage.rowContent.get(0).getText().contains(lastName1));
        Assert.assertTrue(webTablesPage.rowContent.get(0).getText().contains(age1));
        Assert.assertTrue(webTablesPage.rowContent.get(0).getText().contains(email1));
        Assert.assertTrue(webTablesPage.rowContent.get(0).getText().contains(salary1));
        Assert.assertTrue(webTablesPage.rowContent.get(0).getText().contains(department1));

        Assert.assertTrue(webTablesPage.rowContent.get(1).getText().contains(firstName2));
        Assert.assertTrue(webTablesPage.rowContent.get(1).getText().contains(lastName2));
        Assert.assertTrue(webTablesPage.rowContent.get(1).getText().contains(age2));
        Assert.assertTrue(webTablesPage.rowContent.get(1).getText().contains(email2));
        Assert.assertTrue(webTablesPage.rowContent.get(1).getText().contains(salary2));
        Assert.assertTrue(webTablesPage.rowContent.get(1).getText().contains(department2));

        Assert.assertTrue(webTablesPage.rowContent.get(2).getText().contains(firstName3));
        Assert.assertTrue(webTablesPage.rowContent.get(2).getText().contains(lastName3));
        Assert.assertTrue(webTablesPage.rowContent.get(2).getText().contains(age3));
        Assert.assertTrue(webTablesPage.rowContent.get(2).getText().contains(email3));
        Assert.assertTrue(webTablesPage.rowContent.get(2).getText().contains(salary3));
        Assert.assertTrue(webTablesPage.rowContent.get(2).getText().contains(department3));
    }

    @Test
    public void userCanAddMultipleRecordsUsingExcelData() {
        deleteAllRecords();

        int j = 0;
        for (int i = 0; i < excelReader.getLastRow("TestData"); i++) {

            String firstName = excelReader.getStringData("TestData", i + 1, 0);
            String lastName = excelReader.getStringData("TestData", i + 1, 1);
            String email = excelReader.getStringData("TestData", i + 1, 2);
            String age = String.valueOf(excelReader.getIntegerData("TestData", i + 1, 3));
            String salary = String.valueOf(excelReader.getIntegerData("TestData", i + 1, 4));
            String department = excelReader.getStringData("TestData", i + 1, 5);

            addRecord(firstName, lastName, email, salary, department, age);

            Assert.assertTrue(webTablesPage.cell.get(j).getText().equals(firstName));
            Assert.assertTrue(webTablesPage.cell.get(j + 1).getText().equals(lastName));
            Assert.assertTrue(webTablesPage.cell.get(j + 2).getText().equals(age));
            Assert.assertTrue(webTablesPage.cell.get(j + 3).getText().equals(email));
            Assert.assertTrue(webTablesPage.cell.get(j + 4).getText().equals(salary));
            Assert.assertTrue(webTablesPage.cell.get(j + 5).getText().equals(department));

            j = j + 7;
        }
    }

    @AfterMethod
    public void clearData() {
        driver.manage().deleteAllCookies();
    }

}
