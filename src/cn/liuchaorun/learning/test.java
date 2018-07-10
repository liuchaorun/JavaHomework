package cn.liuchaorun.learning;

import cn.liuchaorun.learning.person.Sum;
import cn.liuchaorun.learning.person.TimePrinterB;

public class test {
    public static void main(String[] args){
        Runnable a = new Sum(100);
        Runnable b = new TimePrinterB();

        Thread ta = new Thread(a);
        Thread tb = new Thread(b);

        tb.start();
        ta.start();
    }
}
