package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");//Register the driver - step 1 - Chrome browser
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");//Register the driver - step 1 - Firefox browser
		//step 2 - Create an object for Web Driver Interface (Chrome Browser) -  Prerequiste - Download and Copy the chromedriver.exe in the project folder
		WebDriver driver=new ChromeDriver();
		//OR
		//step 2 -Create an object for Web Driver Interface (Firefox Browser) -  Prerequiste -  Download and Copy the geckodriver.exe in the project folder
		//WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.simplilearn.com/");// Open the website with the link - step 3
		
		driver.manage().window().maximize();//Maximise the chrome window
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); // if network is slow, the screen will wait for 5 sec
		WebDriverWait wait=new WebDriverWait(driver, 50);
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));//Find the login link using linktext
		wait.until(ExpectedConditions.elementToBeClickable(LoginLink));
		
		Thread.sleep(5000); //To explicitly wait for specific time
		
		
		
		
		LoginLink.click();//Click on the login link
		
		WebElement UserName=driver.findElement(By.name("user_login")); // Object to find username textbox
		WebElement Password=driver.findElement(By.id("password")); // Object to find password textbox
		WebElement LoginButton= driver.findElement(By.name("btn_login")); //Object to find the login button
		WebElement RemMe= driver.findElement(By.className("rememberMe")); //Object to find the Remember Me check box
		UserName.sendKeys("xyz@gil.com"); //Enter test value for username
		Password.sendKeys("Abc_12345"); //Enter test password
		RemMe.click(); //TO Enable REmember me
		LoginButton.click(); // To click on Login button
		
		WebElement ErrorMsg=driver.findElement(By.id("msg_box")); //Object to find the error element on the webpage
		String ActualMsg=ErrorMsg.getText(); //Error message text is fetched in a string variable
		String ExpMsg="The email or password you have entered is valid.";//Wrong message to fail the TC is given as expected message
		if(ActualMsg.endsWith(ExpMsg)) //Comparing actual and expected error msg
		{
			System.out.println("Test case Passed");
			
		}
		else
		{
			System.out.println("Test case Failed");
		}
		
		
		List<WebElement> links=driver.findElements(By.tagName("a")); //All the links from the webpage are fetched in a List using the link tag name "a"
		
		System.out.println("Total number of links are : "+ links.size()); //Print the total number of links by using the size of list
		
		for(WebElement elm:links) //Looping to traverse through the list
		{
			System.out.println(elm.getAttribute("href")); //Print the Href attribute's value of all the tags in the list by accessing through list element get attribute method
		}
		
		
		
		driver.close(); //Closing the driver object to close the chrome
				
		

	}

}
