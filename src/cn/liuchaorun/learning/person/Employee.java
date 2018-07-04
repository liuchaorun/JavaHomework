package cn.liuchaorun.learning.person;

public class Employee implements compare<Employee> {
    private int i;
    public Employee(int i){
        this.i = i;
    }
    public void p(Object... args){
        for (Object a:args){
            System.out.println(a.toString());
        }
    }

    public int getI() {
        return i;
    }

    public int c(Employee o){
        return 0;
    }
}

interface compare<T>{
    int c(T other);
}