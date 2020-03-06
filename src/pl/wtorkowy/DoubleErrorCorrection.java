package pl.wtorkowy;

import java.util.Arrays;

public class DoubleErrorCorrection {
    private byte[][] H = {
            { 1,1,1,0,0,1,1,1,  1,0,0,0,0,0,0,0  },
            { 1,1,0,1,1,1,1,0,  0,1,0,0,0,0,0,0  },
            { 1,0,1,0,1,0,0,1,  0,0,1,0,0,0,0,0  },
            { 1,0,0,1,0,1,1,1,  0,0,0,1,0,0,0,0  },
            { 0,1,1,0,1,0,1,0,  0,0,0,0,1,0,0,0  },
            { 0,1,0,1,0,1,0,1,  0,0,0,0,0,1,0,0  },
            { 0,0,1,1,0,0,1,1,  0,0,0,0,0,0,1,0  },
            { 0,0,0,0,1,1,1,1,  0,0,0,0,0,0,0,1  }
    };

    private byte[][] G = {
            { 1,0,0,0,0,0,0,0,  1,1,1,1,0,0,0,0 },
            { 0,1,0,0,0,0,0,0,  1,1,0,0,1,1,0,0 },
            { 0,0,1,0,0,0,0,0,  1,0,1,0,1,0,1,0 },
            { 0,0,0,1,0,0,0,0,  0,1,0,1,0,1,1,0 },
            { 0,0,0,0,1,0,0,0,  0,1,1,0,1,0,0,1 },
            { 0,0,0,0,0,1,0,0,  1,1,0,1,0,1,0,1 },
            { 0,0,0,0,0,0,1,0,  1,1,0,1,1,0,1,1 },
            { 0,0,0,0,0,0,0,1,  1,0,1,1,0,1,1,1 }
    };

    public Bits checkParityBits(Bits bits) {
        return new Bits(Matrix.multiply(H, Matrix.transpose(bits.getBits())));
    }

    public int[] checkErrorPosition(Bits columnB) {
        int[] position = new int[2];
        byte[] column = columnB.getBits();
        for (int i = 0; i < H[0].length; i++) {
            for (int j = 0; j < column.length; j++) {
                if (column[j] != H[j][i]) {
                    break;
                }
                if (j == column.length - 1) {
                    position[0] = i + 1;
                    return position;
                }
            }
        }
        for (int i = 0; i < H[0].length; i++) {
            for (int j = i + 1; j < H[0].length; j++) {
                if (Arrays.equals(column, Matrix.sumColumns(H, i, j))) {
                    position[0] = i + 1;
                    position[1] = j + 1;
                    return position;
                }
            }
        }
        return position;
    }

    public Bits correctError(Bits bits) {
        int[] positon = checkErrorPosition(checkParityBits(bits));
        for (int i :
                positon) {
            if (i != 0) {
                bits.changeBit(i - 1);
            }
        }
        return bits;
    }

    public Bits code(Bits bits) {
        return Matrix.multiply(bits, G);
    }

    public Bits decode(Bits bits) {
        bits = correctError(bits);
        return new Bits(Arrays.copyOfRange(bits.getBits(), 0, 8));
    }
}
