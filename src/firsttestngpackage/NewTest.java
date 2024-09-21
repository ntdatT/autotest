package firsttestngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import java.util.Random; 
public class NewTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the Firefox executable
        System.setProperty("webdriver.gecko.driver", "C:\\selenium webdriver\\geckodriver-v0.35.0-win64\\geckodriver.exe");
        // Initialize the FirefoxDriver
        driver = new FirefoxDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void testSetup() {
    	//open page
        driver.get("https://stage.moosocial.com/php81/dat/moo321v7/home");
    }

    public static String generateRandomString(int length) { 
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; 
        Random random = new Random(); 
        StringBuilder result = new StringBuilder(length); 
         
        for (int i = 0; i < length; i++) { 
            int index = random.nextInt(characters.length()); 
            result.append(characters.charAt(index)); 
        } 
         
        return result.toString(); 
    } 

	@Test(description = "Verify sign-in funtion succcess")
    public void verifySignIn() throws InterruptedException {
    	String filePath = "C:\\Users\\acer\\OneDrive\\Pictures\\download.jpg";
    	String randomString = generateRandomString(10);
        // Generates a random string of length 10 
        System.out.println("Random String: " + randomString);
   
    	// Open sign-in
    	driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/div[2]/a[2]")).click();
    	//input names
    	driver.findElement(By.name("data[name]")).sendKeys(randomString);
    	//input email
    	driver.findElement(By.name("data[email]")).sendKeys(randomString+"@aa.com");
    	// input pass and confirm pass then sleep 2s
    	driver.findElement(By.name("data[password]")).sendKeys("123456");
    	driver.findElement(By.name("data[password2]")).sendKeys("123456");
    	Thread.sleep(2000);
    	//Click continue then sleep 2s
    	driver.findElement(By.id("submitFormsignup")).click();
    	Thread.sleep(2000);
    	
    	//Click photo upload
    	driver.findElement(By.xpath("//*[@id=\"profile_picture\"]")).click();
		//Initializing a Robot Class.
		Robot rb = null;
		try {
		  rb = new Robot();
		} catch (AWTException e) {
		  e.printStackTrace();
		}
		// Copy File path vào Clipboard
		StringSelection str = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	
		Thread.sleep(1000);
		  
		// Nhấn Control+V để dán
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		// Xác nhận Control V trên
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		Thread.sleep(1000);

		// Nhấn Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(4000);
	    // Click Month dropdown list & Select "January"
	    driver.findElement(By.xpath("//*[@id=\"regFields\"]/div[6]/div/div[1]/div")).click();
	    driver.findElement(By.xpath("//*[@id=\"regFields\"]/div[6]/div/div[1]/div/ul/li[2]")).click();
	    // Click Day dropdown list & Select "3"
	    driver.findElement(By.xpath("//*[@id=\"regFields\"]/div[6]/div/div[2]/div/div")).click();
	    driver.findElement(By.xpath("//*[@id=\"regFields\"]/div[6]/div/div[2]/div/div/ul/li[4]")).click(); 
	    // Click year dropdown list & Select year
	    driver.findElement(By.xpath("//*[@id=\"regFields\"]/div[6]/div/div[3]/div")).click();   
	    driver.findElement(By.xpath("//*[@id=\"regFields\"]/div[6]/div/div[3]/div/ul/li[38]")).click();   
	    //check the checkbox 
	    driver.findElement(By.xpath("//*[@id=\"regFields\"]/div[11]/label/span")).click();  
	    //click submit
	    driver.findElement(By.xpath("//*[@id=\"step2Submit\"]")).click();  
	    Thread.sleep(5000);
	    // Verify title after sign up
	    String expectedTitle = "Home Page | moo321v7";
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void afterMethod() { 
        // Clean up after each test method (e.g., close any pop-ups, reset state, etc.)
    }

    @AfterClass
    public void afterClass() {
        // Clean up after all test methods (e.g., close the browser)
//        driver.quit();
    }
}
//update thu lan 3