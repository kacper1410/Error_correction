package pl.wtorkowy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        byte[][] first = {
//                {1, 0, 0},
//                {1, 0, 1}
//        };
//        byte[][] second = {
//                {1, 0},
//                {1, 0},
//                {0, 1}
//        };
//        byte [][] result = Matrix.multiply(first, second);
//        for (byte[] b :
//                result) {
//            System.out.println(Arrays.toString(b));
//        }
	// write your code here

        Bits bits = new Bits('a');
        ErrorCorrection errorCorrection = new ErrorCorrection();
        System.out.println(bits);
        System.out.println(errorCorrection.addParityBits(bits));
        System.out.println(errorCorrection.checkParityBits(new Bits(new byte[] { 0,1,1,0,0,0,0,1,1,0,0,0})));
    }
}
