package ru.regard.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'Categories_categoryItem')]")
    private List<WebElement> listCategoriesMenu;

    public void selectInListCategoriesMenuByText(String nameCategories) {
        for (WebElement itemMenu : listCategoriesMenu) {
            if (itemMenu.getText().contains(nameCategories)) {
                itemMenu.click();
                return;
            }
        }
        fail("Меню с текстом '" + nameCategories + "' не найдено в каталоге");
        waitingForLoading();
    }

}