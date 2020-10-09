package week5.ShuffleAnArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * created by victory_woo on 2020/10/08
 */
public class woo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);
        int[] param_2 = solution.shuffle();
        for (int i : param_2) System.out.println(i);
        int[] param_1 = solution.reset();
        for (int i : param_1) System.out.println(i);
    }

    static class Solution {
        int[] og; // 배열을 의미하고, 값을 수정할 수도 있다.
        int[] copy; // 오로지, 원본에 대한 복사본을 가지며 절대 값이 바뀐채로 들어가지 않는다.
        Random random;

        public Solution(int[] nums) {
            og = nums; // 얖은 복사.
            copy = nums.clone(); // 깊은 복사.
            random = new Random();
        }

        /**
         * Resets the array to its original configuration and return it.
         * 유지하고 있던 복사본을 반환.
         */
        public int[] reset() {
            return copy;
        }

        /**
         * Returns a random shuffling of the array.
         * 삭제할 인덱스를 랜덤하게 얻는다.
         * 인덱스에 해당하는 원소를 og 배열에 담는다.
         * 인덱스에 해당하는 원소를 삭제한다. 이로 인해 리스트의 사이즈가 줄어든다.
         */
        public int[] shuffle() {
            List<Integer> list = getArrayCopy();
            for (int i = 0; i < og.length; i++) {
                int removeIdx = random.nextInt(list.size());
                og[i] = list.get(removeIdx);
                list.remove(removeIdx);
            }
            return og;
        }

        // 배열을 리스트에 담아서 반환.
        // 이유는 삭제가 편하기 때문
        private List<Integer> getArrayCopy() {
            List<Integer> list = new ArrayList<>();
            for (int v : og) list.add(v);
            return list;
        }
    }
}
