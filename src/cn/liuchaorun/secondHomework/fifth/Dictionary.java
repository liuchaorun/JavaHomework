package cn.liuchaorun.secondHomework.fifth;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
    private HashMap<String,String> dic ;
    private File f = new File("./dictionary.txt");

    public Dictionary(){
        this.dic = new HashMap<>();
        try{
            if(f.exists()){
                RandomAccessFile r = new RandomAccessFile(f,"r");
                String s = null;
                while ((s=r.readLine())!=null){
                    s = s.trim();
                    String t = r.readLine();
                    t = new String(t.trim().getBytes("ISO-8859-1"),"UTF-8");
                    this.dic.put(s,t);
                }
                r.close();
            }else {
                if(f.createNewFile()){
                    System.out.println("�ļ������ɹ���");
                }
            }
        }
        catch (IOException err){
            System.out.println(err.toString());
        }
    }

    public boolean add(String s,String t){
        try {
            FileWriter fw = new FileWriter(f,true);
            PrintWriter p = new PrintWriter(fw);
            p.println(s);
            p.println(t);
            p.flush();
            dic.put(s,t);
            p.close();
            return true;
        }
        catch (IOException err){
            err.printStackTrace();
            return false;
        }
    }

    public String get(String s){
        return dic.get(s);
    }

    public static void main(String[] args){
        Dictionary d = new Dictionary();
        while (true){
           try{
               System.out.println("1.���һ������");
               System.out.println("2.��ѯ");
               System.out.println("������һ����:");
               Scanner scan = new Scanner(System.in);
               int n;
               String number = scan.nextLine();
               n = Integer.parseInt(number);
               if(n == 1){
                   System.out.println("�����뵥�ʣ�");
                   String s = scan.nextLine();
                   System.out.println("���������:");
                   String t = scan.nextLine();
                   d.add(s,t);
               }else if(n==2){
                   System.out.println("�����뵥�ʣ�");
                   String s = scan.nextLine();
                   System.out.println(d.get(s));
               }else {
                   break;
               }
           }
           catch (Exception err){
               System.out.println(err.toString());
               break;
           }
        }
    }
}
