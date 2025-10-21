package HRM;


import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import net.bytebuddy.asm.Advice.This;



public class Base extends ExtentReportsDemo{
	//web driver setup//
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Betopia\\eclipse-workspace\\hrm-solutions.betopiagroup\\driver\\chromedriver.exe"); 
		 Thread.sleep(2000);
		 //web driver setup end//
		 // extend report//
		 ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/extent-report.html");
		 
		 // 2️⃣ Create ExtentReports object and attach reporter
	     ExtentReports extent = new ExtentReports();
	     extent.attachReporter(reporter);

	     // 3️⃣ Create test
	      ExtentTest test = extent.createTest("Betopia HRM", "Betopia HRM Application Test Case");
	        
		 // extend report end//
	
		 
		 //google Password popup Handle /start/
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
			//google Password popup Handle end//
		
		   //get url//
		   Thread.sleep(2000);
		   test.log(Status.INFO, "Go To URl");
		   test.pass("Opened Betopia HRM successfully!");
		   driver.get("https://hrm-solutions.betopiagroup.com/auth/login");
		   test.log(Status.INFO, "maximize Url");
		   driver.manage().window().maximize();
		   extent.flush();
		   //get url end//
//		
//		   //Function Call
//		
	       Login(driver);
		   logout(driver);
	      }

	     //login function///
	public static void Login(WebDriver driver) throws InterruptedException {
		
	
		WebDriverWait wait1 = new WebDriverWait(driver, 10); // Reuse or re-initialize wait
		wait1.until(ExpectedConditions.elementToBeClickable(By.name("identifier"))).sendKeys("ekramul.haque@betopialimited.com");
		
		WebDriverWait wait2 = new WebDriverWait(driver, 10); // Reuse or re-initialize wait
		wait2.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys("Haque123");
		
		WebDriverWait wait3 = new WebDriverWait(driver, 10); // Reuse or re-initialize wait
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/div/div[2]/div/form/button/span/span"))).click();
		Thread.sleep(2000);
		String header = driver.findElement(By.xpath("/html/body/div[4]/div[1]/aside/nav/div[1]/a/span[2]")).getText();
		
		if (header!= null) {
			System.out.println("header: "+header);
			if (header.equals("Dashboard")) {
				System.out.println("Test Pass");
			} else {
				System.out.println("Test Fail");
			} 
		}
	}
	
	
	// In your logout function
			public static void logout(WebDriver driver) throws InterruptedException {
				
				WebDriverWait wait4 = new WebDriverWait(driver, 10); // Reuse or re-initialize wait
				wait4.until(ExpectedConditions.elementToBeClickable(By.className("text-xs"))).click();
				
				WebDriverWait wait5 = new WebDriverWait(driver, 10); // Reuse or re-initialize wait
				wait5.until(ExpectedConditions.elementToBeClickable(By.className("block"))).click();
				
			    Thread.sleep(2000); // Give time for the page to redirect

			    // Verify successful logout by checking for login page elements
			    try {
			        boolean loginFieldVisible = driver.findElement(By.name("identifier")).isDisplayed();
			        boolean passwordFieldVisible = driver.findElement(By.name("password")).isDisplayed();
			        if (loginFieldVisible && passwordFieldVisible) {
			            System.out.println("Logout Test Pass: Returned to Login Page.");
			        } else {
			            System.out.println("Logout Test Fail: Did not return to Login Page or elements not found.");
			        }
			    } catch (org.openqa.selenium.NoSuchElementException e) {
			        System.out.println("Logout Test Fail: Login page elements not found after logout.");
			    }
			    driver.close();
			}
			
			// 	end your logout function
			
}
