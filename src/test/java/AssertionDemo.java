import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionDemo {

    @Test
    void basic() {
        assertEquals(1 + 1, 2);
        assertEquals(1 + 1, 2, () -> "message");
        assertFalse(1 > 2);
        assertTrue(1 < 2);
        assertNull(null);
        assertNotNull(this);
        assertSame("foo", "foo");
        assertEquals("foo", "foo");
        assertArrayEquals(new int[] {1, 2, 3}, new int[] {1, 2, 3});
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each");
    }

};