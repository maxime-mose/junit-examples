package examples.tests;

import examples.QA;
import examples.QAService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты на QAService")
//@TestMethodOrder(MethodOrderer.Random.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class QaServiceTest {

    private final QAService qaService = new QAService();

    @Nested
//    @Tag("tag2")
    @DisplayName("Тесты на добавление qa")
//    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class AddQaTest {

        @Test
        @Tag("tag2")
//        @DisplayName("Добавление 1-го QA")
            // для второго теста добавлен tag2
//        void должен_добавить_1_тестировщика() {
        void should_add_one_qa() {
//        void should_add_one_qa() {
            qaService.add(new QA());
            List<QA> qaList = qaService.getAll();
            assertEquals(1, qaList.size());
        }

        @Test
        @Tag("tag2")
//        @Disabled("Падает из-за бага")
//        @DisabledOnOs(OS.LINUX)
//        @DisabledOnJre(JRE.JAVA_11)
        @DisabledIfSystemProperty(named = "asdf", matches = "qwerty123")
//        @DisplayName("Добавление 2 QA")
            // для второго теста добавлен tag2
        void test2() {
            qaService.add(new QA());
            qaService.add(new QA());
            List<QA> qaList = qaService.getAll();
            assertEquals(2, qaList.size());
        }
    }

    @Test
    // mvn clean test -Dgroups=tag1
    @Tag("tag1")
    @Order(2)
//    @DisplayName("Тест 1")
    void test1() {
        System.out.println("Тест 1");
        List<QA> qaList = qaService.getAll();
        assertTrue(qaList.isEmpty());
    }

    @Test
    @Tag("tag1")
    void test3() {
        qaService.remove(new QA());
        List<QA> qaList = qaService.getAll();
        assertEquals(0, qaList.size());
    }

    @Test
    @Timeout(value = 2)
    void timeout_test() throws InterruptedException {
        Thread.sleep(1900);
    }

    @RepeatedTest(value = 5)
    void repeated_test(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        assertFalse(false);
    }
}
