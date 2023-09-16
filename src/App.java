public class App {
    public static void main(String[] args) throws Exception {
        int[][] obstacle = new int[][] {
                new int[] { 0, 0, 0, 0 },
                new int[] { 0, 0, 1, 1 },
                new int[] { 0, 0, 0, 0 },
        };
        int result = toXY(obstacle);
        System.out.println(result);
    }

    public static int toXY(int obstacle[][]) {
        int m = obstacle.length;
        int n = obstacle[0].length;
        int[][] cache = new int[m][n];
        cache[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacle[i][j] == 1) {
                    obstacle[i][j] = 0;
                    continue;
                }
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
