package ru.portal;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.openqa.selenium.support.ui.ExpectedCondition.*;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Service_Test {
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public ChromeDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


        // Выставляем таймаут 10 секунд на ожидание действия
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Выставляем разрешение 1920х1080 *добавить тест мобильной версии
        driver.manage().window().setSize(new Dimension(1920,1080));

        // Полный экран
        driver.manage().window().maximize();
    }

    @Test
    // Тест 1.1 - Экранная форма Сотрудники - Служба - общий функционал
    public void test1CheckEmployee() throws Exception {


        // Открываем портал
        driver.get("http://bg-app02.ecor2.pp.newdv.ru:4092/#/");
        System.out.println("- Портал открыт");

        // Вход
        driver.findElement(By.linkText("Войти")).click();
        System.out.println("- Вход произведён");


        // Вход для городских служб
        driver.findElement(By.xpath("//*/text()[normalize-space(.)='Вход для городских служб']/parent::*")).click();
        System.out.println("- Вход для городских служб произведён");

        // Ввод логина
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("test3");
        System.out.println("- Ввод логина произведён");

        // Ввод пароля
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("test3");
        System.out.println("- Ввод пароля произведён");

        // Кнопка Входа
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Вход'])[3]/preceding::button[1]")).click();
        System.out.println("- Нажатие на кнопку входа произведено");

        // Меню
        driver.findElement(By.xpath("//*/text()[normalize-space(.)='Меню']/parent::*")).click();
        System.out.println("- Нажатие на кнопку меню произведено");

        // Сотрудники
        driver.findElement(By.xpath("//a[contains(text(),'Сотрудники')]")).click();
        System.out.println("- Нажатие на кнопку меню -> сотрудники произведено");

        // Поиск кнопок
        // Сотрудники



        // Проверить сортировку и пагинацию

        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='content-container']/div/div/div/article/section/div[2]/table/thead/tr/th/div"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Объекты'])[1]/preceding::a[1]")));
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Объекты'])[1]/preceding::a[1]")).click();
        System.out.println("- Проверка сортировки и пагинации успещно завершена");

        // Открываем первого из списка
        driver.get("http://bg-app02.ecor2.pp.newdv.ru:4092/#/employee/5adfd29d-0494-4437-879a-af955a874f3e/view");
        System.out.println("- Карточка сотрудника успешно открыта");

        // Переходим назад
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='«'])[1]/following::span[1]")).click();
        System.out.println("- Переход назад осуществлён");

        // Выход
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='✓'])[1]/following::a[3]")).click();
        driver.findElement(By.xpath("//*/text()[normalize-space(.)='Выйти']/parent::*")).click();
        System.out.println("- Выход произведён");
    }

    @Test
    // Тест 1.2 - Добавить сотрудника
    public void test2AddEmployee() throws Exception {

        // Открываем портал
        driver.get("http://bg-app02.ecor2.pp.newdv.ru:4092/#/");
        System.out.println("- Портал открыт");

        // Вход
        driver.findElement(By.linkText("Войти")).click();
        System.out.println("- Вход произведён");


        // Вход для городских служб
        driver.findElement(By.xpath("//*/text()[normalize-space(.)='Вход для городских служб']/parent::*")).click();
        System.out.println("- Вход для городских служб произведён");

        // Ввод логина
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("test3");
        System.out.println("- Ввод логина произведён");

        // Ввод пароля
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("test3");
        System.out.println("- Ввод пароля произведён");

        // Кнопка Входа
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Вход'])[3]/preceding::button[1]")).click();
        System.out.println("- Нажатие на кнопку входа произведено");

        // Меню
        driver.findElement(By.xpath("//*/text()[normalize-space(.)='Меню']/parent::*")).click();
        System.out.println("- Нажатие на кнопку меню произведено");

        // Сотрудники
        driver.findElement(By.xpath("//a[contains(text(),'Сотрудники')]")).click();
        System.out.println("- Нажатие на кнопку меню -> сотрудники произведено");

        // Создание сотрудника
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*/text()[normalize-space(.)='Добавить']/parent::*")).click();
        System.out.println("- Нажатие на кнопку Добавить произведено");

        // Ввод Фамилии
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("Тест");
        System.out.println("- Ввод фамилии произведен");

        // Ввод Имени
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Тест");
        System.out.println("- Ввод имени произведен");

        // Ввод Отчества
        driver.findElement(By.id("middleName")).click();
        driver.findElement(By.id("middleName")).clear();
        driver.findElement(By.id("middleName")).sendKeys("Тест");
        System.out.println("- Ввод отчества произведен");

        // Ввод должности
        driver.findElement(By.id("post")).click();
        driver.findElement(By.id("post")).clear();
        driver.findElement(By.id("post")).sendKeys("рабочий");
        System.out.println("- Ввод Должности произведен");

        // Ввод звания
        driver.findElement(By.id("rank")).click();
        driver.findElement(By.id("rank")).clear();
        driver.findElement(By.id("rank")).sendKeys("генеральный");
        System.out.println("- Ввод Звания произведен");

        // Ввод
        driver.findElement(By.linkText("Сохранить")).click();
        System.out.println("- Нажата кнопка Сохранить");

        Thread.sleep(1000);
        // надать да во всплывашке с вопросом
        driver.findElement(By.xpath("//button[3]")).click();
        System.out.println("- Нажата кнопка Сохранить");

        Thread.sleep(1000);
        // Выход
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='✓'])[1]/following::a[3]")).click();
        driver.findElement(By.xpath("//*/text()[normalize-space(.)='Выйти']/parent::*")).click();
        System.out.println("- Выход произведён");
        System.out.println("- Тест упешно пройден");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
