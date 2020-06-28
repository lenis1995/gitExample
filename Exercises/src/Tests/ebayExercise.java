package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ebayExercise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM "
				+ "CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("http://www.ebay.com/");
		// Count of the Link in the Entire Page
		// System.out.println("Links in the Page");
		// System.out.println(driver.findElements(By.tagName("a")).size());
		// Count of links in the footer section of the page
		WebElement footer = driver.findElement(By.xpath(".//*[@id='glbfooter']"));
		// System.out.println("Links in the footer section");
		// System.out.println(footer.findElements(By.tagName("a")).size());
		WebElement col = driver.findElement(By.xpath(".//*[@id='gf-BIG']/table/tbody/tr/td[2]/ul"));
		// System.out.println("Links in the 2nd coloumn of the section");
		// System.out.println(col.findElements(By.tagName("a")).size());
		String Beforeclicking = null;
		String Afterclicking = null;
		;

		for (int i = 0; i < col.findElements(By.tagName("a")).size(); i++) {

			if (col.findElements(By.tagName("a")).get(i).getText().contains("Mapa del sitio")) {
				Beforeclicking = driver.getTitle();
				col.findElements(By.tagName("a")).get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		Afterclicking = driver.getTitle();
		
		if (Beforeclicking != Afterclicking) {
			if (driver.getPageSource().contains("Mapa del sitio"))

			System.out.println("PASS");
		}else{
			System.out.println("FAIL");
		}
		System.out.println(Beforeclicking);
        System.out.println(Afterclicking);
	}

}
