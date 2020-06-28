package Tests;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class multipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM "
				+ "CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signup");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,15);
		
		// Title before clicking on Support
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector("[id='initialView'] footer ul  li a")).click();
		
		
		Set<String> windowIds=driver.getWindowHandles();
		Iterator<String> id=windowIds.iterator();
		
		String wh1=id.next();
		String wh2=id.next();
		
		driver.switchTo().window(wh2);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(wh1);
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(wh2);
		driver.close();
	}

}
