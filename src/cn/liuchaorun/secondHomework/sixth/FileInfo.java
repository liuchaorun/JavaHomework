/*
 *
 * @author lcr
 * @date 18-7-10
 */
package cn.liuchaorun.secondHomework.sixth;

public class FileInfo {
    private String name = "";
    private long size = 0;
    private String path = "";

    public FileInfo(String name,long size,String path){
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public FileInfo(){
        this("",0,"");
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj.getClass() == FileInfo.class){
            return this.name.equals(((FileInfo)obj).getName())&&this.size == ((FileInfo)obj).getSize();
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name+", "+this.path;
    }
}
