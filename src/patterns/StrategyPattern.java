package patterns;

public class StrategyPattern {
    public static void main(String[] args) {
        Compressor zipCompressor = new Compressor(new ZipCompressor());
        System.out.println("I am using strategy of type : " + zipCompressor.compress());

        Compressor gzipCompressor = new Compressor(new GzipCompressor());
        System.out.println("I am using strategy of type : " + gzipCompressor.compress());
    }
}

interface CompressStrategy {
    String compress();
}

class ZipCompressor implements CompressStrategy {
    @Override
    public String compress() {
        return "Zip compressor ";
    }
}

class GzipCompressor implements CompressStrategy {
    @Override
    public String compress() {
        return "Gzip compressor ";
    }
}

class Compressor {
    private final CompressStrategy compressStrategy;
    Compressor(CompressStrategy compressStrategy) {
        this.compressStrategy = compressStrategy;
    }

    public String compress() {
        return this.compressStrategy.compress();
    }
}