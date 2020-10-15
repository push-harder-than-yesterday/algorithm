package leetcode;

public class HammingDistance {
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println("result: " + hammingDistance(x, y));
    }

    private static int hammingDistance(int x, int y) {
        int distance = 0;

        // 첫번째 풀이
        // 비트 연산을 사용하지 않고 2진수로 변환하여 체크
        String binaryX = Integer.toBinaryString(x);
        String binaryY = Integer.toBinaryString(y);
        int sizeX = binaryX.length();
        int sizeY = binaryY.length();

        int maxSize = Math.max(sizeX, sizeY);
        int minSize = Math.min(sizeX, sizeY);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxSize - minSize; i++) {
            // 두 2진수의 자릿수를 동일하게 맞춰 줌
            sb.append(0);
        }
        sb.append(sizeX > sizeY ? binaryY : binaryX);
        if (sizeX < sizeY) {
            binaryX = sb.toString();
        } else if (sizeX > sizeY){
            binaryY = sb.toString();
        }

        for (int i = 0; i < maxSize; i++) {
            char charX = binaryX.charAt(i);
            char charY = binaryY.charAt(i);

            if (charX != charY) distance++;
        }

        return distance;
    }
}
