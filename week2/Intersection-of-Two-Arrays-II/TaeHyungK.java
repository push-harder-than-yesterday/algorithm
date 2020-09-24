// 문제: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/

import java.util.*;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};

        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] result = intersect(nums1, nums2);
        System.out.print("result: ");
        for (int num : result) {
            System.out.print(num + ",");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // 첫번째 풀이
        // 이중 포문을 돌면서 같은 값이 있는 경우 중복 체크가 되지 않게 하기 위해 -1로 바꿔준다.
        // 또한, 같은 값을 찾은 경우 break를 통해 그 뒤로는 돌지 않도록 한다.
//        List<Integer> data = new ArrayList<>();
//        for (int i = 0; i < nums1.length; i++) {
//            int num = nums1[i];
//            for (int j = 0; j < nums2.length; j++) {
//                int compareNum = nums2[j];
//                if (num == compareNum) {
//                    data.add(compareNum);
//                    nums1[i] = -1;
//                    nums2[j] = -1;
//                    break;
//                }
//            }
//        }

        // 두번째 풀이
        // 정렬한 후 두 배열 한칸씩 돈다.
        // 두 값을 배교해서 더 작은 배열의 index를 1씩 증가시킨다.
        // 같은 값을 발견한 경우 두 index 모두 1씩 증가시킨다.
        // 아마, return 할 때에 스트림을 이용해서 배열로 변환시키지 않고 직접 배열로 변환시켜서 return하면 속도가 더 빠를 것같지만..
        // 편의상 그대로 두었다.
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> data = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            int item1 = nums1[i];
            int item2 = nums2[j];

            if (item1 == item2) {
                data.add(item1);
                i++;
                j++;
            } else if (item1 > item2) {
                j++;
            } else {
                i++;
            }
        }
        return data.stream().mapToInt(Integer::intValue).toArray();
    }
}
