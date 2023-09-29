import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        // System.out.println(fib(0));
        // System.out.println(fib(1));
        // System.out.println(fib(2));
        // System.out.println(fib(10));
        // System.out.println(fibTopToDown(0));
        // System.out.println(fibTopToDown(1));
        // System.out.println(fibTopToDown(2));
        // System.out.println(fibTopToDown(3));
        // System.out.println(fibTopToDown(10));
        // System.out.println(fibBottomUpDPForward(0));
        // System.out.println(fibBottomUpDPForward(1));
        // System.out.println(fibBottomUpDPForward(2));
        // System.out.println(fibBottomUpDPForward(3));
        // System.out.println(fibBottomUpDPForward(10));
        System.out.println(fibBottomUpDPBackword(0));
        System.out.println(fibBottomUpDPBackword(1));
        System.out.println(fibBottomUpDPBackword(2));
        System.out.println(fibBottomUpDPBackword(3));
        System.out.println(fibBottomUpDPBackword(10));
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fibTopToDown(int n) {

        Map<Integer, Integer> memo = new HashMap<>();
        return fibTopDownHelper(n, memo);

    }

    public static int fibTopDownHelper(int n, Map<Integer, Integer> memo) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        if (memo.get(n) != null) {
            return memo.get(n);
        }
        memo.put(n, fibTopDownHelper(n - 1, memo) + fibTopDownHelper(n - 2, memo));
        return memo.get(n);

    }

    public static int fibBottomUpDPForward(int n) {
        List<Integer> cache = new ArrayList<>();
        cache.add(0);
        cache.add(1);
        for (int i = 2; i <= n; i++) {
            cache.add(cache.get(i - 1) + cache.get(i - 2));
        }
        return cache.get(n);
    }

    public static int fibBottomUpDPBackword(int n) {
        List<Integer> cache = new ArrayList<>(n);
        cache.add(0);
        cache.add(1);
        for (int i = 0; i < n; i++) {
            cache.add(0);
            cache.set(i + 1, cache.get(i) + cache.get(i + 1));
            cache.set(i + 2, cache.get(i) + cache.get(i + 2));
        }
        System.out.println("size: " + cache.size());
        return cache.get(n);
    }

}
// 0 1 1 2 3 5 8 13 21 34 55