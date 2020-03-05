package pl.wtorkowy;

import java.util.Arrays;

public class Bits {
    private byte[] bits;

    public Bits(char c) {
        changeToBits(c, 8);
    }

    public Bits(char c, int length) {
        changeToBits(c, length);
    }

    public Bits(byte[] bits) {
        this.bits = bits;
    }

    public Bits(byte[][] bits) {
        this.bits = new byte[bits.length];

        for (int i = 0; i < bits.length; i++) {
            this.bits[i] = bits[i][0];
        }
    }

    private void changeToBits(char c, int length) {
        bits = new byte[length];
        byte tmp;
        int number = c;

        for (int i = 0; i < length; i++) {
            bits[i] = (byte) (number%2);
            number = (byte) (number/2);
        }

        for(int i = 0; i < length/2; i++){
            tmp = bits[i];
            bits[i] = bits[length - 1 - i];
            bits[length - 1 - i] = tmp;
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

    public void changeBit (int position) {
        bits[position] ^= 1;
    }

}
