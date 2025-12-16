package base;


import com.aventstack.extentreports.ExtentTest;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utilities.Report;




public class Hooks {


    public static ExtentTest test;
 

    @Before    
    public void setUp(Scenario scenario) {

            Report.getInstance().createTest(scenario.getName());
    }


    
    @After
    public static void tearDown() {
    	
        Report.getInstance().flush();  
    }




}

