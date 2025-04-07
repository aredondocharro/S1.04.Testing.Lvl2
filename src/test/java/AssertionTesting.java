import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

public class AssertionTesting {

    @Test
    void integerValueComparison() {
        Integer num1 = 10;
        Integer num2 = 10;
        Integer num3 = 20;

        assertThat(num1).isEqualTo(num2);

        assertThat(num1).isNotEqualTo(num3);
    }

    @Test
    void objectReferenceComparison() {
        Object obj1 = new Object();
        Object obj2 = obj1;
        Object obj3 = new Object();

        assertThat(obj1).isSameAs(obj2);

        assertThat(obj1).isNotSameAs(obj3);
    }

    @Test
    void arrayEquality() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {4, 5, 6};

        assertThat(array1).isEqualTo(array2);

        assertThat(array1).containsExactly(1, 2, 3);

        assertThat(array1).isNotEqualTo(array3);
    }

    @Test
    void arrayListOperations() {
        String text = "Hello";
        Integer number = 42;
        Double decimal = 3.14;
        Object obj = new Object();
        String notInList = "Missing";

        List<Object> list = new ArrayList<>();
        list.add(text);
        list.add(number);
        list.add(decimal);
        list.add(obj);


        assertThat(list).containsExactly(text, number, decimal, obj);

        assertThat(list).containsExactlyInAnyOrder(obj, decimal, number, text);

        assertThat(list).containsOnlyOnce(number);

        assertThat(list).doesNotContain(notInList);
    }

    @Test
    void mapKeyVerification() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);

        assertThat(map).containsKey("two");

        assertThat(map).doesNotContainKey("three");
    }

    @Test
    void exceptionVerification() {
        int[] array = {1, 2, 3};
        boolean exceptionThrown = false;

        try {
            int x = array[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown, "Expected ArrayIndexOutOfBoundsException to be thrown");
    }



    @Test
    void optionalVerification() {
        Optional<String> emptyOptional = Optional.empty();
        Optional<String> presentOptional = Optional.of("value");

        assertThat(emptyOptional).isEmpty();


        assertThat(presentOptional).isPresent();
        assertThat(presentOptional).contains("value");
    }
}
