package ru.portal;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\Google\\soft\\projects\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://bg-app02.ecor2.pp.newdv.ru:4092/#");
        driver.quit();
    }
}
