package com.testing;
import java.security.*;
import javax.crypto.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "\n" + "This app will encrypt this string and push it to console!" + "\n" );

        Logger logger = LogManager.getRootLogger();
    	logger.trace("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));

        Signature sign = Signature.getInstance("SHA256withRSA");
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(4096);

        KeyPair pair = keyPairGen.generateKeyPair();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

        byte[] input = "This app will encrypt this string and push it to console!".getBytes();
        cipher.update(input);

        byte[] cipherText = cipher.doFinal();
        System.out.println(new String(cipherText, "UTF8"));


    }
}
