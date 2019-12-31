
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

    public class SecondTest {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();


        @Test
        public void test1CheckEmployee() throws Exception {

            // Инициализируем Chrome
            System.setProperty("webdriver.chrome.driver", "D:\\Google\\soft\\projects\\chromedriver.exe");
            ChromeDriver driver = new ChromeDriver();

            // Разворачиваем в полный экран
            driver.manage().window().maximize();

            // Открываем портал
            driver.get("http://bg-app02.ecor2.pp.newdv.ru:4092/#/");

            // Выставляем таймаут 10 секунд на ожидание действия
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Вход
            driver.findElement(By.linkText("Войти")).click();


            // Вход для городских служб
            driver.findElement(By.xpath("//*/text()[normalize-space(.)='Вход для городских служб']/parent::*")).click();

            // Ввод логина
            driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
            driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
            driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("test3");

            // Ввод пароля
            driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
            driver.findElement(By.xpath("(//input[@type='password'])[2]")).clear();
            driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("test3");

            // Кнопка Вход
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Вход'])[3]/preceding::button[1]")).click();

            // Меню
            //driver.findElement(By.linkText("Сотрудники")).click();
            driver.findElement(By.xpath("//span[contains(@class,'lich_kab ng-scope') and contains(text(), 'Меню')]")).click();
            driver.findElement(By.xpath("//a[contains(@href, '#/employee_catalog')]")).click();

            // driver.findElement(By.xpath("//th/div")).click();
            driver.findElement(By.xpath("//*/text()[normalize-space(.)='»']/parent::*")).click();

            // Выбрать первый элемент в списке
            //driver.findElement(By.className('')
            //driver.findElement(By.xpath("//div[@id='content-container']/div/div/div/article/section/div[2]/table/tbody/tr[2]/td[8]/button")).click();
            //driver.findElement(By.cssSelector("button.oko_bl_link")).click();
            //driver.findElement(By.xpath("//td[8]/button")).click();


            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='«'])[1]/following::label[1]")).click();
            driver.findElement(By.xpath("//*/text()[normalize-space(.)='Назад']/parent::*")).click();
            driver.findElement(By.xpath("//div[5]/ul/li[2]/a")).click();
            driver.findElement(By.xpath("//*/text()[normalize-space(.)='Выйти']/parent::*")).click();
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
