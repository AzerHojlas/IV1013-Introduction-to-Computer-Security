import java.io.*;
import java.util.Random;

public class StreamCipher {

    public static void main (String []args) {


        try {
            Long.parseLong(args[0]);
        } catch (NumberFormatException num) {
            System.out.println("Bad seed input");
            System.exit(1);
        }

        try {
            if (Long.parseLong(args[0]) == 0) 
                throw new ArithmeticException();
         } catch (ArithmeticException arithmetic) {
            System.out.println("key value 0 not allowed");
            System.exit(1);
         }

        try {
        // File read statements
        File inputFile = new File (args[1]);
        inputFile.exists();
        inputFile.canRead();
        
        // File read statements
        FileInputStream fis = new FileInputStream(inputFile);
        InputStreamReader inReader = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(inReader);

        // File write statements
        File outputFile = new File (args[2]);
        outputFile.canWrite();         
        FileOutputStream fos = new FileOutputStream(outputFile);
        OutputStreamWriter outWriter = new OutputStreamWriter(fos);
        BufferedWriter bufferWriter = new BufferedWriter(outWriter);


        // Random numbers (with a seed set from command prompt) and initializations for the loop
        Random random = new Random(Long.parseLong(args[0]));

        // while loop declarations
        int key;
        int input; 
        int xored;

        
        // create random keys and xor them with the plaintext
        while ((input = inReader.read()) != -1){

            key = random.nextInt(256); 
            xored = input^key; 
            bufferWriter.write(xored);          
        }
  
         
        // close all appropriate readers
        fis.close();
        inReader.close();
        br.close();

        // flush the stream
        bufferWriter.flush();

        // close all appropriate writers
        bufferWriter.close();
        outWriter.close();
        fos.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Acces denied to one or more files. Files either do not exist or cannot be edited");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Something went wrong");
            System.exit(1);
        }
    }    
}
