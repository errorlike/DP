public class App {
    public static void main(String[] args) throws Exception {
        int[][] obstacle = new int[][] {
                { 0, 2, 2, 1 },
                { 3, 1, 1, 1 },
                { 4, 4, 2, 0 }
        };
        int[][] obstacle1 = new int[][] {
                { 0, 2, 2, 50 },
                { 3, 1, 1, 100 },
                { 4, 4, 2, 0 }
        };
        int result = toXY(obstacle);
        int result1 = toXY(obstacle1);
        System.out.println(result);
        System.out.println(result1);
    }

    public static int toXY(int obstacle[][]) {
        int m = obstacle.length;
        int n = obstacle[0].length;
        int[][] cache = new int[m][n];
        cache[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0 && j > 0) {
                    cache[i][j] = obstacle[i][j] + cache[i][j - 1];
                    continue;
                }
                if (j == 0 && i > 0) {
                    cache[i][j] = obstacle[i][j] + cache[i - 1][j];
                    continue;
                }
                cache[i][j] = obstacle[i][j] + Math.max(cache[i - 1][j], cache[i][j - 1]);
            }
        }
        return cache[m - 1][n - 1];
    }
}
