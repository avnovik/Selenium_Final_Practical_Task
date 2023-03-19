package ru.regard.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.regard.framework.utils.PropConst;


public class DriverManager {

    private static DriverManager instance;
    private static WebDriver driver;
    private TestPropManager propManager = TestPropManager.getTestPropManager();

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public void initDriver() {
        driver = new FirefoxDriver();
        System.setProperty(propManager.getProperty(PropConst.WEB_DRIVER_FIREFOX), propManager.getProperty(PropConst.PATH_GECKO_DRIVER_MAC));
    }

//
//    private void initDriver() {
//        if (OS.isFamilyWindows()) {
//            initDriverWindowsOsFamily();
//        } else if (OS.isFamilyMac()) {
//            initDriverMacOsFamily();
//        } else if (OS.isFamilyUnix()) {
//            initDriverUnixOsFamily();
//        }
//    }

//    /**
//     * Метод инициализирующий веб драйвер под ОС семейства Windows
//     */
//    private void initDriverWindowsOsFamily() {
//        initDriverAnyOsFamily(PATH_GECKO_DRIVER_WINDOWS, PATH_CHROME_DRIVER_WINDOWS);
//    }
//
//    private void initDriverMacOsFamily() {
//        initDriverAnyOsFamily(PATH_GECKO_DRIVER_MAC, PATH_CHROME_DRIVER_MAC);
//    }
//
//    private void initDriverUnixOsFamily() {
//        initDriverAnyOsFamily(PATH_GECKO_DRIVER_UNIX, PATH_CHROME_DRIVER_UNIX);
//    }
//
//    /**
//     * Метод инициализирующий веб драйвер под любую ОС
//     *
//     * @param gecko - переменная firefox из файла application.properties в классе {@link ru.appline.framework.utils.PropConst}
//     * @param chrome - переменная chrome из файла application.properties в классе {@link ru.appline.framework.utils.PropConst}
//     */
//    private void initDriverAnyOsFamily(String gecko, String chrome) {
//        switch (props.getProperty(TYPE_BROWSER)) {
//            case "firefox":
//                System.setProperty("webdriver.gecko.driver", props.getProperty(gecko));
//                driver = new FirefoxDriver();
//                break;
//            case "chrome":
//                System.setProperty("webdriver.chrome.driver", props.getProperty(chrome));
//                driver = new ChromeDriver();
//                break;
//            default:
//                Assert.fail("Типа браузера '" + props.getProperty(TYPE_BROWSER) + "' не существует во фреймворке");
//        }
//    }

}
