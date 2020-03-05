package pl.wtorkowy;

import java.util.Arrays;

public class ErrorCorrection {
    private byte[][] H = {
            { 1,1,1,0,0,0,1,1,1,0,0,0 },
            { 1,0,0,1,0,1,1,0,0,1,0,0 },
            { 0,1,0,0,1,1,1,1,0,0,1,0 },
            { 0,0,1,1,1,0,0,1,0,0,0,1 }
    };

    private byte[][] G = {
            { 1,0,0,0,0,0,0,0,1,1,0,0 },
            { 0,1,0,0,0,0,0,0,1,0,1,0 },
            { 0,0,1,0,0,0,0,0,1,0,0,1 },
            { 0,0,0,1,0,0,0,0,0,1,0,1 },
            { 0,0,0,0,1,0,0,0,0,0,1,1 },
            { 0,0,0,0,0,1,0,0,0,1,1,0 },
            { 0,0,0,0,0,0,1,0,1,1,1,0 },
            { 0,0,0,0,0,0,0,1,1,0,1,1 }
    };

    public Bits addParityBits(Bits bits) {
        return Matrix.multiply(bits, this.G);
    }

    public Bits checkParityBits(Bits bits) {
        return new Bits(Matrix.multiply(this.H, Matrix.transpose(bits.getBits())));
    }

    public int checkErrorPosition (Bits columnB) {
        byte[] column = columnB.getBits();
        for (int i = 0; i < H[0].length; i++) {
            for (int j = 0; j < column.length; j++) {
                if (column[j] != H[j][i]) {
                    break;
                }
                if (j == column.length - 1) {
                    return i + 1;
                }
            }
        }
        return 0;
    }

    public Bits correctError (Bits bits) {
        int positon = checkErrorPosition(checkParityBits(bits));
        if (positon != 0) {
            bits.changeBit(positon - 1);
        }
        return bits;
    }

    public Bits code (Bits bits) {
        return Matrix.multiply(bits, G);
    }

    public Bits decode (Bits bits) {
        return new Bits(Arrays.copyOfRange(bits.getBits(), 0, 8));
    }
}

