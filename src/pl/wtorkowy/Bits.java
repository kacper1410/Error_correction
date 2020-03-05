package pl.wtorkowy;

import java.util.Arrays;

public class Bits {
    private byte[] bits;

    public Bits(char c) {
        bits = new byte[8];
        byte tmp;
        int number = c;

        for (int i = 0; i < 8; i++) {
            bits[i] = (byte) (number%2);
            number = (byte) (number/2);
        }

        for(int i = 0; i < 4; i++){
            tmp = bits[i];
            bits[i] = bits[7 - i];
            bits[7 - i] = tmp;
        }
    }

    public byte[] getBits() {
        return bits;
    }

    @Override
    public String toString() {
        return "Bits{" +
                "bits=" + Arrays.toString(bits) +
                '}';
    }
}
