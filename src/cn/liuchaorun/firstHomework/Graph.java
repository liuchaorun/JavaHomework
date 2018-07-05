package cn.liuchaorun.firstHomework;

public class Graph {
    private int[][] matrix;
    private int pointNumber;
    private int[] mark;

    public Graph(){
        pointNumber = 6;
        matrix = new int[pointNumber][pointNumber];
        for (int[] i: matrix){
            for (int j:i){
                j = 0;
            }
        }
        mark = new int[pointNumber];
        for (int i:mark){
            i = 0;
        }
    }

    public void init(){
        setGraphEdge(0,1,2);
        setGraphEdge(0,2,5);
        setGraphEdge(0,3,1);
        setGraphEdge(1,2,3);
        setGraphEdge(1,3,2);
        setGraphEdge(2,3,3);
        setGraphEdge(2,4,1);
        setGraphEdge(2,5,5);
        setGraphEdge(3,4,1);
        setGraphEdge(4,5,2);
    }

    public void setGraphEdge(int i,int j, int value){
        matrix[i][j] = value;
        matrix[j][i] = value;
    }

    public int getPointNumber() {
        return pointNumber;
    }

    public void dijkstra(int i, int[] dist, int[] length) {
        int min = 0;
        for (int j = 0; j < pointNumber; ++j) {
            mark[j] = 0;
        }
        mark[i] = 1;
        for (int k = 0; k < pointNumber - 1; ++k) {
            for (int j = 0; j < pointNumber; ++j) {
                if (mark[j] == 0) {
                    if ((length[j] == 0 || length[j] > length[i] + matrix[i][j]) && matrix[i][j] != 0) {
                        length[j] = length[i] + matrix[i][j];
                        dist[j] = i;
                    }
                }
            }
            for (int m = 0; m < pointNumber; ++m) {
                if(mark[m] == 0 && length[m] != 0){
                    min = m;
                    break;
                }
            }
            for (int l = 0; l < pointNumber; ++l) {
                if (mark[l] == 0 && length[l] != 0) {
                    if (length[l] < length[min]) {
                        min = l;
                    }
                }
            }
            i = min;
            mark[i] = 1;
        }
    }


    public static void main(String[] args){
        char[] table = {'A','B','C','D','E','F'};
        Graph g = new Graph();
        g.init();
        int[] dist = new int[g.getPointNumber()];
        int[] length = new int[g.getPointNumber()];
        for (int i = 0; i < g.getPointNumber(); ++i){
            dist[i] = 0;
            length[i] = 0;
        }
        g.dijkstra(0,dist,length);
        for (int i = 0; i < g.getPointNumber(); i++){
            StringBuilder  builder = new StringBuilder();
            builder.append(table[i]);
            if(i != 0){
                int j = i;
                do{
                    j = dist[j];
                    builder.append(">-");
                    builder.append(table[j]);
                }while(0 != j);
                System.out.println(builder.reverse().toString() + ",length = " + length[i]);
            }
        }
    }
}
