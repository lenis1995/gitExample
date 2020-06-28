package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class actionsExercise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//Inicialize webdriver and open the browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM "
				+ "CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,15);
		
		Actions webActions=new Actions(driver);
		
		WebElement signIn=driver.findElement(By.cssSelector("div.nav-signin-tt.nav-flyout"));
		wait.until(ExpectedConditions.invisibilityOf(signIn));
		WebElement languages=driver.findElement(By.cssSelector("#icp-nav-flyout"));
		webActions.moveToElement(languages).build().perform();
		
		
		WebElement radBotEng=driver.findElement(By.xpath("//div[@id='nav-flyout-icp']//span[contains(text(),'Português')]"));
		wait.until(ExpectedConditions.visibilityOf(radBotEng));
        webActions.moveToElement(radBotEng).click().build().perform();
        
        Thread.sleep(1000);
       
        WebElement searchBar=driver.findElement(By.id("twotabsearchtextbox"));
        wait.until(ExpectedConditions.urlMatches("language=pt_BR"));
        webActions
        .moveToElement(searchBar)
        .click()
        .keyDown(Keys.SHIFT)
        .sendKeys("playstation")
        .keyUp(Keys.SHIFT)
        .sendKeys(" 5")
        .doubleClick()
        .build().perform();
        
        
        driver.quit();
	}

}
