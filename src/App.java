// f(n) = f (n-1) + f(n-3)+f(n-5)+f(n-10)
//需要记忆 n-面额的值
//当n>1,3,5,10的时候才需要添加相应的f(n-面额)
// 该例子中找零的顺序是重要的
public class App {

    public static void main(String[] args) {

        System.out.println(makeChange(0, 1));
        System.out.println(makeChange(7, 3));
    }

    public static int makeChange(int n, int limit) {
        int[][] cache = new int[n + 1][limit + 1];
        cache[0][0] = 1;
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < limit + 1; j++) {
                if (i > 0 && j == 0) {
                    continue;
                }
                if (i >= 1) {
                    cache[i][j] += cache[i - 1][j - 1];
                }
                if (i >= 2) {
                    cache[i][j] += cache[i - 2][j - 1];
                }
                if (i >= 3) {
                    cache[i][j] += cache[i - 3][j - 1];
                }
                if (i >= 5) {
                    cache[i][j] += cache[i - 5][j - 1];
                }
            }
        }

        return cache[n][limit];
    }
}
