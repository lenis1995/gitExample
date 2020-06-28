package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment5_Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int in=0;
		String s="felicidad,paciencia,persistencia";
		char c='d';
		boolean b=false;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM "
				+ "CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,15);
		
		//	driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		WebElement topFrame=driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(topFrame);
		
		WebElement middleFrame=	driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(middleFrame);	
		
		String frameMessage=driver.findElement(By.cssSelector("div#content")).getText();
		System.out.println(frameMessage);
		
		driver.switchTo().parentFrame();
		//driver.findElement(By.cssSelector("div#content")).getText(); No lo puede encontrar ya que esta en el frame padre.
		
		driver.quit();
	}

}
