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
	
//	public static String link = "mgmt1";  
	

	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\LabourAngularProject\\Report\\dIstributor.html",true);
		test = extent.startTest("Loging In - Distributor admin");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(0,"Statutory");
	
	}
	
	///////--------------------------User -------------------------------------------/////////////////////// 
	
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
		test = extent.startTest("Validadte Edit Button of User Master Page");
		
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
	
///////--------------------------Corporate -------------------------------------------///////////////////////
	
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
	
///////--------------------------Entity -------------------------------------------///////////////////////
	
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
	
	//@Test(priority = 27) 
	void SearchEntity() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether entity drop down is working or not");
		
		Methods.SearchEntity(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 28) 
	void SearchEntityClear() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate entity Page Clear button.");
		
		Methods.SearchEntityClear(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 29)
	void EntityDeleteCancel() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate entity Page Delete customer 'Cancel' button.");
		
		Methods.EntityDeleteCancel(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 30)
	void EntityDelete() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether entity is getting deleted or not");
		
		Methods.EntityDelete(test);
		
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
		test = extent.startTest("Validate Entity Page Entity upload with Invalid details.");
		
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
		
			Methods.EntityBulkUploadInvalidCheck(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 35)
	void EntityBulkUploadCheckB() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate error message for empty file upload in selected(checkbox) Entity functionality.");
		
		Methods.EntityBulkUploadCheckB(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 36)
	void ResetBtn() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("To check whether reset button is working or not");
		
		Methods.ResetBtn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 37)
	void AllCheckbox() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("To check whether all check boxes are getting selected or not");
		
		Methods.AllCheckbox(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 38) 
	void EntityBack() throws InterruptedException, IOException
	{
		test = extent.startTest(" Validate Back Button of Entity Page");
		
		Methods.EntityBack(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 39) 
	void EntityLocation() throws InterruptedException, IOException
	{
		test = extent.startTest(" To check whether EntityLocation excel is getting downloaded or not");
		
		Methods.EntityLocation(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 40) 
	void EntityExcel() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether Entity excel is getting downloaded o not");
		
		Methods.EntityExcel(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 41) 
	void Searchentities() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Entities search dropdown");
		
		Methods.Searchentities(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
///////--------------------------Onboard Entity - Premises -------------------------------------------///////////////////////
	
	@Test(priority = 42) //25/01/2025
	void EntityBranchAddNew() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether add new premise button is working or not");
		
		Methods.EntityBranchAddNew(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 43) 
	void ExportPremises() throws InterruptedException, IOException
	{
		test = extent.startTest("Premise Export Button");
		
		Methods.ExportPremises(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 44) //27/01/2025
	void UploadBranch() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Branch Upload With Valid Datails from onboard entity.");
		
		Methods.UploadBranch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 45)
	void UploadBranchInvalid() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Branch Upload With inValid Datails from onboard entity.");
		
		boolean text	=	Methods.UploadBranchInvalid(test);
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
	
	@Test(priority = 46) 
	void UploadBranchEmpty() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("To check whether error message display or not for empty file upload from premise master..");
		
		Methods.UploadBranchEmpty(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 46)
	void UploadBranchCheck() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Upload Selected(Checkbox) Location with Valid Datails of premise tab from onboard entity.");
		
		Methods.UploadBranchCheck(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 47)
	void UploadInvalidCheck() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Upload Selected(Checkbox) Location with Invalid Datails.");
		
			Methods.UploadInvalidCheck(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 48)
	void UploadBranchCheckEmpty() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Upload Selected(Checkbox) Location with Empty File");
		
			Methods.UploadBranchCheckEmpty(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 49) 
	void UploadBranchInvalidTemp() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("To check whether error message display or not for invalid template file upload from premise upload.");
		
			Methods.UploadBranchInvalidTemp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 50)
	void UploadBranchInvalidFormate() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate error message for the invalid formate file upload in bulk upload from premise master.");
		
			Methods.UploadBranchInvalidFormate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 51)
	void Upload() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate validation message for the no choose file button from bulk upload of premise master.");
		
			Methods.Upload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 52) 
	void UploadBranchCheckInvalidTemp() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate error message displayed for invalid template file upload in selected(CheckBox) location from premise master.");
		
			Methods.UploadBranchCheckInvalidTemp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 53)
	void UploadBranchCheckInvalidFormate() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("validate error message displayed for invalid formate file upload in selected(Check box) location from premise master.");
		
			Methods.UploadBranchCheckInvalidFormate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 54)
	void UploadCheck() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate validation message displayed for choose file button in selected(CheckBox) location from premise master.");
		
			Methods.UploadCheck(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 55)
	void UploadAddMapping() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate  Sample Document  download of address mapping upload from premise master.");
		
			Methods.UploadAddMapping(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 56)
	void MUploadAddMapping() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate master document file download of address mapping upload from premise master.");
		
			Methods.MUploadAddMapping(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 57)
	void UploadAddressMap() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("To check whether valid address mapping file upload or not from premise master.");
		
			Methods.UploadAddressMap(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 58)
	void UploadAddressMapEmpty() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate error message for empty file upload in address mapping upload from premise master.");
		
			Methods.UploadAddressMapEmpty(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 59)
	void UploadAddInvalid() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate error message and error file download for address mapping upload from premise master with invalid data file.");
		
		boolean text	=	Methods.UploadAddInvalid(test);
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
	
	@Test(priority = 60) 
	void UploadAddInvalidTemp() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate error message for the invalid template file upload in address mapping upload from premise master.");
		
			Methods.UploadAddInvalidTemp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 61)
	void UploadAddInvalidFormate() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("To check whether error message display or not for invalid file formate upload from authority address mapping upload of premise master.");
		
			Methods.UploadAddInvalidFormate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 62)
	void UploadADD() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate validation message for the no choose file button from bulk upload of premise master.");
		
			Methods.UploadADD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 63)
	void SearchBranch() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("To check whether search field (branch) is working or not");
		
			Methods.SearchBranch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 64)
	void BDeleteCancel() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Delete Branch 'Cancel' Button");
		
			Methods.BDeleteCancel(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 65)
	void branchDelete() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("To check whether branch is getting deleted or not");
		
			Methods.branchDelete(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
///////--------------------------Onboard Entity - Paycode Mapping -------------------------------------------///////////////////////
	
	@Test(priority = 66) //28/01/2025
	void PayCodeAddNew() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Onboard Entity Add New Paycode With Valid Data");
		
			Methods.PayCodeAddNew(test);
		
		extent.endTest(test);
		extent.flush();
	}
	  
	@Test(priority = 67) 
	void PayCodeAddNewInvalid() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Onboard Entity Add new Paycode With Invalid Data");
		
			Methods.PayCodeAddNewInvalid(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 68) 
	void PayCodeEdit() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Onboard Entity Paycode 'Edit' Button.");
		
			Methods.PayCodeEdit(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 69) 
	void UploadPaycode() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Onboard Entity Paycode Upload with Valid Data.");
		
			Methods.UploadPaycode(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 70)
	void UploadPaycodeInvalid() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Onboard Entity Paycode Upload with Invalid Data.");
		
		boolean text	=	Methods.UploadPaycodeInvalid(test);
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
	
	@Test(priority = 71)
	void UploadPaycodeEmpty() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Onboard Entity Paycode Upload with Empty File.");
		
			Methods.UploadPaycodeEmpty(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 72)
	void SearchPaycode() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate searchbox Apply Button Of Paycode Mapping Tab from Onboard Entity Module");
		
			Methods.SearchPaycode(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 73)
	void SearchPaycodeClear() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Onboard Entity's Paycode Mapping Clear Button");
		
			Methods.SearchPaycodeClear(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 74)
	void PaycodeDeleteCancel() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Delete Paycode Mapping 'Cancel' Button");
		
			Methods.PaycodeDeleteCancel(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 75)
	void PaycodeDelete() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("To check whether Paycode Mapping is getting deleted or not");
		
			Methods.PaycodeDelete(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
///////--------------------------Onboard Entity - User-Branch Mapping -------------------------------------------///////////////////////

	@Test(priority = 76) //29/01/2025
	void Mapuser() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("To check whether map user button is working or not");
		
			Methods.Mapuser(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 77) 
	void Mapuseralready() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate error massage when  Existing user and branch mapping data which is already mapped to map user is working or not");
		
			Methods.Mapuseralready(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 78)
	void MapuserManagement() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("To check whether map user(management) button is working or not");
		
			Methods.MapuserManagement(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 79)
	void MapuserManagementAlredy() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate error massage when Existing user and branch mapping data which is already mapped to map user(management) is working or not");
		
			Methods.MapuserManagementAlredy(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 80)
	void UserMapDelete() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("To check whether mapping is getting deleted or not");
		
			Methods.UserMapDelete(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 81)
	void MapuserDeleteCancel() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Delete User Mapping 'Cancel' Button working or not");
		
			Methods.MapuserDeleteCancel(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 82)
	void UserMapFilter() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("To check whether  User Mapping apply button is working or not");
		
			Methods.UserMapFilter(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 83)
	void UserMapFilterClear() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("To check whether  User Mapping clear button is working or not.");
		
			Methods.UserMapFilterClear(test);
		
		  
		extent.endTest(test);
		extent.flush();
		
	}
	
///////--------------------------Manage Masters - Leave Type -------------------------------------------///////////////////////
	
	@Test(priority = 84) //25/02/2025
	void Exportleavetype() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Leave Type - To check whether excel is getting downloaded or not");
		
			Methods.Exportleavetype(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 85) //25/02/2025
	void Searchleave() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Leave Type - To check whether search field is working or not");
		
			Methods.Searchleave(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 86) //25/02/2025
	void SearchleaveClear() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Leave Type - To check whether search field clear or not");
		
			Methods.SearchleaveClear(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
///////--------------------------Manage Masters - Paycode Mapping -------------------------------------------///////////////////////
	
	@Test(priority = 87) //25/02/2025
	void PayCodeAddNewMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Validate Add New Paycode With Valid Data");
		
			Methods.PayCodeAddNewMM(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 88) 
	void PayCodeAddNewInvalidMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Validate Add new Paycode With Invalid Data");
		
			Methods.PayCodeAddNewInvalidMM(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 89) 
	void PayCodeEditMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Validate Paycode 'Edit' Button.");
		
			Methods.PayCodeEditMM(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 90) //2 test cases//26/02/2025
	void UploadPaycodeMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Validate  Paycode Upload with Valid Data.");
		
			Methods.UploadPaycodeMM(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 91)
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
	
	@Test(priority = 92)
	void UploadPaycodeEmptyMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Manage Masters Paycode Upload with Empty File.");
		
			Methods.UploadPaycodeEmptyMM(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 93)
	void UploadPaycodeforMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Manage Masters Paycode Upload with Invalid formate File.");
		
			Methods.UploadPaycodeforMM(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 94)
	void UploadPaycodeNoMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Manage Masters Paycode Upload with without selecting File.");
		
			Methods.UploadPaycodeNoMM(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 95)
	void SearchPaycodeMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate searchbox Apply Button Of Paycode Mapping Tab from Manage Masters Module");
		
			Methods.SearchPaycodeMM(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 96)
	void SearchPaycodeClearMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Validate Manage Masters Paycode Mapping Clear Button");
		
			Methods.SearchPaycodeClearMM(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 97)
	void PaycodeDeleteCancelMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - Delete Paycode Mapping 'Cancel' Button");
		
			Methods.PaycodeDeleteCancelMM(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 98)
	void PaycodeDeleteMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters - To check whether Paycode Mapping is getting deleted or not");
		
			Methods.PaycodeDeleteMM(test);
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
///////--------------------------Manage Masters - Statutory Master -------------------------------------------///////////////////////
	
	@Test(priority = 99) 
	void ExportSM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters -Statutory Master - Challan - To check whether excel is getting downloaded or not");
		
			Methods.ExportSM(test,"Challan");
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 100) 
	void ExportSM1() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters -Statutory Master - Register - To check whether excel is getting downloaded or not");
		
			Methods.ExportSM(test,"Register");
		
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 101) 
	void ExportSM2() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters -Statutory Master - returns - To check whether excel is getting downloaded or not");
		
			Methods.ExportSM(test,"returns");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 102) 
	void SearchSMMM() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters -Statutory Master - Validate searchbox Apply Button  from Manage Masters Module");
		
			Methods.SearchSMMM(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 103) 
	void SearchSMClear() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Manage Masters -Statutory Master - Validate Clear Button");
		
			Methods.SearchSMClear(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

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
