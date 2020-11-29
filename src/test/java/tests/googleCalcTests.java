package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import page.CalcGooglePage;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class googleCalcTests {

    private static WebDriver driver;
    private static CalcGooglePage CalcGooglePage;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        CalcGooglePage = new CalcGooglePage(driver);

    }


    @Test
    public void test1() {
        driver.get("https://www.google.ru/");
        CalcGooglePage.search("Калькулятор");

        CalcGooglePage.openBracket.click();
        //1
        CalcGooglePage.one.click();
        CalcGooglePage.plus.click();
        //2
        CalcGooglePage.two.click();
        CalcGooglePage.closingBracket.click();
        CalcGooglePage.multiply.click();
        //3
        CalcGooglePage.three.click();
        CalcGooglePage.minus.click();
        //4
        CalcGooglePage.four.click();
        //0
        CalcGooglePage.zero.click();
        CalcGooglePage.division.click();
        //5
        CalcGooglePage.five.click();
        CalcGooglePage.equally.click();
        assertEquals("(1 + 2) × 3 - 40 ÷ 5 =",driver.findElement(By.cssSelector("div [jsname=\"VkJw6\"] span")).getText());
        assertEquals("1",driver.findElement(By.cssSelector("div [jsname=\"zLiRgc\"] span")).getText());


    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }

}
