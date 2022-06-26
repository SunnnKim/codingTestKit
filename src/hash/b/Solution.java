package hash.b;

import java.security.Key;
import java.util.*;

public class Solution {
    /**
     * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
     * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
     *
     * 구조대 : 119
     * 박준영 : 97 674 223
     * 지영석 : 11 9552 4421
     * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
     * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한 사항
     * phone_book의 길이는 1 이상 1,000,000 이하입니다.
     * 각 전화번호의 길이는 1 이상 20 이하입니다.
     * 같은 전화번호가 중복해서 들어있지 않습니다. ---> set
     *
     *
     * 입출력 예제
     * phone_book	                        return
     * ["119", "97674223", "1195524421"]	false
     * ["123","456","789"]	                true
     * ["12","123","1235","567","88"]   	false
     *
     * 입출력 예 설명
     * 입출력 예 #1
     * 앞에서 설명한 예와 같습니다.
     *
     * 입출력 예 #2
     * 한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.
     *
     * 입출력 예 #3
     * 첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.
     *
     * */

    public boolean solution(String[] phone_book) {

        Set<String> hs = new HashSet();

        hs.addAll(Arrays.asList(phone_book));
        for (String s : phone_book) {
            for (int j = 0; j < s.length(); j++) {
                if (hs.contains(s.substring(0, j))) return false;
            }
        }

        return true;

        // 내 답안 (실패)
//        boolean answer = true;
//        Set<String> h1 = new HashSet();
//        Set<String> h2 = new HashSet();
//
//        for(String p : phone_book) {
//            h1.add(p);
//            h2.add(p);
//        }
//
//        Iterator<String> i1 = h1.stream().iterator();
//        while(i1.hasNext()){
//            String n = i1.next();
//            h2.remove(n);
//            Iterator<String> i2 = h2.stream().iterator();
//            while(i2.hasNext()){
//                String n2 = i2.next();
//                if(n.startsWith(n2) || n2.startsWith(n) ){
//                    return false;
//                }
//            }
//
//        }


    }

}