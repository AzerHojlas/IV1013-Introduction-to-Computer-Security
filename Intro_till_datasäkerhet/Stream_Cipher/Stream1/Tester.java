import java.util.*;

public class Tester {

    public static void main (String []args) {

        Random random = new Random (Long.parseLong(args[0]));
        int key;

        for (int i = 0; i < 10; i++) {
        key = random.nextInt(8); 
        System.out.println(key);
        }
    }  
}
