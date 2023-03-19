package ru.regard.framework.steps;

import io.cucumber.java.en.And;
import ru.regard.framework.managers.PageManager;

public class NavigationBarPageStep {

    PageManager pageManager = PageManager.getPageManager();

    @And("^Выбрать раздел каталога \"([^\"]*)\"$")
    public void selectInCatalogMenuByText(String nameMenu){
        pageManager.getNavigationBarPage().selectInCatalogMenuByText(nameMenu);
    }
}