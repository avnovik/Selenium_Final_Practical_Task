package ru.regard.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StartPage extends BasePage {

    @FindBy(xpath = "//span[text()='Каталог']/..")
    private WebElement catalogBtn;

    @FindBy(xpath = "//div[contains(@class, 'CatalogPanel')]")
    private WebElement catalogPanel;


    public void clickCatalogBtn() {
        catalogBtn.click();
        wait.until(ExpectedConditions.visibilityOf(catalogPanel));
    }

}
