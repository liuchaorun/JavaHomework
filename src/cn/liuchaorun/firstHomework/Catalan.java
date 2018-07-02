package cn.liuchaorun.firstHomework;

public class Catalan {

    public static int answers = 0;

    //请实现go函数
    public static void go(Deque from, Deque to, Stack s) {
        if (from.size()==0&&to.size()==0&&s.size()==0) return;
        if (s.size() == 0 && from.size() == 0) {
            for (int i = 0; i < to.size(); i++) {
                System.out.print(to.get(i) + " ");
            }
            System.out.println();
            answers++;
            return;
        }
        Deque fromClone = from.clone();
        Deque toClone = to.clone();
        Stack sClone = s.clone();
        if (s.size() > 0) {
            to.addLast(s.pop());
            go(from, to, s);
        }
        if (fromClone.size() > 0) {
            sClone.push(fromClone.getFirst());
            fromClone.removeFirst();
            go(fromClone, toClone, sClone);
        }
        return;
    }

    public static void main(String[] args) {
        Deque from = new Deque();
        Deque to = new Deque();
        Stack s = new Stack();

        for (int i = 1; i <= 7; i++) {
            from.addLast(i);
        }

        go(from, to, s);

        System.out.println(answers);


    }

}
