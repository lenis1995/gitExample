package Tests;


import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fbLinksExample {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM "
				+ "CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://es-la.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait=new WebDriverWait(driver,15);
		
		//----------------------------------------------------------------------------------------------------------
		
		WebElement pageFooter=driver.findElement(By.cssSelector("div#pageFooterChildren"));
		List<WebElement> pageFooterLinks=pageFooter.findElements(By.tagName("a"));
		int numOfLinks=pageFooterLinks.size();
		String keyStroke=Keys.chord(Keys.CONTROL,Keys.ENTER);
		System.out.println(numOfLinks);
		
		for(int i=0;i<numOfLinks;i+=5) {
			
			pageFooterLinks.get(i).sendKeys(keyStroke);
			Thread.sleep(3000);
		}
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> iterator=handles.iterator();
		
		while(iterator.hasNext()) {
			
			driver.switchTo().window(iterator.next());
			System.out.println(driver.getTitle());
		}
		
		
	}

}
