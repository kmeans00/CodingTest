package com.kmeans.code.ch08_DFS_BFS_2;
import java.util.*;

class Edge implements Comparable<Edge> {
    public int vex;
    public int cost;
    Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob) {
        return cost - ob.cost;
    }
}

public class P15_Dijkstra {
    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public void solution(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v,0));
        dis[v] = 0;
        while(!pQ.isEmpty()){
            Edge tmp=pQ.poll();
            int now = tmp.vex;
            int nowCost=tmp.cost;
            if(nowCost>dis[now]) continue;
            for(Edge ob : graph.get(now)){
                if(dis[ob.vex] > nowCost + ob.cost){
                    dis[ob.vex] = nowCost+ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost+ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        P15_Dijkstra T = new P15_Dijkstra();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Edge>());
        }
        dis=new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b,c));
        }
        T.solution(1);
        for(int i = 2; i <= n; i++){
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i+" : " + dis[i]);
            else System.out.println(i + " : imposiible");
        }
    }

}
