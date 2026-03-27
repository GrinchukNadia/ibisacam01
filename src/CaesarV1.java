public class CaesarV1 {
    public static void main(String[] args) {
        String example = "HALLO XY";
        System.out.println(normalize(example));

        String encrypted1 = encrypt(example, 3);
        String encrypted2 = encrypt(example, 4);
        System.out.println(encrypted1);
        System.out.println(encrypted2);
        System.out.println(decrypt(encrypted1, 3));
        System.out.println(decrypt(encrypted2, 4));
    }

    static String normalize(String text) {
        StringBuilder edited = new StringBuilder();

//        char[] exampleChar = text.toUpperCase().toCharArray();
//        for (char c : exampleChar) {
//            if (c >= 'A' && c <= 'Z') edited.append(c);
//        }

        text = text.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') edited.append(text.charAt(i));
        }
        return edited.toString();
    }

    static String encrypt(String text, int key) {
        //  'A' 65 - 90 'Z'
        StringBuilder encrypted = new StringBuilder();
        String edited = normalize(text);
        int amountLetters = 26;

        for (int i = 0; i < edited.length(); i++) {
            int charCode = edited.charAt(i);
            int shiftedValue = key < 0 ? charCode + 'A' + key : charCode - 'A' + key;
            int resultCharCode = (shiftedValue % amountLetters) + 'A';
            encrypted.append((char) resultCharCode);
        }
        return encrypted.toString();
    }

    static String decrypt(String text, int key) {
        return encrypt(text, -key);
    }
}
