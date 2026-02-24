package com.kmeans.code.ch09;

/*
7. 원더랜드(최소스패닝트리 : 프림, PriorityQueue)
설명

원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.

원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.

아래의 그림은 그 한 예를 설명하는 그림이다.

Image1.jpg

위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.


입력

첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.

다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.

이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.


출력

모든 도시를 연결하면서 드는 최소비용을 출려한다.


예시 입력 1

9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15
예시 출력 1

196
 */


import aQute.bnd.annotation.licenses.BSD_2_Clause;

import java.util.*;
class Edge2 implements Comparable<Edge>{
    public int vex;
    public int cost;
    Edge2(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost - ob.cost;
    }
}

public class p07 {
    static int[] unf;
    public static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v]=Find(unf[v]);
    }
    public static void Union(int a, int b){
        int fa=Find(a);
        int fb=Find(b);
        if(fa != fb) unf[fa]=fb;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Edge2>> graph = new ArrayList<ArrayList<Edge2>>();
        for(int i = 0; i <=n; i++){
            graph.add(new ArrayList<Edge2>());
        }
        int[] ch = new int[n+1];
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge2(b,c));
            graph.get(b).add(new Edge2(a,c));
        }
        int answer = 0;
        PriorityQueue<Edge2> pq = new PriorityQueue<Edge2>();
        pq.offer(new Edge2(1,0));
        while(!pq.isEmpty()){
            Edge2 tmp = pq.poll();
            int ev = tmp.vex;
            if(ch[ev]==0){
                ch[ev]=1;
                answer+=tmp.cost;
                for(Edge2 edge : graph.get(ev)){
                    if(ch[edge.vex]==0) pq.offer(new Edge2(edge.vex, edge.cost));
                }
            }
        }
        System.out.println(answer);

    }
}
