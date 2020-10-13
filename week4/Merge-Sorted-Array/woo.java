package week4.MergeSortedArray;

import java.util.Arrays;

/**
 * created by victory_woo on 2020/09/23
 */
public class woo {
    public static void main(String[] args) {
        //merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        merge(new int[]{-1, 0, 0, 3, 3, 3, 0, 0, 0}, 6, new int[]{1, 2, 2}, 3);
    }

    // 첫번째 접근법.
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < m; i++) list.add(nums1[i]);
//        for (int i = m; i < m + n; i++) list.add(i, nums2[i - m]);
//        Collections.sort(list);
//
//        for (int i = 0; i < list.size(); i++) {
//            nums1[i] = list.get(i);
//            System.out.println(nums1[i]);
//        }
//    }


    // 두번째 접근.
    // deep copy 후, 접근하는 방법.
    /*public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // deep copy.
        int[] copy = nums1.clone();

        int i = 0, j = 0;
        int index = 0;
        while (i <= n && j <= n) {
            if (nums1[i] < nums2[j]) nums1[index++] = copy[i++];
            else nums1[index++] = nums2[j++];
        }

        index = index - 1;
        while (j < n) {
            nums1[index++] = nums2[j++];
        }
        *//*for (int k = 0; k < nums1.length; k++) {
            System.out.println("index : " + k + ", value : " + nums1[k]);
        }
        for (int v : nums1) System.out.println(v);*//*
    }*/

    // 내일 원리나 로직 다시 접근해보기!!
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }
}
