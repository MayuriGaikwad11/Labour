package clientPortal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import distributor.Locators;
import login.BasePage;

public class ClientMethods extends BasePage {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	 static String filePath ="D:\\eclipse-workspace\\LabourAngularProject\\TestData\\Labour.xlsx";

	
	public static void filterEntity ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='k-input-inner k-readonly']")));	//Wait until records table get visible.

	  	
		ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	  	ClientLocators.EntityTri().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAENTEST().click();
		Thread.sleep(2000);
		
		ClientLocators.SelectYear().click();
		Thread.sleep(2000);
	  	ClientLocators.SelectYear22().click();
		Thread.sleep(2000);
	 	ClientLocators.Apply().click();
			Thread.sleep(4000);
		  
		  	
	}
	
	public static void Entities(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.Entities().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
	ClientLocators.Entities().click();
		Thread.sleep(5000);
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Entities in the grid = "+CatcountGrid+" | Dashboard Entities  Count = "+CategoriesCountDas);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "No of Entities in the grid = "+CatcountGrid+" | Dashboard Entities Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	
	public static void EntitiesSearch(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	ClientLocators.Entities().click();
		Thread.sleep(5000);
		try {
		ClientLocators.Search().sendKeys("AVAENTEST",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='AVAENTEST']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected entity name along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "entity selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void Locations(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.Locations().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
	ClientLocators.Locations().click();
		Thread.sleep(5000);
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Locations in the grid = "+CatcountGrid+" | Dashboard Locations  Count = "+CategoriesCountDas);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "No of Locations in the grid = "+CatcountGrid+" | Dashboard Locations Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void LocationsSearch(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	ClientLocators.Locations().click();
		Thread.sleep(5000);
		try {
		ClientLocators.Search().sendKeys("Kolhapur",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='Kolhapur']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Locations name along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Locations selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void AssignedCompliances(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.AssignedCompliances().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
	ClientLocators.AssignedCompliances().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Assigned Compliances in the grid = "+CatcountGrid+" | Dashboard Assigned Compliances  Count = "+CategoriesCountDas);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "No of Assigned Compliances in the grid = "+CatcountGrid+" | Dashboard Assigned Compliances Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void exportcount(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	ClientLocators.AssignedCompliances().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void OverviewAC(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	ClientLocators.AssignedCompliances().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		
		ClientLocators.Overview().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		
		
	}
	
	public static void ExpiredRegistrations(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.ExpiredRegistrations().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
	ClientLocators.ExpiredRegistrations().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Expired Registrations in the grid = "+CatcountGrid+" | Dashboard Expired Registrations  Count = "+CategoriesCountDas);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "No of Expired Registrations in the grid = "+CatcountGrid+" | Dashboard Expired Registrations Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void OpenNotices( ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.OpenNotices().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
	ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Open Notices in the grid = "+CatcountGrid+" | Dashboard Open Notices  Count = "+CategoriesCountDas);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "No of Open Notices in the grid = "+CatcountGrid+" | Dashboard Open Notices Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void OpenNoticesView( ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
	
	ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
		String item = ClientLocators.Viewpage().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("View Notices")) {
			test.log(LogStatus.PASS,  "Clicking on view button page redirect to the view notices page");
		}else {
			test.log(LogStatus.FAIL,  " view button not working ");

		}
		
		
	}
	
	public static void ViewAddNew ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
			  	ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
				
		ClientLocators.ViewAddNew().click();
				Thread.sleep(4000);
				ClientLocators.State().click();
				Thread.sleep(1000);
				ClientLocators.State1().click();
				Thread.sleep(3000);
				
				ClientLocators.Location().click();
				Thread.sleep(1000);
				ClientLocators.Location1().click();
				Thread.sleep(3000);
				
				ClientLocators.Branch().click();
				Thread.sleep(1000);
				ClientLocators.Branch1().click();
				Thread.sleep(3000);
				
				ClientLocators.ModeofReceipt().click();
				Thread.sleep(1000);
				ClientLocators.ModeofReceipt1().click();
				Thread.sleep(3000);
				
				ClientLocators.NoticeNumber().sendKeys("NTC1133");;
				Thread.sleep(3000);
				
				ClientLocators.NoticeReceivedDateT().sendKeys("01-02-2024");;
				Thread.sleep(3000);
				ClientLocators.NoticeReceivedDateT().sendKeys("01-02-2024");;
				Thread.sleep(3000);
				ClientLocators.NoticeReceivedDateT().sendKeys("01-02-2024");;
				Thread.sleep(3000);
				
				//ClientLocators.NoticeReceivedDate().click();
				Thread.sleep(1000);
				//Actions action1 = new Actions(getDriver());

				//action1.moveToElement(ClientLocators.NoticeReceivedDate1()).click().perform();
			//	ClientLocators.NoticeReceivedDate1().click();
				Thread.sleep(1000);
			//	ClientLocators.NoticeReceivedDate2().click();
				Thread.sleep(3000);
				
				ClientLocators.ResponseDueDate().click();
				Thread.sleep(1000);
				ClientLocators.NoticedueDate1().click();
				Thread.sleep(3000);
				
				ClientLocators.NoticeType().click();
				Thread.sleep(1000);
				ClientLocators.NoticeType1().click();
				Thread.sleep(3000);
				
				ClientLocators.Risk().click();
				Thread.sleep(1000);
				ClientLocators.Risk1().click();
				Thread.sleep(3000);
				
				ClientLocators.Browse().click();
				Thread.sleep(3000);
				Robot robot=new Robot();
				 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\ContractsList__MyWorkspace.pdf");
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
						 
				
				 ClientLocators.remark().sendKeys("remark");
					Thread.sleep(3000);
				
				
					Thread.sleep(3000);
				
				
					ClientLocators.SaveNotice().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				if(text.equalsIgnoreCase("Notice Saved Successfully"))
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
	
	
	public static void exportNotice(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void NoticeSearch(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
		try {
		ClientLocators.Search().sendKeys("NTC1122",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='NTC1122']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Notice No along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Notice No selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void NoticeSearchClear(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
				ClientLocators.Search().sendKeys("NTC1122",Keys.ENTER);
		Thread.sleep(4000);
		
		Thread.sleep(3000);
		 if(ClientLocators.Clear().isEnabled()) {
			 
				test.log(LogStatus.PASS,  " Clear button working successfully."); 
				Locators.Clear().click();
		 }
		 else
		 {
		 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
		 }
		  	 Thread.sleep(3000);
		  
		
	}
	
	public static void OpenNoticesEditback( ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
	
	ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
		ClientLocators.Edit().click();
		Thread.sleep(3000);
		ClientLocators.EditBack().click();
		Thread.sleep(3000);
		
		String item = ClientLocators.Viewpage().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("View Notices")) {
			test.log(LogStatus.PASS,  "Clicking on Back button page redirect to the view notices page");
		}else {
			test.log(LogStatus.FAIL,  " Back button not working ");

		}
		
		
	}
	
	public static void OverviewNotice(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		
		
	}
	
	public static void OpenNoticesback( ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
	
	ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
	
		ClientLocators.Edit().click();
		Thread.sleep(3000);
		ClientLocators.EditBack().click();
		Thread.sleep(3000);
		
		String item = ClientLocators.OpenNoticePage().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("Open Notices")) {
			test.log(LogStatus.PASS,  "Clicking on Back button page redirect to the Open Notices page");
		}else {
			test.log(LogStatus.FAIL,  " Back button not working ");

		}
		
		
	}
	
	public static void RegistrationStatus( ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.Active().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	ClientLocators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ActiveCol().click();
		Thread.sleep(3000);
		
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Active in the grid = "+CatcountGrid+" | Dashboard Active  Count = "+CategoriesCountDas);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "No of Active in the grid = "+CatcountGrid+" | Dashboard Active Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void RegistrationStatusExport( ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.Active().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	ClientLocators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ActiveCol().click();
		Thread.sleep(3000);
		
		
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
		
File dir = new File("C:\\Users\\mayurig\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Locators.Export().click();

Thread.sleep(5500);
File dir1 = new File("C:\\Users\\mayurig\\Downloads");
File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

if(dirContents.length < allFilesNew.length)
{
	
	test.log(LogStatus.PASS, "File downloaded successfully.");
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
		
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{
		
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
}
else
{
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
}
	
	}
	
	public static void RegistrationSView( ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	ClientLocators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ActiveCol().click();
		Thread.sleep(3000);
		
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  "view successfully.");
		
		
	}
	
	public static void DownloadActive(  ExtentTest test) throws InterruptedException, IOException
	{
	
		ClientLocators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ActiveCol().click();
		Thread.sleep(3000);
		
	
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.DownloadBtn().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void RegistrationSHistory( ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	ClientLocators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ActiveCol().click();
		Thread.sleep(3000);
		
		
		ClientLocators.History().click();
		Thread.sleep(5000);
		String item = ClientLocators.RegistrationLicencesHistory().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("Registration & Licences History")) {
			test.log(LogStatus.PASS,  "Clicking on History button page redirect to the Registration & Licences History page");
		}else {
			test.log(LogStatus.FAIL,  " History button not working ");

		}
		
	}
	
	public static void RegistrationSHistoryExport(  ExtentTest test) throws InterruptedException, IOException
	{
	
		ClientLocators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ActiveCol().click();
		Thread.sleep(3000);
		ClientLocators.History().click();
		Thread.sleep(5000);
		
	
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void RegistrationSExport(  ExtentTest test) throws InterruptedException, IOException
	{
	
		ClientLocators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
	
		
	
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	
	public static void ActiveSearch(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.Active().click();
		Thread.sleep(5000);
		ClientLocators.ActiveCol().click();
		Thread.sleep(3000);
		try {
		ClientLocators.Search().sendKeys("LCN001",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='LCN001']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected License No along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "License No selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void RegistrationSearch(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.Active().click();
		Thread.sleep(5000);
		
		try {
		ClientLocators.Search().sendKeys("Trade license",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[normalize-space()='Trade license']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected License Name along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "License Name selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void CompliancePerformance( ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.Overdue().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 2];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	ClientLocators.Overdue().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		
		js.executeScript("window.scrollBy(0,300)");	
		
		
		String string_User =ClientLocators.OverdueGrid().getText();		//Storing old value of Statutory overdue.
		int	UserCountDas = Integer.parseInt(string_User);
		if(CategoriesCountDas == UserCountDas)
		{
			
			test.log(LogStatus.PASS, "No of Overdue in the grid = "+UserCountDas+" | Dashboard Overdue  Count = "+CategoriesCountDas);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "No of Overdue in the grid = "+UserCountDas+" | Dashboard Overdue Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void PayrollCompliancesOverdue(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.PayrollCompliancesOverdue().click();
		Thread.sleep(5000);
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		
		
	}
	
	public static void exportPayrollCompliancesOverdue(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.PayrollCompliancesOverdue().click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	
	public static void ECOverdue(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.ECOverdue().click();
		Thread.sleep(5000);
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		
		
	}
	
	public static void exportEC(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.ECOverdue().click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void FCOverdue(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.FCOverdue().click();
		Thread.sleep(5000);
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		
		
	}
	
	public static void exportFC(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.FCOverdue().click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void ClraOverdue(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.ClraOverdue().click();
		Thread.sleep(5000);
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		
		
	}
	
	public static void exportClra (  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.ClraOverdue().click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void exportCP (  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.Overdue().click();
		Thread.sleep(5000);

		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void OpenStatus( ExtentTest test) throws InterruptedException, IOException
	{
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,700)");
		String string_Categories =ClientLocators.Open().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	ClientLocators.Open().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.OpenCol().click();
		Thread.sleep(3000);
		
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Open count in the grid = "+CatcountGrid+" | Dashboard Open Count = "+CategoriesCountDas);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "No of Open count in the grid = "+CatcountGrid+" | Dashboard Open Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void OpenView(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		ClientLocators.Open().click();
		Thread.sleep(5000);
		
		ClientLocators.OpenCol().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  "view successfully.");
		
		
	}
	
	public static void exportOpen (  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		ClientLocators.Open().click();
		Thread.sleep(5000);
		
		ClientLocators.OpenCol().click();
		Thread.sleep(5000);

		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void ClosedStatus( ExtentTest test) throws InterruptedException, IOException
	{
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,700)");
		String string_Categories =ClientLocators.Closed().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	ClientLocators.Closed().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ClosedCol().click();
		Thread.sleep(3000);
		
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Closed count in the grid = "+CatcountGrid+" | Dashboard Closed Count = "+CategoriesCountDas);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "No of Closed count in the grid = "+CatcountGrid+" | Dashboard Closed Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void ClosedView(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		ClientLocators.Closed().click();
		Thread.sleep(5000);
		
		ClientLocators.ClosedCol().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  "view successfully.");
		
		
	}
	
	public static void exportClosed (  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		ClientLocators.Closed().click();
		Thread.sleep(5000);
		
		ClientLocators.ClosedCol().click();
		Thread.sleep(5000);

		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void exportNoticeStatus (  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		ClientLocators.Closed().click();
		Thread.sleep(5000);

		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void RegistrationStatusBar( ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		
		String string_Categories =ClientLocators.Registration().getText();		//Storing old value of Statutory overdue.
		
		int CategoriesCountDas = Integer.parseInt(string_Categories);
     	ClientLocators.Registration().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Active in the grid = "+CatcountGrid+" | Dashboard Active  Count = "+CategoriesCountDas);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "No of Active in the grid = "+CatcountGrid+" | Dashboard Active Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	
	public static void RegistrationStatusExportBar( ExtentTest test) throws InterruptedException, IOException
	{
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(4000);
		
     	ClientLocators.Registration().click();
		Thread.sleep(5000);
		
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
		
File dir = new File("C:\\Users\\mayurig\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Locators.Export().click();

Thread.sleep(5500);
File dir1 = new File("C:\\Users\\mayurig\\Downloads");
File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

if(dirContents.length < allFilesNew.length)
{
	
	test.log(LogStatus.PASS, "File downloaded successfully.");
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
		
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{
		
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
}
else
{
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
}
	
	}

	
	public static void RegistrationSViewL( ExtentTest test) throws InterruptedException, IOException
	{
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(4000);
		
     	ClientLocators.Registration().click();
		Thread.sleep(5000);
		
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  "view successfully.");
		
		
	}
	
	public static void DownloadActiveBar(  ExtentTest test) throws InterruptedException, IOException
	{
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(4000);
		
     	ClientLocators.Registration().click();
		Thread.sleep(5000);
		
	
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.DownloadBtn().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void RegistrationSHistoryBar( ExtentTest test) throws InterruptedException, IOException
	{
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(4000);
		
     	ClientLocators.Registration().click();
		Thread.sleep(5000);
		
		
		ClientLocators.History().click();
		Thread.sleep(5000);
		String item = ClientLocators.RegistrationLicencesHistory().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("Registration & Licences History")) {
			test.log(LogStatus.PASS,  "Clicking on History button page redirect to the Registration & Licences History page");
		}else {
			test.log(LogStatus.FAIL,  " History button not working ");

		}
		
	}
	
	
	public static void RegistrationSHistoryExportBar(  ExtentTest test) throws InterruptedException, IOException
	{
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(4000);
		
     	ClientLocators.Registration().click();
		Thread.sleep(5000);
		ClientLocators.History().click();
		Thread.sleep(5000);
		
	
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void CalendarExport( ExtentTest test) throws InterruptedException, IOException
	{
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100)) ;
     	ClientLocators.ClickTriangle().click();
		Thread.sleep(2000);
		ClientLocators.nextmonth().click();
		Thread.sleep(1000);
		ClientLocators.nextmonth2025().click();
		Thread.sleep(5000);
		ClientLocators.number().click();
		Thread.sleep(5000);
		
		//ClientLocators.readTotalItems1().click();					//Clicking on total items count
		Thread.sleep(500);
		Actions action = new Actions(getDriver());

		By locator = By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-client-dashboard/div[8]/div/div/app-client-compliance-calender/div[2]/div[2]/kendo-grid/kendo-pager/kendo-pager-info");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(3000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		String item = ClientLocators.readTotalItems1().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
		
File dir = new File("C:\\Users\\mayurig\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Locators.Export().click();

Thread.sleep(5500);
File dir1 = new File("C:\\Users\\mayurig\\Downloads");
File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

if(dirContents.length < allFilesNew.length)
{
	
	test.log(LogStatus.PASS, "File downloaded successfully.");
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
		
		test.log(LogStatus.PASS, "Total records from Calendar Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{
		
		test.log(LogStatus.FAIL, "Total records from  CalendarGrid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
}
else
{
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
}
	
	}

    public static void CalendarCount( ExtentTest test) throws InterruptedException, IOException
	{
	
    	JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100)) ;
     	ClientLocators.ClickTriangle().click();
		Thread.sleep(2000);
		ClientLocators.nextmonth().click();
		Thread.sleep(1000);
		ClientLocators.nextmonth2025().click();
		Thread.sleep(5000);
		
		
		String string_Categories =ClientLocators.number().getText();		//Storing old value of Statutory overdue.
		
		int CategoriesCountDas = Integer.parseInt(string_Categories);
     	ClientLocators.number().click();
		Thread.sleep(5000);
	
		
		
		ClientLocators.readTotalItems1().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems1().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Calendar Grid = "+CatcountGrid+" | Dashboard Calendar  Count = "+CategoriesCountDas);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "No of Calendar Grid= "+CatcountGrid+" | Dashboard Calendar Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	
	
    public static void CalendarOverview( ExtentTest test) throws InterruptedException, IOException
  	{
  	
      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
  		js.executeScript("window.scrollBy(0,1500)");
  		Thread.sleep(4000);
  		WebDriverWait wait = new WebDriverWait(getDriver(), (100)) ;
       	ClientLocators.ClickTriangle().click();
  		Thread.sleep(2000);
  		ClientLocators.nextmonth().click();
  		Thread.sleep(1000);
  		ClientLocators.nextmonth2025().click();
  		Thread.sleep(5000);
       	ClientLocators.number().click();
  		Thread.sleep(5000);
  		
  		ClientLocators.OverviewCalen().click();
  		Thread.sleep(5000);
       	ClientLocators.OverviewColse().click();
  		Thread.sleep(5000);
  		test.log(LogStatus.PASS,  " Overview successfully.");
  		
  	}
    
    public static void DailyUpdates( ExtentTest test) throws InterruptedException, IOException
  	{
  	
      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
  		js.executeScript("window.scrollBy(0,2000)");
  		Thread.sleep(4000);
  		WebDriverWait wait = new WebDriverWait(getDriver(), (100)) ;
       	ClientLocators.read().click();
  		Thread.sleep(2000);
  		SwitchtoChild(test);
  		
  		test.log(LogStatus.PASS,  " read more link working  successfully.");
  	  SwitchtoParent(test);
      Thread.sleep(3000);
  	}

    public static void SwitchtoChild( ExtentTest test) throws InterruptedException, IOException
	{		
		Thread.sleep(3000);
		
		Set w = getDriver().getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver().switchTo().window(ch);         // switching child window
	      
	    
			Thread.sleep(1000);
	      
	  
	}
    
    public static void SwitchtoParent( ExtentTest test) throws InterruptedException, IOException
	{		
		Thread.sleep(3000);
		
		Set w = getDriver().getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      getDriver().close();
	      Thread.sleep(3000);
	      getDriver().switchTo().window(pw);         // switching child window
	       
	}
    
    
    public static void InputUpload ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		
	 	ClientLocators.InputUpload().click();
	 
		Thread.sleep(3000);

		ClientLocators.BrowseIn().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlyAttendance.xlsx");
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
					
					if(text1.equalsIgnoreCase("File uploaded successfully")) {
						test.log(LogStatus.PASS,"Message Displayed : "+text1);
				
					}else {
						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
					}
						Locators.ok().click();
		  	
	}
	
    public static void InputUploadTem ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		ClientLocators.SelectEntity().click();
   		Thread.sleep(2000);
   	  	ClientLocators.EntityTri1().click();
   		Thread.sleep(2000);
   		
   		ClientLocators.AVAAEntity().click();
   		Thread.sleep(2000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);
   		
   	 	ClientLocators.InputUpload().click();
   	 
   		Thread.sleep(3000);

   		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.Template().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "Template File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "Template File does not downloaded.");
		}
   		  	
   	}
   	
       
    public static void InputUploadInavlid ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{		
  		
  		Thread.sleep(3000);
  		ClientLocators.SelectEntity().click();
  		Thread.sleep(2000);
  	  	ClientLocators.EntityTri1().click();
  		Thread.sleep(2000);
  		
  		ClientLocators.AVAAEntity().click();
  		Thread.sleep(2000);
  		ClientLocators.Apply().click();
  		Thread.sleep(4000);
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlyAttendance_InvalidData.xlsx");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    public static void InputUploadBlank ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{		
  		
  		Thread.sleep(3000);
  		ClientLocators.SelectEntity().click();
  		Thread.sleep(2000);
  	  	ClientLocators.EntityTri1().click();
  		Thread.sleep(2000);
  		
  		ClientLocators.AVAAEntity().click();
  		Thread.sleep(2000);
  		ClientLocators.Apply().click();
  		Thread.sleep(4000);
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlyAttendance_Blank.xlsx");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    public static void InputUploadInvalidformate ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{		
  		
  		Thread.sleep(3000);
  		ClientLocators.SelectEntity().click();
  		Thread.sleep(2000);
  	  	ClientLocators.EntityTri1().click();
  		Thread.sleep(2000);
  		
  		ClientLocators.AVAAEntity().click();
  		Thread.sleep(2000);
  		ClientLocators.Apply().click();
  		Thread.sleep(4000);
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\ContractsList__MyWorkspace.pdf");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    
    public static void InputUploadInvalidTemp ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{		
  		
  		Thread.sleep(3000);
  		ClientLocators.SelectEntity().click();
  		Thread.sleep(2000);
  	  	ClientLocators.EntityTri1().click();
  		Thread.sleep(2000);
  		
  		ClientLocators.AVAAEntity().click();
  		Thread.sleep(2000);
  		ClientLocators.Apply().click();
  		Thread.sleep(4000);
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		ClientLocators.BrowseIn().click();
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
  				 
  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    public static void InputUploadNofile ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{		
  		
  		Thread.sleep(3000);
  		ClientLocators.SelectEntity().click();
  		Thread.sleep(2000);
  	  	ClientLocators.EntityTri1().click();
  		Thread.sleep(2000);
  		
  		ClientLocators.AVAAEntity().click();
  		Thread.sleep(2000);
  		ClientLocators.Apply().click();
  		Thread.sleep(4000);
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    
    
    
    
    
    
    
    
    

}
