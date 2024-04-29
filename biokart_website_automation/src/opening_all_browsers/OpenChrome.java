package opening_all_browsers;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class OpenChrome 
{
  public static void main(String[] args) throws InterruptedException, IOException {
	  // set the system properties to open chrome browser
<<<<<<< HEAD
	System.setProperty("webdriver.chrome.driver", 
			"D:\\ecoders_production_applications\\biokart\\testing\\Biokart\\biokart_website_automation\\driver_executables\\chromedriver.exe");
=======
	System.setProperty("webdriver.chrome.driver", "D:\\ecoders_testing_project\\biokart_testing_project\\Biokart\\Biokart\\biokart_website_automation\\driver_executables\\chromedriver.exe");
>>>>>>> beafad3a22b1bb8471f4fb75d6bae0f50747fa0b
	
    // open the web browser by creating an object of Chromedriver class. 
	WebDriver driver =  new ChromeDriver(); 
	
	// implicitly wait for the browser to load completly. 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	// updated code for implicitlyWait using Duration class,
<<<<<<< HEAD
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
=======
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
>>>>>>> beafad3a22b1bb8471f4fb75d6bae0f50747fa0b
	
	// navigate to the biokart website using get() , or navigate().to() method. of WebDriver interface. 
	
	driver.get("https://www.biokart.com");
	
	// implicitly wait for the browser to load completly. 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	String actualtitle = driver.getTitle();
    System.out.println(actualtitle);
	
//	String expectedTitle = "Biokart India Pvt Ltd &#8211; Bringing Biotech Closer!";
<<<<<<< HEAD
	String expectedTitle = "Biokart India Pvt Ltd – Bringing Biotech Closer!";
=======
	String expectedTitle = "Biokart India Pvt Ltd � Bringing Biotech Closer!";
>>>>>>> beafad3a22b1bb8471f4fb75d6bae0f50747fa0b
//	Expected condition failed: waiting for title to be "Biokart India Pvt Ltd &#8211; Bringing Biotech Closer!". Current title: "Biokart India Pvt Ltd � Bringing Biotech Closer!
	
	// check if the title of the biokart.com is matching or not. 

	// check if the title of the biokart.com is matching or not. 
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
<<<<<<< HEAD
	WebDriverWait wait = new WebDriverWait(driver,10);
=======
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
>>>>>>> beafad3a22b1bb8471f4fb75d6bae0f50747fa0b
	try {
	    Boolean element = wait.until(ExpectedConditions.titleIs(expectedTitle));
	    if (element) {
	        System.out.println("Test case passed, title is matching.");
	    	// giving 2 seconds to wait till we close the browser compeletly.
	    	Thread.sleep(2000);
	    	
	    	// close the browser. 
	    	driver.quit();
	    }
	} catch (Exception ex) {
		System.out.println("Test case failed, Title did not match.");
//	    ex.printStackTrace();
	    // screen shot code. 
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    // take the screenshot and store it in the RAM location. 
	    File ram = ts.getScreenshotAs(OutputType.FILE);
	    // make a location on the hard disk to store the screenshot. 
	    Date d = new Date();
	    // Replace special characters in the file name.
	    String sanitizedTitle = expectedTitle.replace("&", "").replace("�", "-");
<<<<<<< HEAD
	    File hd = new File("D:\\ecoders_production_applications\\biokart\\testing\\Biokart\\biokart_website_automation\\failed_screenshots\\" + sanitizedTitle + "_" + d.getTime() + ".jpg");
=======
	    File hd = new File("D:\\ecoders_testing_project\\biokart_testing_project\\Biokart\\Biokart\\biokart_website_automation\\failed_screenshots" + sanitizedTitle + "_" + d.getTime() + ".jpg");
>>>>>>> beafad3a22b1bb8471f4fb75d6bae0f50747fa0b
	    // copy the file from RAM to the hard disk location. 
	    Files.copy(ram, hd);
		// giving 2 seconds to wait till we close the browser compeletly.
		Thread.sleep(2000);
		
		// close the browser. 
		driver.quit();
	}

	//similarly we can check if the url of the biokart page is matching or not. 
	
	

  }
}
