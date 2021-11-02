package systemTesting;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FunzioniAdmin {
	
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	
	 @Test
	  public void testFunzioniAdminEffettuate() throws Exception {
		  System.setProperty("webdriver.gecko.driver",
				  "C:\\Users\\luisi\\Downloads\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		    driver = new FirefoxDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.get("http://localhost:8080/provaSmartCooking3/index.jsp");
		   
		    
		    driver.findElement(By.linkText("login")).click();
		    driver.findElement(By.id("email")).click();
		    driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys("paoloRossi80@gmail.com");
		    driver.findElement(By.id("password")).click();
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("12345678");
		    driver.findElement(By.id("loginsubmit")).click();
		    
		    driver.findElement(By.id("titolo")).click();
		    driver.findElement(By.id("titolo")).clear();
		    driver.findElement(By.id("titolo")).sendKeys("Pasta alla cenere di Luca Pappagallo");
		    
		   
		    
		    Select dropdownCategoria = new Select(driver.findElement(By.id("sel1")));
		    dropdownCategoria.selectByIndex(1);
		    
		    Select dropdownInsegnante = new Select(driver.findElement(By.id("sel2")));
		    dropdownInsegnante.selectByIndex(5);
		    
		    driver.findElement(By.id("file")).sendKeys("C:\\Users\\luisi\\Desktop\\videoTest.mp4");
		    driver.findElement(By.id("submitCaricamento")).click();
		    
		    Thread.sleep(1000);
		    driver.switchTo().alert().accept();
		    Thread.sleep(1000);
		    
		    driver.findElement(By.linkText("Lista Utenti")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.linkText("Lista Video")).click();
		    
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("window.scrollBy(0,900)");
		    
		    Thread.sleep(1000);
		    WebElement baseTable = driver.findElement(By.tagName("table"));
		    WebElement tableRow = baseTable.findElement(By.xpath("//tr[26]")); //should be the third row
		    WebElement cellIneed = tableRow.findElement(By.xpath("//td[5]"));
		    cellIneed.findElement(By.id("xButton")).click();
		    
		    
		    
		    
	  }
	/*
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  } 
	*/

}
