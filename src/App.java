public class App {

    public static void main(String[] args) {

        System.out.println(makeChange(2, new int[] { 1, 2, 3, 5 }));
        System.out.println(makeChange(3, new int[] { 1, 2, 3, 5 }));
        System.out.println(makeChange(4, new int[] { 1, 2, 3, 5 }));
        System.out.println(makeChange(29, new int[] { 1, 3, 5 }));
        System.out.println(makeChange(1, new int[] { 2, 3, 5 }));
        System.out.println(makeChange(56, new int[] { 15, 4, 3 }));
    }

    public static int makeChange(int n, int[] coins) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        for (int i = 1; i <= n; i++) {
            cache[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j] || cache[i - coins[j]] == Integer.MAX_VALUE) {
                    continue;
                }
                cache[i] = Math.min(cache[i], 1 + cache[i - coins[j]]);
            }
        }
        return cache[n];
    }
}
