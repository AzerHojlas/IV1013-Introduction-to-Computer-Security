import java.util.*;

public class MyRandom extends Random {

    final int modulo = 10000019;
    long seed;
    long nextSeed;
    final int coefficient = 2;

    public MyRandom () {}

    public MyRandom (long seed) {

        this.seed = seed;
    }

    public int next (int bits) {

        nextSeed = (coefficient * seed) % modulo;

        setSeed(nextSeed);

        // the key to learning this is by rewatching the part of the lessons where he floors the values and divides a bunch of gibberish

        double between = (double) this.seed / modulo;

        double desirable = (between * Math.pow(2, (double) bits)) + 1;

        int next = (int) Math.floor(desirable);

        return next;  
    }

    public void setSeed (long seed) {
        this.seed = seed;
    }

    /*public static void main (String[] args) {

        MyRandom random = new MyRandom(17);

        System.out.println(random.next(Integer.parseInt(args[0])));

        int modulo1 = 5;
        long seed1 = 6;

        System.out.println((double) seed1/modulo1);
        

    } */
}
