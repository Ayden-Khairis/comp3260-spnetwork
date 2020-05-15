import java.util.*;
import java.io.*;

public class Main{
   
    public static void main(String[] args){

        //Get Start Time
        long startTime = System.currentTimeMillis();

        System.out.println("\nPlain Text: " + args[0] + "\nKey: " + args[1]);
        SPCipher cipher = new SPCipher(args[0], args[1]);
        
        System.out.println("\nCipher Text: " + cipher.getEncrypted());

        //Output compute Time
        System.out.println("Total time to compute: " + (System.currentTimeMillis() - startTime));
    }

}
