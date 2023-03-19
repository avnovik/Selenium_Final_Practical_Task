package ru.regard.framework.steps;

import io.cucumber.java.en.And;
import ru.regard.framework.managers.PageManager;

public class MainPageStep {

    PageManager pageManager = PageManager.getPageManager();

    @And("^Выбрать раздел \"([^\"]*)\"$")
    public void selectInListCategoriesMenuByText(String nameCategories) {
        pageManager.getMainPage().selectInListCategoriesMenuByText(nameCategories);
    }
}