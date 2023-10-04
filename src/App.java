// f(n) = f (n-1) + f(n-3)+f(n-5)+f(n-10)
//需要记忆 n-面额的值
//当n>1,3,5,10的时候才需要添加相应的f(n-面额)
// 该例子中找零的顺序是重要的
public class App {

    public static void main(String[] args) {

        System.out.println(makeChange(0));
        System.out.println(makeChange(3));
        System.out.println(makeChange(4));
        System.out.println(makeChange(5));
    }

    public static int makeChange(int n) {
        int[] cache = new int[n + 1];

        if (n < 2) {
            return 1;
        }
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i < 3) {
                cache[i] = cache[i - 1];
            } else if (i < 5) {
                cache[i] = cache[i - 1] + cache[i - 3];
            } else if (i < 10) {
                cache[i] = cache[i - 1] + cache[i - 3] + cache[i - 5];
            } else {
                cache[i] = cache[i - 1] + cache[i - 3] + cache[i - 5] + cache[i - 10];
            }

        }
        return cache[n];
    }
}
