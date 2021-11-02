package systemTesting;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sottoscriviabbonamento {
	
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	
	 @Test
	  public void testVisualizzazioneVideoNonGratuitoEffettuata() throws Exception {
		  System.setProperty("webdriver.gecko.driver",
				  "C:\\Users\\luisi\\Downloads\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		    driver = new FirefoxDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.get("http://localhost:8080/provaSmartCooking3/index.jsp");
		   
		    
		    driver.findElement(By.id("video2")).click();
		    
		    Thread.sleep(1000);
		    
		    driver.switchTo().alert().accept();
		  
		    
		    driver.findElement(By.id("email")).click();
		    driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys("marioRossi60@gmail.com");
		    driver.findElement(By.id("password")).click();
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("12345678");
		    driver.findElement(By.id("loginsubmit")).click();
		   
		    
		    driver.findElement(By.id("imageLogo")).click();
		    
		    driver.findElement(By.id("video2")).click();
		    
		    Thread.sleep(1000);
		    
		    driver.switchTo().alert().accept();
		    
		    Thread.sleep(1000);
		    
		    driver.findElement(By.linkText("abbonati")).click();
		    
		    Thread.sleep(1000);
		    
		    driver.findElement(By.id("abbonamentoSubmit")).click();
		    
		    Thread.sleep(1000);
		    
		    Alert al = driver.switchTo().alert();
		      // click on OK to accept with accept()
		      al.accept();
		    
		    /*driver.findElement(By.linkText("login")).click();
		    driver.findElement(By.id("email")).click();
		    driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys("marioRossi60@gmail.com");
		    driver.findElement(By.id("password")).click();
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("12345678");
		    driver.findElement(By.id("loginsubmit")).click();
		    driver.findElement(By.id("imageLogo")).click();
		    
		    driver.findElement(By.id("video2")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("video2")).click();
		    */
		    
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
