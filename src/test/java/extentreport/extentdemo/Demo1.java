package extentreport.extentdemo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 {
	
	ExtentReports ereport;
	@BeforeTest
	public void config()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);	
		reporter.config().setReportName("Vinay Report Results");
		reporter.config().setDocumentTitle("Vinay");
		
		ereport= new ExtentReports();
		ereport.attachReporter(reporter);
		ereport.setSystemInfo("Tester", "Mallela Vinay");
		
	}
	

	@Test
	public void initialDemo()
	{
		ExtentTest test=ereport.createTest("RahulAppTest");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		test.fail("Result is not matching");
		ereport.flush();
		driver.close();
		
	}

}
