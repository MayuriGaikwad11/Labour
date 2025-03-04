package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import distributor.Methods;
import login.BasePage;

public class ReviewerTest extends BasePage {
	
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static List<WebElement> elementsList1 = null;
	public static List<WebElement> elementsList2 = null;
	public static List<WebElement> elementsList3 = null;
	public static List<WebElement> elementsList4 = null;
	public static List<WebElement> menus = null;
	public int count = 0;
	public int interest = 0;					//Variable created for reading Interest
	public int penalty = 0;						//Variable created for reading Penalty
	
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\LabourAngularProject\\Report\\ReviewerResults.html",true);
		test = extent.startTest("Loging In - Reviewer");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(3,"Statutory");
	
	}
	
///////--------------------------Manage Masters - Leave Type -------------------------------------------///////////////////////
	
	@Test(priority = 1) //27/02/2025
	void Exportleavetype() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Leave Type - To check whether excel is getting downloaded or not");
		
			Methods.Exportleavetype(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 2) 
	void Searchleave() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Leave Type - To check whether search field is working or not");
		
			Methods.Searchleave(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3) 
	void SearchleaveClear() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Leave Type - To check whether search field clear or not");
		
			Methods.SearchleaveClear(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
///////--------------------------Manage Masters - Paycode Mapping -------------------------------------------///////////////////////
	
	@Test(priority = 4) 
	void PayCodeAddNewMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Validate Add New Paycode With Valid Data");
		
			Methods.PayCodeAddNewMM(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5) 
	void PayCodeAddNewInvalidMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Validate Add new Paycode With Invalid Data");
		
			Methods.PayCodeAddNewInvalidMM(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6) 
	void PayCodeEditMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Validate Paycode 'Edit' Button.");
		
			Methods.PayCodeEditMM(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 7) //2 test cases
	void UploadPaycodeMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Validate  Paycode Upload with Valid Data.");
		
			Methods.UploadPaycodeMM(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void UploadPaycodeInvalidMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Manage Masters Paycode Upload with Invalid Data.");
		
		boolean text	=	Methods.UploadPaycodeInvalidMM(test);
		if(text==true)
		{
			test.log(LogStatus.PASS, "Error text file should get downloaded with proper error message along with row number.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Failure : Error file does not downloaded.");
		}
		  
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 9)
	void UploadPaycodeEmptyMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Manage Masters Paycode Upload with Empty File.");
		
			Methods.UploadPaycodeEmptyMM(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 10)
	void UploadPaycodeforMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Manage Masters Paycode Upload with Invalid formate File.");
		
			Methods.UploadPaycodeforMM(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 11)
	void UploadPaycodeNoMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Manage Masters Paycode Upload with without selecting File.");
		
			Methods.UploadPaycodeNoMM(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12)
	void SearchPaycodeMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate searchbox Apply Button Of Paycode Mapping Tab from Manage Masters Module");
		
			Methods.SearchPaycodeMM(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void SearchPaycodeClearMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Manage Masters Paycode Mapping Clear Button");
		
			Methods.SearchPaycodeClearMM(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 14)
	void PaycodeDeleteCancelMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Delete Paycode Mapping 'Cancel' Button");
		
			Methods.PaycodeDeleteCancelMM(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15)
	void PaycodeDeleteMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - To check whether Paycode Mapping is getting deleted or not");
		
			Methods.PaycodeDeleteMM(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
///////--------------------------Manage Masters - Statutory Master -------------------------------------------///////////////////////
	
	@Test(priority = 16) 
	void ExportSM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters -Statutory Master - Register - To check whether excel is getting downloaded or not");
		
			Methods.ExportSM(test,"Challan");
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17) 
	void ExportSM1() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters -Statutory Master - Register - To check whether excel is getting downloaded or not");
		
			Methods.ExportSM(test,"Register");
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 18) 
	void ExportSM2() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters -Statutory Master - returns - To check whether excel is getting downloaded or not");
		
			Methods.ExportSM(test,"returns");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 19) //27/02/2025
	void SearchSMMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters -Statutory Master - Validate searchbox Apply Button  from Manage Masters Module");
		
			Methods.SearchSMMM(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 20) 
	void SearchSMClear() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters -Statutory Master - Validate Clear Button");
		
			Methods.SearchSMClear(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//24
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
		closeBrowser();
  		//Thread.sleep(1000);
  		//getDriver().close();
  	}	       
  		       		
  	@AfterTest
  	void Closing() throws InterruptedException
  	{
  		
  	}	 


}
