package leetcode;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5};
//        int[] nums = {5,4,3,2,1};
        int[] nums = {5,1,5,5,2,5,4};
        System.out.println("result: " + increasingTriplet(nums));
    }

    private static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;

        // 첫번째 풀이
        // 중복된 값을 제거하고 나머지 데이터들이 점점 증가하는지를 확인한다.
        // -> 예시 {2,5,3,4,5} 에서 맨 뒤에 5가 사라지면서 실패한다.
//        List<Integer> data = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!data.contains(nums[i])) {
//                data.add(nums[i]);
//            }
//        }
//        for (int i = 2; i < data.size(); i++) {
//            int first = data.get(i - 2);
//            int second = data.get(i - 1);
//            int third = data.get(i);
//
//            if (first <= second && second <= third) {
//                return true;
//            }
//        }
//
//        return false;

        // 답을 본 후..
        // 1. if 문에서 가장 작은 값(min)을 찾는다.
        // 2. else if 문에서 가장 작은 값의 다음 값을 찾는다.
        // 3. else 문까지 도달 시 현재 값(num)은 최솟값보다 크고, 두번째 최솟값보다도 크니까 true를 바로 반환한다.
        // 와.. 이걸 이렇게 쉽게 푼다니 대단하다..
        int min = Integer.MAX_VALUE;
        int secondaryMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= secondaryMin) {
                secondaryMin = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
