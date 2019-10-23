package com.mayab.calidad.proyectoJava.funcionales;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleImageTest {

	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private String URL;

	  @Before
	  public void setUp() throws Exception {
	    //driver = new FirefoxDriver();
	    URL = "https://anahuac.blackboard.com/webapps/login/";
		//baseUrl = "https://www.katalon.com/";
	    System.setProperty("webdriver.chrome.driver", "E:\\Documentos\\Java Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	   // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void LoginTest() throws Exception {
	    driver.get(URL);
	    WebElement element = driver.findElement(By.name("user-id"));
	    element.sendKeys("00270500");
	    element.submit();
	    WebElement resultStat = driver.findElement(By.name(""));
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
