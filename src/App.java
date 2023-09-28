public class App {
    // f(i,j) = f(i-1,1-j)+f(i-2,1-j)
    // f(n,0)+f(n,1);
    // 0 1 00 10 01 11
    // 建模方式变成：i个fences的最后一个颜色为j时有多少种涂法,子问题为 i-1个fences的颜色，末尾颜色为1-j的时的涂法 +
    // i-2个fence末尾颜色为1-j的时候（此时最后两个同色）
    public static void main(String[] args) {
        System.out.println(painted(3));
        System.out.println(painted(4));
        System.out.println(painted(5));
    }

    public static int painted(int n) {
        int[][] cache = new int[n + 1][2];
        cache[1][0] = 1;
        cache[1][1] = 1;
        cache[2][0] = 2;
        cache[2][1] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                cache[i][j] = cache[i - 1][1 - j] + cache[i - 2][1 - j];
            }
        }
        return cache[n][0] + cache[n][1];
    }
}
