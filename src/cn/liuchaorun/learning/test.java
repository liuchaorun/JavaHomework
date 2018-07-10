package cn.liuchaorun.learning;

import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args){
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 35; i++){
            list.add(i);
        }
//        List<Integer> select = new LinkedList<>();
//        for (int i = 1; i <= 7; i++){
//            Collections.shuffle(list);
//            select.add(list.remove(0));
//        }
//        for (int i = 0; i < 7; i++){
//            if(i < 6){
//                System.out.print(select.get(i) + ", ");
//            }
//            else {
//                System.out.println(select.get(i));
//            }
//        }
        Iterator it = list.iterator();
        while (((Iterator) it).hasNext()){
            System.out.println(it.next());
        }
    }
}
