package outlook_automation;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Main {
    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{RunTests.class});
        testng.addListener(tla);
        testng.run();
    }
}
