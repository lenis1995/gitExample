package Tests;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dragDropFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM "
				+ "CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,15);
		
		List<WebElement> frameList=driver.findElements(By.tagName("iframe"));
		WebElement frame1=driver.findElement(By.cssSelector("iframe.demo-frame"));
		System.out.println(frameList.size());
		
		driver.switchTo().frame(frameList.get(0));
		//driver.switchTo().frame(frame1);
		
		WebElement source=driver.findElement(By.cssSelector("div#draggable"));
		WebElement target=driver.findElement(By.cssSelector("div#droppable"));
		
		Actions driverActions=new Actions(driver);
				                  
		driverActions
		.dragAndDrop(source,target)
        .build().perform();
		
		
        driver.switchTo().defaultContent();
        driver.quit();
	}
	

}
