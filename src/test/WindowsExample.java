package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");//Register the driver - step 1
		//step 2 - Create an object for Web Driver Interface (Chrome Browser) -  Prerequiste - Download and Copy the chromedriver.exe in the project folder
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://demoqa.com/browser-windows");// Open the website with the link - step 3
		driver.manage().window().maximize();//Maximise the chrome window
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //Wait time
		
	WebElement btn=driver.findElement(By.xpath("//button[@id=\"windowButton\"]"));
	//If you want to click on new tab,instead of new window
		//WebElement btn=driver.findElement(By.xpath("//button[@id='tabButton']"));
		
		btn.click();
		
		String ParentWin=driver.getWindowHandle();
		System.out.println("Before clicking "+ ParentWin);
		
		Set <String> handles=driver.getWindowHandles();
		Iterator<String> itr=handles.iterator();
		System.out.println("After clicking");
		while (itr.hasNext())
		{
			String curWindow=itr.next();
			System.out.println(curWindow);
			if (!curWindow.equals(ParentWin))
			{
				driver.switchTo().window(curWindow);
			}
		}
		WebElement heading=driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(heading.getText());
		
		driver.switchTo().window(ParentWin);
		System.out.println("Back to parent window");
	    driver.close();
	    
		
		
	}

}
