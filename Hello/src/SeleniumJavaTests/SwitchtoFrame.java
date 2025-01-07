package SeleniumJavaTests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class SwitchtoFrame {

	void loginTest()
	{
		// Object of the Fire Fox Driver
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
		
		 String title = driver.getTitle();
		
		System.out.println(title);
		
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
		
		
	// Switch to Frame
		
		driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
		
	// identify dropdown
		
		WebElement dropdown = driver.findElement(By.name("loc_code"));
		
		List<WebElement> droplist = dropdown.findElements(By.tagName("options")); 
		
		// dropdown size
		System.out.println(" dropdown value size" + droplist.size());
		
		//print dropdown values
		
		for (int i=0; i<droplist.size();i++)
		{
			System.out.println(droplist.get(i).getText());
			
		}
		
		// select the dropdown value
		
		Select s = new Select(dropdown);
		s.selectByIndex(2);
	
		// get the selected value
		String selected_text = s.getFirstSelectedOption().getText();
		
		System.out.println(selected_text);
		
		if (selected_text.equals("First Name"))
		{
			System.out.println("Yes");
		}
		else
			
		{
			System.out.println("No");
		}
			
			driver.switchTo().defaultContent();
			
			driver.close();
		
		// identify list box
			
			WebElement listbox = driver.findElement(By.id("ctl00_MainContent_lbCountry"));
			
			// select listbox values
			
			Select SS = new Select(listbox);
			SS.selectByIndex(3);
		//	s.selectByVisibleText("Argentina);
			
			if(SS.isMultiple())
			{
				System.out.println("YY");
			}
			else
			{
				System.out.println("NN");
			}
			
			
			//checkbox
			
			WebElement checkbox1 =driver.findElement(By.id("vfb-6-0"));
			checkbox1.click();
			
			if(checkbox1.isSelected())
			{
				System.out.println("YY");
			}
			else
			{
				System.out.println("NN");
			}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SwitchtoFrame LT = new SwitchtoFrame();
		
		LT.loginTest();
		

	}

}
