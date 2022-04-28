package listeners;

import annotations.RetryCount;
import org.testng.IAnnotationTransformer;
import org.testng.ITestResult;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.ITestAnnotation;
import utils.RetryAnalyzer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (testMethod.getDeclaredAnnotations().length > 0) {
            for (Annotation a: testMethod.getDeclaredAnnotations()) {
                if (a instanceof RetryCount) {
                    annotation.setRetryAnalyzer(RetryAnalyzer.class);
                    break;
                }
            }
        }
    }
}
