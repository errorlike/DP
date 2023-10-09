// 该例子中找零的顺序是重要的
// x = 1 even number
// x = 0 odd number
// f(i,x) x表示奇数或者偶数的情况
// f(0,1) = 0 f(1,1) = 0
//f(i,1) = f(i-1,0)+f(i-3,0)+...
public class App {

    public static void main(String[] args) {

        System.out.println(makeChange(4, 0, new int[] { 1, 3, 5, 10 }));
        System.out.println(makeChange(6, 0, new int[] { 1, 3, 5, 10 }));
        System.out.println(makeChange(5, 1, new int[] { 1, 3, 5, 10 }));
    }

    public static int makeChange(int n, int x, int[] coins) {
        int[][] cache = new int[n + 1][2];
        cache[0][0] = 1;
        cache[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j]) {
                    continue;
                }
                cache[i][0] += cache[i - coins[j]][1];
                cache[i][1] += cache[i - coins[j]][0];
            }
        }
        return cache[n][x];
    }
}
