package TestingFaculty;

//import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import FacultyReporting.ELogin;
import FacultyReporting.ReportingPage;

public class ReportingTestCase{
	static WebDriver driver;
	
    static String driverPath = "E:\\Selenium123\\";
    
    @AfterTest
    public void closeAll()
    {
    	driver.close();
    }

  @BeforeTest
  public void verifylogin() 
	 	  	{
	  	
	  		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
	  		driver = new ChromeDriver();
	  		driver.get("http://elearningm1.upskills.in/");
	  		driver.manage().window().maximize();
	  		
	 	  	}
	  	// creating object of LoginPage class
  
	@Test
	public void Checklogin()
	{
			ELogin login = new ELogin(driver);
			boolean success=login.Login("veda", "1234");
			Assert.assertEquals(success, true);
	}
	@Test
	public void checkreport()
	{
		 boolean Userreport=false;
		 ReportingPage studlist = new ReportingPage(driver);
		 Userreport = studlist.report();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 Assert.assertEquals(Userreport,true);
		 
		 }
		 
	
  }	  		

			
  

