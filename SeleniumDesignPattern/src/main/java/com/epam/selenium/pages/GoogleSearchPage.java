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
public class GoogleSearchPage extends TestBase {
    /**
     * WebElement having Address on result page.
     */
    @FindBy(xpath =
          "//div[contains(text(),'EPAM Systems, Address')]/parent::*//div[1]")
    private WebElement companyAddress;

    /**
     * Constructor which initializes all the page objects.
     */
    public GoogleSearchPage() {
        PageFactory.initElements(getDriver(), this);
    }

    /**
     * @return String having address
     */
    public String verfiyCoompanyAddress() {
        return companyAddress.getText();
    }
}
