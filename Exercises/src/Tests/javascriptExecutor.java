package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javascriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM "
				+ "CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait=new WebDriverWait(driver,15);
		
		//---------------------------------------------------------------------------------------------------------
		
		WebElement textField=driver.findElement(By.cssSelector("#fromPlaceName"));
		textField.click();
		textField.sendKeys("ben");
		Thread.sleep(2000);
		textField.sendKeys(Keys.DOWN);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String script="return document.getElementById(\"fromPlaceName\").value;";
		String value=(String) js.executeScript(script);
		int count=0;
		
		while(!value.equalsIgnoreCase("RANEBENNUR") && count<10){
			
			textField.sendKeys(Keys.DOWN);
			Thread.sleep(2000);
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
