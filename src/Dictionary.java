import java.util.HashMap;

public class Dictionary {
    static HashMap<String, String> enDe = new HashMap<>();
    static HashMap<String, String> deEn = new HashMap<>();

    public static void main() {
        addWord("dog", "Hund");
        addWord("cat", "Katze");

        translate("dog");
        translate("Katze");

        delete("cat");

        translate("Katze");
        translate("Vogel");
        delete("Vogel");
    }

    public static void addWord(String word, String translation) {
        enDe.put(word, translation);
        deEn.put(translation, word);
    }

    public static void delete(String word) {
        if (enDe.containsKey(word)) {
            String keyW = enDe.remove(word);
            deEn.remove(keyW);
        } else if (deEn.containsKey(word)) {
            String keyW = deEn.remove(word);
            enDe.remove(keyW);
        } else {
            System.out.println("word not found");
        }
    }

//    вернуть строку
    public static void translate(String word) {
        if (enDe.containsKey(word)) {
            System.out.println(enDe.get(word));
        } else if (deEn.containsKey(word)) {
            System.out.println(deEn.get(word));
        } else {
            System.out.println("word not found");
        }
    }
}
