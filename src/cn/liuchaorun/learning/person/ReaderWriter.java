/*
 *
 * @author lcr
 * @date 18-7-11
 */
package cn.liuchaorun.learning.person;

public class ReaderWriter {
    private int currentReader;
    private Object lock1 = new Object();

    public ReaderWriter() {
        this.currentReader = 0;
    }

    public void read(){
    }
}
