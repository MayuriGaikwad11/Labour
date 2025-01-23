package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class DistributorTest  extends BasePage {
	
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
	
	public static String link = "mgmt1";  
	

	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\eclipse-workspace\\LabourAngularProject\\Report\\Labour.html",true);
		test = extent.startTest("Loging In - Distributor admin");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,0,"Statutory");
	
	}
	
	
	@Test(priority = 1)
	void User() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether user button is clickable or not.");
		
		Methods.User(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 2)
	void UserAddNew() throws InterruptedException, IOException
	{
		test = extent.startTest("Validadte Add New Button of User Master Page");
		
		Methods.UserAddNew(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void UserEdit() throws InterruptedException, IOException
	{
		test = extent.startTest("Validadte Add New Button of User Master Page");
		
		Methods.UserEdit(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void UserEditInvalid() throws InterruptedException, IOException
	{
		test = extent.startTest("Validadte Edit Button of User Master with Invalid Data");
		
		Methods.UserEditInvalid(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5) //find search
	void SearchUser() throws InterruptedException, IOException
	{
		test = extent.startTest("validadte User Dropdown of User Master Page");
		
		Methods.SearchUser(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6)
	void SearchUserClear() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Clear Button of User Master Page");
		
		Methods.SearchUserClear(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 7)
	void UserDelete() throws InterruptedException, IOException
	{
		test = extent.startTest(" Validate Delete Button of User Master Page With No Compliances Assign");
		
		Methods.UserDelete(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8) //update
	void UserDeleteAssign() throws InterruptedException, IOException
	{
		test = extent.startTest(" Validate Confirmation Message Of Delete Button for User With Compliances Assigned from User Master Page");
		
		Methods.UserDeleteAssign(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 9) 
	void UserDeleteCancel() throws InterruptedException, IOException
	{
		test = extent.startTest(" Validate 'Cancel' Button of Delete User from User Master Page");
		
		Methods.UserDeleteCancel(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 10) 
	void UserBack() throws InterruptedException, IOException
	{
		test = extent.startTest(" Validate Back Button of User Master Page");
		
		Methods.UserBack(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 11) //21/01/2025
	void ExportUser() throws InterruptedException, IOException
	{
		test = extent.startTest(" To check whether user is excel is getting downloaded or not");
		
		Methods.ExportUser(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12)
	void Corporate() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Home Page Corporate button");
		
		Methods.Corporate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void CorporateAddNew() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Corporate Page Add new customer.");
		
		Methods.CorporateAddNew(test);
		
		extent.endTest(test);
		
		extent.flush();
	}
	
	@Test(priority = 14)
	void CorporateEdit() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Corporate Page Edit customer with valid details.");
		
		Methods.CorporateEdit(test);
		
		extent.endTest(test);
		
		extent.flush();
	}
	
	@Test(priority = 15)
	void CorporateEditInvalid() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Corporate Page Edit customer with invalid details");
		
		Methods.CorporateEditInvalid(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16) 
	void SearchCorporate() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Corporate Page Customer search dropdown");
		
		Methods.SearchCorporate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17) 
	void SearchCorporateClear() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Corporate Page Clear button.");
		
		Methods.SearchCorporateClear(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 18)
	void corporateDelete() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Corporate Page Delete customer 'OK' button");
		
		Methods.corporateDelete(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 19)
	void CorDeleteCancel() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Corporate Page Delete customer 'Cancel' button.");
		
		Methods.CorDeleteCancel(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 20)//22/01/2025
	void CorporateView() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Corporate Page View Entity button.");
		
		Methods.CorporateView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
	void CorporateBack() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Corporate Page Back button");
		
		Methods.CorporateBack(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 22) //23/01/2024
	void Entity() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether entity tab is clickable or not");
		
		Methods.Entity(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 23) 
	void EntityAddNew() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Add new entity Button With valid data.");
		
		Methods.EntityAddNew(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 24) 
	void EntityEdit() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Entity Page Entity Edit Button With Valid Data.");
		
		Methods.EntityEdit(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 25) 
	void EntityEditinvalid() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Entity Page Entity Edit Button With Invalid Data.");
		
		Methods.EntityEditinvalid(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 26) 
	void SearchCustomer() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether customer name drop down is working or not");
		
		Methods.SearchCorporate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 27) 
	void SearchEntity() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether entity drop down is working or not");
		
		Methods.SearchEntity(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 28) 
	void SearchEntityClear() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate entity Page Clear button.");
		
		Methods.SearchEntityClear(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 29)
	void EntityDelete() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether entity is getting deleted or not");
		
		Methods.EntityDelete(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 30)
	void EntityDeleteCancel() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate entity Page Delete customer 'Cancel' button.");
		
		Methods.EntityDeleteCancel(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 31)
	void EntityBulkUpload() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Entity Page Entity upload with valid details.");
		
		Methods.EntityBulkUpload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 32) //24/01/2025
	void EntityBulkUploadInvalid() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Entity Page Entity upload with valid details.");
		
		boolean text	=	Methods.EntityBulkUploadInvalid(test);
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
	
	@Test(priority = 33)
	void EntityBulkUploadCheck() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate message for valid file upload in selected(Checkbox) Entity functionality.");
		
		Methods.EntityBulkUploadCheck(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 34)
	void EntityBulkUploadInvalidCheck() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate error message and error file download for Invalid data file upload in selected(checkbox) Entity functionality.");
		
		boolean text	=	Methods.EntityBulkUploadInvalidCheck(test);
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
	
	
	
	
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
		//closeBrowser();
  		//Thread.sleep(1000);
  		//getDriver().close();
  	}	       
  		       		
  	@AfterTest
  	void Closing() throws InterruptedException
  	{
  		
  	}	 

}
