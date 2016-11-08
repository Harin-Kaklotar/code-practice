import java.util.Base64;

/**
 * Created by liju on 11/7/16.
 */
public class Base64Example {

    public static void main(String[] args) {
        String sampleText  = "This is a sample text";
        final byte[] encodedBytes = Base64.getEncoder().encode(sampleText.getBytes());
        final byte[] decode = Base64.getDecoder().decode(encodedBytes);
        System.out.println("encoded bytes : "+new String(encodedBytes));
        System.out.println("decoded bytes : "+new String(decode));
    }
}
