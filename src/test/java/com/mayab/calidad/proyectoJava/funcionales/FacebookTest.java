package com.mayab.calidad.proyectoJava.funcionales;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String URL;

  @Before
  public void setUp() throws Exception {
    //driver = new FirefoxDriver();
    URL = "https://www.facebook.com/";
	//baseUrl = "https://www.katalon.com/";
    System.setProperty("webdriver.chrome.driver", "E:\\Documentos\\Java Drivers\\chromedriver.exe");
    driver = new ChromeDriver();
   // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void LoginWrong() throws Exception {
	  driver.get(URL);
	    WebElement user = driver.findElement(By.id("email"));
	    user.sendKeys("prueba@pruebacalidad.com");
	    WebElement password = driver.findElement(By.id("pass"));
	    password.sendKeys("password");
	    password.sendKeys(Keys.ENTER);
	    pause(5000);
	    WebElement check = driver.findElement(By.className("_50f6"));
	    assertThat(check.getText(),equalTo("Iniciar sesión en Facebook"));
	    driver.close();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
  public void pause(long mils) {
	  try {
		  Thread.sleep(mils);
	  }catch(Exception e){
		  e.printStackTrace();
	  }
  }

}

