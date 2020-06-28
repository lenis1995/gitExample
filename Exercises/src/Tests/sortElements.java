package Tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class sortElements {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM "
				+ "CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait=new WebDriverWait(driver,15);
		//------------------------------------------------------------------------------------------------------------
		
		List<WebElement> producElem=driver.findElements(By.cssSelector("#sortableTable tbody tr td:nth-child(2)"));
		ArrayList<String> producList=new ArrayList<String>();
		for(WebElement we:producElem) {producList.add(we.getText());}
		System.out.println(producList);

		ArrayList<String> ascProdLis=(ArrayList<String>) producList.clone();
		Collections.sort(ascProdLis);
		
		ArrayList<String> dscProdLis=(ArrayList<String>) producList.clone();
		Collections.sort(dscProdLis);
		Collections.reverse(dscProdLis);
		
		System.out.println(ascProdLis);
		System.out.println(dscProdLis);
		System.out.println("-----------------------------------------------------------------------------------------");
		
		Assert.assertNotEquals(dscProdLis, ascProdLis,"Test F");
		driver.quit();
		
		
	}

}
