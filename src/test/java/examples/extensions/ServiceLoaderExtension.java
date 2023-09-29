package examples.extensions;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;


public class ServiceLoaderExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        System.out.println("Extension, загруженный через ServiceLoader");
    }
}
