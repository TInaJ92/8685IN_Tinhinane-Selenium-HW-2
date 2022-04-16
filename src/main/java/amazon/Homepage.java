package amazon;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;

    @FindBy(id="nav-search-submit-button")
    public WebElement searchButton;

    public Homepage() {
        PageFactory.initElements(driver, this);
    }


    // region Workflow Methods
    public SearchResultPage doSearch(String searchTerm) {
        typeOnSearchBar(searchTerm);
        clickSearchButton();

        return new SearchResultPage();
    }

    // endregion

    // region Sole Responsibility Methods
    public void typeOnSearchBar(String input) {
        searchBar.sendKeys(input);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    // endregion




}
