package firmvpjctpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.support.ui.Select;
//import org.apache.bcel.generic.Select;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class petstore {
	
	WebDriver driver;
	Row row;
	 String excelFilePath= "C:\\Hima\\petstore.xlsx";
	
	@Test(priority=1)
	
	public void petregister() {
		   
		 
			System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe");
			
			 driver=new ChromeDriver();
		
		try {
			
			driver.get("https://petstore.octoperf.com/actions/Catalog.action");
			
			WebElement signin=driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[2]"));
			signin.click();
			
			WebElement registernow=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/a"));
			registernow.click();
			
			    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

				Workbook workbook = new XSSFWorkbook(inputStream);

				Sheet sheet = workbook.getSheetAt(0);
				
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					
					row = sheet.getRow(i);
					
					//read from excel
					
					String userid=row.getCell(0).getStringCellValue();
					
					
					
					
					String pwd=row.getCell(1).getStringCellValue();
					String repeatpwd=row.getCell(2).getStringCellValue();
					String fname=row.getCell(3).getStringCellValue();
					String lname=row.getCell(4).getStringCellValue();
					String email=row.getCell(5).getStringCellValue();
					int phone=(int)row.getCell(6).getNumericCellValue();
					
					String addr1=row.getCell(7).getStringCellValue();
					String addr2=row.getCell(8).getStringCellValue();
					String city=row.getCell(9).getStringCellValue();
					String state=row.getCell(10).getStringCellValue();
					int zip=(int)row.getCell(11).getNumericCellValue();
					String country=row.getCell(12).getStringCellValue();
					
					
					
					
					
					
					//give values in register form
					
					WebElement userid1=driver.findElement(By.name("username"));
					userid1.sendKeys(userid);
					
					
					WebElement pwd1=driver.findElement(By.name("password"));
					pwd1.sendKeys(pwd);
					
					WebElement repeatpwd1=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[1]/tbody/tr[3]/td[2]/input"));
					
					//WebElement repeatpwd1=driver.findElement(By.name("repeatedPassword"));
					
					repeatpwd1.sendKeys(repeatpwd);
					
					WebElement fname1=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[1]/td[2]/input"));
					fname1.sendKeys(fname);
					
					WebElement lname1=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[2]/td[2]/input"));
					lname1.sendKeys(lname);
					
					WebElement email1=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[3]/td[2]/input"));
					email1.sendKeys(email);
					
					WebElement phone1=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[4]/td[2]/input"));
					phone1.sendKeys(String.valueOf(phone));
					
					WebElement addr11=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[5]/td[2]/input"));
					addr11.sendKeys(addr1);
					
					WebElement addr22=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[6]/td[2]/input"));
					addr22.sendKeys(addr2);
					
					WebElement city1=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[7]/td[2]/input"));
					city1.sendKeys(city);

					WebElement state1=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[8]/td[2]/input"));
					state1.sendKeys(state);
					
					WebElement zip1=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[9]/td[2]/input"));
					zip1.sendKeys(String.valueOf(zip));
					
					WebElement country1=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[10]/td[2]/input"));
					country1.sendKeys(country);
					
					//from dropdown
					
					Select dropdownlang = new Select(driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[1]/td[2]/select")));
					
					dropdownlang.selectByVisibleText("english");
					
                    Select dropdownfavcat = new Select(driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[2]/td[2]/select")));
					
                    dropdownfavcat.selectByVisibleText("CATS");
					
                    // checkbox
                    
                    driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[3]/td[2]/input")).click();
                    driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[4]/td[2]/input")).click();
                    
                    WebElement saveaccnt=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/input"));
                    saveaccnt.click();
                    
                 
                    
                    
					
                }//for loop
                
               
			 
                workbook.close();

				inputStream.close();
			
		}//try
		
		 catch (IOException e) {

				e.printStackTrace();

				}//catch
		
	}//petregister
	

	
	@AfterTest
	
	public void close() {
		
		
		driver.quit();
	}

	@Test(priority=2)
	
	public void login() {
		
		    
			 
			System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe");
			
			 driver=new ChromeDriver();
			 
			 try {
				 
				 driver.get("https://petstore.octoperf.com/actions/Account.action;jsessionid=A566DE5A210CEB488087860F0CE03A7A?signonForm=");
				 
				 FileInputStream inputStream1 = new FileInputStream(new File(excelFilePath));

					Workbook workbook1 = new XSSFWorkbook(inputStream1);

					Sheet sheet1 = workbook1.getSheetAt(0);
					   
					for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
							
							row = sheet1.getRow(i);
							
							//read from excel
							
							String useridd=row.getCell(0).getStringCellValue();
							
							String pwdd=row.getCell(1).getStringCellValue();
							
							
							WebElement useridd1=driver.findElement(By.name("username"));
							useridd1.sendKeys(useridd);
							
							
							WebElement pwdd1=driver.findElement(By.name("password"));
							pwdd1.sendKeys(pwdd);
					
							WebElement login=driver.findElement(By.name("signon"));
							login.click();
							
							
							driver.get("https://petstore.octoperf.com/actions/Catalog.action");
							
							WebElement fish=driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[1]/img"));
							fish.click();
							
							WebElement fishpdtid=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a"));
							fishpdtid.click();
							
							WebElement fishadd2crt=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a"));
							fishadd2crt.click();
							
							WebElement ret2mainmenu=driver.findElement(By.xpath("//*[@id=\"BackLink\"]/a"));
							ret2mainmenu.click();
							
							WebElement dog=driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[2]/img"));
							dog.click();
							
							WebElement dogpdtid=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a"));
							dogpdtid.click();
							
							WebElement dogadd2crt=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a"));
							dogadd2crt.click();
							
							WebElement dogret2mainmenu=driver.findElement(By.xpath("//*[@id=\"BackLink\"]/a"));
							dogret2mainmenu.click();
						
							
							
							WebElement cat=driver.findElement(By.cssSelector("#SidebarContent > a:nth-child(7) > img"));
							cat.click();
							
							WebElement catpdtid=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a"));
							catpdtid.click();
							
							WebElement catadd2crt=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a"));
							catadd2crt.click();
							

							WebElement catret2mainmenu=driver.findElement(By.xpath("//*[@id=\"BackLink\"]/a"));
							catret2mainmenu.click();
							
							WebElement reptiles=driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[4]/img"));
							reptiles.click();
							
							WebElement reptpdtid=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a"));
							reptpdtid.click();
							
							WebElement reptadd2crt=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a"));
							reptadd2crt.click();
							
							WebElement reptre2mainmenu=driver.findElement(By.xpath("//*[@id=\"BackLink\"]/a"));
							reptre2mainmenu.click();
							
							
							WebElement birds=driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[5]/img"));
							birds.click();
							
							WebElement birdspdtid=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a"));
							birdspdtid.click();
							
							WebElement birdsadd2crt=driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a"));
							birdsadd2crt.click();
							
							WebElement birds2mainmenu=driver.findElement(By.xpath("//*[@id=\"BackLink\"]/a"));
							birds2mainmenu.click();
							
					}//for loop
					    workbook1.close();

						inputStream1.close();
			 }//try
			 
			 catch(IOException e) {
				 
				 e.printStackTrace();
			 }//catch
			 
			 
			
		
	}//login
	
}//petstore
