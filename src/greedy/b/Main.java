package greedy.b;

/*
조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.

▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.

- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

제한 사항
name은 알파벳 대문자로만 이루어져 있습니다.
name의 길이는 1 이상 20 이하입니다.
입출력 예
name	return
"JEROEN"	56
"JAN"	23

 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String name = "AAAAAAABBBB"; //
        int r = s.solution(name);
        System.out.println(r);
    }
}
class Solution {
    public int solution(String name) {
        // A
        // BCDEFGHIJKLM
        // NOPQRSTUVWXYZ
        int count = 0;
        int index = 0; // 다음값 확인
        int move = name.length() - 1; // 좌우 움직임(1번씩 움직였을 경우)
        // 좌우

        for (int i = 0; i < name.length(); i++) {
            // 상하
            count += countAlpabat(name.charAt(i));

            index = i + 1; // 다음값 확인
            // 다음 인덱스부터 연속되는 값이 A인 경우의 인덱스
            while(index < name.length() && name.charAt(index) == 'A'){
                index++;
            }
            // i -> 처음 -> index로 오는 케이스
            move = Math.min(move, i * 2 + name.length() - index);
            // BBBBAAAAAAAB
            // i -> index -> 마지막 -> i 로 오는 케이스 (뒷부분부터입력하면 더 빠름)
            move = Math.min(move, (name.length() - index) * 2 + i);
        }
        return count + move;
    }
    int countAlpabat(char c){
        return Math.min(c - 'A', 'Z' - c + 1);
    }
}