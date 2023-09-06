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
        System.out.println(climbStairs(1000000));
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println((afterUsedMem - beforeUsedMem) / 1024 / 1024 + "MB");
    }

    public static long climbStairs(int n) {
        // long[] cache = new long[n + 1];
        // cache[0] = 1;
        long[] cache = new long[2];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            // cache[i] = cache[i - 1] + cache[i - 2];
            cache[i % 2] = cache[0] + cache[1];
        }
        // return cache[n];
        return cache[n % 2];
    }
}
