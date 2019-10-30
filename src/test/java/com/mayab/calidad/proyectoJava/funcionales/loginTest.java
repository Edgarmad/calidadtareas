package com.mayab.calidad.proyectoJava.funcionales;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
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
	    URL = "https://anahuac.blackboard.com/webapps/login/";
	    System.setProperty("webdriver.chrome.driver", "E:\\Documentos\\Java Drivers\\chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
	    		UnexpectedAlertBehaviour.IGNORE);
	    driver = new ChromeDriver();
	  }

	  @Test
	  public void LoginTest() throws Exception {
	    driver.get(URL);
	    WebElement user = driver.findElement(By.id("user_id"));
	    user.sendKeys("user");
	    WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys("password");
	    password.sendKeys(Keys.ENTER);
	    pause(5000);
	    WebElement check = driver.findElement(By.className("moduleTitle"));
	    assertThat(check.getText(),equalTo("Mis cursos"));
	    driver.close();
	  }
	  @Test
	  public void LoginFailedTest() throws Exception{
		  driver.get(URL);
		  WebElement user = driver.findElement(By.id("user_id"));
		  user.sendKeys("user");
		  WebElement password = driver.findElement(By.id("password"));
		  password.sendKeys("password");
		  password.sendKeys(Keys.ENTER);
		  pause(5000);
		  WebElement failcheck = driver.findElement(By.id("loginErrorMessage"));
		  assertThat(failcheck.getText(),equalTo("El nombre de usuario o contraseña que ha introducido no son correctos. Inténtelo de nuevo. Si aún no puede iniciar sesión, comuníquese con su administrador del sistema."));
		  driver.close();
	  }
	  @Test
	  public void LoginNoTextTest() throws Exception{
		  driver.get(URL);
		  WebElement user = driver.findElement(By.id("user_id"));
		  user.sendKeys("");
		  WebElement password = driver.findElement(By.id("password"));
		  password.sendKeys("");
		  password.sendKeys(Keys.ENTER);
		  pause(5000);
		  String alert = (String) driver.switchTo().alert().getText();
		  Alert alerta = driver.switchTo().alert();
		  alerta.accept();
		  assertThat(alert,equalTo("Introduzca un nombre de usuario y una contraseña."));
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
