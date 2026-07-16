package java_core.static_learn;

public final class MathUtils {
    private MathUtils() {
    }

    public static int max(int a, int b) {
        return a >= b ? a : b;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
