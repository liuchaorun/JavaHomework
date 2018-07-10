/*
 *
 * @author lcr
 * @date 18-7-10
 */
package cn.liuchaorun.secondHomework.sixth;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

public class FindTheSameFile {
    public static void getAllFiles(LinkedList<FileInfo> list,File f,String rootPath){
        if(f.isFile()){
            String absolute = (new File(f.getParent())).getPath();
            list.add(new FileInfo(f.getName(),f.length(),absolute.substring(rootPath.length(),absolute.length())+'/'));
        }
        else{
            String[] files = f.list();
            if (files != null) {
                for (String i:files){
                    getAllFiles(list,new File(f.getPath()+'/'+i),rootPath);
                }
            }
        }
    }

    public static void main(String[] args){
        LinkedList<FileInfo> fileList = new LinkedList<>();
        File f = new File(args[1]);
        getAllFiles(fileList,f,args[1]);
        while (fileList.size() != 0){
            LinkedList<Integer> temp = new LinkedList<>();
            temp.push(0);
            for (int i = 1; i < fileList.size(); i++){
                if(fileList.get(i).equals(fileList.get(0))){
                    temp.push(i);
                }
            }
            if (temp.size() > 1){
                Iterator it = temp.iterator();
                int c = 0;
                while (it.hasNext()){
                    int i = (Integer) it.next();
                    System.out.println(fileList.get(i));
                    fileList.remove(i);
                    c++;
                }
            }
            else{
                fileList.remove(0);
            }

        }
    }
}
