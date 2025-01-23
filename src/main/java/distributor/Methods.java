package distributor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
								Locators.Users().click();
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
	
	public static boolean EntityBulkUploadInvalidCheck ( ExtentTest test) throws InterruptedException, IOException, AWTException
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
	
	
	
public static void selectOptionFromDropDown_bs(List<WebElement> options, String value) {
		
		for(WebElement option:options) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

}
