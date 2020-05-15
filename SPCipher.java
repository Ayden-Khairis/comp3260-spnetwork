import java.math.BigInteger;
import java.util.*;

public class SPCipher{
    private String plainText;
    private String bString = "";
    private String bKey = "";
    private char [] bytes, keyBytes;
    Map<Character,String> hm = new HashMap<Character,String>();

    /*
    *param: plain data and key data
    *output: binary values for data & key as char arrays
    */
    public SPCipher(String plain, String key){

        //Initialising the hash map look up table for hex to binary conversion
        initHM();

        //Hex -> Binary conversion
        try{
            bString = HexToBin(plain.toCharArray());
            bKey = HexToBin(key.toCharArray());
        }catch(Exception e){}

        //Pretty Self Explanitory
        System.out.println("\nPlain Text Converted to binary: " + bString + " | Length: " + bString.length());
        System.out.println("Key Converted to binary: " + bKey + " | Length: " + bKey.length());

        //making sure spec is met
        if(bString.length() != 128){
            System.out.println("Length of input is not valid, please enter a hex string of length 32");
            System.exit(0);
        }
        if(bString.length() != bKey.length()){
            System.out.println("Length of KEY is not valid, please enter a hex string of length 32");
            System.exit(0);
        }

        //Takes binary strings and makes arrays for encryption
        bytes = bString.toCharArray();
        keyBytes = bKey.toCharArray();

        //Lets run this shit
        startEncrypt();
    }
    
    /*
    *param: all variables meet spec
    *output: when finished, encryption is completed
    */
    public void startEncrypt(){

        int rounds = 16;

        for(int i = 0; i < rounds; i ++){
            char[] roundkey = generateRoundKey(keyBytes, i, rounds);
        }

    }

    /*
    *param: null
    *output: Encrypted data
    */
    public String getEncrypted(){
        return "";
    }

    /*
    *param: char array of hex
    *output: String of binary representation from input
    */
    private String HexToBin(char hexdec[]) 
    { 
        String full = "";      

        //just runs through each char
        for(int i = 0; i < hexdec.length; i++){
            full += hm.get(hexdec[i]);
        } 
            return full;
    } 

    /*
    *param: takes given key & round number
    *output: returns the round key for the given round
    */
    private char[] generateRoundKey(char[] key, int roundNum, int rounds){
        

        return null;
    }

    /*
    *param: null
    *output: loads hashmap with values for hex to binary converstion 
    */
    private void initHM(){
        hm.put('0', "0000"); 
        hm.put('1', "0001");
        hm.put('2', "0010");
        hm.put('3', "0011");
        hm.put('4', "0100");
        hm.put('5', "0101");
        hm.put('6', "0110");
        hm.put('7', "0111");
        hm.put('8', "1000");
        hm.put('9', "1001");
        hm.put('A', "1010");
        hm.put('B', "1011");
        hm.put('C', "1100");
        hm.put('D', "1101");
        hm.put('E', "1110");
        hm.put('F', "1111");
    }
}
