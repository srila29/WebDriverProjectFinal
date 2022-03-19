package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stubSystem.setProperty("webdriver.chrome.driver", "chromedriver.exe");//Register the driver - step 1
		WebDriver driver=new ChromeDriver();		
		driver.get("https://demo.guru99.com/test/upload/");// Open the website with the link - step 3
		driver.manage().window().maximize();//Maximise the chrome window
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //Wait time
		
		WebElement chooseFile=driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		chooseFile.sendKeys("F:\\Automation testing\\XPath calling methods.txt");
		
		WebElement terms=driver.findElement(By.xpath("//input[@id='terms']"));
		terms.click();
		WebElement submitBtn=driver.findElement(By.xpath("//button[@id='submitbutton']"));
		submitBtn.click();
		
		

	}

}
