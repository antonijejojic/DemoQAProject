package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {


    public static WebDriver driver;

    public ExcelReader excelReader;
    public HomePage homePage;
    public WebTablesPage webTablesPage;
    public PracticeFormPage practiceFormPage;
    public BookStoreLoginPage bookStoreLoginPage;
    public SideBar sideBar;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;


    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("ProjectData.xlsx");
    }


    @AfterClass
    public void tearDown() {
        //driver.quit();
    }














}
