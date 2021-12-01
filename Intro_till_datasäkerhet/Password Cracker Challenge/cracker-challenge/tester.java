import java.lang.*;
import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class tester {
    public static void main (String [] args) {
        
        String s = "String";

        String [] sa = s.split("");

        for (int i = 0; i < sa.length; i++) {

            //System.out.println(sa [i]);
        }
        
        // reverse string mangle
        // getBytes() method to convert string into bytes[].
        byte[] getByte = s.getBytes();

        byte[] result = new byte[getByte.length];

        // Store result in reverse order into the result byte[]
        for (int i = 0; i < getByte.length; i++)
            result[i] = getByte[getByte.length - i - 1];

        String reversed = new String (result, StandardCharsets.UTF_8);
        System.out.println(reversed); 
    }
}