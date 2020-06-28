package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment8_JSExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM "
				+ "CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait=new WebDriverWait(driver,15);
		
		//---------------------------------------------------------------------------------------------------------
		
		WebElement textField=driver.findElement(By.cssSelector("#autocomplete"));
		textField.click();
		textField.sendKeys("co");
		Thread.sleep(2000);
		textField.sendKeys(Keys.DOWN);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String script="return document.getElementById(\"autocomplete\").value;";
		String value=(String) js.executeScript(script);
		int count=0;
		
		while(!value.equalsIgnoreCase("MOROCCO") && count<10){
			
			textField.sendKeys(Keys.DOWN);
			//Thread.sleep(2000);
			value=(String) js.executeScript(script);
			System.out.println(value);
			count++;
		}
		
		if(count>10) {
			System.out.println("Element wasn't found");
		}else {
			System.out.println("Element successfully found");
		}
		driver.quit();
	}

}
