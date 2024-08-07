package firmvpjctpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class firmvclass {
	WebDriver driver;
@Test(dataProvider="data")
	
	public void hello(String user,String pass) {
		
		//System.out.println("Hello world");
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe");
	
	 driver=new ChromeDriver();
	
	driver.get("https://www.saucedemo.com/v1/");
	
	WebElement uname=driver.findElement(By.id("user-name"));
	
	
	uname.sendKeys(user);
	
	
	WebElement pwd1=driver.findElement(By.id("password"));
	
	pwd1.sendKeys(pass);
	
   WebElement loginbtn1=driver.findElement(By.id("login-button"));
	
   loginbtn1.click();
   
   
	
	}

@AfterTest

public void close() {
	
	driver.quit();
	
}

@DataProvider(name="data")

public Object[][] data() {
	
	return new Object[][] {
		
		{"user1","pass1"},
		{"standard_user","secret_sauce"}
	};
	
	
	
}

}
