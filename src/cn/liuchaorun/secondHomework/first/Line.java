/*
 * Line
 * @author lcr
 * @date 18-7-9
 */
package cn.liuchaorun.secondHomework.first;

public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) throws TwoPointException {
        if (start.equals(end)){
            throw new TwoPointException();
        }
        this.start = start;
        this.end = end;
    }

    public Line() throws TwoPointException {
        this(new Point(0.0,0.0),new Point(1.0,1.0));
    }

    public Line(double startX, double startY, double endX, double endY) throws TwoPointException {
        this(new Point(startX,startY), new Point(endX,endY));
    }

    public double getK(){
        return (end.getY() - start.getY())/(end.getX() - start.getX());
    }

    public boolean isOnLine(Point p){
        return (new Double(getK())).equals((p.getY() - start.getY()) / (p.getX() - start.getX()));
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public int hashCode() {
        return start.hashCode()*13 + end.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if(obj.getClass() == Line.class){
            return ((Line)obj).getK() == getK() && isOnLine(((Line)obj).getStart());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Line:[start="+start.toString()+", end="+end.toString()+"y="+getK()+"x+"+(start.getY() - getK()*start.getX()) +"]";
    }

    public static void main(String[] args){
        try {
            Line l1 = new Line();
            Line l2 = new Line(2,2,3,3);
            Point p1 = new Point(10,10);
            Point p2 = new Point(3,6.12);
            Line l3 = new Line(p1,p2);
            System.out.println(l1.equals(l2));
            System.out.println(l1.equals(l3));
            System.out.println(l1.isOnLine(p1));
        }
        catch (TwoPointException err){
            System.out.println(err.toString());
        }
    }
}
