package com.guvi.Task22;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownSync {
	
	public static WebDriver driver;
	
		public static void main(String[] args) {
		
		// WebDriver driver = new ChromeDriver();
		
		driver = new ChromeDriver();
		
		driver.get("https://phptravels.com/demo/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement firstNameField = driver.findElement(By.xpath("//input[@name ='first_name']"));
		firstNameField.sendKeys("Selenium");
		
		WebElement lastNameField = driver.findElement(By.xpath("//input[@name ='last_name']"));
		lastNameField.sendKeys("Testing");
		
		WebElement businessField = driver.findElement(By.xpath("//input[@name ='business_name']"));
		businessField.sendKeys("Software Testing");
		
		WebElement email = driver.findElement(By.xpath("//input[@name ='email' and @placeholder = 'Email']"));
		email.sendKeys("test@test.com");
		
		WebElement num1 = driver.findElement(By.xpath("//span[@id = 'numb1']"));
		String value1 = num1.getText();
		
		WebElement num2 = driver.findElement(By.xpath("//span[@id = 'numb2']"));
		String value2 = num2.getText();
		
		int sum = Integer.parseInt(value1)+Integer.parseInt(value2);
		String sumvalue = Integer.toString(sum);
		
		WebElement resultField = driver.findElement(By.xpath("//input[@id = 'number']"));
		resultField.sendKeys(sumvalue);
		
		WebElement submitButton = driver.findElement(By.xpath("//button[@id = 'demo']"));
		submitButton.click();
		
		String expectedText = "Instant demo request form";
		
		WebElement message = driver.findElement(By.xpath("//h2[@class = 'text-start fs-4']"));
		String actualText = message.getText();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(message));
		
		if(actualText.contentEquals(expectedText))
		{
			System.out.println("Form is Submitted");
			takeSS("Screenshot"); // call the method to take Screenshot
		}
		else
		{
			System.out.println("Form is not Submitted");
		}
		
		driver.quit();
	}
	
		public static void takeSS(String filename)
		{
			String location = System.getProperty("user.dir") + "/"+ filename + ".png";
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(location);
			
			try {
				FileHandler.copy(source, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
		
}


