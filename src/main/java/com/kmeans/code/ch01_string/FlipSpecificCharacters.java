package com.kmeans.code.ch01_string;

/**
 *
 * 첫 줄에 알파벳만 뒤집힌 문자열을 출력
 * 예시 입력
 * a#b!GE*T@S
 * 예시 출력
 * S#T!EG*B@A
 *
 */

import java.util.*;


public class FlipSpecificCharacters {
    public String solution(String str){
        String answer="";

        char[] s = str.toCharArray();
        int lt = 0, rt = str.length()-1;
        while(lt < rt){
            if(!Character.isAlphabetic(s[lt])) lt++;
            else if(!Character.isAlphabetic(s[rt])) rt--;
            else{
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }

        answer = String.valueOf(s);

        return answer;
    }

    public static void main(String[] args){
        FlipSpecificCharacters flip = new FlipSpecificCharacters();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(flip.solution(str));
    }

}
