package ru.regard.framework.steps;

import io.cucumber.java.en.And;
import ru.regard.framework.managers.PageManager;

public class StartPageStep {

    PageManager pageManager = PageManager.getPageManager();

    @And("^Открыть браузер и развернуть на весь экран, зайти на 'http://regard.ru' и открыть меню \"Каталог\"$")
    public void clickCatalogBtn(){
        pageManager.getStartPage().clickCatalogBtn();
    }
}