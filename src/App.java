public class App {
    /*
     * 1. 目标函数：
     * f(n)
     * 2.确定基本情况（边界条件）
     * f(0) = 1
     * f(1) = 1
     * 3.递推关系
     * 3.f(n) = f(n-1)+f(n-2)
     * 4.由子问题的推导顺序。
     * 自底至上
     * 5.定位答案
     * f(n)
     */
    public static void main(String[] args) throws Exception {
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(climbStairs(5, 3));
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println((afterUsedMem - beforeUsedMem) / 1024 / 1024 + "MB");
    }

    public static long climbStairs(int n, int k) {
        long[] cache = new long[k];
        cache[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < k; j++) {
                if (i - j < 0)
                    continue;
                cache[i % k] += cache[(i - j) % k];
            }
        }
        return cache[n % k];
    }
}
