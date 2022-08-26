package programmers.java;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] c = {5, 3, 2, 7, 5}; // TCMA
        System.out.println(s.solution(survey, c));
    }
}
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // R / T
        // C / F
        // J / M
        // A / N
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < survey.length; i++) {
            if(choices[i] < 4){
                String type = survey[i].substring(0,1);
                int score = 4 - choices[i];
                map.put(type, map.getOrDefault(type, 0) + score);
            }else if(choices[i] > 4){
                String type = survey[i].substring(1);
                int score = choices[i] - 4;
                map.put(type, map.getOrDefault(type, 0) + score);
            }
        }
        StringBuilder a = new StringBuilder();
        a.append(map.getOrDefault("R",0) >= map.getOrDefault("T",0) ? "R" : "T");
        a.append(map.getOrDefault("C",0) >= map.getOrDefault("F",0) ? "C" : "F");
        a.append(map.getOrDefault("J",0) >= map.getOrDefault("M",0) ? "J" : "M");
        a.append(map.getOrDefault("A",0) >= map.getOrDefault("N",0) ? "A" : "N");

        return a.toString();
    }
}