/*
 *
 * @author lcr
 * @date 18-7-9
 */
package cn.liuchaorun.secondHomework.second;

import java.io.FileInputStream;
import java.io.IOException;

public class CountOne {
    public static void main(String[] args){
        try {
            FileInputStream f = new FileInputStream("/home/lcr/IdeaProjects/JavaHomework/src/cn/liuchaorun/secondHomework/second/a.txt");
            byte[][] b = new byte[8][8];
            int count = 0;
            while (f.read(b[count]) == 8){
                byte[] a = new byte[1];
                f.read(a);
                if((char)a[0] == '\n'){
                    ++count;
                }
            }
            f.close();
            for (int i = 0; i < b.length; i++){
                for (int j = 0; j < b[i].length; j++){
                    b[i][j] -= 48;
                }
            }

            //横向搜索
            int max = 0;
            for (int i = 0; i < b.length; i++){
                int temp = 0;
                for (int j = 0; j < b[i].length; j++){
                    if(b[i][j] == 1){
                        temp ++;
                    }
                    else {
                        if(temp > max){
                            max = temp;
                        }
                        temp = 0;
                    }
                }
            }

            //纵向搜索
            for (int i = 0; i < 8; i++){
                int temp = 0;
                for (int j = 0; j < 8; j++){
                    if(b[j][i] == 1){
                        temp ++;
                    }
                    else {
                        if(temp > max){
                            max = temp;
                        }
                        temp = 0;
                    }
                }
            }

            //斜线搜索
            for (int i = 0; i < 8; i++){
                int temp = 0;
                if(max > 8 - i){
                    break;
                }
                if(i == 0){
                    for (int j = 0; j < 8; j ++){
                        if(b[i+j][i+j] == 1){
                            temp++;
                        }
                        else {
                            if(temp > max){
                                max = temp;
                            }
                            temp = 0;
                        }
                    }
                }else{
                    for (int j = 0; j < 8 - i; j ++){
                        if(b[i+j][j] == 1){
                            temp++;
                        }
                        else {
                            if(temp > max){
                                max = temp;
                            }
                            temp = 0;
                        }
                    }
                    for (int j = 0; j < 8 - i; j ++){
                        if(b[j][i+j] == 1){
                            temp++;
                        }
                        else {
                            if(temp > max){
                                max = temp;
                            }
                            temp = 0;
                        }
                    }
                }
            }

            System.out.println(max);
        }
        catch (IOException err){
            System.out.println(err.toString());
        }
    }
}
