package week9.Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * created by victory_woo on 2020/11/04
 */
public class woo {
    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }

    private static LinkedList<Integer> list;
    private static List<List<Integer>> result;
    private static boolean[] check;

    public static List<List<Integer>> permute(int[] nums) {
        list = new LinkedList<>();
        result = new ArrayList<>();
        check = new boolean[nums.length];

        solve(nums.length, nums.length, nums);

        return result;
    }

    private static void solve(int n, int r, int[] nums) {
        if (list.size() == r) {
            print(nums);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                list.add(i);
                check[i] = true;

                solve(n, r, nums);
                list.removeLast();
                check[i] = false;
            }
        }
    }

    private static void print(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        for (int index : list) {
            sub.add(nums[index]);
        }

        result.add(sub);
    }
}
