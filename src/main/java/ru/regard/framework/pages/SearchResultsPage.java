package ru.regard.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    private String name;

    @FindBy(xpath = "//div[contains(@class, 'Pagination_wrap')]//span")
    private WebElement countOfThings;

    @FindBy(xpath = "(//div[contains(@class, 'Card_wrap')]//a/h6)[1]")
    private WebElement firstElement;

    @FindBy(xpath = "//input[@id='searchInput']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='rendererWrapper']//div[contains(@class, 'Card_wrap')]")
    private List<WebElement> listOfSearchElement;

    @FindBy(xpath = "//div[contains(@class, 'Search_inputWrap')]//*[contains(@class, 'Icons_search')]")
    private WebElement searchBtn;


    public void checkCountOfThingsAfterSearch(int count) {
        Assertions.assertTrue(countOfThings.getText().contains(String.valueOf(count)),
                "Значение из выпадающего списка 'Товаров на странице' внизу страницы должно быть :" + count);
    }

    public void saveFirstNameAndSearch() {
        waitingForLoading();
        this.name = firstElement.getText();
        searchInput.sendKeys(name);
        searchBtn.click();
        waitingForLoading();
    }

    public void checkCountItem(int count) {
        Assertions.assertEquals(count, listOfSearchElement.size(), "В поисковой выдаче ожидается " + count + " товара(ов)");
    }

    public void checkNameItem() {
        Assertions.assertEquals(this.name, firstElement.getText(), "Наименование товара НЕ соответствует сохраненному значению");
    }

}
