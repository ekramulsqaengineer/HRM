package HRM;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;




public class Logout extends Base{

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();   // <-- resolves & sets the driver
		 ChromeOptions options = new ChromeOptions();
		    Map<String, Object> prefs = new HashMap<>();
		    prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);
		    prefs.put("password_manager_enabled", false);
		    prefs.put("profile.password_manager_leak_detection", false);
		    options.setExperimentalOption("prefs", prefs);
		    options.addArguments("--disable-features=PasswordManager");
		    options.addArguments("--disable-save-password-bubble");
		    WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://hrm-solutions.betopiagroup.com/auth/login");
		Thread.sleep(2000);
		driver.manage().window().maximize();
			
		WebDriverWait wait1 = new WebDriverWait(driver, 10); // Reuse or re-initialize wait
		wait1.until(ExpectedConditions.elementToBeClickable(By.name("identifier"))).sendKeys("ekramul.haque@betopialimited.com");
	    
		WebDriverWait wait2 = new WebDriverWait(driver, 10); // Reuse or re-initialize wait
		wait2.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys("Haque123");
		
		WebDriverWait wait3 = new WebDriverWait(driver, 10); // Reuse or re-initialize wait
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/div/div[2]/div/form/button/span/span"))).click();
		Thread.sleep(3000);	
		String header = driver.findElement(By.xpath("/html/body/div[4]/div[1]/aside/nav/div[1]/a/span[2]")).getText();
		
		if (header!= null) {
			System.out.println("header: "+header);
			if (header.equals("Dashboard")) {
				System.out.println("Test Pass");
			} else {
				System.out.println("Test Fail");
			} 
			
			
		}
		//////////////// call other function
			
		logout(driver);
		
	}
	
	
	public static void logout(WebDriver driver) throws InterruptedException {
		
		
		WebDriverWait wait4 = new WebDriverWait(driver, 10); // Reuse or re-initialize wait
		wait4.until(ExpectedConditions.elementToBeClickable(By.className("text-xs"))).click();
		
		WebDriverWait wait5 = new WebDriverWait(driver, 10); // Reuse or re-initialize wait
		wait5.until(ExpectedConditions.elementToBeClickable(By.className("block"))).click();
		Thread.sleep(2000);
		String forgot = driver.findElement(By.linkText("Forgot Password?")).getText();
		Thread.sleep(2000);
		if (forgot!= null) {
			System.out.println("forgot: "+forgot);
			if (forgot.equals("Forgot Password?")) {
				System.out.println("Test Pass");
			} else {
				System.out.println("Test Fail");
			} 
		}
		
	}

}
