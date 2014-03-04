package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8888/index.php";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled2() throws Exception {
    openMainPage();
    gotoNewContact();
    fillContactForm();
    returnHomePage();
  }

private void returnHomePage() {
	driver.findElement(By.linkText("home page")).click();
}

private void fillContactForm() {
	driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("First_Name");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("Last_Name");
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("Name Surname\n01234 City\n12 Some.str\nCOUNTRY");
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys("(044)123-45-67");
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys("+");
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys("+3-8-010-123-45-67");
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys("044-1234567");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("email1@adress.com");
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys("email2@address.com");
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText("29");
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("September");
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys("2001");
    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("group1");
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys("Name Surname\n01234 City\n12 Some.str\nCOUNTRY2");
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys("http://site.com");
    driver.findElement(By.name("submit")).click();
}

private void gotoNewContact() {
	driver.findElement(By.linkText("add new")).click();
}

private void openMainPage() {
	driver.get(baseUrl + "/index.php");
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
