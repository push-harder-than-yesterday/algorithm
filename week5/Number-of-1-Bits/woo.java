package week5.NumberOf1Bits;

/**
 * created by victory_woo on 2020/10/08
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
        System.out.println(hammingWeight(00000000000000000000000010000000));
        //System.out.println(hammingWeight(11111111111111111111111111111101));
    }

    public static int hammingWeight(int n) {
        System.out.println(n);
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) bits++;

            mask = mask << 1;
        }
        return bits;
    }
}
