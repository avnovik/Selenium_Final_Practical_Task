package ru.regard.framework.managers;

import ru.regard.framework.pages.*;

public class PageManager {

    private static PageManager pageManager;

    private StartPage startPage;
    private NavigationBarPage navigationBar;
    private MainPage mainPage;
    private FiltersPage filtersPage;
    private SearchResultsPage searchResultsPage;

    private PageManager() {}

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public NavigationBarPage getNavigationBarPage() {
        if (navigationBar == null) {
            navigationBar = new NavigationBarPage();
        }
        return navigationBar;
    }

    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public FiltersPage getFiltersPage() {
        if (filtersPage == null) {
            filtersPage = new FiltersPage();
        }
        return filtersPage;
    }

    public SearchResultsPage getSearchResultsPage() {
        if (searchResultsPage == null) {
            searchResultsPage = new SearchResultsPage();
        }
        return searchResultsPage;
    }
}