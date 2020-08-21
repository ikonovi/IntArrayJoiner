package ik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ArrayJoinerTest {

    private static ArrayJoiner joiner;

    @BeforeAll
    static void setUp() {
        joiner = new ArrayJoiner("array1.txt", "array2.txt");
    }

    @Test
    void testJoin() {
        joiner.join();
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 5, 6, 7}, joiner.getArrayJoined());
    }
}