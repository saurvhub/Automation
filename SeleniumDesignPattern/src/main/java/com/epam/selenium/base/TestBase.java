package com.epam.selenium.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.epam.selenium.util.Driver;
import static com.epam.selenium.base.WebDriverContainer.getDriver;
import static com.epam.selenium.base.WebDriverContainer.setDriverType;
import static com.epam.selenium.base.PropertyReader.readProperty;
/**
 * @author Saurabh_Verma
 *
 */
public class TestBase {

    /**
     *This method will run before all test cases.
     */
    @BeforeTest
    public void setUp() {
        try {

            setDriverType(Driver.valueOf(readProperty("browser")));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method will run after every test case.
     */
    @AfterTest
    public void tearDown() {
        getDriver().quit();
    }

}
