package hash.a;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<String, Integer> map = new HashMap<>();

    public String solution(String[] participant, String[] completion) {
        String answer;
        hashKey(completion);
        answer = checkName(participant);
        return answer;
    }

    public void hashKey(String[] str){
        for(String s : str){
            if(map.containsKey(s)){
                int num = map.get(s) + 1;
                map.put(s, num);
            }else{
                map.put(s, 1);
            }
        }
    }
    public String checkName(String[] str){
        String answer= "";
        for(String s : str){
            if(map.containsKey(s) && map.get(s) != 0){
                int  num = map.get(s) - 1;
                map.put(s,num);
            }else{
                return s;
            }
        }


        return "";
    }
}