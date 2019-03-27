
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;


public class MainTestClass {

    @BeforeAll
    static void beforeAllMethod() {
        //Выполнится перед началом всех тестов, позволяет подготовить среду
        //Если тестов 10, то выполнится один раз перед всеми
    }

    @BeforeEach
    void setUp() {
        //Выполнится перед каждым тестом
        //Если тестов 10, то будет выполнятся каждый раз перед каждым тестом
    }

    @Test
    void testMethod_1() {
        assertTrue(1 + 1 == 2);
        assertFalse(1 + 1 == 10);
    }

    @Test
    @Disabled //Тест не будет выполнен
    void testMethod_2() {
        String nullString = null;
        String notNullString = "Not null string";

        assertNull(nullString);
        assertNotNull(notNullString);
    }

    @Test
    void testMethod_3() {
        assertEquals(15,	5 + 5, "Values are not equals");
        assertNotEquals(10, 2 + 2);
    }

    @AfterEach
    void tearDown(){
        //Выполнится после каждого теста
        //Если тестов 10, то будет выполняться каждый раз в конце каждого теста
    }

    @AfterAll
    static void afterAllMethod() {
        //Выполнится после всех тестов
        //Если тестов 10, то выполнится один раз в конце всех тестов
    }

}
