package homepage_automation_vineeth;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Opening_homepage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Biokart_automation_project\\Biokart\\Biokart\\biokart_website_automation\\driver_executables\\chromedriver.exe");
		
	WebDriver driver=new ChromeDriver();
	driver.get("https://biokart.com/");
	
	Thread.sleep(5000);


	
	driver.quit();
	}
	}
