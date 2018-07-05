package cn.liuchaorun.learning.person;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.function.BiFunction;
import javax.swing.*;

public class TimerTest {
    public static void repeat(int n, BiFunction<Integer,Integer,Integer> action){
        for (int i = 0; i < n; i++){
            System.out.println(action.apply(0,i));
        }
    }

    public static void main(String[] args) {
        ActionListener listener = event ->
        {
            System.out.println("this time is " + new Date());
            repeat(10,(i,j)->{
                for (int start = i; start < j; start++){
                    System.out.println(i+" "+j);
                }
                return 1;
            });
            Toolkit.getDefaultToolkit().beep();
        };

        Timer t = new Timer(10000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "quit program");
        System.exit(0);
    }
}
