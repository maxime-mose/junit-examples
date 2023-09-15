package examples.tests;

import examples.QA;
import examples.QAService;
import examples.extensions.MyExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(
        MyExtension.class
)
@DisplayName("Тестовый класс")
public class MyTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Перед всеми");
    }

    @BeforeEach
    @DisplayName("Перед каждым")
    void setUp() {
        System.out.println("Перед каждым");
    }

    @Test
    // mvn clean test -Dgroups=tag1
    @Tag("tag1")
    @DisplayName("Тест 1")
    void test1() {
        System.out.println("Тест 1");
        QAService qaService = new QAService();
        List<QA> qaList = qaService.getAll();
        assertTrue(qaList.isEmpty());
    }

    @Test
    void test2() {
        System.out.println("Тест 2");
        QAService qaService = new QAService();
        qaService.add(new QA());
        List<QA> qaList = qaService.getAll();
        assertEquals(1, qaList.size());
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
