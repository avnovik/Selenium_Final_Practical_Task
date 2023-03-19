package ru.regard.framework.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.regard.framework.managers.DriverManager;
import ru.regard.framework.managers.InitManager;
import ru.regard.framework.managers.TestPropManager;
import ru.regard.framework.utils.PropConst;

public class Hooks {

    protected WebDriver driver = DriverManager.getInstance().getDriver();
    private DriverManager driverManager = DriverManager.getInstance();
    private TestPropManager propManager = TestPropManager.getTestPropManager();

    @Before
    public void before() {
        InitManager.initFramework();
        driverManager.getDriver().get(propManager.getProperty(PropConst.BASE_URL));
    }

    @After
    public void tearDown(Scenario scenario) {
        String screenshotName = scenario.getName().replace(" ", "_");
        try {
            if (scenario.isFailed()) {
                scenario.log("ALARM!");
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        InitManager.quitFramework();
    }
}
