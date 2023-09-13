import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
        int[] record =   climbStairsWithPrice(8, new int[] { 0, 3, 2, 4, 6, 1, 1, 5, 3 });
        System.out.println(getBestPath(record));
    }

    public static int[] climbStairsWithPrice(int n, int[] price) {
        int[] path = new int[n + 1];
        int[] cache = new int[n + 1];
        cache[0] = 0;
        if (n >= 1) {
            cache[1] = 3;
            for (int i = 2; i < n + 1; i++) {
                cache[i] = price[i] + Math.min(cache[i - 1], cache[i - 2]);
                if (cache[i - 1] < cache[i - 2]) {
                    path[i] = i - 1;
                } else {
                    path[i] = i - 2;
                }
            }
        }
        return path;
    }

    public static List<Integer> getBestPath(int[] record) {
        List<Integer> path = new LinkedList<>();
        for (int i = record.length - 1; i > 0; i = record[i]) {
            path.add(i);
        }
        path.add(0);
        Collections.reverse(path);
        return path;
    }
}
