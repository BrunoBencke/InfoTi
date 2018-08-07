package apoio;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;
/**
 *
 * @author Bruno Bencke
 */
public class Criptografia {

    public String criptografa(String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(senha.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(digest.digest());
        } catch (NoSuchAlgorithmException ns) {
            ns.printStackTrace();
        }
        return senha;
    }

    public String descriptografa(String senha) {
        String s = criptografa(senha);
        return s;
    }
}
