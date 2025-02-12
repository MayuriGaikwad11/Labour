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

import clientPortal.ClientMethods;
import distributor.Methods;
import login.BasePage;

public class ClientsTest extends BasePage {
	
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\eclipse-workspace\\LabourAngularProject\\Report\\Labour.html",true);
		test = extent.startTest("Loging In - Distributor admin");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(2,"Statutory");
		ClientMethods.filterEntity(test);
	
	}
	
	
	
	@Test(priority = 1) //04/02/2025
	void Entities() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on 'Entities'");
		
		ClientMethods.Entities(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 2) 
	void EntitiesSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Entity search filter working or not");
		
		ClientMethods.EntitiesSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void Locations() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on 'Locations'");
		
		ClientMethods.Locations(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void LocationsSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Locations search filter working or not");
		
		ClientMethods.LocationsSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5)
	void AssignedCompliances() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on 'Assigned Compliances'");
		
		ClientMethods.AssignedCompliances(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6)
	void exportcount() throws InterruptedException, IOException
	{
		test = extent.startTest("Assigned Compliances - Export button working or not");
		
		ClientMethods.exportcount(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 7)
	void OverviewAC() throws InterruptedException, IOException
	{
		test = extent.startTest("Assigned Compliances - Overview button working or not");
		
		ClientMethods.OverviewAC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void ExpiredRegistrations() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on 'Expired Registrations'");
		
		ClientMethods.ExpiredRegistrations(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 9)
	void OpenNotices() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on 'Open Notices'");
		
		ClientMethods.OpenNotices(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 10)
	void OpenNoticesView() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - view button working or not ");
		
		ClientMethods.OpenNoticesView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 11)//05/02/2025
	void ViewAddNew() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Open Notices' - view button working or not ");
		
		ClientMethods.ViewAddNew(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12)
	void exportNotice() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Open Notices' - view - Export button working or not ");
		
		ClientMethods.exportNotice(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void NoticeSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - view - Validate Notice search filter working or not");
		
		ClientMethods.NoticeSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 14)
	void NoticeSearchClear() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - view - Validate Notice clear button working or not");
		
		ClientMethods.NoticeSearchClear(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15)
	void OpenNoticesEditback() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - view - edit - Validate Notice Back button working or not");
		
		ClientMethods.OpenNoticesEditback(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void OverviewNotice() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - view - Overview button working or not");
		
		ClientMethods.OverviewNotice(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17)
	void OpenNoticesback() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - edit - Validate Notice Back button working or not");
		
		ClientMethods.OpenNoticesback(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 18)
	void RegistrationSExport() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Export button working or not");
		
		ClientMethods.RegistrationSExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 19) 
	void RegistrationSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Validate search filter working or not");
		
		ClientMethods.RegistrationSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 20)
	void RegistrationStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active  Count Verification");
		
		ClientMethods.RegistrationStatus(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 21) //2 test case //10/02/2025
	void RegistrationStatusExport() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Active - Export button working or not");
		
		ClientMethods.RegistrationStatusExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 22) //07/02/2025
	void RegistrationSView() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Active - view button working or not");
		
		ClientMethods.RegistrationSView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 23) //07/02/2025
	void DownloadActive() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Active - Download button working or not");
		
		ClientMethods.DownloadActive(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 24) //07/02/2025
	void RegistrationSHistory() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Active - History button working or not");
		
		ClientMethods.RegistrationSHistory(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 25) //07/02/2025
	void RegistrationSHistoryExport() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Active - History - Export button working or not");
		
		ClientMethods.RegistrationSHistoryExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 26) //06/02/2025
	void ActiveSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - Validate search filter working or not");
		
		ClientMethods.ActiveSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 27) //pending
	void CompliancePerformance() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Overdue  Count Verification");
		
		ClientMethods.CompliancePerformance(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 28) 
	void PayrollCompliancesOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Payroll Compliances - Overdue - Overview button working or not");
		
		ClientMethods.PayrollCompliancesOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 29) 
	void exportPayrollCompliancesOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Payroll Compliances - Overdue - Export button working or not");
		
		ClientMethods.exportPayrollCompliancesOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 30) 
	void ECOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Establishment Compliances - Overdue - Overview button working or not");
		
		ClientMethods.ECOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 31) 
	void exportEC() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Establishment Compliances - Overdue - Export button working or not");
		
		ClientMethods.exportEC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 32) 
	void FCOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Factory  Compliances - Overdue - Overview button working or not");
		
		ClientMethods.FCOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 33) 
	void exportFC() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Factory  Compliances - Overdue - Export button working or not");
		
		ClientMethods.exportFC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 34) 
	void ClraOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Clra Compliances - Overdue - Overview button working or not");
		
		ClientMethods.ClraOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 35) 
	void exportClra() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Clra Compliances - Overdue - Export button working or not");
		
		ClientMethods.exportClra(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 36) 
	void exportCP() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Overdue - Export button working or not");
		
		ClientMethods.exportCP(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 37) 
	void OpenStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Open  Count Verification");
		
		ClientMethods.OpenStatus(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 38) //07/02/2025
	void OpenView() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Open -  Overview button working or not");
		
		ClientMethods.OpenView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 39) 
	void exportOpen() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Open -  Export button working or not");
		
		ClientMethods.exportOpen(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 40) 
	void ClosedStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Closed  Count Verification");
		
		ClientMethods.ClosedStatus(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 41) 
	void ClosedView() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Closed -  Overview button working or not");
		
		ClientMethods.ClosedView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 42) 
	void exportClosed() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Closed -  Export button working or not");
		
		ClientMethods.exportClosed(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 43) 
	void exportNoticeStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' -  Export button working or not");
		
		ClientMethods.exportNoticeStatus(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 44) //10/02/2025
	void RegistrationStatusBar() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Active Licences  Count Verification");
		
		ClientMethods.RegistrationStatusBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 45) //2 test case 
	void RegistrationStatusExportBar() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences - Export button working or not");
		
		ClientMethods.RegistrationStatusExportBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 46)
	void RegistrationSViewL() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences  - view button working or not");
		
		ClientMethods.RegistrationSViewL(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 47) 
	void DownloadActiveBar() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences - Download button working or not");
		
		ClientMethods.DownloadActiveBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 48)
	void RegistrationSHistoryBar() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences - History button working or not");
		
		ClientMethods.RegistrationSHistoryBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 49) 
	void RegistrationSHistoryExportBar() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences - History - Export button working or not");
		
		ClientMethods.RegistrationSHistoryExportBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 50) //2 test case 
	void CalendarExport() throws InterruptedException, IOException
	{
		test = extent.startTest("'My Compliance Calendar - Export button working or not");
		
		ClientMethods.CalendarExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 51) //11/02/2025
	void CalendarCount() throws InterruptedException, IOException
	{
		test = extent.startTest("'My Compliance Calendar - Calendar Count Verification");
		
		ClientMethods.CalendarCount(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 52) 
	void CalendarOverview() throws InterruptedException, IOException
	{
		test = extent.startTest("'My Compliance Calendar - Overview button working or not");
		
		ClientMethods.CalendarOverview(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 53) 
	void DailyUpdates() throws InterruptedException, IOException
	{
		test = extent.startTest("'Daily Updates - Read more Link working or not");
		
		ClientMethods.DailyUpdates(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 54) 
	void InputUploadTem() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - To check whether sample template get downloaded or not from input web upload tab.");
		
		ClientMethods.InputUploadTem(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 55) 
	void InputUpload() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - Validate  upload with valid details.");
		
		ClientMethods.InputUpload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 56) 
	void InputUploadInavlid() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - Validate  upload with Invalid details.");
		
		ClientMethods.InputUploadInavlid(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 57) 
	void InputUploadBlank() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - Validate  upload with Balnk sheet .");
		
		ClientMethods.InputUploadBlank(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 58) 
	void InputUploadInvalidformate() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - Validate error message for the invalid formate file upload.");
		
		ClientMethods.InputUploadInvalidformate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 59) 
	void InputUploadInvalidTemp() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - Validate error message displayed for invalid template file upload.");
		
		ClientMethods.InputUploadInvalidTemp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 60) 
	void InputUploadNofile() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - Validate validation message for the no choose file clicking on upload");
		
		ClientMethods.InputUploadNofile(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	//issues  
	//Pending scripts
	//Open Notices -download ,delete
//	Registration Status' - Active - History -view ,download search data not load
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
