public class App {

    public static void main(String[] args) {

        System.out.println(makeChange(8, new int[] { 1, 2, 3, 5 }));
        System.out.println(makeChange(75, new int[] { 1, 2, 3, 5 }));
    }

    public static int makeChange(int n, int[] coins) {
        int column = coins.length;
        int[][] cache = new int[n + 1][column];
        for (int i = 0; i < column; i++) {
            cache[0][i] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < column; j++) {
                for (int k = 0; k <= j; k++) {
                    if (i < coins[k]) {
                        // f(3,3) = f(3,5)
                        // 如果coins是升序的话可以使用break，如果乱序就使用continue.
                        break;
                    }
                    cache[i][j] += cache[i - coins[k]][k];
                }
            }
        }
        return cache[n][column - 1];
    }
}
