package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v140.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    // List of all cards displayed on the home page
    @FindBy(className = "card-body")
    public List<WebElement> cards;


    //----------------------------------

    // This method clicks on a card by its visible text
    public void selectCard(String selected) {
        for (int i=0; i<cards.size(); i++) {
            if(cards.get(i).getText().equals(selected)) {
                cards.get(i).click();
                break;
            }
        }
    }

    // This method returns a WebElement of a card by its name
    public WebElement getCard(String cardName) {
        WebElement card = null;
        for (int i = 0; i < this.cards.size(); ++i) {
            if (this.cards.get(i).getText().equals(cardName)) {
                card = cards.get(i);

            }
        }
        return card;
    }























}
