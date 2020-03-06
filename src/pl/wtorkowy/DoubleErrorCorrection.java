package pl.wtorkowy;

public class DoubleErrorCorrection extends ErrorCorrection {
    private byte[][] H = {
            { 1,1,1,0,0,1,1,1,  1,0,0,0,0,0,0,0 },
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

    @Override
    public Bits checkParityBits(Bits bits) {
        return super.checkParityBits(bits);
    }

    @Override
    public int checkErrorPosition(Bits columnB) {
        return super.checkErrorPosition(columnB);
    }

    @Override
    public Bits correctError(Bits bits) {
        return super.correctError(bits);
    }

    @Override
    public Bits code(Bits bits) {
        return super.code(bits);
    }

    @Override
    public Bits decode(Bits bits) {
        return super.decode(bits);
    }
}
