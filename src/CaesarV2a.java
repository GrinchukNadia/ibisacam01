import java.util.Arrays;

public class CaesarV2a {
    public static void main(String[] args) {
        String example = "HELLOXWORLDXUNDXHELLOXNADIAX";
        String pasword = "IBIS";

        System.out.printf("Text: %s.\n", example);
        String encrypted = crypt(example, pasword, true);
        System.out.println(encrypted);
        String decrypted = crypt(encrypted, pasword, false);
        System.out.println(decrypted);
    }

    static String crypt(String text, String pass, boolean encrypt) {
        //  'A' 65 - 90 'Z'

        int[] keys = new int[pass.length()];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = pass.charAt(i) - 'A';
        }
        System.out.println(Arrays.toString(keys));

        StringBuilder encrypted = new StringBuilder();

        for (int i = 0, k = 0; i < text.length(); i++, k++) {
            if (k == keys.length) k = 0;
            int key = encrypt ? keys[k] : -keys[k];
            char c = (char) (text.charAt(i) + key);
            if (c > 'Z') c -= 26;
            else if (c < 'A') c += 26;
            encrypted.append(c);
        }
        return encrypted.toString();
    }
}
