package pl.wtorkowy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IOController {
    private FileInputStream fileInputStream;
    private FileWriter fileWriter;

    private long length;

    public IOController(String input, String output) throws IOException {
        File file = new File(input);
        length = file.length();
        fileInputStream = new FileInputStream(file);
        fileWriter = new FileWriter(new File(output));
    }

    public void writeBits(ArrayList<Bits> bits) throws IOException {
        for (Bits b: bits) {
            for (byte by: b.getBits()) {
                if(by == 1)
                    fileWriter.write('1');
                else
                    fileWriter.write('0');
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

    public void close() throws IOException {
        fileWriter.close();
        fileInputStream.close();
    }
}
