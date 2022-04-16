package amazon;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    public WebElement searchTerm;

    @FindBy(xpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-index='2']")
    public WebElement firstResult;

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    public String getSearchTerm() {
        String searchTermString = searchTerm.getText().toLowerCase();
        return searchTermString.substring(1, searchTermString.length() - 1);
    }

    public ItemListingPage clickFirstSearchResult() {
        firstResult.click();

        return new ItemListingPage();
    }

}
