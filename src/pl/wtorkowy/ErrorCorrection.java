package pl.wtorkowy;

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
}

