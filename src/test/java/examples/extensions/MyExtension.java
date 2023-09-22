package examples.extensions;

import org.junit.jupiter.api.extension.*;


public class MyExtension implements AfterEachCallback, BeforeAllCallback, AfterTestExecutionCallback, AfterAllCallback {
    @Override
    public void afterEach(ExtensionContext extensionContext) {
        System.out.println("Extension: после каждого");
        extensionContext.getTags().forEach(t -> System.out.println("На тесте есть тэг: " + t));
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        System.out.println("Extension: перед всеми");
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        System.out.println("Extension: между @Test и @AfterEach");
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) {
        System.out.println("Extension: после всех");
    }
}
