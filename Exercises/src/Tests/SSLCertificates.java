package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertificates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SSl certificates

		//Desired capabilities=
		//general chrome profile
		DesiredCapabilities ch=DesiredCapabilities.chrome();
		//ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		String browName=ch.getBrowserName();
		System.out.println(browName);
		//ch.setAcceptInsecureCerts(true);
		    
		    for(String s:ch.getCapabilityNames()) {
		    	System.out.println(s);
		    }
		    
		//Belows to your local browser
		ChromeOptions c= new ChromeOptions();
		c.merge(ch);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\"
				         + "CURSO SELENIUM CON JAVA\\CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(c);
	    System.out.println(ch.getVersion());
	}

		


		
}

