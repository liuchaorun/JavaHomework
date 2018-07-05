package cn.liuchaorun.learning;

import cn.liuchaorun.learning.person.TalkingClock;

import javax.swing.*;

public class test {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000,true);
        clock.start();
        TalkingClock.TimerPrinter l = clock.new TimerPrinter();

        JOptionPane.showMessageDialog(null,"quit?");
        System.exit(0);
    }
}
