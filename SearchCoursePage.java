package FacultyReporting;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

public class SearchCoursePage {
	WebDriver driver;
	
	By course=By.linkText("Course catalog");
	By find=By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/div/div/div[1]/form/div/input");
	By search=By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/div/div/div[1]/form/div/div/button");
    By noresult=By.xpath("//*[@id=\"cm-content\"]/div/div[3]");
    By view=By.xpath("//*[@id=\"cm-content\"]/div/div[3]/div/div/div[1]/a/img");
   
    
	public SearchCoursePage(WebDriver driver)
	{
		this.driver = driver;
	}

	public boolean ELsearch()
	{
        boolean foundcourse=false;
		driver.findElement(course).click();
		driver.findElement(find).sendKeys("jira");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/div/div/div[2]/form/div/div/button/span/span"));
		dropdown.click(); 
		dropdown.findElement( By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/div/div/div[2]/form/div/div/div/div/ul/li[8]/a")).click();
		driver.findElement(search).click();
		
		try{
				driver.findElement(view);
				System.out.println("Course Displayed");
				foundcourse=true;
		    }
		   catch(NoSuchElementException e) {
			   System.out.println("Course not Exist");
			   foundcourse=true;
		   }
		
		return foundcourse;
	
	 }

}
