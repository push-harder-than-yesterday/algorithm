package leetcode;

public class CountAndSay {
    public static void main(String[] args) {
        int n = 1;

        System.out.println("result: " + countAndSay(n)); // 111221
    }

    public static String countAndSay(int n) {
        StringBuilder result = new StringBuilder("1");
        String temp = "1";
        for (int i = 1; i < n; i++) {
            result.delete(0, result.length());
            int count = 1;
            temp += "#";
            for (int j = 1; j < temp.length(); j++) {
                if (temp.charAt(j) != temp.charAt(j - 1)) {
                    result.append(count);
                    result.append(temp.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }
            temp = result.toString();
        }

        return result.toString();
    }
}
