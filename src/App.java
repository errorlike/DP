public class App {
    /*
     * n = 3 , k = 2
     * 1. 目标函数：
     * f(n)
     * 2.确定基本情况（边界条件）
     * f(0) = 0
     * f(1) = 3
     * f(2) = 2
     * f(3) = 6
     * 3.递推关系
     * 3.f(n) = p(n) + min(f(n-1),f(n-2))
     * 4.由子问题的推导顺序。
     * 自底至上
     * 5.定位答案
     * f(n)
     */
    public static void main(String[] args) throws Exception {
        System.out.println(climbStairsWithPrice(0, new int[] { 3, 2, 4 }));
        System.out.println(climbStairsWithPrice(1, new int[] { 3, 2, 4 }));
        System.out.println(climbStairsWithPrice(3, new int[] { 3, 2, 4 }));
    }

    public static int climbStairsWithPrice(int n, int[] price) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        if (n >= 1) {
            cache[1] = 3;
            for (int i = 2; i < n + 1; i++) {
                cache[i] = price[i - 1] + Math.min(cache[i - 1], cache[i - 2]);
            }
        }
        return cache[n];
    }
}
