package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Learning git management 1");
		System.out.println("Learning git management 2");
		System.out.println("Learning git management 3");
		System.out.println("Learning git management 4");
		System.out.println("The last git example");
		
		System.out.println("This is the last one I promise");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM "
				+ "CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// April 23
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();

		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
				.contains("October")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}

		List<WebElement> dates = driver.findElements(By.className("day"));
		// Grab common attribute//Put into list and iterate
		int count = dates.size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();

			if (text.equalsIgnoreCase("19")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}
	}

}
