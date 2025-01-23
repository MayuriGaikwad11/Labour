package distributor;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class Locators extends BasePage {

	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	private static WebElement user = null;				//WebElement variable created for 'Categories' click
	private static WebElement compliances = null;				//WebElement variable created for 'Compliances' read and click
	private static List<WebElement> compliancesList = null;	
	
	public static WebElement Users( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='User']"));
		return user;
	}
	
	public static WebElement addNewBtn( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Add New']"));
		return user;
	}
	
	public static WebElement firstName( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='First Name']"));
		return user;
	}
	
	
	public static WebElement lastName( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Last Name']"));
		return user;
	}
	
	public static WebElement designation( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Designation']"));
		return user;
	}
	
	public static WebElement mail( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Email']"));
		return user;
	}
	
	public static WebElement contactno( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Contact No']"));
		return user;
	}
	
	public static WebElement Status( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[2]"));
		return user;
	}
	
	public static WebElement Status1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//span[contains(text(),'Active')])[1]"));
		return user;
	}
	
	public static WebElement roledd( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[3]"));
		return user;
	}
	
	public static WebElement roledd1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Performer')]"));
		return user;
	}
	
	public static WebElement Save( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Save']"));
		return user;
	}
	
	public static WebElement ok( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[@class='figma-btn-green']"));
		return user;
	}
	
	public static WebElement Edit( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//tbody/tr[1]/td[7]/img[1]"));
		return user;
	}
	
	public static WebElement SearchUser( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@class='k-input-inner']"));
		return user;
	}
	
	public static WebElement SearchUser1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//*[@class='k-list-item-text']"));
		return user;
	}
	
	public static WebElement Apply( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ApplyFilter.svg']"));
		return user;
	}
	
	public static WebElement Clear( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//div[@class='col-md-8 colpadding0']//button[2]"));
		return user;
	}
	
	public static WebElement Delete( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//tbody/tr[1]/td[7]/img[2]"));
		return user;
	}
	
	public static WebElement DeleteOk( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//div[@class='col-md-12 ok-btn-confirm colpadding0 ng-star-inserted']//button[@class='figma-btn-blue']"));
		return user;
	}
	
	public static WebElement DeleteCan( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Cancel']"));
		return user;
	}
	
	public static WebElement Back( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
		return user;
	}
	
	
	public static WebElement GridCount( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-user-master > kendo-grid > kendo-pager > kendo-pager-info"));
		return user;
	}
	
	public static WebElement Export( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
		return user;
	}
	
	public static WebElement Corporate( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Corporate']"));
		return user;
	}
	
	public static WebElement name( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Customer Name']"));
		return user;
	}
	
	public static WebElement CorporateID( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Corporate ID']"));
		return user;
	}
	
	public static WebElement BuyerName( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Buyer Name']"));
		return user;
	}
	
	public static WebElement Email( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Email']"));
		return user;
	}
	
	public static WebElement ContactNo( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Contact No']"));
		return user;
	}
	
	public static WebElement Check( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Check']"));
		return user;
	}
	
	public static WebElement CorporateEdit( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//tbody/tr[1]/td[6]/div[1]/img[1]"));
		return user;
	}
	
	public static WebElement Pan( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//*[@formcontrolname='cO_PAN']"));
		return user;
	}
	
	public static WebElement DeleteCor( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//tbody/tr[1]/td[6]/div[1]/img[2]"));
		return user;
	}
	
	public static WebElement view( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//tbody/tr[1]/td[6]/div[1]/img[3]"));
		return user;
	}
	
	public static WebElement Entity( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//a[normalize-space()='Entity']"));
		return user;
	}
	
	public static WebElement EntityName( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Entity Name']"));
		return user;
	}
	
	public static WebElement ClientId( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Client Id']"));
		return user;
	}
	
	public static WebElement PFType( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[@class='k-input-value-text'][normalize-space()='Select']"));
		return user;
	}
	
	public static WebElement PFType1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Client']"));
		return user;
	}
	
	public static WebElement PFCode( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter PF Code']"));
		return user;
	}
	
	public static WebElement Address( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//textarea[@placeholder='Enter Address']"));
		return user;
	}
	
	public static WebElement EnterEmail( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Email']"));
		return user;
	}
	
	
	public static WebElement State( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Select State')]"));
		return user;
	}
	
	public static WebElement State1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Andhra Pradesh')]"));
		return user;
	}
	
	
	public static WebElement City( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Select City')]"));
		return user;
	}
	
	public static WebElement City1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Amaravati main Road-522402')]"));
		return user;
	}
	
	public static WebElement ContactPerson( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Contact Person']"));
		return user;
	}
	
	public static WebElement ContactNo1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Contact Number']"));
		return user;
	}
	
	
	public static WebElement StatusE( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[6]"));
		return user;
	}
	
	public static WebElement StatusE1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Active']"));
		return user;
	}
	
	public static WebElement CommencementDate( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//*[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return user;
	}
	
	public static WebElement CommencementDate1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='7']"));
		return user;
	}
	
	public static WebElement WagePeriodFrom( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[7]"));
		return user;
	}
	
	public static WebElement WagePeriodFrom1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='2']"));
		return user;
	}
	
	public static WebElement WagePeriodTo( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[8]"));
		return user;
	}
	
	public static WebElement WagePeriodTo1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'3')]"));
		return user;
	}
	
	public static WebElement PaymentDay( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[9]"));
		return user;
	}
	
	public static WebElement PaymentDay1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='2']"));
		return user;
	}
	
	public static WebElement EstablishmentType()	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[10]"));
		return user;
	}
	
	public static WebElement EstablishmentType1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Shop & Establishment')]"));
		return user;
	}
	
	public static WebElement ActApplicability()	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[11]"));
		return user;
	}
	
	public static WebElement ActApplicability1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='State']"));
		return user;
	}
	
	public static WebElement BonusExempted()	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[13]"));
		return user;
	}
	
	public static WebElement BonusExempted1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Yes')]"));
		return user;
	}
	
	public static WebElement BonusPer( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Bonus Percentage']"));
		return user;
	}
	
	public static WebElement next( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Next']"));
		return user;
	}
	
	public static WebElement Salutation( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[3]"));
		return user;
	}
	
	public static WebElement Salutation1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Ms')]"));
		return user;
	}
	
	public static WebElement FirstName( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@formcontrolname='FirstName']"));
		return user;
	}
	
	public static WebElement ContactNumber( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@formcontrolname='ContactNumber']"));
		return user;
	}
	
	public static WebElement SPOCEmail( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@formcontrolname='SPOCEmail']"));
		return user;
	}
	
	public static WebElement Designationspo( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Designation']"));
		return user;
	}
	
	public static WebElement EP1Salutation( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[4]"));
		return user;
	}
	
	public static WebElement EP1Salutation1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//span[contains(text(),'Ms')])[2]"));
		return user;
	}
	
	public static WebElement EP1FirstName( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//div[4]//div[2]//div[1]//input[1]"));
		return user;
	}
	
	public static WebElement EP1ContactNumber( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//div[5]//div[2]//div[1]//input[1]"));
		return user;
	}
	
	public static WebElement EP1SPOCEmail( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//div[6]//div[1]//div[1]//input[1]"));
		return user;
	}
	
	public static WebElement EP1Designationspo( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//input[@placeholder='Enter Designation'])[2]"));
		return user;
	}
	
	
	public static WebElement IVSPOCName( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter First Name']"));
		return user;
	}
	
	public static WebElement IVSPOCEnterEmail( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Email']"));
		return user;
	}
	
	public static WebElement IVSPOCMobileNumber( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Mobile Number']"));
		return user;
	}
	
	public static WebElement Type( )		
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[3]"));
		return user;
	}
	
	public static WebElement Type1( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Public')]"));
		return user;
	}
	
	public static WebElement EDLIExcemptionType( )		
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[4]"));
		return user;
	}
	
	public static WebElement EDLIExcemptionType1( )		
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='B']"));
		return user;
	}
	
	public static WebElement ServiceTaxExempted( )		
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[5]"));
		return user;
	}
	
	public static WebElement ServiceTaxExempted1( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Yes')]"));
		return user;
	}
	
	public static WebElement CLRAApplicable( )		
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[6]"));
		return user;
	}
	
	public static WebElement CLRAApplicable1( )		
	{
		user = getDriver().findElement(By.xpath("(//span[contains(text(),'Yes')])[2]"));
		return user;
	}
	
	public static WebElement CLRAType( )		
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[7]"));
		return user;
	}
	
	public static WebElement CLRAType1( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Client as Contractor')]"));
		return user;
	}
	
	public static WebElement ContractorEmployerName( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Employer Name']"));
		return user;
	}
	
	public static WebElement POApplicable( )		
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[8]"));
		return user;
	}
	
	public static WebElement POApplicable1( )		
	{
		user = getDriver().findElement(By.xpath("(//span[contains(text(),'Yes')])[3]"));
		return user;
	}
	
	public static WebElement AgreementID( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter AgreementID']"));
		return user;
	}
	
	public static WebElement Mandate( )		
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[9]"));
		return user;
	}
	
	public static WebElement Mandate1( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'One time')]"));
		return user;
	}
	
	public static WebElement Triangle( )		
	{
		user = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])"));
		return user;                             
	}
	
	public static WebElement selectDropdown( )		
	{
		user = getDriver().findElement(By.xpath("//input[@id='k-8631657d-527f-4962-986f-59bcf19af021']"));
		return user;
	}
	
	public static WebElement EditEntity( )		
	{
		user = getDriver().findElement(By.xpath("(//img[@title='Edit'])[1]"));
		return user;
	}
	
	public static WebElement DeleteEntity( )		
	{
		user = getDriver().findElement(By.xpath("(//img[@title='Delete'])[1]"));
		return user;
	}
	
	public static WebElement ValMsg( )		
	{
		user = getDriver().findElement(By.xpath("//div[contains(text(),'PF Code must be 15 characters, no leading 0.')]"));
		return user;
	}
	
	public static WebElement ValMsg1( )		
	{
		user = getDriver().findElement(By.xpath("//div[contains(text(),'Please enter a valid email address.')]"));
		return user;
	}
	

	public static WebElement ValMsg2( )		
	{
		user = getDriver().findElement(By.xpath("//div[contains(text(),'Only Numbers, max 10 digits allowed.')]"));
		return user;
	}
	
	public static WebElement BulkUpload ( )		
	{
		user = getDriver().findElement(By.xpath("(//button[normalize-space()='Bulk Upload'])[1]"));
		return user;
	}
	
	public static WebElement DownloadTemplate ( )		
	{
		user = getDriver().findElement(By.xpath("//img[@title='Download Template']"));
		return user;
	}
	
	public static WebElement  Browse ( )		
	{
		user = getDriver().findElement(By.xpath("//label[normalize-space()='Browse']"));
		return user;
	}
	
	public static WebElement  Upload ( )		
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Upload']"));
		return user;
	}
	
	public static WebElement  CheckBox ( )		
	{
		user = getDriver().findElement(By.xpath("(//input[@class='ng-pristine ng-valid ng-touched'])[1]"));
		return user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
