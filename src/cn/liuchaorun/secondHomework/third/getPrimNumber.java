/*
 *
 * @author lcr
 * @date 18-7-9
 */
package cn.liuchaorun.secondHomework.third;

import java.io.FileOutputStream;
import java.io.IOException;

public class getPrimNumber {
    public static boolean isPrime(int n){
        if (n <= 3) {
            return n > 1;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        try {
            FileOutputStream f = new FileOutputStream("/home/lcr/IdeaProjects/JavaHomework/src/cn/liuchaorun/secondHomework/third/a.txt");
            for (int i = 2; i <= 10000; i++){
                if(isPrime(i)){
                    String temp = Integer.toString(i);
                    for (int j = 0; j < temp.length(); j++){
                        f.write(temp.charAt(j));
                    }
                    f.write('\r');
                    f.write('\n');
                }
            }
            f.close();
        }
        catch (IOException err){
            System.out.println(err.toString());
        }
    }
}
