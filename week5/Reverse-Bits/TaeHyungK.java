package leetcode;

public class ReverseBits {
    public static void main(String[] args) {
//        reverseBits(43261596);
//        reverseBits(-3);
        System.out.println("result: " + reverseBits(-3));
    }

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        while (binary.length() < 32) {
            binary = "0" + binary;
        }

        String reverse = "";
        for (int i = binary.length() - 1; i >= 0; i--) {
            reverse += binary.charAt(i);
        }

        return (int) Long.parseLong(reverse, 2);
    }
}
