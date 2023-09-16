public class App {
    public static void main(String[] args) throws Exception {
        int result = toXY(3, 4);
        System.out.println(result);
    }

    public static int toXY(int m, int n) {
        int[][] cache = new int[m][n];
        cache[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 1;
                    continue;
                }
                cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
            }
        }
        return cache[m - 1][n - 1];
    }
}
