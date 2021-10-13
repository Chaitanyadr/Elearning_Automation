package TestingFaculty;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import FacultyReporting.ELogin;
import FacultyReporting.SearchCoursePage;

public class SearchCourseTestCase{
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
  
	@Test(priority=1)
	public void CheckLogin()
	{
			ELogin login = new ELogin(driver);
			boolean success=login.Login("veda", "1234");
			Assert.assertEquals(success, true);
	}
	@Test(priority=2)
	public void checkcourse()
	{
		boolean found=false;
		 SearchCoursePage courselist = new SearchCoursePage(driver);
		 found = courselist.ELsearch();
		 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		 Assert.assertEquals(found,true);
	}
 
	 	        	 
}

	
			


