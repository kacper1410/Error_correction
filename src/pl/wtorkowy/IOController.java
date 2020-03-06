package pl.wtorkowy;

import java.io.*;
import java.util.ArrayList;

public class IOController {
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    private long length;

    public IOController(String input, String output) throws IOException {
        File file = new File(input);
        length = file.length();
        fileInputStream = new FileInputStream(file);
        fileOutputStream = new FileOutputStream(new File(output));
    }

    public void writeBits(ArrayList<Bits> bits) throws IOException {
        for (Bits b: bits) {
            for (byte by: b.getBits()) {
                if(by == 1)
                    fileOutputStream.write('1');
                else
                    fileOutputStream.write('0');
            }
        }
    }

    public ArrayList<Bits> readBits(int number) throws IOException {
        byte[] tmp = new byte[number];
        ArrayList<Bits> bits = new ArrayList<>();

        for (int i = 0; i < length / number; i++) {
            for (int j = 0; j < number; j++) {
                if(fileInputStream.read() == 49)
                    tmp[j] = 1;
                else
                    tmp[j] = 0;
            }

            bits.add(new Bits(tmp));
        }

        return bits;
    }

    public ArrayList<Bits> read() throws IOException {
        ArrayList<Bits> bits = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            bits.add(new Bits((char) fileInputStream.read()));
        }

        return bits;
    }

    public void write(ArrayList<Bits> bits) throws IOException {
        int result = 0;
        int tmp = 1;
        
        for (Bits b: bits) {
            result = 0;
            tmp = 1;
            byte[] tab = b.getBits();

            for (int i = tab.length - 1; i >= 0; i--) {
                result += tab[i] * tmp;
                tmp *= 2;
            }
            fileOutputStream.write(result);
        }

    }

    public void close() throws IOException {
        fileOutputStream.close();
        fileInputStream.close();
    }
}
