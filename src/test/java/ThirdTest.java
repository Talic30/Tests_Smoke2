
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ThirdTest {
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public ChromeDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\Google\\soft\\projects\\chromedriver.exe");
        driver = new ChromeDriver();
        // Выставляем таймаут 10 секунд на ожидание действия
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver = new FirefoxDriver();
        //baseUrl = "https://www.katalon.com/";
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test1CheckEmployee() throws Exception {
        driver.get("http://bg-app02.ecor2.pp.newdv.ru:4092/#/");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }
}
