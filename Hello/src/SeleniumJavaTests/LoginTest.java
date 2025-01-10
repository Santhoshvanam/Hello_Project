package SeleniumJavaTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class LoginTest {

	void loginTest()
	{
		// Object of the Fire Fox Driver
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
		
		 String title = driver.getTitle();
		
		System.out.println(title);
		System.out.println(titleee);
		
		//Verify
		
		if (title.equals("OrangeHRM - New Level of HR Management"))
			
		{
			System.out.println("Title Verififed Successfully");	
		}
		
		else
		{
			System.out.println("Title Not Verififed");
		} 
		
		
		// Identify Username and Password 
		
		driver.findElement(By.name("txtUserName")).sendKeys("user1");
		driver.findElement(By.name("txtPassword")).sendKeys("user1");
		driver.findElement(By.name("Submit")).click();
		
		// Identify welcome selenium text
		
		String text = driver.findElement(By.xpath("/html/body/div[3]/ul/li[1]")).getText();
		
		System.out.println(text);
		
		// Verify whether welcome page successfully opened or not
		
		if(text.equals("Welcome user1"))
		{
			System.out.println("Welcome page Verififed Successfully");
		}
		else
		{
			System.out.println("Welcome page is not verififed Successfully");
		}
		
		
		//Click on Log out
		
		driver.findElement(By.xpath("/html/body/div[3]/ul/li[3]/a")).click();
		
		// Close the Current Firefox Browser
		
		driver.close();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoginTest LT = new LoginTest();
		
		LT.loginTest();
		

	}

}
