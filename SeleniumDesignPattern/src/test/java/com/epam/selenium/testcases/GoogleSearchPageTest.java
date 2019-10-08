package com.epam.selenium.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.epam.selenium.base.TestBase;
import com.epam.selenium.pages.GoogleHomePage;
import com.epam.selenium.pages.GoogleSearchPage;

import static com.epam.selenium.base.WebDriverContainer.getDriver;

import static com.epam.selenium.base.PropertyReader.readProperty;

/**
 * @author Saurabh_Verma
 *
 */
public class GoogleSearchPageTest extends TestBase {
    /**
     * GoogleSearchPage instance.
     */
    private GoogleSearchPage searchPage;
    /**
     * GoogleHomePage instance.
     */
    private GoogleHomePage homePage;

    /**
     * @throws IOException
     *             as reading from the property file.
     */
    @Test
    public void testCompanyAddress() throws IOException {
        homePage = new GoogleHomePage();
        getDriver().get(readProperty("url"));
        searchPage = homePage.searchText(readProperty("searchText"));
        String address = searchPage.verfiyCoompanyAddress();
        assertEquals(address, readProperty("address"));
    }
}
