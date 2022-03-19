package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");//Register the driver - step 1
		//step 2 - Create an object for Web Driver Interface (Chrome Browser) -  Prerequiste - Download and Copy the chromedriver.exe in the project folder
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");// Open the website with the link - step 3
		driver.manage().window().maximize();//Maximise the chrome window
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //Wait time
		
		List<WebElement> tbRows=driver.findElements(By.xpath("//table[@id=\"customers\"]//tr"));
	//	List<WebElement> tbRows=driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")); Alternate XPATH (longer one)
		
		
		System.out.println("Total number of rows are "+tbRows.size());
		
		List<WebElement> tbCols=driver.findElements(By.xpath("//table[@id=\"customers\"]//th"));
		
		//List<WebElement> tbCols=driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr/th"));Alternate XPATH
		
	
		
		System.out.println("Total number of rows are "+tbCols.size());
		//To print the whole row no 3
		List<WebElement> tbData=driver.findElements(By.xpath("//table[@id=\"customers\"]//tr[4]/td"));
		
		for(WebElement elm:tbData)
		{
			System.out.println(elm.getText());
		}
	
		//To print all the data in first column with the heading
		WebElement tbHeadingColumns=driver.findElement(By.xpath("//table[@id=\"customers\"]//th[1]"));
		System.out.println("The first column Heading is :"+tbHeadingColumns.getText());
	/*	List<WebElement> tbDataColumns=driver.findElements(By.xpath("//table[@id=\"customers\"]//td[1]"));
		for(WebElement elm:tbDataColumns)
		{
			System.out.println(elm.getText());
		}*/
		
		
		//XPath to find the data runtime 
		int col=1;
		List<WebElement> tbDataColumn=driver.findElements(By.xpath("//table[@id=\"customers\"]//td["+col+"]"));
	
		for(WebElement elm:tbDataColumn)
		{
			System.out.println(elm.getText());
		}
		
		//XPATH by searching trough a text -  " //td[text()='Island Trading']//parent::tr/td"
		
		
		
	}

}
