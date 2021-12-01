import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.nio.charset.StandardCharsets;


public class PasswordCrack2 {

    static ArrayList <String> dictList = new ArrayList <> ();
    static ArrayList <String> passList = new ArrayList <> ();
    // declare an iterator
    public static ListIterator<String> passIterator;

    public static void main (String args[]) throws exception {


        // create a file
        File inputFile = new File (args[0]);

        // File read statements
        FileInputStream fis = new FileInputStream(inputFile);
        InputStreamReader inReader = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(inReader);

        // add the try blocks later
        inputFile.exists();
        inputFile.canRead();

        String input;
        
        while ((input = br.readLine()) != null) {

            // add the word to the dictionary
            dictList.add(input);         
        }
        // close all appropriate readers
        fis.close();
        inReader.close();
        br.close();

        // create a file for passwords
        File inputFile2 = new File (args[1]);

        // File read statements
        FileInputStream fis2 = new FileInputStream(inputFile2);
        InputStreamReader inReader2 = new InputStreamReader(fis2);
        BufferedReader br2 = new BufferedReader(inReader2);

        // add the try blocks later
        inputFile.exists();
        inputFile.canRead();

        String input2;
        
        while ((input2 = br2.readLine()) != null){


            String[] divided = input2.split("[: ]+");



            // add the hashed pass + salt
            passList.add(divided[1]);

            // add these candidates to the dictionary
            dictList.add(divided[0]);
            dictList.add(divided[4]);
            dictList.add(divided[5]);
        }
        // close all appropriate readers
        fis2.close();
        inReader2.close();
        br2.close();

        // normal iterator unmangled
        for(String candidate : dictList){
           
            // initiate the custom iterator
            passIterator = passList.listIterator();

            while(passIterator.hasNext()){
                // extract the hashed password
                String password = passIterator.next();
                //extract the salt
                String salt = password.substring(0, 2);
                // make a hashed and salted version of each word in the dictionare 
                String compare = jcrypt.crypt(salt, candidate);

                // compare the hashed and salted dictionary word to the real password
                if(compare.equals(password)){
                    System.out.println(candidate);                     
                    passIterator.remove();
                }
            }
        }

        String[] add = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", 
                        "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", 
                        "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", 
                        "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        // compare this
        String mangle; 

        // use this for ntoggle
        StringBuilder sb = new StringBuilder();

        // mangler
        for(String candidate : dictList){
        
            for (int i = 0; i < add.length; i++) {

                // appender mangle
                mangle = candidate.concat(add [i]);
                comparator(mangle);
            
                // prepender mangle
                mangle = add [i].concat(candidate);
                comparator(mangle);
            }

            // duplicate mangle
            mangle = candidate.concat(candidate);
            comparator(mangle);

            // delete first mangle
            mangle = candidate.substring(1);
            comparator(mangle);

            // delete last mangle
            mangle = candidate.substring(0, (candidate.length() - 1));
            comparator (mangle);

            // Uppercase mangle
            mangle = candidate.toUpperCase();
            comparator (mangle);

            // Lowercase mangle
            mangle = candidate.toLowerCase();
            comparator (mangle);

            // Capitalize mangle
            mangle = candidate.substring(0, 1).toUpperCase().concat(candidate.substring(1).toLowerCase());
            comparator (mangle);

            // Ncapitalize mangle
            mangle = candidate.substring(0, 1).toLowerCase().concat(candidate.substring(1).toUpperCase());
            comparator (mangle);

            // Toggle capitalize 1 mangle
            for (int i = 0; i < candidate.length(); i++) {
                String [] mangleThis = candidate.split("");
                
                if ((i % 2) == 0) {
                    sb.append(mangleThis[i].toUpperCase());
                }

                if ((i % 2) == 1) {
                    sb.append(mangleThis[i].toLowerCase());
                }
            }

            // compare the result
            comparator(sb.toString());
            // clear the stringbuilder
            sb.delete(0, sb.length());

            // Toggle capitalize 2 mangle
            for (int i = 0; i < candidate.length(); i++) {
                String [] mangleThis = candidate.split("");
                
                if ((i % 2) == 0) {
                    sb.append(mangleThis[i].toLowerCase());
                }

                if ((i % 2) == 1) {
                    sb.append(mangleThis[i].toUpperCase());
                }
            }

            // compare the result
            comparator(sb.toString());
            // clear the stringbuilder
            sb.delete(0, sb.length());

            // reverse string mangle
            // getBytes() method to convert string into bytes[].
            byte[] getByte = candidate.getBytes();
 
            byte[] result = new byte[getByte.length];
 
            // Store result in reverse order into the result byte[]
            for (int i = 0; i < getByte.length; i++)
                result[i] = getByte[getByte.length - i - 1];

            // convert byte array to string
            String reversed = new String (result, StandardCharsets.UTF_8);

            comparator(reversed);

            // reflect mangler 1
            mangle = candidate.concat(reversed);
            comparator(mangle);

            // reflect mangler 2
            mangle = reversed.concat(candidate);
            comparator(mangle);
        }
    } 

    public static void comparator (String mangled) {

        // initiate the custom iterator
        passIterator = passList.listIterator();

        while(passIterator.hasNext()) {

            // extract the hashed password
            String password = passIterator.next();
            //extract the salt
            String salt = password.substring(0, 2);
            // make a hashed and salted version of each word in the dictionare 
            String compare = jcrypt.crypt(salt, mangled);

            // compare the hashed and salted dictionary word to the real password
            if(compare.equals(password)){
                System.out.println(mangled);                     
                passIterator.remove();
            }

        } 
    }
}