/*
 *
 * @author lcr
 * @date 18-7-10
 */
package cn.liuchaorun.learning.person;

public class Acount {

    private int money;

    public Acount(int money) {
        this.money = money;
    }

    public synchronized void getMoney(int money) {
        // ע������ط�������whileѭ������Ϊ�����ٴ���ǮҲ�п��ܱ�ȡ��Ҫ��
        while (this.money < money) {
            System.out.println("ȡ�" + money + " ��" + this.money
                    + " ���㣬���ڵȴ����......");
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.money = this.money - money;
        System.out.println("ȡ����" + money + " ��ʣ�ࣺ" + this.money);

    }

    public synchronized void setMoney(int money) {

        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.money = this.money + money;
        System.out.println("�´��룺" + money + " ���ƣ�" + this.money);
        notify();
    }

    public static void main(String args[]) {
        Acount Acount = new Acount(0);
        Bank b = new Bank(Acount);
        Consumer c = new Consumer(Acount);
        for (int i = 0; i < 5; i++){
            new Thread(b,"Bank "+Integer.toString(i)).start();
        }
        for (int i = 0; i < 3; i++){
            new Thread(c,"customer" + Integer.toString(i)).start();
        }
    }
}

// �����
class Bank implements Runnable {
    Acount Acount;

    public Bank(Acount Acount) {
        this.Acount = Acount;
    }

    public void run() {
        while (true) {
            int temp = (int) (Math.random() * 1000);
            Acount.setMoney(temp);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

// ȡ����
class Consumer implements Runnable {
    Acount Acount;

    public Consumer(Acount Acount) {
        this.Acount = Acount;
    }

    public void run() {
        while (true) {
            int temp = (int) (Math.random() * 1000);
            Acount.getMoney(temp);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}