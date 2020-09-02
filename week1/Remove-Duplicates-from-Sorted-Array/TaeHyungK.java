public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len =  removeDuplicates(nums);
        System.out.println("len: " + len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public static int removeDuplicates(int[] nums) {
        // 자료구조 Set을 이용해 중복되는 값들을 자료구조에 의해 add 되지 않도록 함
        // 내부적으로 reference 를 넘기므로 input데이터인 nums가 아닌 새로운 데이터를 생성시키면 틀린다고 한다..
        // 추가로, 문제에 공간복잡도가 O(1) 을 유지해야 한다고 하니.. 새로운 데이터를 생성하면 안된다.
//        Set<Integer> items = IntStream.of(nums).boxed().collect(Collectors.toSet());
//        return items.size();

        // 문제를 자세히 읽어보니 함수의 return 값을 통해 nums 의 0 ~ return value 까지
        // for 문을 돌면서 출력하고 그 출력한 값을 비교한다.
        // 즉, 중복되지 않은 값들을 앞으로 빼내줘야 하고 그 위치(index + 1)을 반환해야 한다.

        // 새로운 값이 들어가야할 위치(index)를 지정해두고
        // for 문을 돌면서 같은 값이 아닌 애가 나오면 index 에 그 값을 저장하고
        // index를 증가시켜 위치를 보정한다.
        int index = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index] = nums[i + 1];
                index++;
            }

            System.out.print("cur nums: ");
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j] + ",");
            }
            System.out.println();
        }

        return index;
        /**
         * nums = {1, 1, 2}
         * cur nums: 1,1,2,
         * cur nums: 1,2,2,
         *
         * nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
         * cur nums: 0,0,1,1,1,2,2,3,3,4,
         * cur nums: 0,1,1,1,1,2,2,3,3,4,
         * cur nums: 0,1,1,1,1,2,2,3,3,4,
         * cur nums: 0,1,1,1,1,2,2,3,3,4,
         * cur nums: 0,1,2,1,1,2,2,3,3,4,
         * cur nums: 0,1,2,1,1,2,2,3,3,4,
         * cur nums: 0,1,2,3,1,2,2,3,3,4,
         * cur nums: 0,1,2,3,1,2,2,3,3,4,
         * cur nums: 0,1,2,3,4,2,2,3,3,4,
         */
    }
}
