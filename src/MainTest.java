import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    @Test
    public void testGetDigitsArray() {
        final long testNumber = 12345678900L;
        final int[] expected = {2, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        final int[] actual = Main.getDigitsArray(testNumber);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAllDigitsTheSame() {
        final long testNumber = 142857L;

        // verify our assumption that this number is a solution
        final int[] expected = {0, 1, 1, 0, 1, 1, 0, 1, 1, 0};
        final int[] actualSingle = Main.getDigitsArray(testNumber);
        final int[] actualDouble = Main.getDigitsArray(testNumber * 2);
        final int[] actualTriple = Main.getDigitsArray(testNumber * 3);
        final int[] actualQuadruple = Main.getDigitsArray(testNumber * 4);
        final int[] actualQuintuple = Main.getDigitsArray(testNumber * 5);
        final int[] actualHextuple = Main.getDigitsArray(testNumber * 6);
        assertArrayEquals(expected, actualSingle);
        assertArrayEquals(expected, actualDouble);
        assertArrayEquals(expected, actualTriple);
        assertArrayEquals(expected, actualQuadruple);
        assertArrayEquals(expected, actualQuintuple);
        assertArrayEquals(expected, actualHextuple);

        assertTrue(Main.allDigitsTheSame(testNumber));
    }

    @Test
    public void microBenchmark() {
        final Instant start = Instant.now();
        Main.main(new String[] {});
        final Instant end = Instant.now();
        System.out.println("microBenchmark took " + Duration.between(start, end).getNano() / 1000 / 1000 + " ms");
    }
}
