import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNull.notNullValue;

class HamcrestAssertionDemo {

    @Test
    void hamcrestAssertion() {
        assertThat("some text", allOf(notNullValue(), containsString("x")));
    }
}


