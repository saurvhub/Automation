package com.epam.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.epam.selenium.base.WebDriverContainer.getDriver;
import com.epam.selenium.base.TestBase;

/**
 * @author Saurabh_Verma
 *
 */
public class GoogleHomePage extends TestBase {
    /**
     * WebElement of search box.
     */
    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchArea;

    /**
     * Constructor which initializes all the page objects.
     */
    public GoogleHomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    /**
     * @param searchText
     *            to be entered in search box
     * @return GoogleSearchPage instance
     * @throws IOException
     */
    public GoogleSearchPage searchText(final String searchText) {
        searchArea.sendKeys(searchText);
        searchArea.submit();
        return new GoogleSearchPage();
    }

}
