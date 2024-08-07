package firmvpjctpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class luma {
	
	WebDriver driver=new ChromeDriver();
	

	Row row;
	 String excelFilePath= "C:\\Hima\\luma.xlsx";
	
	
		
	 
	 
	 @Test(priority=1)
	 
	 
	 public void lumaregister() {

		 System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe");
		 //driver=new ChromeDriver();
			 try {
				 driver.get("https://magento.softwaretestingboard.com/");
				 driver.manage().window().maximize();
				 
				 
				    WebElement createaccnt=driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a"));
				    createaccnt.click();
				 
				    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

					Workbook workbook = new XSSFWorkbook(inputStream);

					Sheet sheet = workbook.getSheetAt(0);
					
					
					for (int i = 1; i <= sheet.getLastRowNum(); i++) {
						
						row = sheet.getRow(i);
						
						//read from excel
						
						String firstname=row.getCell(0).getStringCellValue();
						String lastname=row.getCell(1).getStringCellValue();
						String email=row.getCell(2).getStringCellValue();
						String pwd=row.getCell(3).getStringCellValue();
						String confirmpwd=row.getCell(4).getStringCellValue();
						
						//give values to site
						
						WebElement firstname1=driver.findElement(By.id("firstname"));
						firstname1.sendKeys(firstname);
						firstname1.clear();
						
						
						WebElement lastname1=driver.findElement(By.id("lastname"));
						lastname1.sendKeys(lastname);
						lastname1.clear();
						
						WebElement email1=driver.findElement(By.name("email"));
						email1.sendKeys(email);
						email1.clear();
						
						WebElement pwd1=driver.findElement(By.id("password"));
						pwd1.sendKeys(pwd);
						pwd1.clear();
						
						WebElement confirmpwd1=driver.findElement(By.name("password_confirmation"));
						confirmpwd1.sendKeys(confirmpwd);
						confirmpwd1.clear();
						
						WebElement createaccnt1=driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
						createaccnt1.click();
						
						}//for loop
					
					
					inputStream.close();
					workbook.close();
				 
			 }//try
			 
			 catch (IOException e) {

					e.printStackTrace();

					}//catch
			
		 
		 
	 }//lumaregister
	 
	 @Test(priority=2)
	 
	 public void lumalogin() {
		 
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe");
			
		 //driver=new ChromeDriver();
		 
		 try {
			 
			
			 
			 WebElement signin=driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
			 signin.click();
			 
			   FileInputStream inputStream1 = new FileInputStream(new File(excelFilePath));

				Workbook workbook1 = new XSSFWorkbook(inputStream1);

				Sheet sheet1 = workbook1.getSheetAt(0);
				
				
				for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
					
					row = sheet1.getRow(i);
					
					String email=row.getCell(2).getStringCellValue();
					String pwd=row.getCell(3).getStringCellValue();
					
					
					WebElement email1=driver.findElement(By.xpath("//*[@id=\"email\"]"));
					email1.sendKeys(email);
					email1.clear();
					
					WebElement pwd1=driver.findElement(By.xpath("//*[@id=\"pass\"]"));
					pwd1.sendKeys(pwd);
					pwd1.clear();
					
					WebElement signin1=driver.findElement(By.id("send2"));
					signin1.click();
					
				}//for
			 inputStream1.close();
			 workbook1.close();
			 
		 }//try
		 
		 catch (IOException e) {

				e.printStackTrace();

				}//catch
		 
		 
	 }//lumalogin
	 
	 @Test(priority=3)
	 
	 public void lumapdt() {
		 
		 
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe");
		 
		 try {
			 
			 driver.get("https://magento.softwaretestingboard.com/");
			 driver.manage().window().maximize();
			 
			 //women adding jacket to cart
			
			Actions builder = new Actions(driver);
			 
//			 WebElement element = driver.findElement(By.linkText("Women"));
//			 builder.moveToElement(element).build().perform();
//			 
//			 WebElement element1 = driver.findElement(By.linkText("Tops"));
//			 builder.moveToElement(element1).build().perform();
//			 
//			 WebElement jackets=driver.findElement(By.xpath("//*[@id=\"ui-id-11\"]"));
//			 jackets.click();
//			 
//			 WebElement element2 = driver.findElement(By.linkText("Olivia 1/4 Zip Light Jacket"));
//			 builder.moveToElement(element2).build().perform();
//			 
//			
//			 
//				WebElement oliviajacket=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[1]/form/button"));
//				oliviajacket.click();
//				Thread.sleep(4000);
//				WebElement sizemedium=driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-168\"]"));
//				sizemedium.click();
//				Thread.sleep(4000);
//				WebElement jackcolour=driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-57\"]"));
//				jackcolour.click();
//				
//				Thread.sleep(4000);
//				
//				WebElement jackadd2cart=driver.findElement(By.id("product-addtocart-button"));
//				jackadd2cart.click();
//				
//				//men adding jackets to cart
//				
//				 WebElement elementmen = driver.findElement(By.linkText("Men"));
//				 builder.moveToElement(elementmen).build().perform();
//				 
//				 WebElement elementmentop = driver.findElement(By.linkText("Tops"));
//				 builder.moveToElement(elementmentop).build().perform();
//				
//				 WebElement menjackets=driver.findElement(By.xpath("//*[@id=\"ui-id-19\"]"));
//				 menjackets.click();
//				 
//				 WebElement elementfitjack = driver.findElement(By.linkText("Proteus Fitness Jackshirt"));
//				 builder.moveToElement(elementfitjack).build().perform();
//				 
//				 WebElement fitjackadd2cart=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[1]/form/button"));
//				 fitjackadd2cart.click();
//				 
//				 Thread.sleep(4000);
//				 
//				 WebElement mensizemedium=driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-168\"]"));
//				 mensizemedium.click();
//				 
//				 Thread.sleep(4000);
//				 WebElement menjackcolour=driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-50\"]"));
//				 menjackcolour.click();
//				 
//				 Thread.sleep(4000);
//			     WebElement menjackadd2cart=driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
//				 menjackadd2cart.click();
//				 
//				 //add gear/bag to cart
//				 
//				 WebElement elementgear = driver.findElement(By.linkText("Gear"));
//				 builder.moveToElement(elementgear).build().perform();
//				  
//				 WebElement fitnessequip=driver.findElement(By.xpath("//*[@id=\"ui-id-26\"]"));
//				 fitnessequip.click();
//				 
//				 WebElement spriteyoga=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/strong/a"));
//				 spriteyoga.click();
//				 
//				 WebElement spriteyogacustomize=driver.findElement(By.xpath("//*[@id=\"bundle-slide\"]"));
//				 spriteyogacustomize.click();
//				 
//				 Thread.sleep(4000);
//				 WebElement spriteyogaadd2crt=driver.findElement(By.cssSelector("#product-addtocart-button"));
//				 spriteyogaadd2crt.click();
//				 
				
			 
			/////// //add bags from dropdown
				 
				 
//			
//			    Thread.sleep(4000);
//			    WebElement elementgear1=driver.findElement(By.cssSelector("#ui-id-6"));
//			    elementgear1.click();
//			 
//				 WebElement bagss=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[2]/div[2]/div/ul/li[1]/a"));
//				 bagss.click();
//				 
//				 //dropdown style ....
//				 
//				 WebElement bagsstyle=driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
//				 bagsstyle.click();
//				 
//				 WebElement bagsstylelaptop=driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[5]/a"));
//				 bagsstylelaptop.click();
//				 
//				 WebElement bagsactivity=driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
//				 bagsactivity.click();
//				 
//				 WebElement bagsactivityschool=driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[5]/a"));
//				 bagsactivityschool.click();
//				 
//				 WebElement bagsrecomends=driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
//				 bagsrecomends.click();
//				 
//				 WebElement bagsrecomendsys=driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li/a"));
//				 bagsrecomendsys.click();
//				
//				
//				 Thread.sleep(4000);
//				 WebElement bagsfeatures=driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
//				 bagsfeatures.click();
//				 
//				 WebElement bagsfeaturelapsleeve=driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[4]/a"));
//				 bagsfeaturelapsleeve.click();
//				 
//				 WebElement bagsmaterial=driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
//				 bagsmaterial.click();
//				 
//				 WebElement bagsmaterialnylon=driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[2]/a"));
//				 bagsmaterialnylon.click();
//				 
//				 
//
//				 
//				 WebElement bagssale=driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
//				 bagssale.click(); 
//				 
//				 
//				 WebElement bagssaleys=driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li/a"));
//				 bagssaleys.click();
//				 
//				 WebElement bagsstrap=driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div/div[1]"));
//				 bagsstrap.click();
//				
//				 WebElement bagsstrapadjust=driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div/div[2]/ol/li[1]/a"));
//				 bagsstrapadjust.click();
//				 
//
//				 
//				 
//				 WebElement elementbag = driver.findElement(By.linkText("Endeavor Daytrip Backpack"));
// 			     builder.moveToElement(elementbag).build().perform();
// 			     
// 			     Thread.sleep(4000);
// 				 WebElement bagaddcart=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li/div/div/div[3]/div/div[1]/form/button"));
// 				 bagaddcart.click();
 				 
 				 
 				//////// //women dropdown
// 				Thread.sleep(4000);
// 				 WebElement womendropdown = driver.findElement(By.linkText("Women"));
// 				 womendropdown.click();
// 				
// 				 WebElement womenjckt = driver.findElement(By.linkText("Jackets"));
// 				 womenjckt.click();
// 				 
// 			
// 				 WebElement womenjcktstyle = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
// 				 womenjcktstyle.click();
// 				 WebElement womenjcktstylelghtwt = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[3]/a"));
// 				 womenjcktstylelghtwt.click();
// 				
// 				 
// 				WebElement womenjcktsize = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
// 				womenjcktsize.click();
//				WebElement womenjcktsizem = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/div/div/a[3]/div"));
//				womenjcktsizem.click();
//				
//				Thread.sleep(2000);
//				WebElement womenjcktclimate = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
//				womenjcktclimate.click();
//			
//				WebElement womenjcktclimatecool = driver.findElement(By.cssSelector("#narrow-by-list > div.filter-options-item.allow.active > div.filter-options-content > ol > li:nth-child(2) > a"));
//				womenjcktclimatecool.click();
//				
//				WebElement womenjcktcolor = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
//				womenjcktcolor.click();
//				WebElement womenjcktcolorpurple = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/div/div/a[5]/div"));
//				womenjcktcolorpurple.click();
//				 
//				WebElement womenjckterinrecmnds = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[1]"));
//				womenjckterinrecmnds.click();
//				WebElement womenjckterinrecmndsys = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[2]/ol/li[1]/a"));
//				womenjckterinrecmndsys.click();
//				
//				WebElement womenjcktecocollection = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
//				womenjcktecocollection.click();
//				WebElement womenjcktecocollectionys = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li/a"));
//				womenjcktecocollectionys.click();
//				
//				WebElement womenjcktnew = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[1]"));
//				womenjcktnew.click();
//				WebElement womenjcktnewno = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[2]/ol/li[1]/a"));
//				womenjcktnewno.click();
//				
//				WebElement womenjcktperfabric = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[1]"));
//				womenjcktperfabric.click();
//				WebElement womenjcktperfabricno = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[2]/ol/li/a"));
//				womenjcktperfabricno.click();
//				
//				WebElement womenjcktmaterial = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
//				womenjcktmaterial.click();
//				WebElement womenjcktmaterialcoton = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[1]/a"));
//				womenjcktmaterialcoton.click();
//				
//				WebElement womenjcktpattern = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[1]"));
//				womenjcktpattern.click();
//				WebElement womenjcktpatternsolid = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[2]/ol/li/a"));
//				womenjcktpatternsolid.click();
//				
//				WebElement womenjcktsale = driver.findElement(By.cssSelector("#narrow-by-list > div > div.filter-options-title"));
//				womenjcktsale.click();
//				WebElement womenjcktsaleys = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div/div[2]/ol/li/a"));
//				womenjcktsaleys.click();
//				
//				 WebElement womenjacketcart = driver.findElement(By.linkText("Adrienne Trek Jacket"));
// 			     builder.moveToElement(womenjacketcart).build().perform();
// 			     
// 			     Thread.sleep(4000);
// 				 WebElement womenjacketadd2crt=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li/div/div/div[4]/div/div[1]/form/button"));
// 				womenjacketadd2crt.click();
			
			
			//Men dropdown
			
			Thread.sleep(4000);
			 WebElement mendropdown = driver.findElement(By.linkText("Men"));
			 mendropdown.click();
			
			 WebElement menjacket = driver.findElement(By.linkText("Jackets"));
			 menjacket.click();
			 
			 WebElement menjcktstyle = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
			 menjcktstyle.click();
			 WebElement menjcktstylelghtwt = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[3]/a"));
		     menjcktstylelghtwt.click();
			 
		     WebElement menjcktsize = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
		     menjcktsize.click();
			 WebElement menjcktsizem = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/div/div/a[3]/div"));
			 menjcktsizem.click();
			 
			 WebElement menjcktclimate = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
			 menjcktclimate.click();
			 WebElement menjcktclimatecool = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[2]/a"));
			 menjcktclimatecool.click();
			 
			 
			 WebElement menjcktcolor = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
			 menjcktcolor.click();
			 WebElement menjcktcolorblue = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/div/div/a[2]/div"));
			 menjcktcolorblue.click();
			 
			 WebElement menjcktecocollection = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
			 menjcktecocollection.click();
			 WebElement menjcktecocollectionno = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li/a"));
			 menjcktecocollectionno.click();
			 
			 WebElement menjckterinrecomnds = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
			 menjckterinrecomnds.click();
			 WebElement menjckterinrecomndsno = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li/a"));
			 menjckterinrecomndsno.click();
			 
			 WebElement menjcktmaterial = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
			 menjcktmaterial.click();
			 WebElement menjcktmaterialcocona = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[1]/a"));
			 menjcktmaterialcocona.click();
			 
			 WebElement menjcktnew = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
			 menjcktnew.click();
			 WebElement menjcktnewno = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li/a"));
			 menjcktnewno.click();
			 
			 WebElement menjcktpattern = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
			 menjcktpattern.click();
			 WebElement menjcktpatternsolid = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li/a"));
			 menjcktpatternsolid.click();
			 
			 WebElement menjcktperformance = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
			 menjcktperformance.click();
			 WebElement menjcktperformanceno = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li/a"));
			 menjcktperformanceno.click();
			 
			 WebElement menjcktsale = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div/div[1]"));
			 menjcktsale.click();
			 WebElement menjcktsaleno = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div/div[2]/ol/li/a"));
			 menjcktsaleno.click();
			 
			 WebElement menjacketcart = driver.findElement(By.linkText("Taurus Elements Shell"));
			 builder.moveToElement(menjacketcart).build().perform();
			     
			Thread.sleep(4000);
		    WebElement menjacketadd2crt=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li/div/div/div[4]/div/div[1]/form/button"));
			menjacketadd2crt.click();
				
		 }//try
		 
		 
		 catch (Exception e) {

				e.printStackTrace();

				}//catch
		 
		 
		 
	 }//lumapdts

}//luma
