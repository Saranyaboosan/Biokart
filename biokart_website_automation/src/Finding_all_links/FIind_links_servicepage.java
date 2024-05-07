package Finding_all_links;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class FIind_links_servicepage 
{

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Biokart_automation_project\\Biokart\\Biokart\\biokart_website_automation\\driver_executables\\chromedriver.exe");
		
	WebDriver driver=new ChromeDriver();
	driver.get("https://biokart.com/services-2/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	List<WebElement> alllinks =driver.findElements(By.tagName("a"));
	int count=alllinks.size();
	System.out.println("total links and urls in service page="+count);
	System.out.println();
	for(int i=0;i<count;i++)
	{
		String text=alllinks.get(i).getText();
		String url=alllinks.get(i).getAttribute("href");
		System.out.println(i+1 +" : " +text);
		Thread.sleep(500);
		
	}
	
	driver.quit();
}
}
