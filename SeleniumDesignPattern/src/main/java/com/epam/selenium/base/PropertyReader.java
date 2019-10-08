package com.epam.selenium.base;

import java.util.ResourceBundle;

/**
 * @author Saurabh_Verma Reads from the property file.
 */
public final class PropertyReader {
    /**
     * Resource bundle instance.
     */
    private static ResourceBundle rb = ResourceBundle.getBundle("config");
    /**
     *private constructor.
     */
    private PropertyReader() {

    }

    /**
     * @param key whose value is to be fetched from the file
     * @return corresponding value
     */
    public static String readProperty(final String key) {
        return rb.getString(key);

    }

}
