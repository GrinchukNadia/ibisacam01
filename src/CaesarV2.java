public class CaesarV2 {
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
        int amountLetters = 26;

        StringBuilder password = new StringBuilder();
        for (int i = 0; password.length() < text.length(); i++) {
            if (pass.length() == i) i = 0;
            password.append(pass.charAt(i));
        }

        if (encrypt) {
            StringBuilder encrypted = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                char countedChar = (char) ((text.charAt(i) + password.charAt(i)) % 26 + 'A');
                encrypted.append(countedChar);
            }
            return encrypted.toString();
        } else {
            StringBuilder decrypted = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                char countedChar;
                if ((text.charAt(i) - password.charAt(i)) < 0) {
                    countedChar = (char) ('[' - (password.charAt(i) - text.charAt(i)));

                } else {
                    countedChar = (char) ((text.charAt(i) - password.charAt(i)) % 26 + 'A');
                }
                decrypted.append(countedChar);
            }
            return decrypted.toString();
        }
    }
}
