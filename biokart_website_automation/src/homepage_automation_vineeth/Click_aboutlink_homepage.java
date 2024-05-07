package homepage_automation_vineeth;

import java.io.OutputStream;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.google.common.io.Files;

public class Click_aboutlink_homepage {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Biokart_automation_project\\Biokart\\Biokart\\biokart_website_automation\\driver_executables\\chromedriver.exe");
		
	    // open the web browser by creating an object of Chromedriver class. 
		WebDriver driver =  new ChromeDriver(); 
		
		// implicitly wait for the browser to load completly. 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// navigate to the biokart website using get() , or navigate().to() method. of WebDriver interface. 
		
		driver.get("https://www.biokart.com");
		
		// implicitly wait for the browser to load completly. 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String actualtitle = driver.getTitle();
	    System.out.println(actualtitle);
		
	    //find the about link
		WebElement aboutlink = driver.findElement(By.xpath("(//a[@class='menu-link'])[2]"));
		// click on about link
		
		aboutlink.click();
		
		// check if about page is open or not. (take screenshot)
		
		String expectedtitle = "About – Biokart India Pvt Ltd";
		WebDriverWait wait = new WebDriverWait(driver,10);
		try {
			String actual_title = driver.getTitle();
			System.out.println(actual_title);
			
	         Boolean result = wait.until(ExpectedConditions.titleIs(expectedtitle));
		    if (result) {
		        System.out.println("Test case passed, title is matching.");
		    	// giving 2 seconds to wait till we close the browser compeletly.
		    	
		    	// close the browser. 
		    	driver.close();
		    }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Test case failed, Title did not match.");
//		    ex.printStackTrace();
		    // screen shot code. 
		    TakesScreenshot ts = (TakesScreenshot) driver;
		    // take the screenshot and store it in the RAM location. 
		    java.io.File ram = ts.getScreenshotAs(OutputType.FILE);
		    // make a location on the hard disk to store the screenshot. 
		    Date d = new Date();
		    // Replace special characters in the file name.
		    String sanitizedTitle = expectedtitle.replace("&", "").replace("�", "-");
		    File hd = new File();

		    // copy the file from RAM to the hard disk location. 
//		    FileUtils.copyFile(ram, hd);
			// giving 2 seconds to wait till we close the browser compeletly.
			
			// close the browser. 
			driver.close();
		}}}


