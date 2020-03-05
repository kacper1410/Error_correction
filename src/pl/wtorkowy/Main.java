package pl.wtorkowy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ErrorCorrection errorCorrection = new ErrorCorrection();
        Bits bits = new Bits(new byte[] { 0,1,1,0,0,0,0,1,1,0,0,0});
        System.out.println(bits);
        Bits column = errorCorrection.checkParityBits(bits);
        System.out.println(column);
        System.out.println(errorCorrection.checkErrorPosition(column));
        errorCorrection.correctError(bits);
        System.out.println(bits);

    }
}
