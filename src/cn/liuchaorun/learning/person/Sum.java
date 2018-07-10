/*
 *
 * @author lcr
 * @date 18-7-10
 */
package cn.liuchaorun.learning.person;

public class Sum implements Runnable {
    private int sum = 0;
    private int end = 0;

    public Sum(int end){
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = 0; i < end; i++){
            sum+=i;
        }
        System.out.println(sum);
    }
}
