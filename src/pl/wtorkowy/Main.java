package pl.wtorkowy;

import java.util.Arrays;

public class Main {

    public static byte[][] multiply(byte[][] first, byte[][] second) {
        byte[][] result = new byte[first.length][second[0].length];

        if(first[0].length != second.length)
            return null;

        for (int i = 0; i < first.length; i++) {
            for (int j  = 0; j < second[0].length; j++) {
                for (int k = 0; k < second.length; k++) {
                    result[i][j] = (byte) (result[i][j] ^ first[i][k] * second[k][j]);
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        byte[][] first = {
                {1, 0, 0},
                {1, 0, 1}
        };
        byte[][] second = {
                {1, 0},
                {1, 0},
                {0, 1}
        };
        byte [][] result = multiply(first, second);
        for (byte[] b :
                result) {
            System.out.println(Arrays.toString(b));
        }
	// write your code here

        Bits bits = new Bits('a');
        System.out.println(bits);
    }
}
