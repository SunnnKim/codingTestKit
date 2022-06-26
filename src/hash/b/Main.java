package hash.b;

import hash.b.Solution;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] phone_book = {
                "12", "123", "1235", "567", "88"
        };
        boolean result = s.solution(phone_book);
        System.out.println(result);
    }
}
