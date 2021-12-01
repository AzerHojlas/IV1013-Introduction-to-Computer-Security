import java.io.*;
import java.nio.file.*;
import java.io.File;
import java.util.Random;

public class NewCipher {
    public static void main (String [] args) {

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

            File inputFile = new File (args[1]);
            inputFile.exists();
            inputFile.canRead();

            byte [] bytesFromFile = Files.readAllBytes(inputFile.toPath()); 

            File outputFile = new File(args[2]);
            outputFile.canWrite(); 
            outputFile.exists();

            FileOutputStream fos = new FileOutputStream(outputFile);
            OutputStreamWriter outWriter = new OutputStreamWriter(fos);
            BufferedWriter bufferWriter = new BufferedWriter(outWriter);

            Random random = new Random(Long.parseLong(args[0]));

            int xored;

            for (int i = 0; i < bytesFromFile.length; i++) {

                xored = bytesFromFile[i] ^ random.nextInt(256);
                bufferWriter.write(xored);
            }
            
            bufferWriter.close();
            outWriter.close();
            fos.close();

           // Files.write(outputFile.toPath(), xored);

        } catch (FileNotFoundException notFound){
            System.out.println("Input file could not be found");
            System.exit(1);
        } catch (SecurityException ex2) {
            System.out.println("Acces denied to one or more files ");
            System.exit(1);
        } catch (IOException io) {
            System.out.println("Something went wrong");
            System.exit(1);
        } /*catch (Exception e) {
            System.out.println("Something went very wrong");
            System.exit(1);
        } */
    }
}