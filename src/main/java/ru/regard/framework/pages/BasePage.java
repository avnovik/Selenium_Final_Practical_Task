package ru.regard.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.regard.framework.managers.DriverManager;

import java.time.Duration;


public class BasePage {

    @FindBy(xpath = "//div[@class='rendererWrapper']//h6//span[contains(@class, 'Skeleton_skeleton')]")
    private WebElement loadingIcons;

    protected WebDriver driver = DriverManager.getInstance().getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public void waitingForLoading() {
        wait.until(ExpectedConditions.invisibilityOfAllElements(loadingIcons));
    }
}