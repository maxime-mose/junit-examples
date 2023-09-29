package examples.tests;

import examples.extensions.MyExtension;
import examples.extensions.ServiceLoaderExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({MyExtension.class})
@DisplayName("Тестовый класс")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JUnitLifecycleTest {

//    @RegisterExtension
//    static MyExtension myExtension = new MyExtension();

    @BeforeAll
    void beforeAll() {
        System.out.println("Перед всеми");
    }

    @BeforeEach
    @DisplayName("Перед каждым")
    void setUp() {
        System.out.println("Перед каждым");
    }

    @MyAnno
    @Test
    // mvn clean test -Dgroups=tag1
    @Tag("tag1")
    @DisplayName("Тест 1")
    void test1(TestInfo testInfo) {
        System.out.println("Тестовый класс: " + testInfo.getTestClass());
        System.out.println("Тест 1");
    }

    @Test
    @Tag("tag2")
        //для второго теста добавлен tag2
    void test2() {
        System.out.println("Тест 2");
    }

    @Test
    @Tag("tag1")
    void test3() {
        System.out.println("Тест 3");
    }

    @AfterEach
    void tearDown() {
        System.out.println("После каждого");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("После всех");
    }
}
