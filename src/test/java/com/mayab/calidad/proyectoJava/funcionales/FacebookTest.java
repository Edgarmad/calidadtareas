package com.mayab.calidad.proyectoJava.funcionales;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
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
    URL = "https://www.google.com/";
	//baseUrl = "https://www.katalon.com/";
    System.setProperty("webdriver.chrome.driver", "E:\\Documentos\\Java Drivers\\chromedriver.exe");
    driver = new ChromeDriver();
   // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void LoginTest() throws Exception {
    driver.get(URL);
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("Hello");
    element.submit();
    WebElement resultStat = driver.findElement(By.name("//*[@id=\"resultStats\"]"));
    resultStat.submit();
    pause(5000);
    driver.close();
    Assert.assertEquals(resultStat,containsString("Resultado"));
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

