package hash.a;

import java.util.HashMap;
import java.util.Map;

public class newSolution {

    /*
           수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

           마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
           완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

           제한사항
           마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다. ( 1 <= x <= 100000 )
           completion의 길이는 participant의 길이보다 1 작습니다. ( completion = participant - 1 )
           참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다. ( 1 <= name <= 20 )
           참가자 중에는 동명이인이 있을 수 있습니다.

            ["leo", "kiki", "eden"]
            ["eden", "kiki"]
            "leo"
           예제 #1
            "leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

            ["marina", "josipa", "nikola", "vinko", "filipa"]
            ["josipa", "filipa", "marina", "nikola"]
            "vinko"
            예제 #2
            "vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

            ["mislav", "stanko", "mislav", "ana"]
            ["stanko", "ana", "mislav"]
            "mislav"
            예제 #3
            "mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.

        */

    // int = 참가자배열, 완주자배열
    // out = 완주하지 못한 사람
    public String solution(String[] participant, String[] completion) {

        String result = ""; // 완주하지 못한 자
        Map<String, Integer> map = new HashMap();

        // 완주자 map에 담기
        for(String p : participant) map.put(p, map.getOrDefault(p, 0) + 1);
        for(String c : completion) map.put(c, map.get(c) - 1);

        for(String key : map.keySet()){
            if(map.get(key) > 0){
                result = key;
                break;
            }
        }

        return result;
    }

    /**
     * 내답안
    */

    public String mySolution(String[] participant, String[] completion) {
        String result = ""; // 완주하지 못한 자
        Map<String, Integer> completionMap = new HashMap();
        for (String value : completion) {
            if (completionMap.containsKey(value)) {
                completionMap.put(value, completionMap.get(value) + 1);
            } else {
                completionMap.put(value, 1);
            }
        }

        for (String s : participant) {
            if (completionMap.containsKey(s)) {
                if (completionMap.get(s) == 1) { // 완주자 1명임
                    completionMap.remove(s);
                } else if (completionMap.get(s) > 0) {
                    completionMap.put(s, completionMap.get(s) - 1);
                }
            } else {
                result = s;
            }
        }

        return result;
    }

}
