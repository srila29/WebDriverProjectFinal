package test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


		
public class DragandDrop {


	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");//Register the driver - step 1
		//step 2 - Create an object for Web Driver Interface (Chrome Browser) -  Prerequiste - Download and Copy the chromedriver.exe in the project folder
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://demo.guru99.com/test/drag_drop.html");// Open the website with the link - step 3
		driver.manage().window().maximize();//Maximise the chrome window
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //Wait time
		
		
		WebElement from=driver.findElement(By.xpath("//li[@id=\'fourth\']/a"));
		WebElement to=driver.findElement(By.xpath("//ol[@id=\'amt7\']/li"));
		Actions act=new Actions(driver);
		act.dragAndDrop(from, to).build().perform();
		
		
		
	}

}
