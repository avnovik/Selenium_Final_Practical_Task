package ru.regard.framework.steps;

import io.cucumber.java.en.And;
import ru.regard.framework.managers.PageManager;

public class FiltersPageStep {

    PageManager pageManager = PageManager.getPageManager();

    @And("^Задать параметр поиска по цене от \"(\\d+)\" рублей$")
    public void inputMinPrice(int price) {
        pageManager.getFiltersPage().inputMinPrice(price);
    }

    @And("^Выбрать производителя \"([^\"]*)\"$")
    public void chooseBrand(String brandName) {
        pageManager.getFiltersPage().chooseBrand(brandName);
    }
}