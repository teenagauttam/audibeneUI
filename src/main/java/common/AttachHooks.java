package common;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class AttachHooks {

    private Scenario scenario;
    public static WebDriver driver;
    DesiredCapabilities capabilities;
    private static Logger LOGGER = LoggerFactory.getLogger(AttachHooks.class);


    @Before
    public void setUp(Scenario scenario) throws IOException {
        LOGGER.info("Inside set up method of before hook");
        ConfigManager.loadConfig();
        this.scenario = scenario;
        System.out.println(scenario.getName());


        if (ConfigManager.getProperty("browserName").equalsIgnoreCase("chrome") &&
                ConfigManager.getProperty("OS").equalsIgnoreCase("MAC")) {
            LOGGER.info("Our browser will be invoked here");

            System.setProperty("webdriver.chrome.driver", "webdriver/bin/chromedriver");

            // Please comment below code for headless browser
            capabilities = DesiredCapabilities.chrome();
            driver = new ChromeDriver(capabilities);
            driver.manage().window().fullscreen();

            // Please uncomment below code for headless browser
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless");
//            chromeOptions.addArguments("disable-gpu");
//            chromeOptions.addArguments("--test-type", "--ignore-certificate-errors");
//            driver = new ChromeDriver(chromeOptions);
//            driver.manage().window().setSize(new Dimension(1200, 1100));


        } else if (ConfigManager.getProperty("browserName").equalsIgnoreCase("chrome") &&
                ConfigManager.getProperty("OS").equalsIgnoreCase("WINDOWS")) {

            System.setProperty("webdriver.chrome.driver", "webdriver/bin/chromedriver.exe");
            capabilities = DesiredCapabilities.chrome();
            driver = new ChromeDriver(capabilities);
            driver.manage().window().maximize();

        }


        if (ConfigManager.getProperty("browserName").equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        if (ConfigManager.getProperty("browserName").equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        LOGGER.info("Browser Opened");
    }

    @After
    public void tearDown() {

        driver.quit();


    }

}