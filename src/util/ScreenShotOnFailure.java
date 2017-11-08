package util;

import java.io.File;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotOnFailure implements MethodRule {
	static WebDriver driver;
    static java.util.Date date= new java.util.Date();
	static Timestamp t = new Timestamp (date.getTime());
	static String dateNow = t.toString().replace(":","_");
	String obj = "Screenshots";
	String className = this.getClass().getSimpleName();
	String dates = date.toString();
	
	@Override
	
	    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
	        return new Statement() {
	           
	        	@Override
	            public void evaluate() throws Throwable {
	                try {
	                    statement.evaluate();
	                } catch (Throwable t) {
	                    // exception will be thrown only when a test fails.
	                    captureScreenshot(frameworkMethod.getName());
	                    // rethrow to allow the failure to be reported by JUnit
	                    throw t;
	                  }
	            }
	 
	            public void captureScreenshot(String fileName) {
	                try {

                	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	        
        			// now save the screenshot to a file some place
        	        
        			FileUtils.copyFile(scrFile, new File("/Users/miloonken/dev/Documents/screenshot/screenshot"+className+dateNow+".png"));
                } 
                
                catch (Exception e) {
                    // No need to crash the tests if the screenshot fails
                }
            }
        };
    }
}
