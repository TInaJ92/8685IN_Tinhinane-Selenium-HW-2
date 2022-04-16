package test_amazon;

import amazon.Homepage;
import amazon.SearchResultPage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchResultPage extends BasePage {

    @Test
    public void testSearchResultTerm() {
        String searchTerm = "watches";
        Homepage home = new Homepage();

        SearchResultPage searchResults = home.doSearch(searchTerm);

        Assert.assertEquals(searchResults.getSearchTerm(), searchTerm);
    }
}
