/*
 * Point
 * @author lcr
 * @date 18-7-9
 */
package cn.liuchaorun.secondHomework.first;

public class Point {
    private double x = 0.0;
    private double y = 0.0;

    public Point(double x,double y){
        this.x = x;
        this.y = y;
    }

    public Point(double x){
        this(x,0.0);
    }

    public Point(){
        this(0.0,0.0);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj.getClass() == Point.class){
            return x==((Point)obj).getX() && y == ((Point)obj).getY();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (new Double(x)).hashCode()*13 * (new Double(y)).hashCode();
    }

    @Override
    public String toString() {
        return "Point:[x="+x+", y="+y+"]";
    }
}
