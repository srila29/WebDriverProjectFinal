package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://demoqa.com/frames");// Open the website with the link - step 3
		driver.manage().window().maximize();//Maximise the chrome window
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //Wait time
		driver.switchTo().frame("frame1");//to select the framw to find the heading
		WebElement heading=driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(heading.getText());
		
		driver.switchTo().defaultContent();//To switch you back to the parent window from the current frame

	}

}
