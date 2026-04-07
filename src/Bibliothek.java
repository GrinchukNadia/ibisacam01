import java.util.HashMap;
import java.util.HashSet;

public class Bibliothek {
    static HashMap<String, HashSet<String>> library = new HashMap<>();

    static void main() {
        addAuthor("Franz Kafka", "Die Verwandlung");
        addAuthor("Franz Kafka", "Der Prozess");
        addAuthor("Franz Kafka", "Das Schloss");

        addAuthor("Johann Wolfgang von Goethe", "Faust I");
        addAuthor("Johann Wolfgang von Goethe", "Die Leiden des jungen Werthers");

        addAuthor("Ingeborg Bachmann", "Malina");

        addAuthor("Elfriede Jelinek", "Die Klavierspielerin");


//        printAuthorsBooks("Franz Kafka");
//        printAllAuthors();
//        printAll();
//        deleteAuthor("Friedrich Schiller");

        printAll();
        System.out.println();
        findAuthor("Faust I");
    }

    public static void addAuthor(String author, String title) {
        if (!library.containsKey(author)) {
            HashSet<String> titles = new HashSet<>();
            titles.add(title);
            library.put(author, titles);
        } else {
            HashSet<String> titles = library.get(author);
            titles.add(title);
        }
    }

    public static void deleteAuthor(String author) {
        library.remove(author);
    }

    //Liste alle Titeln, welche in der Bibliothek verfügbar sind, inkl.
    // Autor im Format: 'Die Verwandlung' von 'Franz Kafka'
    public static void printAll() {
        System.out.println();
        for (String author : library.keySet()) {
            for (String title : library.get(author)) {
                System.out.printf("'%s' von '%s'\n", title, author);
            }
        }
    }

    //Liste aller Bücher eines bestimmten Autors ausgeben
    public static void printAuthorsBooks(String author) {
        HashSet<String> allBooks = library.get(author);
        for (String b : allBooks) System.out.println(b);
    }

    //Suche den Autor eines bestimmten Titels
    public static void findAuthor(String book) {
        for (String author : library.keySet()) {
            if (author.contains(book)) System.out.println(author);
        }
    }

    //Liste aller Autoren ausgeben
    public static void printAllAuthors() {
        for (String key : library.keySet()) {
            System.out.println(key);
        }
    }
}
