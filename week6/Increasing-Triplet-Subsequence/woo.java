package week6.IncreasingTripletSubsequence;

import java.util.ArrayList;

/**
 * created by victory_woo on 2020/10/14
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(increasingTriplet(new int[]{5, 1, 5, 5, 2, 5, 4}));
        System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 3}));
        System.out.println(increasingTriplet(new int[]{1, 2, 3, 1, 2, 1}));

    }

    public static boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n < a) a = n;
            else if (a < n && n < b) b = n;
            else if (b < n) return true;
        }
        return false;
    }

    /*public static boolean increasingTriplet(int[] nums) {
        int s = 0;
        int e = 1;
        ArrayList<Integer> list = new ArrayList<>();

        int min = 0;
        while (e < nums.length) {
            if (nums[s] < nums[e]) {
                min = nums[s];
                list.add(nums[s]);
            }

            s = e;
            e++;
        }

        if (min < nums[e - 1]) list.add(nums[e - 1]);

        if (list.size() < 3) return false;

        int count = 1;
        int begin = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (begin < list.get(i)) {
                count++;
                begin = list.get(i);
            }
        }

        System.out.println(list);
        return 3 <= count;
    }*/


    /*public static boolean increasingTriplet(int[] nums) {
        int s = 0;
        int e = 1;
        int min = 0;
        int count = 0;

        while (e < nums.length) {
            if (nums[s] < nums[e]) {
                if (min < nums[s]) min = nums[s];
                count++;
            }

            s = e;
            e++;
            if (3 <= count) return true;
        }

        System.out.println(count);
        if (min <= nums[e - 1]) count++;


        return 3 <= count;
    }*/
    /*public static boolean increasingTriplet(int[] nums) {
        int s = 0;
        int e = 1;

        int count = 0;
        while (e < nums.length) {
            if (nums[s] < nums[e]) count++;

            s = e;
            e++;
            if (count >= 3) return true;
        }

        System.out.println(s + ", " + e);
        System.out.println(count);

        return false;
    }*/
}
