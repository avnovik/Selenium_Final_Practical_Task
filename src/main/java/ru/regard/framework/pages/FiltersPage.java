package ru.regard.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class FiltersPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'ListingFilters_bottom')]")
    private WebElement filters;

    @FindBy(xpath = "//span[text()='Цена']/ancestor::section//input[@name='min']")
    private WebElement inputMinPrice;

    @FindBy(xpath = "//span[text()='Производитель']/ancestor::section//ul//li")
    private List<WebElement> listOfBrand;

    @FindBy(xpath = "(//div[contains(@class, 'Card_wrap')]//a/h6)[1]")
    private WebElement firstElement;

    public void inputMinPrice(int price) {
        wait.until(ExpectedConditions.visibilityOf(filters));
        inputMinPrice.sendKeys(String.valueOf(price));

    }

    public void chooseBrand(String brandName) {
        for (WebElement itemMenu : listOfBrand) {
            if (itemMenu.getText().contains(brandName)) {
                itemMenu.findElement(By.xpath(".//label")).click();
                return;
            }
        }
        fail("Меню с текстом '" + brandName + "' не найдено в каталоге");
    }
}
