package com.kmeans.code.ch01_string;
import java.util.*;

/**
 * 문장 속 단어 뒤집기
 *  예시 입력
 *  3
 * good
 * Time
 * Big
 * 예시 출력
 * doog
 * emiT
 * giB
 */


public class Flipwords {

    public ArrayList<String> solution(int n, String[] str){
        ArrayList<String> answer = new ArrayList<>();
        for(String x : str){
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length()-1;
            while(lt < rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        Flipwords f = new Flipwords();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        for(String x : f.solution(n, str)){
            System.out.println(x);
        }
    }
}
