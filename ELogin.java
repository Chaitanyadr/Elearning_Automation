package FacultyReporting;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


 //This class will store all the locators and methods of Login page
 
public class ELogin {
static WebDriver driver;	

By username= By.id("login");

By password = By.id("password");
By loginbutton = By.id("form-login_submitAuth");

By footerText = By.xpath("//*[contains(text(),'Administrator')]/parent::div");
By SignUpButton = By.linkText("Sign up!");


//creating parameterized constructor to initialize WebDriver reference
public ELogin(WebDriver driver)
{
	this.driver =driver;
	//System.out.println("Elogin as been instantiated");
}

public boolean isHeaderFound()

{
	
	boolean found=false;
	try {
		
		WebElement element = driver.findElement(footerText);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Dashboard header present in page?
		found=driver.findElement(footerText).isDisplayed();
	}
	
	catch (NoSuchElementException e)
	{
		found=false;
	}
	
	return found;
	
}	
	

	public boolean Login(String un,String pw)
	{
		//WebElement element = driver.findElement(By.id("id_of_element"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(loginbutton).click();
		
		boolean success=this.isHeaderFound();
		
		return success;
		
	
	}

	public String getELLoginTitle(WebDriver driver) {
		// TODO Auto-generated method stub
		
		System.out.println(driver.getTitle());
		String curTitle = driver.getTitle();
		return curTitle;
		
	}
	public void clickSignUp()
	{
		driver.findElement(SignUpButton).click();
		
		
	}

}