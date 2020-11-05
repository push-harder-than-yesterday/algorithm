package week9.Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * created by victory_woo on 2020/11/04
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    /*
     * 첫 번째 접근 방법.
     * 조합을 이용한 방법이다. 하지만, 공간 복잡도가 꽤 크다.
     * */

    /*private static int[] check;
    private static List<List<Integer>> result;

    public static List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i <= nums.length; i++) {
            check = new int[i];
            combination(n, (i), 0, 0, nums);
        }

        System.out.println(result);
        return result;
    }

    *//*
     * n개 중에서 r개를 뽑는 조합.
     * 주어진 배열에서 가능한 부분집합을 모두 구해야 하기 때문에
     * 공집합부터 자기 자신까지 조합을 구한다.
     * 조합 구성이 만들어졌다면 addSubset()을 이용해 부분 집합을 result 에 추가한다.
     * *//*
    private static void combination(int n, int r, int index, int target, int[] nums) {
        if (r == 0) {
            addSubset(check, nums);
            return;
        }

        if (target == n) return;

        check[index] = target;
        combination(n, r - 1, index + 1, target + 1, nums);
        combination(n, r, index, target + 1, nums);
    }

    private static void addSubset(int[] arr, int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        for (int index : arr) sub.add(nums[index]);

        result.add(sub);
    }*/


    /*
     * 솔루션 1번 방법 - 계단식.
     * 비어있는 집합부터 시작해서 각 단계마다 새로운 정수를 고려하여 기존 정수 집합에서 새로운 하위 집합을 생성한다.
     * 이전 단계에서 만들었던 집합을 기반으로 다음 집합을 생성하기 때문에 계단식이다.
     *
     * 빈 집합을 먼저 생성한다.
     * nums 요소에 대해 하나씩 접근하여 result 에 저장된 집합을 이용하여 새로운 집합을 생성한다.
     * result 에 존재하는 집합을 이용해서 새로운 수 num 을 포함하는 집합인 set 을 생성한다.
     * 그리고 그 set 을 subSets 에 추가한다.
     * 이후에는 result 에 subSets 을 추가해준다.
     * */

    /*public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // 빈집합을 먼저 생성해준다.

        for (int num : nums) {
            List<List<Integer>> subSets = new ArrayList<>();
            for (List<Integer> cur : result) {
                ArrayList<Integer> set = new ArrayList<>(cur);
                set.add(num);
                subSets.add(set);

                // 아래는 람다.
                *//*subSets.add(new ArrayList<Integer>(cur) {{
                    add(num);
                }});*//*
            }

            result.addAll(subSets);
        }
        return result;
    }*/

    /*
     * 솔루션 2번 방법 - 백트래킹.
     * 백트래킹은 가능한 모든 경우의 수를 다 확인해보는 방법.
     *
     * k = 0 ~ n까지 진행한다. k는 몇 개로 구성된 부분집합인지를 나타낸다.
     * 순서대로 k개를 갖는 부분 집합을 구성한다. 백트래킹을 통해 이전 단계로 돌아가서 원소를 빼고 다른 원소를 집어 넣어본다.
     * */

    private static int k, n;
    private static List<List<Integer>> result;

    public static List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        n = nums.length;
        for (k = 0; k <= n; k++) {
            backtrak(0, new ArrayList<Integer>(), nums);
        }

        return result;
    }

    private static void backtrak(int first, ArrayList<Integer> cur, int[] nums) {
        if (cur.size() == k) result.add(new ArrayList<>(cur));

        for (int i = first; i < n; i++) {
            cur.add(nums[i]);
            backtrak(i + 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
