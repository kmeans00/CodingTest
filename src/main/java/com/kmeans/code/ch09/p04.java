package com.kmeans.code.ch09;

/*
4. 최대 수입 스케쥴(PriorityQueue 응용문제)
설명

현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.

각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.

단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.


입력

첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.


출력

첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.


예시 입력 1

6
50 2
20 1
40 2
60 3
30 3
30 1
예시 출력 1

150
 */

import java.util.*;
class Lecture implements Comparable<Lecture> {
    public int money;
    public int time;
    Lecture(int money, int time){
        this.money = money;
        this.time = time;
    }
    @Override
    public int compareTo(Lecture ob) {
        return ob.time - this.time;
    }
}

public class p04 {
    static int n, max=Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);
        int j = 0;
        for(int i = max; i >= 1; i--){
            for( ; j <n; j++){
                if(arr.get(j).time < i) break;
                pq.offer(arr.get(j).money);
            }
            if(!pq.isEmpty()) answer+=pq.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        p04 T = new p04();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m,d));
            if(d>max) max = d;
        }
        System.out.println(T.solution(arr));

    }
}
