
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
        public void test1CheckEmployee() throws Exception {

            // Открываем портал
            driver.get("http://bg-app02.ecor2.pp.newdv.ru:4092/#/");

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
            driver.findElement(By.xpath("//*/text()[normalize-space(.)='Меню']/parent::*")).click();

            // Сотрудники
            driver.findElement(By.xpath("//a[contains(text(),'Сотрудники')]")).click();


            // Проверить сортировку и пагинацию
            //driver.wait(10000);
            driver.findElement(By.xpath("//div[@id='content-container']/div/div/div/article/section/div[2]/table/thead/tr/th/div")).click();
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Объекты'])[1]/preceding::a[1]")).click();

            // Открываем первого из списка
            driver.get("http://bg-app02.ecor2.pp.newdv.ru:4092/#/employee/5adfd29d-0494-4437-879a-af955a874f3e/view");

            // Переходим назад
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='«'])[1]/following::span[1]")).click();

            // Выход
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='✓'])[1]/following::a[3]")).click();
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
