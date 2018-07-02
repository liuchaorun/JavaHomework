package cn.liuchaorun.firstHomework;

public class Fibo {
    public static void main(String[] args) {
        Fibo f = new Fibo();
        System.out.println(f.fibo1(9)); // 这两种方法哪种效率更高？
        System.out.println(f.fibo2(9));
    }

    public int fibo1(int n) { // 使用方法（函数）递归来实现
        if(n == 1 || n == 2){
            return 1;
        }else {
            return fibo1(n-1) + fibo1(n-2);
        }
    }

    public int fibo2(int n) { // 使用循环来实现
        if(n == 1 || n == 2){
            return 1;
        }else {
            int p1 = 1;
            int p2 = 1;
            for (int i = 3; i <= n; i++){
                int temp = p2 + p1;
                p1 = p2;
                p2 = temp;
            }
            return p2;
        }
    }
}