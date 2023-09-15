package examples.extensions;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * Задания:
 * 1. Добавить ещё один Extension, который будет между @Test и @AfterEach.
 * 2. Добавить ещё один Extension с текстом "Extension: после всех".
 * 3. Навесить ещё один тэг.
 */
public class MyExtension implements AfterEachCallback, BeforeAllCallback {
    @Override
    public void afterEach(ExtensionContext extensionContext) {
        System.out.println("Extension: после каждого");
        extensionContext.getTags().forEach(t -> System.out.println("На тесте есть тэг: " + t));
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        System.out.println("Extension: перед всеми");
    }
}
