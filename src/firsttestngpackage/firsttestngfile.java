package firsttestngpackage;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class firsttestngfile {
    public String baseUrl = "https://www.demo.guru99.com/V4/";
    String driverPath = "C:\\selenium webdriver\\geckodriver-v0.35.0-win64\\geckodriver.exe";
    public WebDriver driver ; 
     
  @Test
  public void verifyHomepageTitle() {
       
      System.out.println("verify Homepage Title"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);
      String expectedTitle = "Guru99 Bank Home Page";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.quit();
  }
  @Test
  public void verifyLoginValidUsernameandPass() {
      
      System.out.println("verify Login Valid Username and Passwor"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);
      driver.findElement(By.name("uid")).sendKeys("mngr588682");
      driver.findElement(By.name("password")).sendKeys("YtEvAgu");
      driver.findElement(By.name("btnLogin")).click();
      String expectedTitle = "Guru99 Bank Manager HomePage";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.quit();
  }
  @Test
  public void verifyLogininValidUsernameandvalidPass1() {
      
      System.out.println("verify Login Valid Username and Passwor"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);
      driver.findElement(By.name("uid")).sendKeys("mngr588681");
      driver.findElement(By.name("password")).sendKeys("YtEvAgu");
      driver.findElement(By.name("btnLogin")).click();
      String expectedText = "User or Password is not valid";
      String actualText = driver.switchTo().alert().getText();
      Assert.assertEquals(expectedText, actualText);
      driver.quit();
  }
  @Test
  public void verifyLogininValidUsernameandvalidPass() {
      
      System.out.println("verify Login Valid Username and Passwor"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);
      driver.findElement(By.name("uid")).sendKeys("mngr588601");
      driver.findElement(By.name("password")).sendKeys("YtEvAgufasfas!@#$");
      driver.findElement(By.name("btnLogin")).click();
      String expectedText = "User or Password is not valid";
      String actualText = driver.switchTo().alert().getText();
      Assert.assertEquals(expectedText, actualText);
      driver.quit();
  }
  @Test
  public void verifyLogininValidUsernameandinvalidPass() {
      
      System.out.println("verify Login Valid Username and Passwor"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);
      driver.findElement(By.name("uid")).sendKeys("mngr588681");
      driver.findElement(By.name("password")).sendKeys("YtEvAsdadasasdgusad");
      driver.findElement(By.name("btnLogin")).click();
      String expectedText = "User or Password is not valid";
      String actualText = driver.switchTo().alert().getText();
      Assert.assertEquals(expectedText, actualText);
      driver.quit();
  }
}