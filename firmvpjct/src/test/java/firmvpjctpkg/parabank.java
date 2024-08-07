package firmvpjctpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class parabank {
	
	WebDriver driver;
	
	@Test(dataProvider="data")
	
	public void register(String fname,String lname,String addr,String city,String state,String zipcode,String phone,String ssn,String uname,String pass,String confirm) {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		driver=new ChromeDriver();
		 
		driver.get("https://parabank.parasoft.com/parabank/register.htm");
		
		
		
		 WebElement firstname=driver.findElement(By.id("customer.firstName"));
		 
		 firstname.sendKeys(fname);
		 
        WebElement lastname=driver.findElement(By.id("customer.lastName"));
		 
        lastname.sendKeys(lname);
        
        WebElement address=driver.findElement(By.id("customer.address.street"));
		 
        address.sendKeys(addr);
        
        WebElement city1=driver.findElement(By.id("customer.address.city"));
		 
        city1.sendKeys(city);
        
        
        WebElement state1=driver.findElement(By.id("customer.address.state"));
		 
        state1.sendKeys(state);
        
        WebElement zipcode1=driver.findElement(By.id("customer.address.zipCode"));
		 
        zipcode1.sendKeys(zipcode);
        
        WebElement phone1=driver.findElement(By.id("customer.phoneNumber"));
		 
        phone1.sendKeys(phone);
        
        
        WebElement ssn1=driver.findElement(By.id("customer.ssn"));
		 
        ssn1.sendKeys(ssn);
        
        
        WebElement uname1=driver.findElement(By.id("customer.username"));
		 
        uname1.sendKeys(uname);
        
        WebElement pass1=driver.findElement(By.id("customer.password"));
		 
        pass1.sendKeys(pass);
        
        
        WebElement confirm1=driver.findElement(By.id("repeatedPassword"));
		 
        confirm1.sendKeys(confirm);
        
        WebElement regis=driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"));
		 
        regis.click();
        
        
		
	}
	
	@AfterTest
	
	public void close() {
		
		
		driver.quit();
	}
	
@DataProvider(name="data")

public Object[][] values(){
	
	return new Object[][] {
		
		{"hima","jeffy","abcd","tcr","kerala","680003","1234567890","123","h123","hp123","hp123"},
		
		{"hi","je","ab","tcr1","kerala1","680004","1234561111","1234","h1234","hp1234","hp1234"}
		
	};
	
	
	
}

}
