package StepDefns;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplnHooks {
	
	WebDriver driver;
	DriverFactory driverFactory;
	public static ConfigReader configReader;
    public static Properties prop;
	@Before()
	public void getBrowser() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		driverFactory = new DriverFactory();
		driver = driverFactory.init_Driver(prop.getProperty("browser"));
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	

    @After(order = 1)
    public void screenshot(Scenario scenario){

        if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ","_");
            byte[] path = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(path,"image/png",screenshotName);
        }
    }
}
