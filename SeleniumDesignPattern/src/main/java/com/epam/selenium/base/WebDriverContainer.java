package com.epam.selenium.base;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.epam.selenium.util.Driver;
import com.epam.selenium.util.TestUtil;
import static com.epam.selenium.base.PropertyReader.readProperty;

/**
 * @author Saurabh_Verma
 *
 */
public final class WebDriverContainer {
    /**
     * Driver instance.
     */
    private static Driver driverType;
    /**
     * WebDriver instance.
     */
    private static WebDriver driver = null;

    /**
     * private constructor.
     */
    private WebDriverContainer() {
    }

    /**
     * @param driverTypeParam
     *            Driver enum containing driver.
     */
    public static void setDriverType(final Driver driverTypeParam) {
        driverType = driverTypeParam;

    }

    /**
     * @return WebDriver instance.
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            switch (driverType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver",
                        readProperty("path"));
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case IE:
                driver = new InternetExplorerDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver",
                        readProperty("path"));
                driver = new ChromeDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIME,
                TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,
                TimeUnit.SECONDS);
        return driver;
    }

}
