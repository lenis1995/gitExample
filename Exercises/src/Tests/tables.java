package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM "
				+ "CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait=new WebDriverWait(driver,15);
		
		//--------------------------------------------------------------------------------------------------------------
		
		WebElement table=driver.findElement(By.cssSelector("div#innings_2 div:nth-of-type(1)"));
		int rowCount=table.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms")).size();
		System.out.println(rowCount); //Número de filas de la tabla
		int columnDataCount=table.findElements(By.cssSelector("[class='cb-col cb-col-8 text-right text-bold']")).size();
		System.out.println(columnDataCount);
		List<WebElement> columnData=table.findElements(By.cssSelector("[class='cb-col cb-col-8 text-right text-bold']"));
		System.out.println("\nLos datos de dicha columna son: \n");
		int sum=0;
		
		for(WebElement we:columnData){
			
			String data=we.getText();
			
			if(!we.getText().matches("[a-zA-Z]")) {
				int dataInt=Integer.parseInt(data);
				sum+=dataInt;
				System.out.println(dataInt);
			}
			
	    }
		System.out.println("\nLa suma sin extras es igual a: " + sum );
		String extras=table.findElement(By.xpath(".//div[@class='cb-col cb-col-60']//following-sibling::div")).getText();
		int extrasInt=Integer.parseInt(extras);
		
		
		int expecResul=Integer.parseInt(table.findElement(By.xpath(".//div[14]//div[contains(text(),'125')]")).getText());
		int actualResul=sum+extrasInt;
		System.out.println("\nLa suma con las extras es igual a:" + (actualResul));
		
		Assert.assertEquals(actualResul, expecResul);
		System.out.println("¡Test Passed!");
		
		driver.quit();	
   }
}

