package bruthForth.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int b = 0;
        int y = 0;
        int[] r = s.solution(b,y);
        System.out.println(Arrays.toString(r));
    }
}
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int nm = brown + yellow;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= nm/2; i++) {
            if(nm % i == 0 ) list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            int m = list.get(i);
            int n = list.get(list.size()-i-1);
            if(m + n  == (brown + 4) / 2){
                answer[0] = m>n?m:n;
                answer[1] = m>n?n:m;
                break;
            }
        }

        return answer;

    }
}