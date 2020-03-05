package pl.wtorkowy;

public class Matrix {
    public static Bits multiply(Bits first, byte[][] second) {
        byte[][] result;
        byte[][] tmp = new byte[1][];
        tmp[0] = first.getBits();

        result = multiply(tmp, second);

        assert result != null;
        return new Bits(result[0]);
    }

    public static byte[][] multiply(byte[][] first, byte[][] second) {
        byte[][] result = new byte[first.length][second[0].length];

        if(first[0].length != second.length)
            return null;

        for (int i = 0; i < first.length; i++) {
            for (int j  = 0; j < second[0].length; j++) {
                for (int k = 0; k < second.length; k++) {
                    result[i][j] = (byte) (result[i][j] ^ first[i][k] * second[k][j]);
                }
            }
        }

        return result;
    }

    public static byte[][] transpose(byte[] tab) {
        byte[][] result = new byte[tab.length][1];

        for (int i = 0; i < tab.length; i++) {
            result[i][0] = tab[i];
        }

        return result;
    }
}
