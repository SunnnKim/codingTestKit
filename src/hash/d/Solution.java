package hash.d;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    /**
     * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
     * 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
     *
     * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
     * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
     * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
     *
     * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
     * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
     *
     * 제한사항
     * genres[i]는 고유번호가 i인 노래의 장르입니다.
     * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
     * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다. ------ 1 <= 장르, 재생수 <= 10000
     * 장르 종류는 100개 미만입니다. ---- 장르 < 100
     * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
     * 모든 장르는 재생된 횟수가 다릅니다.
     *
     * 입출력 예
     * genres
     * plays
     * return
     *
     * ["classic", "pop", "classic", "classic", "pop"]
     * [500, 600, 150, 800, 2500]
     * [4, 1, 3, 0]
     *
     * 입출력 예 설명
     * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
     *
     * 고유 번호 3: 800회 재생
     * 고유 번호 0: 500회 재생
     * 고유 번호 2: 150회 재생
     * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
     *
     * 고유 번호 4: 2,500회 재생
     * 고유 번호 1: 600회 재생
     * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
     */
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        // 1. 재생수 높은 장르부터 수록
        // 2. 장르내에서 재생수 높은 노래 수록
        // 3. 고유번호 낮은 순으로 수록


        Map<String, Map<Integer, Integer>> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            Map m = map.getOrDefault(genres[i], new HashMap<>());
            m.put(i, plays[i]);
            map.put(genres[i], m);

            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(count.entrySet());
        List result = new ArrayList();
        entryList.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        // 소팅
//        map.forEach( (k, m) -> {
//          m.entrySet()
//                  .stream()
//                  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
//        });
        entryList.forEach(val -> {
            Map m = map.get(val.getKey());
            Stream a = m.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            List l = (List) a.collect(Collectors.toList());

//            result.add(l.get(0));
//            if(l.size() > 1) result.add(l.indexOf(l.get(1)));
        });
        System.out.println(result);

//
//        // map에 곡 별 재생수 더해서 담기
//        Map<String, Integer> map = new HashMap<>();
//        Map<String, ArrayList<Integer>> data = new HashMap<>();
//        Map<Integer, Integer> initNum = new HashMap<>();
//
//        for(int i=0; i<genres.length; i++) {
//            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
//            ArrayList list = data.getOrDefault(genres[i], new ArrayList());
//            list.add(plays[i]);
//            data.put(genres[i], list);
//            // 고유번호
//            initNum.put(i, plays[i]);
//
//        }
//        // 가장 높은장르
//        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
//        // 고유번호 소팅
//        List<Map.Entry<Integer, Integer>> entryNumList = new LinkedList<>(initNum.entrySet());
//
//
//        entryList.sort(Map.Entry.comparingByValue()); // Entry에 값으로 소팅하는 메소드 사용
//        entryList.forEach( (entry) -> {
//            System.out.println(entry.getKey());
//            List list = data.get(entry.getKey());
//            Collections.sort(list, Collections.reverseOrder()); // 역순
//            list.forEach( l -> {
//                System.out.println(l);
//                // 재생수 낮으면 높은거부터
//            });
//        });
//
//        System.out.println(map);
//        System.out.println(data);
//        System.out.println(Arrays.stream(map.values().toArray()).sorted());
//


        return answer;
    }
}
