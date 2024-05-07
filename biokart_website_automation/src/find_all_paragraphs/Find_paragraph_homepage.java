package find_all_paragraphs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Find_paragraph_homepage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Biokart_automation_project\\Biokart\\Biokart\\biokart_website_automation\\driver_executables\\chromedriver.exe");
		
	WebDriver driver=new ChromeDriver();
	driver.get("https://biokart.com/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	List<WebElement> allpara =driver.findElements(By.tagName("p"));
	int count=allpara.size();
	System.out.println("total patragraphs in homepage="+count);
	
	
	System.out.println();
	
	
	for(int i=0;i<count;i++)
	{
		String text=allpara.get(i).getText();
		System.out.println(i+1+" : "+text);
		System.out.println("\n**************************************************************\n");
		
		Thread.sleep(500);
		
	}
	
	driver.quit();

	}

}
