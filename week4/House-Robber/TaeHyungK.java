package leetcode;

public class HouseRobber {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
//        int[] nums = {2, 7, 9, 3, 1};
        int[] nums = {2,1,1,2};
        System.out.println("result: " + rob(nums));
    }

    private static int rob(int[] nums) {
        // 첫번째 풀이
        // 0번 집을 들린 후, 1번 집을 들린 후에 대한 결과를 계산해 둘 중에 더 큰 값을 반환한다.
        // 집은 한칸씩 떨어져 방문한다.
        //  -> 아... {2,1,1,2} 일 때 0번집 방문, 3번집 방문해서 4가 나와야 한다..
//        if (nums.length == 0) return 0;
//        else if (nums.length == 1) return nums[0];
//
//        int[] sum = new int[nums.length];
//        sum[0] = nums[0];
//        sum[1] = nums[1];
//        for (int i = 2; i < nums.length; i++) {
//            sum[i] = sum[i - 2] + nums[i];
//        }
//
//        return Math.max(sum[sum.length - 1], sum[sum.length - 2]);

        // 두번째 풀이
        // 도저히 풀리지가 않아서 solution을 찾아봤다.
        // 참고: https://chiabi.github.io/2018/08/04/HouseRobber/
        // 이분은 천재다. 손으로 디버깅해보면 맞는 답이 나오기는 하는데 왜인지 이해가 가지 않는다.
        // 더 읽어봐야겠다..

        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];

        int even = 0;
        int odd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0){
                // 짝수 인덱스일 경우 0,2,4,6...
                even = Math.max(even + nums[i], odd);
            } else {
                // 홀수 인덱스일 경우 1,3,5,7...
                odd = Math.max(even, odd + nums[i]);
            }
        }

        return Math.max(even, odd);
    }
}
