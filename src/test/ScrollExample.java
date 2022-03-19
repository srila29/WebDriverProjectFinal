package test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


		
public class ScrollExample {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");//Register the driver - step 1
		//step 2 - Create an object for Web Driver Interface (Chrome Browser) -  Prerequiste - Download and Copy the chromedriver.exe in the project folder
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");// Open the website with the link - step 3
		driver.manage().window().maximize();//Maximise the chrome window
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //Wait time
		
		WebElement element=driver.findElement(By.xpath("//h2[text()='Table Rows']"));
		JavascriptExecutor obj=(JavascriptExecutor) driver;
		obj.executeScript("arguments[0].scrollIntoView();", element);
		
		//scroll down
		obj.executeScript("window.scrollTo(0,document.body.ScrollHeight);");

		//scroll up
	obj.executeScript("window.scrollTo(0,-document.body.ScrollHeight);");
		
		
	}
	
	

}
