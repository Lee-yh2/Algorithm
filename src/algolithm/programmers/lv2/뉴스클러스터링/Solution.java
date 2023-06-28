package algolithm.programmers.lv2.뉴스클러스터링;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
 */
public class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> str1List = new ArrayList<>();
        ArrayList<String> str2List = new ArrayList<>();

        // 문자만 포함됬는지 검사후 add
        addList(str1, str1List);
        addList(str2, str2List);

        double intersectionCnt = 0;
        double unionCnt = 0;

        if(str1List.isEmpty() && str2List.isEmpty()){
            intersectionCnt = 1;
            unionCnt = 1;
        }else {

            // 사전순으로 정렬
            Collections.sort(str1List);
            Collections.sort(str2List);

            // 교집합, 합집합 구하기
            intersectionCnt = intersection(str1List, str2List);
            unionCnt = union(str1List, str2List);
        }

        double result = intersectionCnt/unionCnt;
        answer = (int)(result*65536);

        return answer;
    }

    public double intersection(ArrayList<String> list1, ArrayList<String> list2){
        int point1 = 0;
        int point2 = 0;
        double cnt = 0;

        while (point1 < list1.size() && point2 < list2.size()){
            if(list1.get(point1).compareTo(list2.get(point2)) == 0){
                point1++;
                point2++;
                cnt+=1;
            }else if(list1.get(point1).compareTo(list2.get(point2)) < 0){
                point1++;
            }else{
                point2++;
            }
        }
        return cnt;
    }

    public double union(ArrayList<String> list1, ArrayList<String> list2){
        int point1 = 0;
        int point2 = 0;
        double cnt = 0;

        while (point1 < list1.size() && point2 < list2.size()){
            if(list1.get(point1).compareTo(list2.get(point2)) == 0){
                point1++;
                point2++;
                cnt+=1;
            }else if(list1.get(point1).compareTo(list2.get(point2)) < 0){
                point1++;
                cnt+=1;
            }else{
                point2++;
                cnt+=1;
            }
        }

        if(point1 < list1.size()){
            while (point1 < list1.size()){
                point1++;
                cnt+=1;
            }
        }else if(point2 < list2.size()){
            while (point2 < list2.size()){
                point2++;
                cnt+=1;
            }
        }

        return cnt;
    }

    // list에 값 넣기
    public void addList(String str, ArrayList<String> list){
        for (int i = 0; i < str.length()-1; i++) {
            String s = "";
            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);

            if(!isWord(c1) || !isWord(c2))
                continue;

            s = c1 + "" + c2;
            list.add(s);
        }
    }

    // 문자검사
    public boolean isWord(char c){
        if('a' <= c && c <= 'z')
            return true;
        return false;
    }
}
