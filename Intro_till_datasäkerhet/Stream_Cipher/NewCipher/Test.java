import java.io.*;
import java.nio.file.*;
import java.io.File;
import java.util.Random;
import java.nio.charset.StandardCharsets;

public class Test {

    public static void main (String [] args) throws Exception {
        Random random = new Random (Long.parseLong(args[0]));

       /* byte [] a = {2,3,4,5};
        int [] b = new int [a.length];
        byte [] c = new byte [a.length];
    
        for (int i = 0; i < c.length; i++) {
        b [i] = test.nextInt(256);
        c [i] = (byte) (a [i] ^ b[i]);
        c [i] = (byte) (c [i] ^ b[i]);
        System.out.println(c[i]); */

        String inputString = "Hello World!";
        byte[] byteArrray = inputString.getBytes(StandardCharsets.UTF_8);
        int [] keys = new int [byteArrray.length];
        byte [] xored = new byte [byteArrray.length];
        for (int i = 0; i < xored.length; i++) {

            keys [i] = random.nextInt(256);
            xored [i] = (byte) (keys[i] ^ byteArrray [i]);
        }

        String converted = new String (xored);
        System.out.println(converted);
    }
}