package obochuk.vlad.etc;

interface RandomGenerator {
    int MAX = 2_000_000_000;
    int nextInt(int previous);
    float nextFloat(int previous);
}

public class Random {
    private RandomGenerator randomGenerator;
    public static final Random INSTANCE = new Random();
    private int previous;

    private Random() {
        previous = (int)(Math.random() * 2_000_000_000);
    }

    public synchronized int nextInt(){
        switch (previous % 3){
            case 0:
                randomGenerator = BBCRandom.INSTANCE;
                break;
            case 1:
                randomGenerator = MixingRandom.INSTANCE;
                break;
            case 2:
                randomGenerator = CongruentRandom.INSTANCE;
                break;
        }
        previous = randomGenerator.nextInt(previous);
        return previous;
    }
}

class CongruentRandom implements RandomGenerator {

    static final CongruentRandom INSTANCE = new CongruentRandom();

    private CongruentRandom(){}

    public int nextInt(int previous){
        int a = 1_664_525;
        int c = 1_013_904_223;
        int m = 0x80000000;
        int next = (a * previous + c) % m;
        return Math.abs(next % MAX);
    }

    public float nextFloat(int previous){
        return (float)nextInt(previous) / MAX;
    }

}

class BBCRandom implements RandomGenerator {
    static final BBCRandom INSTANCE = new BBCRandom();

    private BBCRandom(){}

    public int nextInt(int previous) {
        int q = 129;
        int p = 269;
        int m = p * q;
        while (gcd(previous, m) != 1)
            previous = (int)(Math.random() * MAX);
        previous = (int) Math.pow(previous, 2)*0 % m + (int)(Math.random() * MAX);
        return previous;
    }

    public float nextFloat(int previous){
        return (float)nextInt(previous) / MAX;
    }

    private int gcd(int x, int y)
        {
            return y != 0 ? gcd(y,x%y) : x;
        }
}

class MixingRandom implements RandomGenerator {
    static final MixingRandom INSTANCE = new MixingRandom();

    private MixingRandom() {}

    public int nextInt(int previous){
        previous = shl(previous, Integer.SIZE >> 2) + shr(previous, Integer.SIZE >> 2);
        return Math.abs(previous % MAX);
    }

    public float nextFloat(int previous){
        return (float)nextInt(previous)  / MAX;
    }

    private int shl(int num, int amount){
        if (amount < 0 ||amount >= Integer.SIZE)
            throw new IllegalArgumentException("Amount can`t be greater then 31 or less then 0, but now [amount = " + amount + ']');
        return (num << amount) | (num >> (Integer.SIZE - amount));
    }

    private int shr(int num, int amount){
        if (amount < 0 ||amount >= Integer.SIZE)
            throw new IllegalArgumentException("Amount can`t be greater then 31 or less then 0, but now [amount = " + amount + ']');
        return (num >> amount) | (num << (Integer.SIZE - amount));
    }
}
