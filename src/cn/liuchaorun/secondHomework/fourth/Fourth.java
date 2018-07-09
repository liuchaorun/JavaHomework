/*
 *
 * @author lcr
 * @date 18-7-9
 */
package cn.liuchaorun.secondHomework.fourth;

public class Fourth {
    public static boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSplice(int n) {
        String number = Integer.toString(n);
        if(number.length() == 1){
            if(isPrime(n)){
                return true;
            }
        }
        if (number.length() == 2){
            if(isPrime(Integer.parseInt(number.charAt(0) + "")) && isPrime(Integer.parseInt(number.charAt(1) + ""))){
                System.out.print(number.charAt(0) + ", "+ number.charAt(1)+", ");
                return true;
            }
        }
        if(number.length() == 3){
            if(isPrime(Integer.parseInt(number.charAt(0) + "")) && isPrime(Integer.parseInt(number.charAt(1) + "")) && isPrime(Integer.parseInt(number.charAt(2) + ""))){
                System.out.print(number.charAt(0) + ", "+ number.charAt(1)+", "+number.charAt(2)+", ");
                return true;
            }
            if(isPrime(Integer.parseInt(number.charAt(0) + "")) && isPrime(Integer.parseInt(number.charAt(1) + "" + number.charAt(2)))){
                System.out.print(number.charAt(0) + ", "+ number.charAt(1)+""+number.charAt(2)+", ");
                return true;
            }
            if(isPrime(Integer.parseInt(number.charAt(0) + "" + number.charAt(1))) && isPrime(Integer.parseInt(number.charAt(2) + ""))){
                System.out.print(number.charAt(0) + ""+ number.charAt(1)+", "+number.charAt(2)+", ");
                return true;
            }
            return false;
        }
        if (number.length() == 4){
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int iCount = 0;
        for (int i = 10; i <= 10000; i++) {
            if (isPrime(i) && isSplice(i)) {
                System.out.println(i);
                iCount++;
            }
        }
        System.out.println(iCount);
    }
}
