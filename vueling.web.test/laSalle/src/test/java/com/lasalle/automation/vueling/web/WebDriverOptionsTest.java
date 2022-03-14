package com.lasalle.automation.vueling.web;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * - Window: get, getTitle, getCurrentUrl, getPageSource, close, quit
 * - Navigate: to, back, forward, refresh
 * - FindElement & FindElements
 * switchTo: frame, alert, window…
 * WebElement: click, clear, findElement/s, getAttribute, getText, sendkeys…
 * Locators según preferencia:
 * By Id
 * By name
 * By css: https://saucelabs.com/resources/articles/selenium-tips-css-selectors
 * By xpath
 * Wait: implicitlyWait vs explicitWait (expected conditions)
 */
public class WebDriverOptionsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static WebDriver driver;

    @Test
    public void testWebDrives() throws InterruptedException {
        LOGGER.debug("start testWebDrive");

        System.setProperty("webdriver.chrome.driver", "C:\\home\\s2o\\tmp\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LOGGER.debug("driver started");

        driver.navigate().to("https://www.vueling.com/es");
        //ACEPTAR COOKIES
        List<WebElement> buttonCookies = driver.findElements((By.cssSelector("button[id='ensCloseBanner']")));
        buttonCookies.get(0).click();

        //SELECCIONAR ORIGEN
        WebElement origen = driver.findElement(By.cssSelector("input[id^='originInput']"));
        origen.sendKeys("Alicante");
        origen.sendKeys(Keys.ENTER);

        //SELECCIONAR DESTINO
        WebElement destino = driver.findElement(By.cssSelector("input[id^='destinationInput']"));
        destino.sendKeys("Atenas");
        destino.sendKeys(Keys.ENTER);

        //SELECCIONAR FECHA
        WebElement fecha = driver.findElement(By.xpath("/html/body/div[4]/div[2]/flights-filter/div/div[2]/div/vy-datepicker-popup/vy-specificdates-datepicker/div/div[2]/table"));
        destino.sendKeys("14/03/2022");

        //origen.click();
        //HABILITAR SOLO IDA
        //WebElement soloIda = driver.findElement(By.cssSelector("li[innerHTML= '<input name=\\\"flightOption\\\" type=\\\"radio\\\" id=\\\"oneWay\\\" class=\\\"ng-pristine ng-valid input--filled ng-touched\\\"><label for=\\\"oneWay\\\">Solo ida</label>']"));
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //soloIda.click();

        //CLICK EN BUSCAR
        List<WebElement> buttons = driver.findElements((By.cssSelector("button[id='btnSubmitHomeSearcher']")));
        buttons.get(0).click();
        driver.close();
        LOGGER.debug("driver closed");
    }

}
