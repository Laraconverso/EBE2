package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {
     public WebDriver driver;

     public BasePage(WebDriver driver) {
          this.driver = driver;
     }

     public void setup() {
          ChromeOptions ChromeOptions = new ChromeOptions();
          ChromeOptions.addArguments("--remote-allow-origins=*");
          driver = new ChromeDriver(ChromeOptions);
          driver.manage().window().maximize();
     }

     public void url(String url) throws InterruptedException {
          driver.get(url);
          Thread.sleep(1000);
     }

     public void close() {
          driver.quit();
     }

     public WebElement findElement(By locator) {
          return driver.findElement(locator);
     }

     public void sendText(String imputText, By locator) {
          this.findElement(locator).clear();
          this.findElement(locator).sendKeys(imputText);
     }

     public void sendKey(CharSequence pressKeys, By locator) {
          this.findElement(locator).sendKeys(pressKeys);
     }

     public void clickear(By locator) {
          this.findElement(locator).click();
     }

     public String getText(By locator) {
          return this.findElement(locator).getText();
     }
}