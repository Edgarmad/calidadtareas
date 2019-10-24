package com.mayab.calidad.proyectoJava.funcionales;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class loginTest {

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
	    WebElement user = driver.findElement(By.id("user_id"));
	    user.sendKeys("00270500");
	    WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys("131196");
	    password.sendKeys(Keys.ENTER);
	    pause(5000);
	    WebElement check = driver.findElement(By.id("anonymous_element_10"));
	    assertThat(check.getText(),equalTo("Cursos en los que usted es: Alumno"));
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
