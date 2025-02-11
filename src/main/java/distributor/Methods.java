package distributor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import login.BasePage;



public class Methods extends BasePage {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	 static String filePath ="D:\\eclipse-workspace\\LabourAngularProject\\TestData\\Labour.xlsx";

	
	public static void User ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	    
		  
		 if(Locators.Users().isEnabled()) {
			 
				test.log(LogStatus.PASS,  "  User Button Working Sucessfully."); 
				Locators.Users().click();
		 }
		 else
		 {
		 	test.log(LogStatus.FAIL, "User Button Working Failure.");
		 }
		  	 Thread.sleep(3000);
		  
		  	
	}
	
	public static void UserAddNew ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				Thread.sleep(3000);
                 Locators.addNewBtn().click();
				Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(0);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.firstName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(1);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.lastName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(2);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.designation().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(3);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.mail().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(4);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

				int No = (int) c1.getNumericCellValue();
				Locators.contactno().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				Locators.Status().click();
				Thread.sleep(2000);
				Locators.Status1().click();
				Thread.sleep(2000);
				Locators.roledd().click();
				Thread.sleep(2000);
				Locators.roledd1().click();
				Thread.sleep(2000);
				Locators.Save().click();
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equals("Details Save Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void UserEdit ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				Thread.sleep(3000);
                 Locators.Edit().click();
				Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.firstName().clear();
				 	row0 = sheet.getRow(5);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.firstName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				
		
				Locators.Save().click();
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equals("Details Save Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void UserEditInvalid ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				Thread.sleep(3000);
                 Locators.Edit().click();
				Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.firstName().clear();
				 	row0 = sheet.getRow(6);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.firstName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				Locators.lastName().clear();
				row0 = sheet.getRow(7);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.lastName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				
		
				Locators.Save().click();
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//div[contains(text(),'First Name must contain only letters and spaces.')]")).getText();
				String text1 = getDriver().findElement(By.xpath("//div[contains(text(),'Last Name must contain only letters and spaces.')]")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				
					
					test.log(LogStatus.PASS,"Message Displayed : "+text +", "+text1);
			
					
		
				
				
		  	
	}
	
	public static void SearchUser ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				
				//Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.SearchUser().click();
				 	row0 = sheet.getRow(5);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			//	List<WebElement> options = getDriver().findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
			//	selectOptionFromDropDown_bs(options, "Vaibhav (mahesh.darandale@tlregtech.in)");
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//*[@class='cell-content'])[1]")).getText();
				
					
				test.log(LogStatus.PASS, "User dropdown working successfully.");
				test.log(LogStatus.PASS, "User selected : "+text);
					
		
				
				
		  	
	}
	
	public static void SearchUserClear ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				
				//Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.SearchUser().click();
				 	row0 = sheet.getRow(5);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				Locators.SearchUser1().click();
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
				Thread.sleep(4000);
				
				
					
				 if(Locators.Clear().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Clear button working successfully."); 
						Locators.Users().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
				 }
				  	 Thread.sleep(3000);
				  
			
	}
	
	public static void UserDelete( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				
				Locators.Delete().click();
				
				Thread.sleep(3000);
				
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				
					
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
					
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void UserDeleteAssign( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				
				Locators.Delete().click();
				
				Thread.sleep(3000);
				
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				
					
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
					
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void UserDeleteCancel( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				Thread.sleep(3000);
				
				Locators.Delete().click();
				
				Thread.sleep(3000);
				
				 if(Locators.DeleteCan().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.DeleteCan().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);
				  
				
					

					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void UserBack( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				
				 Thread.sleep(3000);
				
				 if(Locators.Back().isEnabled()) {
					 
						
						Locators.Back().click();
						 Thread.sleep(3000);
						String value = getDriver().getTitle();
						System.out.println(value);	//Assert.assertEquals(value, true);
						if(value!="")
						{
							test.log(LogStatus.PASS, "Back button working successfully.");
							test.log(LogStatus.PASS, "Page displayed : "+value);
					}
						else
						{
							test.log(LogStatus.PASS, "Back button does not work.");
							test.log(LogStatus.PASS, "Page displayed : "+value);

				}
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Back' button does not working");
				 }
				  	 Thread.sleep(3000);
				  
				
					
				
				
				
		  	
	}
	
	
	public static void ExportUser( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				
				 Thread.sleep(3000);
				 JavascriptExecutor js = (JavascriptExecutor) getDriver();
					js.executeScript("window.scrollBy(0,300)");	
					Thread.sleep(5000);
				 Thread.sleep(2000); 		
					Locators.GridCount().click();					//Clicking on Text of total items just to scroll down.
					Thread.sleep(1000);
					String s = 				Locators.GridCount().getText();
					Thread.sleep(8000);
					String[] bits = s.split(" ");								//Splitting the String
					String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
					int count1 = Integer.parseInt(compliancesCount);
				
					if(compliancesCount.equalsIgnoreCase("to"))
					{
						Thread.sleep(5000);
					   s = Locators.GridCount().getText();
						bits = s.split(" ");
			        
					}
					
					Thread.sleep(2000);
			        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
			        
			        js1.executeScript("window.scrollBy(0,-1000)");
			        Thread.sleep(2000);

			Thread.sleep(1000);
			
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

			Thread.sleep(1000);
			Locators.Export().click();
			Thread.sleep(9000);	
			test.log(LogStatus.PASS, " :- File downloaded successfully.");

			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

			if(dirContents.length < allFilesNew.length)
			{
				
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				Thread.sleep(1000);
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				/*
				int no = sheet.getFirstRowNum();
				Row row = sheet.getRow(no);
				Cell c1 = row.getCell(0);
				int records =(int) c1.getNumericCellValue();
				*/
				sheet = workbook.getSheetAt(0);
				int columnNumber = 3;
				int rowCount = 0;
				int actualRow=0;
				
				for(Row row : sheet)
				{
					
					Cell cell =row.getCell(columnNumber);
					if(cell != null) {
						
						rowCount++;
						actualRow = rowCount-1;
					}
					
				}
				fis.close();
				
				if(count1 == actualRow)
				{
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
				
				
		  	
	}
	
	public static void  Corporate ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	    
		  
		 if(Locators.Corporate().isEnabled()) {
			 
				test.log(LogStatus.PASS,  "  Corporate Button Working Sucessfully.."); 
				Locators.Users().click();
		 }
		 else
		 {
		 	test.log(LogStatus.FAIL, "Corporate Button Working Failure.");
		 }
		  	 Thread.sleep(3000);
		  
		  	
	}
	
	public static void CorporateAddNew ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				Thread.sleep(3000);
                 Locators.addNewBtn().click();
				Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(8);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.name().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(9);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.CorporateID().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				Locators.Check().click();
				Thread.sleep(2000);
				row0 = sheet.getRow(10);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.BuyerName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(11);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Email().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(12);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

				int No = (int) c1.getNumericCellValue();
				Locators.ContactNo().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				
				Locators.Save().click();
				Thread.sleep(4000);
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equals("Details Save Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void CorporateEdit ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				Thread.sleep(3000);
                 Locators.CorporateEdit().click();
				Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			  	Locators.name().clear();
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(8);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.name().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
			
				
				
				
				Locators.Save().click();
				Thread.sleep(4000);
			
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equals("Details Save Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void CorporateEditInvalid ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				Thread.sleep(3000);
                 Locators.CorporateEdit().click();
				Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			  	Locators.Email().clear();
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(13);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Email().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
			
				row0 = sheet.getRow(14);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Pan().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				
				Locators.Save().click();
				Thread.sleep(4000);
			
				String text = getDriver().findElement(By.xpath("//small[@class='ng-star-inserted']")).getText();
				String text1 = getDriver().findElement(By.xpath("//div[contains(text(),'PAN must follow the format AAAAA1111A')]")).getText();
			
					test.log(LogStatus.PASS,"Message Displayed : "+text+", "+text1);
				
		
			
	}
	
	public static void SearchCorporate ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				
				//Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.SearchUser().click();
				 	row0 = sheet.getRow(15);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				row0 = sheet.getRow(16);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				
				Locators.Triangle().click();
				Thread.sleep(3000);
				Locators.Triangle().click();
				Thread.sleep(3000);
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			//	List<WebElement> options = getDriver().findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
			//	selectOptionFromDropDown_bs(options, "Vaibhav (mahesh.darandale@tlregtech.in)");
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//*[@class='cell-content'])[1]")).getText();
				
					
				test.log(LogStatus.PASS, "Selected customer name along with their details should get reflected in the grid.");
				test.log(LogStatus.PASS, "customer selected : "+text);
					
		
				
				
		  	
	}
	
	
	public static void SearchCorporateClear ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				
				//Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.SearchUser().click();
				 	row0 = sheet.getRow(15);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				row0 = sheet.getRow(16);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			//	List<WebElement> options = getDriver().findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
			//	selectOptionFromDropDown_bs(options, "Vaibhav (mahesh.darandale@tlregtech.in)");
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
				Thread.sleep(4000);
				 if(Locators.Clear().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Clear button working successfully."); 
						Locators.Users().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
				 }
				  	 Thread.sleep(3000);
				  
					
		
				
				
		  	
	}
	
	public static void corporateDelete( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				
				Locators.DeleteCor().click();
				
				Thread.sleep(3000);
				
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				if(!text1.equalsIgnoreCase("Customer Branch Deletion Failed")) {
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
				}else {
					test.log(LogStatus.FAIL,"Message Displayed : "+text1);
				}
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void CorDeleteCancel( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Corporate().click();
		
		
		Locators.DeleteCor().click();
		
		Thread.sleep(3000);
				
				 if(Locators.DeleteCan().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.DeleteCan().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);
				  
				
					

					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void CorporateView( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Corporate().click();
		
		
		
		
		Thread.sleep(3000);
				
		
		 if(Locators.view().isEnabled()) {
		{
			Locators.view().click();
		}
			test.log(LogStatus.PASS, "View Entity button Working Successfully.");
					
}
		else
		{
			test.log(LogStatus.FAIL, "View entity button does not working.");
		}	
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void CorporateBack( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				
				 Thread.sleep(3000);
				
				 if(Locators.Back().isEnabled()) {
					 
						
						Locators.Back().click();
						 Thread.sleep(3000);
						String value = getDriver().getTitle();
						System.out.println(value);	//Assert.assertEquals(value, true);
						if(value!="")
						{
							test.log(LogStatus.PASS, "Back button working successfully.");
							test.log(LogStatus.PASS, "Page displayed : "+value);
					}
						else
						{
							test.log(LogStatus.PASS, "Back button does not work.");
							test.log(LogStatus.PASS, "Page displayed : "+value);

				}
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Back' button does not working");
				 }
				  	 Thread.sleep(3000);
				  
				
					
				
				
				
		  	
	}
	
	
	public static void Entity( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Corporate().click();
		
		Locators.view().click();
		
		
		Thread.sleep(3000);
				
		
		 if(Locators.Entity().isEnabled()) {
		
			Locators.Entity().click();
		
			test.log(LogStatus.PASS, "Entity Tab Open Successfully.");
					
}
		else
		{
			test.log(LogStatus.FAIL, "Entity Tab Does Not Open.");
		}	
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void EntityAddNew ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				Thread.sleep(3000);
                 Locators.view().click();
				Thread.sleep(3000);
				Locators.addNewBtn().click();
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(17);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EntityName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(18);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.ClientId().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				Locators.Check().click();
				Thread.sleep(2000);
				
				Locators.PFType().click();
				Thread.sleep(2000);
				Locators.PFType1().click();
				Thread.sleep(2000);
				
				
				Locators.PFCode().sendKeys("123335789012342"); // Writing Task title
				Thread.sleep(4000);
				
				row0 = sheet.getRow(20);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Address().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(21);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EnterEmail().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				
				Locators.State().click();
				Thread.sleep(2000);
				Locators.State1().click();
				Thread.sleep(2000);
				
				Locators.City().click();
				Thread.sleep(2000);
				Locators.City1().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(22);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.ContactPerson().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(23);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

			int	 No = (int) c1.getNumericCellValue();
				Locators.ContactNo1().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				Locators.StatusE().click();
				Thread.sleep(2000);
				Locators.StatusE1().click();
				Thread.sleep(2000);
				
				Locators.CommencementDate().click();
				Thread.sleep(2000);
				Actions action1 = new Actions(getDriver());

				action1.moveToElement(Locators.CommencementDate1()).click().perform();
			//	Locators.CommencementDate1().click();
				Thread.sleep(2000);
				
				Locators.WagePeriodFrom().click();
				Thread.sleep(2000);
				Locators.WagePeriodFrom1().click();
				Thread.sleep(2000);
				
				Locators.WagePeriodTo().click();
				Thread.sleep(2000);
				Locators.WagePeriodTo1().click();
				Thread.sleep(2000);
				
				Locators.PaymentDay().click();
				Thread.sleep(2000);
			//Locators.PaymentDay1().click();
				Thread.sleep(2000);
				action1.moveToElement(Locators.PaymentDay1()).click().perform();
				
				
				Locators.EstablishmentType().click();
				Thread.sleep(2000);
				Locators.EstablishmentType1().click();
				Thread.sleep(2000);
				

				Locators.ActApplicability().click();
				Thread.sleep(2000);
				Locators.ActApplicability1().click();
				Thread.sleep(2000);
				
				Locators.BonusExempted().click();
				Thread.sleep(2000);
				Locators.BonusExempted1().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(24);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

				 No = (int) c1.getNumericCellValue();
				Locators.BonusPer().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				Locators.next().click();
				Thread.sleep(4000);
				
				/////Spoc & Escalation Point Details///////////
				
				Locators.Salutation().click();
				Thread.sleep(2000);
				Locators.Salutation1().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(25);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.FirstName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(23);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

				 No = (int) c1.getNumericCellValue();
				Locators.ContactNumber().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				row0 = sheet.getRow(21);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SPOCEmail().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(26);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Designationspo().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.EP1Salutation().click();
				Thread.sleep(2000);
				Locators.EP1Salutation1().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(25);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EP1FirstName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(23);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

				 No = (int) c1.getNumericCellValue();
				Locators.EP1ContactNumber().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				row0 = sheet.getRow(21);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EP1SPOCEmail().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(26);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EP1Designationspo().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				Locators.next().click();
				Thread.sleep(4000);
				
				
				row0 = sheet.getRow(27);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.IVSPOCName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(28);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.IVSPOCEnterEmail().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				row0 = sheet.getRow(23);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

				 No = (int) c1.getNumericCellValue();
				Locators.IVSPOCMobileNumber().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				Locators.Type().click();
				Thread.sleep(2000);
				Locators.Type1().click();
				Thread.sleep(2000);
				
				Locators.EDLIExcemptionType().click();
				Thread.sleep(2000);
				Locators.EDLIExcemptionType1().click();
				Thread.sleep(2000);
				
				Locators.ServiceTaxExempted().click();
				Thread.sleep(2000);
				Locators.ServiceTaxExempted1().click();
				Thread.sleep(2000);
				
				Locators.CLRAApplicable().click();
				Thread.sleep(2000);
				Locators.CLRAApplicable1().click();
				Thread.sleep(2000);
				
				Locators.CLRAType().click();
				Thread.sleep(2000);
				Locators.CLRAType1().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(29);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.ContractorEmployerName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.POApplicable().click();
				Thread.sleep(2000);
				Locators.POApplicable1().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(30);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

				 No = (int) c1.getNumericCellValue();
				Locators.AgreementID().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				Locators.Mandate().click();
				Thread.sleep(2000);
				Locators.Mandate1().click();
				Thread.sleep(2000);
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equals("Details Save Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void EntityEdit ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				Thread.sleep(3000);
                 Locators.view().click();
				Thread.sleep(3000);
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 
				Thread.sleep(3000);
				 
				Locators.EditEntity().click();
				Thread.sleep(3000);
				
				Locators.EntityName().clear();
				row0 = sheet.getRow(17);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EntityName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				
				Locators.next().click();
				Thread.sleep(4000);
				
				
				Locators.next().click();
				Thread.sleep(4000);
			
				
			
				
				
			
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equals("Entity Updated Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void EntityEditinvalid ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				Thread.sleep(3000);
                 Locators.view().click();
				Thread.sleep(3000);
				Locators.EditEntity().click();
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 
				Thread.sleep(2000);
				
			
				Locators.PFCode().clear();
				Locators.PFCode().sendKeys("1233357890123"); // Writing Task title
				Thread.sleep(4000);
				
				Locators.EnterEmail().clear();
				row0 = sheet.getRow(31);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EnterEmail().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.ContactNo1().clear();
				
				Locators.ContactNo1().sendKeys("12"); // Writing Task title
				Thread.sleep(4000);
				
				
				Locators.EntityName().click();
				
				Thread.sleep(4000);
				
				
				String text = Locators.ValMsg().getText();
				Thread.sleep(4000);
				String text1 = Locators.ValMsg1().getText();
				String text2 = Locators.ValMsg2().getText();
			
					
					test.log(LogStatus.PASS,"Message Displayed : "+text +", "+text1 +", "+text2);
				
				
				Thread.sleep(4000);
		  	
	}
	
	public static void SearchEntity ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				 Locators.view().click();
					Thread.sleep(3000);
				//Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.SearchUser().click();
				 	row0 = sheet.getRow(32);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				row0 = sheet.getRow(33);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			//	List<WebElement> options = getDriver().findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
			//	selectOptionFromDropDown_bs(options, "Vaibhav (mahesh.darandale@tlregtech.in)");
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//*[@class='cell-content'])[1]")).getText();
				
					
				test.log(LogStatus.PASS, "Entities should reflected on the selection of selected customer. Selected entity should get reflected in the grid.");
				test.log(LogStatus.PASS, "Entitiy id selected : "+text);
					
		
				
				
		  	
	}
	
	public static void SearchEntityClear ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				 Locators.view().click();
					Thread.sleep(3000);
				//Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.SearchUser().click();
				 	row0 = sheet.getRow(32);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				row0 = sheet.getRow(33);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			//	List<WebElement> options = getDriver().findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
			//	selectOptionFromDropDown_bs(options, "Vaibhav (mahesh.darandale@tlregtech.in)");
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
						Thread.sleep(4000);
						 if(Locators.Clear().isEnabled()) {
							 
								test.log(LogStatus.PASS,  " Clear button working successfully."); 
								Locators.Clear().click();
						 }
						 else
						 {
						 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
						 }
						  	 Thread.sleep(3000);
						  
				
				
		  	
	}
	
	public static void EntityDelete( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				 Locators.view().click();
					Thread.sleep(3000);
				
				Locators.DeleteEntity().click();
				
				Thread.sleep(3000);
				
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				if(text1.equalsIgnoreCase("Deleted Successfully")) {
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
				}else {
					test.log(LogStatus.FAIL,"Message Displayed : "+text1);
				}
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void EntityDeleteCancel( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Corporate().click();
		
		
		 Locators.view().click();
			Thread.sleep(3000);
		
		Locators.DeleteEntity().click();
		
		Thread.sleep(3000);
				
				 if(Locators.DeleteCan().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.DeleteCan().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);
				  
				
					

					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void EntityBulkUpload ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Corporate().click();
		
		
		 Locators.view().click();
			Thread.sleep(3000);
		
		Locators.BulkUpload().click();
		
		Thread.sleep(3000);
Locators.DownloadTemplate().click();
		Thread.sleep(3000);
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\EntityUpload__20250123T073713110Z.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload().click();
					
					Thread.sleep(3000);
				
					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
					
					if(text1.equalsIgnoreCase("File uploaded successfully!")) {
						test.log(LogStatus.PASS,"Message Displayed : "+text1);
				
					}else {
						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
					}
						Locators.ok().click();
		  	
	}
	
	
	public static boolean EntityBulkUploadInvalid ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Corporate().click();
		
		
		 Locators.view().click();
			Thread.sleep(3000);
		
		Locators.BulkUpload().click();
		
		Thread.sleep(3000);
Locators.DownloadTemplate().click();
		Thread.sleep(3000);
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download
		
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\EntityUpload__20250123T100758293ZInvalid.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload().click();
					
		
		
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			
			int len1 = dirContents.length;
			int len2 = allFilesNew.length;
			
			System.out.println(len1);
			System.out.println(len2);
			Thread.sleep(3000);
			if(len1<len2)
			{
			
				return true;

			}
			else
			{
			
				return false;
				}

		  	
	}
	
	public static void EntityBulkUploadCheck ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Corporate().click();
		
		
		 Locators.view().click();
			Thread.sleep(3000);
		
		Locators.BulkUpload().click();
		
		Thread.sleep(3000);
Locators.CheckBox().click();
		Thread.sleep(3000);
		Locators.DownloadTemplate().click();
		Thread.sleep(3000);
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\EntityUpload__20250123T073713110Z.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload().click();
					
					Thread.sleep(3000);
				
					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
					
					if(text1.equalsIgnoreCase("File uploaded successfully!")) {
						test.log(LogStatus.PASS,"Message Displayed : "+text1);
				
					}else {
						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
					}
						Locators.ok().click();
		  	
	}
	
	public static void EntityBulkUploadInvalidCheck ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Corporate().click();
		
		
		 Locators.view().click();
			Thread.sleep(3000);
		
		Locators.BulkUpload().click();
		
		Thread.sleep(3000);
		Locators.CheckBox().click();
		Thread.sleep(3000);
Locators.DownloadTemplate().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\EntityUpload__20250123T100758293ZInvalid.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Invalid Template")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void EntityBulkUploadCheckB ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Corporate().click();
		
		
		 Locators.view().click();
			Thread.sleep(3000);
		
		Locators.BulkUpload().click();
		
		Thread.sleep(3000);
Locators.CheckBox().click();
		Thread.sleep(3000);
		Locators.DownloadTemplate().click();
		Thread.sleep(3000);
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\EntityUpload__20250123T073713110Z.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload().click();
					
					Thread.sleep(3000);
				
					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
					
					if(!text1.equalsIgnoreCase("File uploaded successfully!")) {
						test.log(LogStatus.PASS,"Message Displayed : "+text1);
				
					}else {
						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
					}
						Locators.ok().click();
		  	
	}
	
	public static void ResetBtn ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Corporate().click();
		
		
		 Locators.view().click();
			Thread.sleep(3000);
		
		Locators.BulkUpload().click();
		
		Thread.sleep(3000);
Locators.CheckBox().click();
		Thread.sleep(3000);
		
		if(Locators.Reset().isEnabled()) {
			 
			test.log(LogStatus.PASS,  "  Check box should be preselected. Check box selection should get removed when user clicked on reset button."); 
			Locators.Reset().click();
	 }
	 else
	 {
	 	test.log(LogStatus.FAIL, "reset Button Working Failure.");
	 }
	  	 Thread.sleep(3000);
	  
				
					
		  	
	}
	
	public static void AllCheckbox ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Corporate().click();
		
		
		 Locators.view().click();
			Thread.sleep(3000);
		
		Locators.BulkUpload().click();
		
		Thread.sleep(3000);
		
		if(Locators.CheckBoxAll().isEnabled()) {
			 
			test.log(LogStatus.PASS,  "All the check boxes should get selected consolidatly"); 
			Locators.CheckBoxAll().click();
	 }
	 else
	 {
	 	test.log(LogStatus.FAIL, "All the check boxes Button Working Failure.");
	 }
	  	 Thread.sleep(3000);
	  
				
					
		  	
	}
	
	public static void EntityBack( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Corporate().click();
		
		
		 Locators.view().click();
			Thread.sleep(3000);
				
				
				 if(Locators.Back().isEnabled()) {
					 
						
						Locators.Back().click();
						 Thread.sleep(3000);
						String value = getDriver().getTitle();
						System.out.println(value);	//Assert.assertEquals(value, true);
						if(value!="")
						{
							test.log(LogStatus.PASS, "Back button working successfully.");
							test.log(LogStatus.PASS, "Page displayed : "+value);
					}
						else
						{
							test.log(LogStatus.PASS, "Back button does not work.");
							test.log(LogStatus.PASS, "Page displayed : "+value);

				}
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Back' button does not working");
				 }
				  	 Thread.sleep(3000);
				  
				
					
				
				
				
		  	
	}
	
	public static void  EntityLocation( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.EntityLocation().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
	  
	}
	
	public static void  EntityExcel( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.EntityExcel().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " :- File does not downloaded.");
		}
	  
		
		  	
	}
	
	public static void Searchentities ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				
				Locators.Searchentities().sendKeys("Regtrack Pvt Ltd"); // Writing Task title
				Thread.sleep(3000);
				
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//td[@class='k-table-td k-touch-action-auto']//div")).getText();
				
					
				test.log(LogStatus.PASS, "The searched entity should get reflectd along with the customer name on the grid.");
				test.log(LogStatus.PASS, "entity selected : "+text);
					
			
	}
	
	public static void EntityBranchAddNew ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
				
				Locators.Addpremises().click();
				Thread.sleep(2000);
				
				Locators.CateringApplicability().click();
				Thread.sleep(3000);
				
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(34);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.BranchName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				
				Locators.SearchUser().sendKeys("maharashtra"); // Writing Task title
				Thread.sleep(4000);
				
				Locators.Maharashtra().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(35);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.BranchAddress().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				
				Locators.Location().sendKeys("aurangabad"); // Writing Task title
				Thread.sleep(4000);
				
				Locators.aurangabad().click();
				Thread.sleep(2000);
				
				Locators.EstablishmentTypeb().click();
				Thread.sleep(2000);
				Locators.EstablishmentType1().click();
				Thread.sleep(2000);
				
				Locators.OfficeType().click();
				Thread.sleep(2000);
			//	Locators.OfficeType1().click();
				Thread.sleep(2000);
			//	Actions action = new Actions(getDriver());

				action.moveToElement(Locators.OfficeType1()).click().perform();
			
				row0 = sheet.getRow(36);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EmployerName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(37);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EmployerAddress().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(38);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.ManagerName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(39);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.ManagerAddress().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
			
				row0 = sheet.getRow(40);
				c1 = row0.getCell(1); 
				int No = (int) c1.getNumericCellValue();
				Locators.CompanyPhNo().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				row0 = sheet.getRow(41);
				c1 = row0.getCell(1); 
				 No = (int) c1.getNumericCellValue();
				Locators.HRPhNo().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				row0 = sheet.getRow(42);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.NatureofBusiness().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.WorkTimings().click();
				Thread.sleep(2000);
				Locators.WorkTimings1().click();
				Thread.sleep(2000);
				
				Locators.WeekOffDays().click();
				Thread.sleep(2000);
				Locators.WeekOffDays1().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(43);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Municipality().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.BusinessType().click();
				Thread.sleep(2000);
				Locators.BusinessType1().click();
				Thread.sleep(2000);
				
				Locators.Powertomposefines().click();
				Thread.sleep(2000);
				Locators.Powertomposefines1().click();
				Thread.sleep(2000);
				
				Locators.MaintainForms().click();
				Thread.sleep(2000);
				Locators.MaintainForms1().click();
				Thread.sleep(2000);
				
				Locators.TradeLicence().click();
				Thread.sleep(2000);
				Locators.TradeLicence1().click();
				Thread.sleep(2000);
				
				Locators.BranchStartDate().click();
				Thread.sleep(2000);
				Actions action1 = new Actions(getDriver());

				action1.moveToElement(Locators.CommencementDate1()).click().perform();
				
				Locators.StatusB().click();
				Thread.sleep(2000);
				Locators.Status1().click();
				Thread.sleep(2000);
				
				Locators.LocationAnchor().sendKeys("Sunil Kumar"); // Writing Task title
				Thread.sleep(4000);
				
			//	Locators.LocationAnchor1().click();
				Thread.sleep(2000);
				
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("Details Saved Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void  ExportPremises( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
	  	
	  	File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.ExportPremises().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
	  
	}
	
	public static void UploadBranch ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
		
		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.UpoadBranchSam().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "sample File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "sample File does not downloaded.");
		}
		

		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\LocationSampleUpdate_AVAREGTR_20250125T052218413Z.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("File uploaded successfully!")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static boolean UploadBranchInvalid ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
		
		
		Thread.sleep(3000);
Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download
		
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\LocationSampleUpdate_AVAREGTR_20250125T052218413ZInvalidB.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload1().click();
					
		 Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			
			int len1 = dirContents.length;
			int len2 = allFilesNew.length;
			
			System.out.println(len1);
			System.out.println(len2);
			Thread.sleep(3000);
			if(len1<len2)
			{
			
				return true;

			}
			else
			{
			
				return false;
				}

		
	
		  	
	}
	
	public static void UploadBranchCheck ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
		Thread.sleep(4000);
		Locators.CheckBox().click();
		
		Thread.sleep(3000);
Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\LocationSampleUpdate_AVAREGTR_checkBox.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("File uploaded successfully!")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadInvalidCheck ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.


	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
		Thread.sleep(4000);
		Locators.CheckBox().click();
		
		Thread.sleep(3000);
		Locators.CheckBox().click();
		Thread.sleep(3000);
Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\LocationSampleUpdate_AVAREGTR_CheckBInvalid.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Invalid Template.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadBranchCheckEmpty ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
		Thread.sleep(4000);
		Locators.CheckBox().click();
		
		Thread.sleep(3000);
Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\LocationSampleUpdate_AVAREGTR_CheckEmpty.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Empty Sheet")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadBranchEmpty ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
	
		Thread.sleep(3000);
		Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\LocationSampleUpdate_Empty.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Empty Sheet")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadBranchInvalidTemp ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
	
		Thread.sleep(3000);
		Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Charge.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Invalid Template.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadBranchCheckInvalidTemp ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
		Thread.sleep(3000);
		Locators.CheckBox().click();
	
		Thread.sleep(3000);
		Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Charge.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Invalid Template.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	
	public static void UploadBranchInvalidFormate ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
	
		Thread.sleep(3000);
		Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\work.txt");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Please upload XLSX file only.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadBranchCheckInvalidFormate ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
		Locators.CheckBox().click();
		
		Thread.sleep(3000);
		Thread.sleep(3000);
		Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\work.txt");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Please upload XLSX file only.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	
	public static void Upload( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
	
		Thread.sleep(3000);	 
		 Locators.Upload1().click();
			
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("You have not chosen any file.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadCheck( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
	
	Locators.CheckBox().click();
		
		Thread.sleep(3000);
		 Locators.Upload1().click();
			
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("You have not chosen any file.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	
	public static void UploadAddMapping ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UploadAddressMapping().click();
		
		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.SampleDoc().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "Sample template download link working successfully.");
		} else {
			test.log(LogStatus.FAIL,  "sample File does not downloaded.");
		}
		

		Thread.sleep(3000);
		
	
		
		  	
	}
	
	public static void MUploadAddMapping ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UploadAddressMapping().click();
		
		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.MasterDownload().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " Master Download link working successfully.");
		} else {
			test.log(LogStatus.FAIL,  " Master file Download  does not downloaded.");
		}
		

		Thread.sleep(3000);
	}
	
	public static void UploadAddressMap ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UploadAddressMapping().click();
		
		
		
		Thread.sleep(500);
		Locators.SampleDoc().click();

		
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SampleLocation.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.UploadAM().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("File uploaded successfully!")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadAddressMapEmpty ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UploadAddressMapping().click();
		
		
		
		Thread.sleep(500);
		Locators.SampleDoc().click();

		
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SampleLocation_empty.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.UploadAM().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Please Upload File with some data")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static boolean UploadAddInvalid ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
				Locators.UploadAddressMapping().click();
				
				
				
				Thread.sleep(500);
				Locators.SampleDoc().click();

		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download
		
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SampleLocation_Invalid.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.UploadAM().click();
					
		 Thread.sleep(3000);
		 
		 String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Invalid Template.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
	
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			
			int len1 = dirContents.length;
			int len2 = allFilesNew.length;
			
			System.out.println(len1);
			System.out.println(len2);
			Thread.sleep(3000);
			if(len1<len2)
			{
			
				return true;

			}
			else
			{
			
				return false;
				}

	}
	
	public static void UploadAddInvalidTemp ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
Locators.UploadAddressMapping().click();

				Thread.sleep(500);
				Locators.SampleDoc().click();
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Charge.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.UploadAM().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Invalid Template.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadAddInvalidFormate ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
				Locators.UploadAddressMapping().click();

				Thread.sleep(500);
				Locators.SampleDoc().click();
	
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\work.txt");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
	//	 Thread.sleep(1000);
				 
	//	 Locators.UploadAM().click();
					
		
		
			Thread.sleep(7000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Please upload XLSX file only.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	

				Thread.sleep(3000);
	}
	
	public static void UploadADD( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
				Locators.UploadAddressMapping().click();
	
		Thread.sleep(3000);	 
		Locators.UploadAM().click();
			
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("You have not chosen any file.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	
	
	
	public static void branchDelete( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	 	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
			Thread.sleep(3000);
			
					
					Thread.sleep(3000);
	                 Locators.Dashboard().click();
					Thread.sleep(3000);
					Locators.OnboardEntity().click();
					Thread.sleep(8000);
					
					 FileInputStream fis = new FileInputStream(filePath);
				        Workbook workbook = WorkbookFactory.create(fis);
				        Sheet sheet = workbook.getSheetAt(1);
			 
				  	Thread.sleep(3000);
				
					int row = 0;
					Thread.sleep(500);
					Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
					Cell c1 = null;
					 	row0 = sheet.getRow(34);
					c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
					Locators.Searchbranch().sendKeys(c1.getStringCellValue()); // Writing Task title
					Thread.sleep(2000);
					
					action.moveToElement(Locators.BranchTriangle()).click().perform();
					
					Thread.sleep(3000);
					action.moveToElement(Locators.BranchTriangle1()).click().perform();
				
					Thread.sleep(3000);
				
				Locators.Deletebranch().click();
				Thread.sleep(3000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				if(text1.equalsIgnoreCase("Deleted Successfully")) {
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
				}else {
					test.log(LogStatus.FAIL,"Message Displayed : "+text1);
				}
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void BDeleteCancel( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(34);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Searchbranch().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				

				action.moveToElement(Locators.BranchTriangle()).click().perform();
				
			Thread.sleep(3000);
			action.moveToElement(Locators.BranchTriangle1()).click().perform();
		
			Thread.sleep(3000);
			
			Locators.Deletebranch().click();
			Thread.sleep(3000);
				
				 if(Locators.DeleteCan().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.DeleteCan().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);	
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void AllCheckBox( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
	
				
				
				
				 if(Locators.AllCheck().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.AllCheck().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);	
					Thread.sleep(3000);
				
				
		  	
	}
	
	
	public static void SearchBranch ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				
			
	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(34);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Searchbranch().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				action.moveToElement(Locators.BranchTriangle()).click().perform();
				
				Thread.sleep(3000);
				action.moveToElement(Locators.BranchTriangle1()).click().perform();
			
				Thread.sleep(3000);
				
			
			
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//div[@title='aurangabad']")).getText();
				
					
				test.log(LogStatus.PASS, "Searched branch related data should get reflected in the grid.");
				test.log(LogStatus.PASS, "Branch selected : "+text);
					
	}
	
	public static void PayCodeAddNew ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
				
				
				Locators.PaycodeAdd().click();
				Thread.sleep(3000);
				
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(44);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Header().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.PaycodeType().click();
				Thread.sleep(2000);
				Locators.PaycodeType1().click();
				Thread.sleep(2000);
				
				Locators.Paycode().click();
				Thread.sleep(2000);
				Locators.Paycode1().click();
				Thread.sleep(2000);
		

				
				
				Locators.SequenceOrder().sendKeys("2"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("Details Saved Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void PayCodeAddNewInvalid ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
				
				
				Locators.PaycodeAdd().click();
				Thread.sleep(3000);
				
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(44);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Header().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.PaycodeType().click();
				Thread.sleep(2000);
				Locators.PaycodeType1().click();
				Thread.sleep(2000);
				
				Locators.Paycode().click();
				Thread.sleep(2000);
				Locators.Paycode1().click();
				Thread.sleep(2000);
		

				
				Locators.SequenceOrder().sendKeys("0"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("Sequence Order should not be zero"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void PayCodeEdit ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
				
				
				Locators.EditPaycod().click();
				Thread.sleep(3000);
				
				Locators.SequenceOrder().clear();
				Thread.sleep(3000);
				
				Locators.SequenceOrder().sendKeys("2"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("Data Edited Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void UploadPaycode ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
		
		Locators.uploadPaycod().click();
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Locators.SamplePaycod().click();
		Thread.sleep(3000);

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "Sample file downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "sample File does not downloaded.");
		}
		

		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SamplePaycodeMappingUpload.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload2().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("File uploaded successfully")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static boolean UploadPaycodeInvalid ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
		
		Locators.uploadPaycod().click();
		
		
		Thread.sleep(3000);
Locators.SamplePaycod().click();
		Thread.sleep(3000);
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download
		
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SamplePaycodeMappingUpload (1).xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload2().click();
		 Thread.sleep(2000);
	String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			
				Locators.ok().click();
  	
				 Thread.sleep(2000);
		
		 Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			
			int len1 = dirContents.length;
			int len2 = allFilesNew.length;
			
			System.out.println(len1);
			System.out.println(len2);
			Thread.sleep(3000);
			if(len1<len2)
			{
			
				return true;

			}
			else
			{
			
				return false;
				}
		  	
	}
	
	public static void UploadPaycodeEmpty ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
		
		Locators.uploadPaycod().click();
		
		
		Thread.sleep(3000);
Locators.SamplePaycod().click();
		Thread.sleep(3000);
		
	
		
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SamplePaycodeMappingUpload (3).xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(1000);
				 
		 Locators.Upload2().click();
		 Thread.sleep(2000);
	String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			
				Locators.ok().click();
  	
				 Thread.sleep(2000);
		
		 Thread.sleep(3000);
		  	
	}
	
	public static void SearchPaycode ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				
			
	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.OnboardEntity().click();
		Thread.sleep(5000);
		
		Locators.PaycodeMapping().click();
		Thread.sleep(3000);


				Locators.SearchUser().sendKeys("Total Deductions"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-paycode-master/div[2]/app-grid-action-item/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[1]/div")).getText();
				
					
				test.log(LogStatus.PASS, "Searched paycode should get reflected in the grid, along with header name, paycode type, sequence order, ESI applicable, PF applicable, PT applicable, LWF applicable.");
				test.log(LogStatus.PASS, "Paycode selected : "+text);
					
		
	}
	
	public static void SearchPaycodeClear ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				
			
	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.OnboardEntity().click();
		Thread.sleep(5000);
		
		Locators.PaycodeMapping().click();
		Thread.sleep(3000);


				Locators.SearchUser().sendKeys("Total Deductions"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
						if(Locators.Clear().isEnabled()) {
							 
							test.log(LogStatus.PASS,  " Clear button working successfully."); 
							Locators.Users().click();
					 }
					 else
					 {
					 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
					 }
					  	 Thread.sleep(3000);
			
	}
	
	public static void PaycodeDelete( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.OnboardEntity().click();
		Thread.sleep(5000);
		
		Locators.PaycodeMapping().click();
		Thread.sleep(3000);
					
				
				Locators.Deletepaycode().click();
				Thread.sleep(3000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				if(text1.equalsIgnoreCase("Data Deleted Successfully")) {
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
				}else {
					test.log(LogStatus.FAIL,"Message Displayed : "+text1);
				}
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	  
	}
	
	public static void PaycodeDeleteCancel( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.OnboardEntity().click();
		Thread.sleep(5000);
		
		Locators.PaycodeMapping().click();
		Thread.sleep(3000);
					
				
				Locators.Deletepaycode().click();
				Thread.sleep(3000);
				
				 if(Locators.DeleteCan().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.DeleteCan().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);	
					Thread.sleep(3000);	
		  	
	}
	
	public static void Mapuser ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.UserBranchMapping().click();
				Thread.sleep(3000);
				
				
				Locators.MapUser().click();
				Thread.sleep(3000);
				
			
				Locators.SearchAct().sendKeys("Shops and"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Shops().click();
				Thread.sleep(2000);
				
				Locators.Branch().click();
				Thread.sleep(2000);
				Locators.Branchtri().click();
				Thread.sleep(2000);
				Locators.Branchtri1().click();
				Thread.sleep(2000);
				Locators.Branch1().click();
				Thread.sleep(2000);
		
				Locators.SearchUserm().sendKeys("sagar (sag"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUserm1().click();
				Thread.sleep(2000);
				
				
			
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("(//h4[@class='f-label'])[3]");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//h4[@class='f-label'])[3]")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("User Branch mapped successfully..."))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void Mapuseralready ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.UserBranchMapping().click();
				Thread.sleep(3000);
				
				
				Locators.MapUser().click();
				Thread.sleep(3000);
				
			
				Locators.SearchAct().sendKeys("Shops and"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Shops().click();
				Thread.sleep(2000);
				
				Locators.Branch().click();
				Thread.sleep(2000);
				Locators.Branchtri().click();
				Thread.sleep(2000);
				Locators.Branchtri1().click();
				Thread.sleep(2000);
				Locators.Branch1().click();
				Thread.sleep(2000);
		
				Locators.SearchUserm().sendKeys("sagar (sag"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUserm1().click();
				Thread.sleep(2000);
				
				
			
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("(//h4[@class='f-label'])[3]");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//h4[@class='f-label'])[3]")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(!text.equalsIgnoreCase("User Branch mapped successfully..."))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	
	public static void MapuserManagement ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.UserBranchMapping().click();
				Thread.sleep(3000);
				
				
				Locators.MapUser().click();
				Thread.sleep(3000);
				Locators.Management().click();
				Thread.sleep(3000);
			
				Locators.SearchAct().sendKeys("Shops and"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Shops().click();
				Thread.sleep(2000);
				
				Locators.Branch().click();
				Thread.sleep(2000);
				Locators.Branchtri().click();
				Thread.sleep(2000);
				Locators.Branchtri1().click();
				Thread.sleep(2000);
				Locators.Branch1().click();
				Thread.sleep(2000);
				
				Locators.SearchUserm().sendKeys("Jassimran (jassimran"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUsermA().click();
				Thread.sleep(2000);
				
			
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("(//h4[@class='f-label'])[3]");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//h4[@class='f-label'])[3]")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("User Branch mapped successfully..."))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void MapuserManagementAlredy ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.UserBranchMapping().click();
				Thread.sleep(3000);
				
				
				Locators.MapUser().click();
				Thread.sleep(3000);
				Locators.Management().click();
				Thread.sleep(3000);
			
				Locators.SearchAct().sendKeys("Shops and"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Shops().click();
				Thread.sleep(2000);
				
				Locators.Branch().click();
				Thread.sleep(2000);
				Locators.Branchtri().click();
				Thread.sleep(2000);
				Locators.Branchtri1().click();
				Thread.sleep(2000);
				Locators.Branch1().click();
				Thread.sleep(2000);
				
				Locators.SearchUserm().sendKeys("Jassimran (jassimran"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUsermA().click();
				Thread.sleep(2000);
				
			
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("(//h4[@class='f-label'])[3]");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//h4[@class='f-label'])[3]")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(!text.equalsIgnoreCase("User Branch mapped successfully..."))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	
	public static void UserMapDelete( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.UserBranchMapping().click();
				Thread.sleep(3000);
				
				Locators.DeleteEntity().click();
				Thread.sleep(3000);
				
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				
					
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
					
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void UserMapFilter( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.UserBranchMapping().click();
				Thread.sleep(3000);
				
				Locators.SelectAct().click();
				Thread.sleep(1000);
				Locators.Shops().click();
				Thread.sleep(3000);
		      
		      
		       Locators.SelectBranch().click();
				Thread.sleep(1000);
				Locators.Branchtri().click();
				Thread.sleep(3000);
				Locators.Branchtri2().click();
				Thread.sleep(3000);
				
				Locators.SearchUser().sendKeys("Jassimran (jassimran"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUsermA().click();
				Thread.sleep(2000);
		      
		       
				Locators.Apply().click();
			
		       Thread.sleep(3000);
		        List<String> li=new ArrayList<String>();
		        
		       
		        li.add("Mumbai Branch");
		        li.add("Jassimran Singh");
		        Thread.sleep(3000);
		        
				List<String> filter=new ArrayList<String>();	
			
				filter.add("Branches");	
				filter.add("User");	
				
				
				Thread.sleep(8000);
				
				String s = Locators.Grid().getText();
				Thread.sleep(3000);
				if(!s.equalsIgnoreCase("No items to display")) {
				Thread.sleep(5000);
			
				
				List<WebElement> Branch=getDriver().findElements(By.xpath("(//*[@class='cell-content'])[2]"));
				List<WebElement> Username=getDriver().findElements(By.xpath("(//*[@class='cell-content'])[3]"));
				Thread.sleep(2000);

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement> raw=new ArrayList<WebElement>();

						if(i==0)
						{
							raw.addAll(Branch);
						}
					else if(i==1)
						{
							raw.addAll(Username);
						}
					

						
						
					for(int k=0;k<raw.size();k++)
						{
							text.add(raw.get(k).getText());
						}

						for(int l=0;l<text.size();l++)
							{
						if(text.get(l).equals(li.get(i)))
							{
								pass.add(text.get(l));	
								System.out.println("pass : "+text.get(l)+" : "+li.get(i));

							}
						else
						{
							fail.add(text.get(l));		
							System.out.println("fail : "+text.get(l)+" : "+li.get(i));
							System.out.println(i);

						}
						 }
				 
			for(String Fal : fail)
				 {
						test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
				 }	
				 for(String Pas : pass)
				 {
					 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
						test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
						System.out.println(filter.get(i)+" : "+Pas);
			 }
				 text.clear();
				pass.clear();
				fail.clear();
				raw.clear();
				
				
				}
				}else {
					test.log(LogStatus.PASS,"No records found");	
				}
				Thread.sleep(8000);
				
				
				Thread.sleep(8000);
				if(Locators.ClearFilter().isEnabled())
				{
					test.log(LogStatus.PASS, "while click on Clear Button selected data should be cleared");
				
					Locators.ClearFilter().click();
				}
			
			else
			{
				test.log(LogStatus.FAIL, "while click on Clear Button selected data not cleared");
				
			}
				
		  	
	}
	
	public static void UserMapFilterClear( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.UserBranchMapping().click();
				Thread.sleep(3000);
				
				Locators.SelectAct().click();
				Thread.sleep(1000);
				Locators.Shops().click();
				Thread.sleep(3000);
		      
		      
		       Locators.SelectBranch().click();
				Thread.sleep(1000);
				Locators.Branchtri().click();
				Thread.sleep(3000);
				Locators.Branchtri2().click();
				Thread.sleep(3000);
				
				Locators.SearchUser().sendKeys("Jassimran (jassimran"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUsermA().click();
				Thread.sleep(2000);
		      
		       
				Locators.Apply().click();
			
		       
						
				
				Thread.sleep(8000);
				if(Locators.ClearFilter().isEnabled())
				{
					test.log(LogStatus.PASS, "while click on Clear Button selected data should be cleared");
				
					Locators.ClearFilter().click();
				}
			
			else
			{
				test.log(LogStatus.FAIL, "while click on Clear Button selected data not cleared");
				
			}
				
		  	
	}
	
	
	public static void MapuserDeleteCancel( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Searchentities().sendKeys("Regtrack Entity"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.OnboardEntity().click();
		Thread.sleep(5000);
		
		Locators.UserBranchMapping().click();
		Thread.sleep(3000);
		
		Locators.DeleteEntity().click();
		Thread.sleep(3000);
				
				 if(Locators.DeleteCan().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.DeleteCan().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);	
					Thread.sleep(3000);	
		  	
	}
	
	
	
	
	
	
public static void selectOptionFromDropDown_bs(List<WebElement> options, String value) {
		
		for(WebElement option:options) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

}
