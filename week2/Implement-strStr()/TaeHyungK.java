package leetcode;

public class ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        System.out.println("result: " + strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        // 첫번째 풀이
        // indexOf 같은 동작이여서 indexOf를 사용했다.
        // -> 문제에 써있다 쓰지말라는 듯..?
//        return haystack != null ? haystack.indexOf(needle) : -1;

        // 두번째 풀이
        // indexOf 동작을 구현하기
        int needleSize = needle.length();
        int haystackSize = haystack.length();
        for (int i = 0; i < haystackSize - needleSize + 1; i++) {
            if (haystack.substring(i, i + needleSize).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
