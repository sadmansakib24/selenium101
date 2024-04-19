package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnLocators {

	WebDriver driver;
	
	//init means initialization/setup
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://objectspy.space/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testLocators() {
		driver.findElement(By.name("firstname")).sendKeys("Selenium");
		driver.findElement(By.id("sex-0")).click();
		
		//upload file: make sure to define file name and extension
		driver.findElement(By.id("photo")).sendKeys("C:\\Users\\sadmansakib\\Downloads\\2023-09-24--Session 5.pptx");
		
		//link text
		driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
		driver.navigate().back();//goes back 
		
		//partial link text
		driver.findElement(By.partialLinkText("TF-API")).click();
		driver.navigate().back();
		
		//CSS Selector: TagName[attribute = ‘value’]	
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("is fun");;
		
		//TagName#Value	Note:(#)represents ID
		driver.findElement(By.cssSelector("input#exp-2")).click();
		
		//TagName[href$=‘value’]
		driver.findElement(By.cssSelector("a[href$='http://techfios.com/api-prod/api/']")).click();
		driver.navigate().back();
		
		//Absolute XPath 1slash: we dont work with this (only for interview)
		driver.findElement(By.xpath("html/body/div/div[2]/div[2]/form/div[13]/input")).sendKeys("passwordwhatever");
		
		//Relative XPath 2slash: //Tag[@Attribute Node=‘Value’]
		//driver.findElement(By.xpath("input[@name='Password']")).sendKeys("passwordwhatever");
		
		//multiple attribute: //Tag[@Attribute Node =‘Value’ and @Attribute Node =‘Value’]
		//driver.findElement(By.xpath("//input[@name='Password' and @type='password']")).sendKeys("passwordwhatever");
		
		//Xpath for links/text: //Tag[text()='Value']
		//driver.findElement(By.xpath("//strong[text()='Link Test : Page Change']")).click();
		
		//Xpath for links/text: //Tag[contains(text(),'Value')] --recommended method
		driver.findElement(By.xpath("//strong[contains(text(), 'Link Test : Page Change')]")).click();
		
		//copy as xpath: when u copy as xpath change it to the following
		//change asterisk(*) to tag name such as input
		
		//xpath Axes
		// //h2[@class='container__title_url-text container_lead-package__title_url-text']/ancestor::div[1]/following-sibling::div/descendant::span[1]
		
	}
		
}
