package cn.liuchaorun.learning.person;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;

public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval,boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public TalkingClock(){
        this(1,false);
    }

    public void start(){
        ActionListener listener = new TimerPrinter();
        Timer t = new Timer(interval,listener);
        t.start();
    }

    public class TimerPrinter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("at the tone, the time is " + new Date());
            if(beep){
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
