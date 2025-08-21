package iRetryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class rerunFailedTestCases implements IRetryAnalyzer {
    private int retrycount=0;
    private static final int maxcount=3;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if(retrycount<maxcount){
            retrycount++;
            return true;
        }
        return false;
    }
}
