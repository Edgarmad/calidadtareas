package com.mayab.calidad.funcionales;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class mernCrudTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String URL;
  
  @Before
  public void setUp() {
	    URL = "http://localhost:4200/";
	    System.setProperty("webdriver.chrome.driver", "E:\\Documentos\\Java Drivers\\chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
	    		UnexpectedAlertBehaviour.IGNORE);
	    driver = new ChromeDriver();

  }
  
  @Test
  public void testAaddNewPerson() {
	driver.get(URL);
    driver.findElement(By.cssSelector(".green")).click();
    driver.findElement(By.name("name")).sendKeys("Luis Madrigal");
    driver.findElement(By.name("email")).sendKeys("madrigal@gmail.com");
    driver.findElement(By.name("age")).sendKeys("23");
    driver.findElement(By.cssSelector(".selection")).click();
    driver.findElement(By.cssSelector(".item:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".right")).click();
    pause(1000);
    WebElement cuadro = driver.findElement(By.cssSelector(".green > .content"));
    assertThat(cuadro.getText(),equalTo("Nice one!\n" + "Successfully added!"));
    driver.close();
  }
  @Test
  public void testBaddRepetPerson() {
	driver.get(URL);
    driver.findElement(By.cssSelector(".green")).click();
    driver.findElement(By.name("name")).sendKeys("Luis Madrigal");
    driver.findElement(By.name("email")).sendKeys("madrigal@gmail.com");
    driver.findElement(By.name("age")).sendKeys("23");
    driver.findElement(By.cssSelector(".selection")).click();
    driver.findElement(By.cssSelector(".item:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".right")).click();
    pause(1000);
    WebElement cuadro = driver.findElement(By.cssSelector(".yellow > .content"));
    assertThat(cuadro.getText(),equalTo("Woah!\n" + "That email is already taken."));
    driver.close();
  }
  @Test
  public void testCeditRightPerson() {
	driver.get(URL);
    driver.findElement(By.cssSelector(".blue")).click();
    driver.findElement(By.name("name")).sendKeys(" Munguia");
    driver.findElement(By.cssSelector(".right")).click();
    pause(1000);
    WebElement cuadro = driver.findElement(By.cssSelector(".green > .content"));
    assertThat(cuadro.getText(),equalTo("Nice one!\n" + "Successfully updated!"));
    driver.close();
  }
  @Test
  public void testDeditWrongPerson() {
	driver.get(URL);
    driver.findElement(By.cssSelector(".blue")).click();
    driver.findElement(By.name("email")).sendKeys("96");
    driver.findElement(By.cssSelector(".right")).click();
    pause(1000);
    WebElement cuadro = driver.findElement(By.cssSelector(".yellow > .content"));
    assertThat(cuadro.getText(),equalTo("Woah!\n" + "Email must be valid."));
    driver.close();
  }
  @Test
  public void testEeraseRightPerson() {
	driver.get(URL);
    driver.findElement(By.cssSelector(".green")).click();
    driver.findElement(By.name("name")).sendKeys("Juana de Arco");
    driver.findElement(By.name("email")).sendKeys("archer@gmail.com");
    driver.findElement(By.name("age")).sendKeys("27");
    driver.findElement(By.cssSelector(".selection")).click();
    driver.findElement(By.cssSelector(".item:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".right")).click();
    driver.findElement(By.cssSelector(".close")).click();
	WebElement original = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody/tr[1]/td[1]"));
	String nombre = (String) original.getText();
	System.out.print("Persona recien creada: " + nombre);
	driver.findElement(By.cssSelector(".black")).click();
    driver.findElement(By.cssSelector(".red")).click();
	WebElement delete = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody/tr[1]/td[1]"));
	String nombresBorrado = (String) delete.getText();
	System.out.print("Persona que ocupa su lugar: "+ nombresBorrado);
    pause(1000);
    assertNotEquals(nombre,nombresBorrado);
    driver.close();
  }
  @Test
  public void testFeraseWrongPerson() {
		driver.get(URL);
	    driver.findElement(By.cssSelector(".green")).click();
	    driver.findElement(By.name("name")).sendKeys("Juana de Arco");
	    driver.findElement(By.name("email")).sendKeys("archer@gmail.com");
	    driver.findElement(By.name("age")).sendKeys("27");
	    driver.findElement(By.cssSelector(".selection")).click();
	    driver.findElement(By.cssSelector(".item:nth-child(2)")).click();
	    driver.findElement(By.cssSelector(".right")).click();
	    driver.findElement(By.cssSelector(".close")).click();
		WebElement original = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody/tr[1]/td[1]"));
		String nombre = (String) original.getText();
		System.out.print("Prsona recien creada: " + nombre);
		driver.findElement(By.cssSelector("tr:nth-child(1) .black")).click();
	    driver.findElement(By.cssSelector(".actions > .black")).click();
		WebElement delete = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody/tr[1]/td[1]"));
		String nombresBorrado = (String) delete.getText();
		System.out.print("Persona que ocupa su lugar: "+ nombresBorrado);
	    pause(1000);
	    assertEquals(nombre,nombresBorrado);
	    driver.close();
  }
  @After
  public void tearDown() {
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
