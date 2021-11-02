package systemTesting;

import static org.junit.jupiter.api.Assertions.fail;



import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrazioneEffettuata {
	
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	
	  
	  @Test
	  public void testRegistrazioneEffettuata() throws Exception {
		  System.setProperty("webdriver.gecko.driver",
				  "C:\\Users\\luisi\\Downloads\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		    driver = new FirefoxDriver();
		    driver.get("http://localhost:8080/provaSmartCooking3/index.jsp");
		    driver.findElement(By.linkText("login")).click();
		    driver.findElement(By.linkText("Registrati qui")).click();
		    driver.findElement(By.id("email")).click();
		    driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys("AldoBaglio@gmail.com");
		    driver.findElement(By.id("password")).click();
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("12345678");
		    driver.findElement(By.id("nome")).click();
		    driver.findElement(By.id("nome")).clear();
		    driver.findElement(By.id("nome")).sendKeys("Aldo");
		    driver.findElement(By.id("cognome")).click();
		    driver.findElement(By.id("cognome")).clear();
		    driver.findElement(By.id("cognome")).sendKeys("Baglio");
		    driver.findElement(By.id("dataNascita")).click();
		    driver.findElement(By.id("dataNascita")).clear();
		    driver.findElement(By.id("dataNascita")).sendKeys("1960-10-10");
		    driver.findElement(By.id("telefono")).click();
		    driver.findElement(By.id("telefono")).clear();
		    driver.findElement(By.id("telefono")).sendKeys("3339911220");
		    driver.findElement(By.id("submitRegistrazione")).click();
		    
	    
	  }
	  
	  /*
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  } */
	

}
