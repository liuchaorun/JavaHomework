/*
 *
 * @author lcr
 * @date 18-7-10
 */
package cn.liuchaorun.learning.person;

import java.util.Date;

public class TimePrinterB implements Runnable{
    @Override
    public void run() {
        System.out.println(new Date());
    }
}
