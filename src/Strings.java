import java.util.ArrayList;

public class Strings {
    static void main() {
        //Länge und Zeichen
        String s = "Banane";
        System.out.printf("Länge: %d\n", s.length());
        System.out.printf("Erster Buchstabe: %s\n", s.charAt(0));
        System.out.printf("Letzter Buchstabe: %s\n", s.charAt(s.length() - 1));

        //Wörter zählen
        String t = "Java ist eine tolle Sprache";
        String[] tArray = t.split(" ");
        System.out.printf("Text: %s\n", t);
        System.out.printf("Ausgabe: %d Wörter\n", tArray.length);

        //Zeichen ersetzen:
        String t1 = "Java ist toll";
        System.out.printf("Eingabe: %s\n", t1);
        System.out.printf("Ausgabe: %s\n", t1.replace(" ", "-"));

        //Vokale zählen
        String t2 = "Hallo Welt";
        ArrayList<Character> vowels = new ArrayList<>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
        int sumVowels = 0;
        for (int i = 0; i < t2.length(); i++) {
            if (vowels.contains(t2.charAt(i))) sumVowels++;
        }
        System.out.printf("Eingabe: %s\n", t2);
        System.out.printf("Ausgabe: %d Vokale\n", sumVowels);

        //Erstes und letztes Vorkommen
        String t3 = "Programmieren";
        int first = t3.indexOf('r');
        int second = 0;
        for (int i = first + 1; i < t3.length(); i++) {
            if (t3.indexOf('r', i) >= 0) second = t3.indexOf('r', i);
        }
        System.out.printf("Erstes Vorkommen: %d\n", first);
        System.out.printf("Letztes Vorkommen: %d\n", second);

        //Text verkehrt
        String t4 = "Hallo";
        System.out.printf("%s ==> %s\n", t4, reverse(t4));

        //Wörter im Satz umdrehen
        String t5 = "Java macht Spaß";
        System.out.printf("Eingabe: %s\n", t5);
        System.out.printf("Ausgabe: %s\n", reverse(t5));

        //Palindrom prüfen
        String w1 = "Anna";
        String w2 = "Lagerregal";
        String w3 = "Java";
        System.out.printf("%s → %s\n", w1, isPalindrome(w1) ? "Palindrom" : "kein Palindrom");
        System.out.printf("%s → %s\n", w2, isPalindrome(w2) ? "Palindrom" : "kein Palindrom");
        System.out.printf("%s → %s\n", w3, isPalindrome(w3) ? "Palindrom" : "kein Palindrom");

        //Pangramm
//        String p1 = "Quick nymph bugs vex fjord waltz.";
        String p1 = "Jeder wackere Bayer vertilgt bequem zwo Pfund Kalbshaxen.";
        String p2 = "The quick brown fox jumps over the lazy dog.";
        System.out.printf("%s\n%s\n",p1, isPangram(p1));
        System.out.printf("%s\n%s\n",p2, isPangram(p2));
    }

    public static String reverse(String s) {
        StringBuilder converse = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            for (int j = word.length() - 1; j >= 0; j--) {
                converse.append(word.charAt(j));
            }
            converse.append(" ");
        }
        return converse.toString().trim();
    }

    public static boolean isPalindrome(String s) {
        String reverted = reverse(s);
        return s.equalsIgnoreCase(reverted);
    }

    public static boolean isPangram(String s) {
        for (int i = 'a'; i <= (int) 'z'; i++) {
            if(!s.toLowerCase().contains(String.valueOf((char) i))) return false;
        }
        return true;
    }
}
