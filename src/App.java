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
        System.out.println(climbStairs(0));
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
        System.out.println(climbStairs(10));

    }

    public static int climbStairs(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        if (n >= 1) {
            cache[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                cache[i] = cache[i - 1] + cache[i - 2];
            }
        }
        return cache[n];
    }
}
