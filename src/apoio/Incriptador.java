/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Christian
 */
public class Incriptador {

    public static void main(String[] args) {

        try {
            String text = "10122018";
            //String text = "21122018";
            // String key = "Bar12345Bar12345"; // 128 bit key
            String key = "ABCDEFGH12345678";

            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");

            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());

            //System.out.println(new String(encrypted));
            System.out.println(encrypted);

            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(encrypted));

            System.err.println(decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
