package examples.extensions;

import org.junit.jupiter.api.extension.*;


public class MyExtension implements AfterEachCallback, BeforeAllCallback, AfterTestExecutionCallback, AfterAllCallback, BeforeEachCallback, BeforeTestExecutionCallback{
    @Override
    public void afterEach(ExtensionContext extensionContext) {
        System.out.println("Extension: после каждого");
        System.out.println("Display name для данного теста: " + extensionContext.getDisplayName());
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

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        System.out.println("Extension: перед каждым");
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) {
        System.out.println("Extension: между @BeforeEach и @Test");
    }
}
