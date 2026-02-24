package com.kmeans.code.ch09;

/*
3. 결혼식
설명

현수는 다음 달에 결혼을 합니다.

현수는 결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다.

피로연에 참석하는 친구들 N명의 참석하는 시간정보를 현수는 친구들에게 미리 요구했습니다.

각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다.

현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.

만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정합니다.


입력

첫째 줄에 피로연에 참석할 인원수 N(5<=N<=100,000)이 주어집니다.

두 번째 줄부터 N줄에 걸쳐 각 인원의 오는 시간과 가는 시간이 주어집니다.

시간은 첫날 0시를 0으로 해서 마지막날 밤 12시를 72로 하는 타임라인으로 오는 시간과 가는 시간이 음이 아닌 정수로 표현됩니다.


출력

첫째 줄에 피로연장에 동시에 존재하는 최대 인원을 출력하세요.


예시 입력 1

5
14 18
12 15
15 20
20 30
5 14
예시 출력 1

2
 */



import java.util.*;

class Time implements Comparable<Time> {
    public int time;
    public char state;

    Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time ob) {
        // 시간이 같으면 알파벳 순서(e가 s보다 앞)로 정렬
        if (this.time == ob.time) return this.state - ob.state;
        else return this.time - ob.time;
    }
}

public class p03 {
    public int solution(ArrayList<Time> arr) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;
        for(Time ob : arr){
            if(ob.state=='s') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        // 1. 시간 순으로 정렬 (시간이 같으면 'e'가 우선)
        Collections.sort(arr);

        int cnt = 0;
        // 2. 타임라인을 한 명씩 확인
        for (Time ob : arr) {
            if (ob.state == 's') {
                cnt++; // 사람이 들어옴
            } else {
                cnt--; // 사람이 나감
            }
            // 3. 매 순간마다 현재 인원수와 최댓값 비교
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        p03 T = new p03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sT = sc.nextInt();
            int eT = sc.nextInt();
            // 도착(s)과 출발(e)을 별도의 객체로 저장
            arr.add(new Time(sT, 's'));
            arr.add(new Time(eT, 'e'));
        }

        System.out.println(T.solution(arr));
    }
}