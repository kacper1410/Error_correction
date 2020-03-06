package pl.wtorkowy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

//        ErrorCorrection errorCorrection = new ErrorCorrection();
//        Bits bits = new Bits(new byte[] { 0,1,1,0,0,0,0,1,1,0,0,0});
//        Bits bits2 = new Bits(new byte[] { 0,1,1,0,0,0,0,1});
//        System.out.println(bits);
//        bits2 = errorCorrection.code(bits2);
//        System.out.println(bits2);
//        Bits column = errorCorrection.checkParityBits(bits);
//        System.out.println(column);
//        System.out.println(errorCorrection.checkErrorPosition(column));
//        errorCorrection.correctError(bits);
//        System.out.println(bits);
//        System.out.println(errorCorrection.decode(bits));

        IOController ioController = new IOController("/Users/user/Desktop/input","/Users/user/Desktop/output");
        ArrayList<Bits> bits = ioController.readBits(8);



        System.out.println(bits.size());

        for (Bits s: bits) {
            System.out.println(s);
        }

        ioController.writeBits(bits);
        ioController.close();
    }
}
