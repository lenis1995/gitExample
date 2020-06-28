package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment7_Tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM "
				+ "CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait=new WebDriverWait(driver,15);
		
		WebElement table=driver.findElement(By.xpath("//table[@id='product']"));
		int rowCount=table.findElements(By.tagName("tr")).size();
		System.out.println(rowCount);
		int columns=table.findElements(By.tagName("td")).size();
		int columnCount=columns/(rowCount-1);
		System.out.println(columnCount);
		
		WebElement row2=table.findElement(By.xpath(".//tbody/tr[3]"));
		List<WebElement> row2Items=row2.findElements(By.tagName("td"));
		
		for(WebElement we:row2Items) {
			System.out.println(we.getText());	
			
		driver.quit();
		}
    }

}
