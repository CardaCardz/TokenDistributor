package configuration;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public interface ConfigurationReaderIT {

    Properties propertyFile = new Properties();
    Logger log = Logger.getLogger(ConfigurationReaderIT.class.getName());

    /**
     * Default method for reading single property from
     * the configuration file by its name.
     *
     * @param propertyName - String name of property to read.
     *
     * @return String - if property found.
     * null - if property not found.
     */
    default String readSingleProperty(String propertyName) {
        if (propertyFile.isEmpty()) {
            initializePropertyFile();
        }
        return propertyFile.getProperty(propertyName);
    }

    /**
     * Default method for propertyFile initialization.
     */
    default void initializePropertyFile() {
        try (InputStream inputStream = ConfigurationReaderIT.class
                .getClassLoader()
                .getResourceAsStream("configuration.properties")) {
            propertyFile.load(inputStream);
        } catch (IOException e) {
            log.error(e);
        }

    }


}
