package leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertDeleteGetRandom_O1 {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println("insert: " + obj.insert(5));
        obj.insert(2);
        obj.insert(6);
        obj.insert(1);
        System.out.println("list: " + obj.toString());

        System.out.println("remove: " + obj.remove(1));
        System.out.println("list: " + obj.toString());

        System.out.println("random: " + obj.getRandom());
        System.out.println("random: " + obj.getRandom());
        System.out.println("random: " + obj.getRandom());
        System.out.println("random: " + obj.getRandom());

    }

    private static class RandomizedSet {
        List<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (list.contains(val)) {
                return false;
            }

            Integer boxed = val;
            list.add(boxed);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!list.contains(val)) {
                return false;
            }

            Integer boxed = val;
            list.remove(boxed);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int index = (int) (Math.random() * list.size());
            return list.get(index);
        }

        @Override
        public String toString() {
            return "RandomizedSet{" +
                    "list=" + list +
                    '}';
        }
    }
}
