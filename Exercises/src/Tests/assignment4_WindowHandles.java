package Tests;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment4_WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM "
				+ "CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,15);
		
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> id= ids.iterator();
		
		String winHan1=id.next();
		String winHan2=id.next();
		
		System.out.println(driver.switchTo().window(winHan2).getTitle());
		driver.close();
		Thread.sleep(1000);
		
		System.out.println(driver.switchTo().window(winHan1).getTitle());
		driver.close(); //For just close the current window
		
		System.out.println("Learning git management");
	}

}
