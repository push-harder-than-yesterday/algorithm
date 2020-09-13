package leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
        String[] strs = {"dog","racecar","car"};
//        String[] strs = {"c","c"};
        System.out.println("result: " + longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        // 첫번째 풀이
        // 배열 중 가장 짧은 스트링만큼 for문을 돌며 같은 만큼 찾는다.
        if (strs.length <= 0) return "";
        if (strs.length == 1) return strs[0];

        int count = Integer.MAX_VALUE;
        for (String str : strs) {
            if (count > str.length()) {
                count = str.length();
            }
        }

        String[] temp = new String[strs.length];
        int resultCount = 0;
        for (int i = 1; i <= count; i++) {
            for (int j = 0; j < temp.length; j++) {
                temp[j] = strs[j].substring(0, i);
            }

            boolean isSame = false;
            for (int j = 0; j < temp.length - 1; j++) {
                if (!temp[j].equals(temp[j + 1])) {
                    isSame = false;
                    break;
                }
                isSame = true;
            }

            if (isSame) resultCount++;
        }

        return strs[0].substring(0, resultCount);
    }
}
