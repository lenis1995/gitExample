package Tests;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class assignment6_Swing {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM "
				+ "CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait=new WebDriverWait(driver,15);
		
		
		
		//----------------------------------------------------------------------------------------------------------
		
		WebElement globalCheck=driver.findElement(By.cssSelector("div#checkbox-example"));
		List<WebElement> options=globalCheck.findElements(By.tagName("input"));
		System.out.println(options.size());
		
	    String opc3=options.get(2).getAttribute("value");
		System.out.println(opc3);
		options.get(2).click();
		
		WebElement dropDown=driver.findElement(By.cssSelector("select#dropdown-class-example"));
		dropDown.click();
		new Select(dropDown).selectByValue(opc3);
		
		//-----------------------------------------------------------------------------------------------------------
		
		WebElement textField=driver.findElement(By.cssSelector("input#name"));
		textField.click();
		textField.sendKeys(opc3);
		
		driver.findElement(By.cssSelector("#alertbtn")).click();
		Thread.sleep(2000);
		
		String alertText=driver.switchTo().alert().getText();
		
		if(alertText.contains(opc3)) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test failed");
		}
		
		
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.quit();

	}

}
