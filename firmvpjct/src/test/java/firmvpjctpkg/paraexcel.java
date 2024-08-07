package firmvpjctpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class paraexcel {
	
WebDriver driver;
	
	Row row;
	 String url="https://parabank.parasoft.com/parabank/register.htm";
	 
	 @Test
	 
	 
	 public void parabank() {
		 
		 
		// String excelFilePath1 = "C:\\Hima\\paraexcel.xlsx";
		 String excelFilePath1= "C:\\Hima\\paraexcel.xlsx";
		 
		 
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe");
		 
		 
		 driver=new ChromeDriver();
		
		 try {
			 
			 
			 FileInputStream inputStream = new FileInputStream(new File(excelFilePath1));

				Workbook workbook = new XSSFWorkbook(inputStream);

				Sheet sheet = workbook.getSheetAt(0);
				
				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					
					row = sheet.getRow(i);
					
					String firstname = row.getCell(0).getStringCellValue();
					
					System.out.println(firstname);
				
					String lastname = row.getCell(1).getStringCellValue();
			
					
					
					String address = row.getCell(2).getStringCellValue();
					
					
					String city = row.getCell(3).getStringCellValue();
					
					String state = row.getCell(4).getStringCellValue();
					System.out.println(state);
					
					//for reading integer value
					//DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
					
					int zipcode=(int)row.getCell(5).getNumericCellValue();
					
					// Cell cell1 = row.getCell(5);
					// String zipcode = formatter.formatCellValue(cell1);
					
				
					
					
					// Cell cell2 = row.getCell(6);
					 //String phone = formatter.formatCellValue(cell2);
					 
					 int phone=(int)row.getCell(6).getNumericCellValue();
					 
					 
					 //Cell cell3 = row.getCell(7);
					// String ssn = formatter.formatCellValue(cell3);
					 
					 int ssn=(int)row.getCell(7).getNumericCellValue();
					 
					System.out.println(zipcode+" "+phone+" "+ssn);
					
					String username = row.getCell(8).getStringCellValue();
					
					String pwd = row.getCell(9).getStringCellValue();
					
					String confirmpwd = row.getCell(10).getStringCellValue();
					
					 driver.get(url);
					
					
					
					 WebElement firstname1=driver.findElement(By.id("customer.firstName"));
					 
					 firstname1.sendKeys(firstname);
					 
			        WebElement lastname1=driver.findElement(By.id("customer.lastName"));
					 
			        lastname1.sendKeys(lastname);
			        
			        WebElement address1=driver.findElement(By.id("customer.address.street"));
					 
			        address1.sendKeys(address);
			        
			        WebElement city1=driver.findElement(By.id("customer.address.city"));
					 
			        city1.sendKeys(city);
			        
			        
			        WebElement state1=driver.findElement(By.id("customer.address.state"));
					 
			        state1.sendKeys(state);
			        
			        WebElement zipcode1=driver.findElement(By.id("customer.address.zipCode"));
					 
			        //zipcode1.sendKeys(zipcode);
			        zipcode1.sendKeys(String.valueOf(zipcode));
			        
			        
			        
			        WebElement phone1=driver.findElement(By.id("customer.phoneNumber"));
					 
			        phone1.sendKeys(String.valueOf(phone));
			        
			        
			        WebElement ssn1=driver.findElement(By.id("customer.ssn"));
					 
			        ssn1.sendKeys(String.valueOf(ssn));
			        
			        
			        WebElement uname1=driver.findElement(By.id("customer.username"));
					 
			        uname1.sendKeys(username);
			        
			        WebElement pass1=driver.findElement(By.id("customer.password"));
					 
			        pass1.sendKeys(pwd);
			        
			        
			        WebElement confirm1=driver.findElement(By.id("repeatedPassword"));
					 
			        confirm1.sendKeys(confirmpwd);
			        
			        WebElement regis=driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"));
					 
			        regis.click();
					
				}//forloop
				
				workbook.close();

				inputStream.close();
		 }//try 
		 
		 
		 catch (IOException e) {

				e.printStackTrace();

				}
	 }//test parabank
	 

	@AfterTest 
	
	public void close() {
		
		
		driver.quit();
	}
	 
	 
}//class paraexcel


//sheet.getRow(i).getCell(0).toString()

//cell.setCellType ( Cell.CELL_TYPE_STRING ) ;

//Cell cell = row.getCell(6); 
//cell.setCellType (Cell.);

 
//String phone = cell.getStringCellValue();


//System.out.println(phone);