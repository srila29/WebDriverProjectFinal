package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbLogin {
	

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");//Register the driver - step 1
			//step 2 - Create an object for Web Driver Interface (Chrome Browser) -  Prerequiste - Download and Copy the chromedriver.exe in the project folder
			WebDriver driver=new ChromeDriver();
			
			
			driver.get("https://www.facebook.com/");// Open the website with the link - step 3
			
			driver.manage().window().maximize();//Maximise the chrome window
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //Wait time
			
			WebElement UserName=driver.findElement(By.xpath("//input[@name='email']"));
			WebElement Password=driver.findElement(By.xpath("//input[@name=\"pass\"]"));
			WebElement LoginButton=driver.findElement(By.xpath("//button[@name=\"login\"]"));
			
			UserName.sendKeys("xyz@gil.com"); //Enter test value for username
			Password.sendKeys("Abc_12345"); //Enter test password
			LoginButton.click(); // To click on Login button  
			
			WebElement CreateNewButton=driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")); 
			// or WebElement CreateNewButton=driver.findElement(By.xpath("//*[text()='Create new account']"));  or //*[contains(@data-testid,'open-registration')]
			CreateNewButton.click();
			
			

}
}
