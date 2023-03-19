package ru.regard.framework.steps;

import io.cucumber.java.en.And;
import ru.regard.framework.managers.PageManager;

public class SearchResultsPageStep {

    PageManager pageManager = PageManager.getPageManager();

    @And("^Проверить, что в поисковой выдаче не более \"(\\d+)\" товаров 'Товаров на странице'$")
    public void checkCountOfThingsAfterSearch(int count) {
        pageManager.getSearchResultsPage().checkCountOfThingsAfterSearch(count);
    }

    @And("^Сохранить наименование первого товара в списке и выполнить поиск$")
    public void saveFirstNameAndSearch() {
        pageManager.getSearchResultsPage().saveFirstNameAndSearch();
    }

    @And("^Проверить, что в поисковой выдаче не более \"(\\d+)\" товара$")
    public void checkCountItem(int count) {
        pageManager.getSearchResultsPage().checkCountItem(count);
    }

    @And("^Проверить, что наименование товара соответствует сохраненному значению$")
    public void checkNameItem() {
        pageManager.getSearchResultsPage().checkNameItem();
    }
}