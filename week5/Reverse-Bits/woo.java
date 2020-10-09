package week5.ReverseBits;

/**
 * created by victory_woo on 2020/10/09
 */
public class woo {
    public static void main(String[] args) {
        //System.out.println(reverseBits(00000010100101000001111010011100));
        System.out.println(0111 % 2);
    }

    // 모르겠네...?
    // you need treat n as an unsigned value
    /*public static int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) sb.append('1');
            else sb.append('0');

            mask = mask << 1;
        }

        return Integer.parseInt(sb.toString());
    }*/

    // 솔루션 : 유튜브 참고!
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += n % 2;
            n >>>= 1;
        }
        return result;
    }
}
