package pl.wtorkowy;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        IOController ioController;
        ErrorCorrection errorCorrection = new ErrorCorrection();
        DoubleErrorCorrection doubleErrorCorrection = new DoubleErrorCorrection();
        ArrayList<Bits> bits;
        ArrayList<Bits> newbits = new ArrayList<>();

//        args = new String[4];
//
//        args[2] = "two";
//        args[3] = "decode";

        if (args[2].equals("one") && args[3].equals("code")) {
            ioController = new IOController(args[0], args[1]);
//            ioController = new IOController("C:\\Users\\Patryk\\Desktop\\input.txt", "C:\\Users\\Patryk\\Desktop\\output.txt");
            bits = ioController.read();

            for (Bits b: bits) {
                newbits.add(errorCorrection.code(b));
            }

            ioController.writeBits(newbits);
        }
        else if (args[2].equals("one") && args[3].equals("decode")){
            ioController = new IOController(args[1], args[0]);
//            ioController = new IOController("C:\\Users\\Patryk\\Desktop\\output.txt", "C:\\Users\\Patryk\\Desktop\\input.txt");
            bits = ioController.readBits(12);

            for (Bits b: bits) {
                newbits.add(errorCorrection.decode(b));
            }

            ioController.write(newbits);
        }
        else if (args[2].equals("two") && args[3].equals("code")) {
            ioController = new IOController(args[0], args[1]);
//            ioController = new IOController("C:\\Users\\Patryk\\Desktop\\input.txt", "C:\\Users\\Patryk\\Desktop\\output.txt");
            bits = ioController.read();

            for (Bits b: bits) {
                newbits.add(doubleErrorCorrection.code(b));
            }

            ioController.writeBits(newbits);
        }
        else {
            ioController = new IOController(args[1], args[0]);
//            ioController = new IOController("C:\\Users\\Patryk\\Desktop\\output.txt", "C:\\Users\\Patryk\\Desktop\\input.txt");
            bits = ioController.readBits(16);

            for (Bits b: bits) {
                newbits.add(doubleErrorCorrection.decode(b));
            }

            ioController.write(newbits);
        }

        ioController.close();
    }
}
