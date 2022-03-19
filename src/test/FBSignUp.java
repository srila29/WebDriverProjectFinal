package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");//Register the driver - step 1
		//step 2 - Create an object for Web Driver Interface (Chrome Browser) -  Prerequiste - Download and Copy the chromedriver.exe in the project folder
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://www.facebook.com/");// Open the website with the link - step 3
		driver.manage().window().maximize();//Maximise the chrome window
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //Wait time
		
		WebElement CreateNewButton=driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")); 
		CreateNewButton.click();
		
		WebElement FirstName=driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement LastName=driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement Mobile=driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement Password=driver.findElement(By.xpath("//input[@id='password_step_input']"));
		WebElement gen=driver.findElement(By.xpath("//input[@value=2]"));
		
		WebElement day=driver.findElement(By.xpath("//select[@title='Day']"));
		WebElement month=driver.findElement(By.xpath("//select[@title='Month']"));
		WebElement year=driver.findElement(By.xpath("//select[@title='Year']"));
		
		
		
	  
		/*To find all the values of drop down list
		List<WebElement> months=driver.findElements(By.xpath("//select[@title='Month']/option"));
		List<WebElement> days=driver.findElements(By.xpath("//select[@title='Day']/option"));
		List<WebElement> years=driver.findElements(By.xpath("//select[@title='Year']/option"));
		
		WebElement CurrentMonth=driver.findElement(By.xpath("//select[@title='Month']/option[@selected='1']"));
		System.out.println(CurrentMonth.getText());
		
		
		for(WebElement elm:months)
		{
			System.out.println(elm.getText());
		}		
		*/
		
		
		String strGender="Male";//Radio button value
		
		String strGenXpath="//label[text()='"+strGender+"']//following-sibling::input"; //GenderXpath given dynamically based on strGender value
		
		
		WebElement Gender=driver.findElement(By.xpath(strGenXpath));//Gender object with dynamic xpath
		
		
		
		FirstName.sendKeys("Vishruth");
		LastName.sendKeys("Pallipuram");
		Mobile.sendKeys("001234");
		Password.sendKeys("Abc@1234");
		Select ddDay=new Select(day);
		ddDay.selectByVisibleText("14");
		Select ddMonth=new Select(month);
		ddMonth.selectByVisibleText("Jul");
		Select ddYear=new Select(year);
		ddYear.selectByVisibleText("2012");
		Gender.click();//Radio button selection
		
		

		}
}
