package firmvpjctpkg;
import java.io.File;

	
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Sheet;

//import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;


public class swagexcel {

	
	WebDriver driver;
	
	Row row;
	 String url="https://www.saucedemo.com/v1/";
	@Test
	
	public void hello() throws InterruptedException{
		
   String excelFilePath1 = "C:\\Hima\\swag.xlsx";
    
   // String excelFilePath1 = "C:\\Hima\\swagtrial.xlsx";
    
	System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe");
	
	 driver=new ChromeDriver();
	
	 try
	 {
		 FileInputStream inputStream = new FileInputStream(new File(excelFilePath1));

			Workbook workbook = new XSSFWorkbook(inputStream);

			Sheet sheet = workbook.getSheetAt(0);
			
			
			//int i=0;heading
			
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			 row = sheet.getRow(i);
			 
			// Get data from the current row

			String username = row.getCell(0).getStringCellValue();

			String pwd = row.getCell(1).getStringCellValue();
		 
			
			driver.get(url);
			
		    WebElement uname=driver.findElement(By.id("user-name"));
			
			
			uname.sendKeys(username);
			
			
			WebElement pwd1=driver.findElement(By.id("password"));
			
			pwd1.sendKeys(pwd);
			
		   WebElement loginbtn1=driver.findElement(By.id("login-button"));
			
		   loginbtn1.click();
		

			
			
		   System.out.println(row.getRowNum());
		    
               if (row.getRowNum() == 0) 
                   // Skip the header row
               {
            	  System.out.println(row.getRowNum());
            	   
            	   
            	  // Cell header1= sheet.getRow(0).createCell(2, CellType.STRING);
            	   //header1.setCellValue("status"); 
                  continue;
              
               }
			
			Cell urlCell = row.getCell(0);//get first username
            Cell expectedTitleCell = row.getCell(1);//get first pwd
            
			String url = urlCell.getStringCellValue();
            String expectedTitle = expectedTitleCell.getStringCellValue();
            
            System.out.println(url);
            System.out.println(expectedTitle);
            
            //String actualTitle = driver.getTitle(); //get title ie. swag labs
            //System.out.println(actualTitle);
           
           
            
           
            
            //Cell sss=row.createCell(3, CellType.STRING);
           
            Cell resultCell = row.createCell(2, CellType.STRING);
           
if(isloginsuccessful())
	
{
	resultCell.setCellValue("pass"); 
	//sss.setCellValue("");
}

else
{
	resultCell.setCellValue("fail");
	
	//sss.setCellValue("");
}
}

        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(new File(excelFilePath1));
        workbook.write(outputStream);
        outputStream.close();
       // workbook.close();
            
            
            
//            Cell actualTitleCell = row.createCell(2, CellType.STRING); 
//			actualTitleCell.setCellValue(actualTitle); 
//			Cell resultCell = row.createCell(3, CellType.STRING);
//			if (actualTitle.equals(expectedTitle)) 
//			{
//				resultCell.setCellValue("Pass"); 
//				}
//			
//			else { 
//				resultCell.setCellValue("Fail"); 
//		} 
//	
//			
             
      		
			
//            
//            
//			String actualTitle = driver.getTitle(); 
//			// Write the actual title and result to the Excel file 
//			Cell actualTitleCell = row.createCell(2, CellType.STRING); 
//			actualTitleCell.setCellValue(actualTitle); 
//			Cell resultCell = row.createCell(3, CellType.STRING);
//			if (actualTitle.equals(expectedTitle)) 
//			{
//				resultCell.setCellValue("Pass"); 
//				}
//			
//			else { 
//				resultCell.setCellValue("Fail"); 
//				} 
	
			
			
			
			workbook.close();

			inputStream.close();
			
	 }  
	 
	 //try close
	 catch (IOException e) {

			e.printStackTrace();

			}
	}
	 
	private boolean isloginsuccessful() {
		
		
		try{
			
			driver.findElement(By.id("inventory_container"));
			
			return true;
			
			
		}	
		
		catch(Exception e) {
		return false;
		
		}
	}

	@AfterTest

	public void close() {
		
//
//		Cell urlCell = row.getCell(0);
//        Cell expectedTitleCell = row.getCell(1);
//        
//		String url = urlCell.getStringCellValue();
//        String expectedTitle = expectedTitleCell.getStringCellValue();
//        
//        
//		String actualTitle = driver.getTitle(); 
		
		
		
		//if(driver="https://www.saucedemo.com/v1/inventory.html"){
			   
			   
			  // System.out.println("User can access login");
		  // }
		driver.quit();
		
		
		
	}
	
}

	
	//package package1;



	//import java.io.File;

	//import java.io.FileInputStream;

	//import java.io.IOException;



	//import org.apache.poi.ss.usermodel.Row;

	//import org.apache.poi.ss.usermodel.Sheet;

	//import org.apache.poi.ss.usermodel.Workbook;

	//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	//import org.openqa.selenium.By;

	//import org.openqa.selenium.WebDriver;

	//import org.openqa.selenium.chrome.ChromeDriver;

	//import org.testng.annotations.Test;



	//public class parabankexcel {

	//WebDriver driver;

	//@Test

	//public void datadriven() throws InterruptedException

	//{

	//String excelFilePath = "C:\\Users\\HP\\Documents\\parabank.xlsx";

	//System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

	//driver=new ChromeDriver();

	//try {

	//FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

	//Workbook workbook = new XSSFWorkbook(inputStream);

	//Sheet sheet = workbook.getSheetAt(0);

	//for (int i = 1; i <= sheet.getLastRowNum(); i++) {

	//Row row = sheet.getRow(i);

	// Get data from the current row

	//String username = row.getCell(0).getStringCellValue();

	//String pwd = row.getCell(1).getStringCellValue();



	//driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=6CC80B96EB2C70EB99BC94B490A83441");

	//driver.manage().window().maximize();

	//driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")).click();

	//driver.findElement(By.id("customer.firstName")).sendKeys(username);

	//driver.findElement(By.id("customer.lastName")).sendKeys(pwd);

	//Thread.sleep(3000);

	//}

	//workbook.close();

	//inputStream.close();

	//} catch (IOException e) {

	//e.printStackTrace();

	//}

	// Close the browser

	//driver.quit();

	//}

	//}

	
//}
