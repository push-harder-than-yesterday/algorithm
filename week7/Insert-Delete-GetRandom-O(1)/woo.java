package week7.InsertDeleteGetRandom;

import java.util.*;

/**
 * created by victory_woo on 2020/10/22
 */
public class woo {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.list);

        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.list);
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }

    static class RandomizedSet {
        List<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            this.list = new LinkedList<>();
        }

        /**
         * Inserts a value to the list. Returns true if the list did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (!list.contains(val)) {
                list.add(val);
                return true;
            } else {
                return false;
            }
        }

        /**
         * Removes a value from the list. Returns true if the list contained the specified element.
         */
        public boolean remove(int val) {
            if (list.contains(val)) {
                list.remove(list.indexOf(val));
                return true;
            } else {
                return false;
            }
        }

        /**
         * Get a random element from the list.
         */
        public int getRandom() {
            int value = (int) (Math.random() * list.size());
            return list.get(value);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
