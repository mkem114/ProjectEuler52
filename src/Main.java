import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        for (long candidate = 10; true; candidate++) {
            if (allDigitsTheSame(candidate)) {
                System.out.println(candidate);
                break;
            }
        }
    }

    public static boolean allDigitsTheSame(final long number) {
        final int[] digits = getDigitsArray(number);
        final int[] sixthDigits = getDigitsArray(number * 6);
        if (!Arrays.equals(sixthDigits, digits)) {
            return false;
        }
        final int[] fifthDigits = getDigitsArray(number * 5);
        if (!Arrays.equals(fifthDigits, sixthDigits)) {
            return false;
        }
        final int[] fourthDigits = getDigitsArray(number * 4);
        if (!Arrays.equals(fourthDigits, fifthDigits)) {
            return false;
        }
        final int[] thirdDigits = getDigitsArray(number * 3);
        if (!Arrays.equals(thirdDigits, fourthDigits)) {
            return false;
        }
        final int[] secondDigits = getDigitsArray(number * 2);
        return Arrays.equals(secondDigits, thirdDigits);
    }

    public static int[] getDigitsArray(long number) {
        final int[] digits = new int[10];
        long currDigit;
        while (number > 0) {
            currDigit = number % 10;
            digits[(int) currDigit]++;
            number /= 10;
        }
        return digits;
    }
}
