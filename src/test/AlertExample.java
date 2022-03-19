package test;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://demoqa.com/alerts");// Open the website with the link - step 3
		driver.manage().window().maximize();//Maximise the chrome window
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //Wait time
		// =============== Alert Accept
		WebElement btn1=driver.findElement(By.xpath("//button[@id='alertButton']"));
		btn1.click();
		
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		//Alert Cancel/Dismiss
		WebElement btn2=driver.findElement(By.xpath("//button[@id='confirmButton']"));
		btn2.click();
		
		Alert alert1=driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.dismiss();
		//Alert with message
		WebElement btn3=driver.findElement(By.xpath("//button[@id='promtButton']"));
		btn3.click();
		
		Alert alert2=driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.sendKeys("Srilakshmi");
		alert2.accept();
		
		WebElement btn4=driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
		btn4.click();
		WebDriverWait wait=new WebDriverWait(driver, 5);
		System.out.println("5 seconds");
		Alert alert3=wait.until(ExpectedConditions.alertIsPresent());
		//Alert alert3=
		System.out.println(alert3.getText());
		alert3.accept();
			
		driver.close();

	}

}
