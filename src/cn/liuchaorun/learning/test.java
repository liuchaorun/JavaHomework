package cn.liuchaorun.learning;

import cn.liuchaorun.learning.person.Employee;

public class test {
    public static void main(String[] args){
        Size a = Size.LARGER;
        System.out.println(a.getAbbreviation());
        Size b = Enum.valueOf(Size.class,"SMALL");
        System.out.println(b.ordinal());
    }
}

enum Size{
    SMALL("S"),LARGER("L");

    private Size(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    private String abbreviation;
}