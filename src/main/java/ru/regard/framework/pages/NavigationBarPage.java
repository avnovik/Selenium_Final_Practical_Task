package ru.regard.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class NavigationBarPage extends BasePage {


    @FindBy(xpath = "//div[contains(@class, 'Catalog_mainCategory')]")
    private List<WebElement> listCatalogMenu;

    @FindBy(xpath = "//h1[contains(@class, 'PageTitle')]")
    private WebElement pageTitle;


    public void selectInCatalogMenuByText(String nameMenu) {

        for (WebElement itemMenu : listCatalogMenu) {
            if (itemMenu.getText().contains(nameMenu)) {
                itemMenu.click();
                return;
            }
        }
        fail("Меня с текстом '" + nameMenu + "' не найдено в каталоге");
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
    }


}
