package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    public int count = 1;
    public int maxRetry = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < maxRetry) {
            count++;
            return true;
        }

        return false;
    }

    public boolean canRetry() {
        return count < maxRetry;
    }
}
