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

    public static boolean isDivide(String n,StringBuilder s){
        if(n.length() == 1){
            if(isPrime(Integer.parseInt(n))){
                s.append(n);
                s.append(", ");
                return true;
            }
        }
        if(n.length() == 2){
            if(n.charAt(0)!='0'&&isPrime(Integer.parseInt(n))){
                s.append(n);
                s.append(", ");
                return true;
            }
            if(n.charAt(0)!='0'&&isDivide(n.charAt(0)+"",s)&&isDivide(n.charAt(1)+"",s)){
                return true;
            }
        }
        if (n.length() == 3){
            if(isPrime(Integer.parseInt(n))){
                s.append(n);
                s.append(", ");
                return true;
            }
            if(n.charAt(0)=='1'){
                if(isDivide(n.substring(0,2),s)&&isDivide(n.charAt(2)+"",s)){
                    return true;
                }
            }
            else{
                if(isDivide(n.substring(0,2),s)&&isDivide(n.charAt(2)+"",s)){
                    return true;
                }
                if(isDivide(n.charAt(0)+"",s)&&isDivide(n.substring(1,3),s)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isSplice(int n,StringBuilder st) {
        String number = Integer.toString(n);
        if (number.length() == 1) {
            if (isPrime(n)) {
                return true;
            }
        }
        if (number.length() == 2) {
            if (isDivide(number.charAt(0) + "",st) && isDivide(number.charAt(1) + "",st)) {
                return true;
            }
        }
        if (number.length() == 3) {
            if(isDivide(number.substring(0,2),st)&&isDivide(number.charAt(2)+"",st)){
                return true;
            }
            st.delete(0,st.length());
            if(isDivide(number.charAt(0)+"",st)&&isDivide(number.substring(1,3),st)){
                return true;
            }
        }
        if (number.length() == 4) {
            if(number.charAt(2)!='0'&&isDivide(number.substring(0,2),st)&&isDivide(number.substring(2,4),st)){
                return true;
            }
            st.delete(0,st.length());
            if(number.charAt(1)!='0'){
                if(isDivide(number.charAt(0)+"",st)&&isDivide(number.substring(1,4),st)){
                    return true;
                }
            }
            st.delete(0,st.length());
            if (isDivide(number.substring(0,3),st)&&isDivide(number.charAt(3)+"",st)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int iCount = 0;
        for (int i = 10; i <= 10000; i++) {
            StringBuilder s = new StringBuilder();
            if (isPrime(i) && isSplice(i,s)) {
                System.out.print(s.toString());
                System.out.println(i);
                iCount++;
            }
        }
        System.out.println(iCount);
    }
}
