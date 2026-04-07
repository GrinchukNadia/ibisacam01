# Arrays

## Grundsätzliches

Mit den bisherigen Datentypen, die wir kennen, können wir lediglich einzelne Werte in Variablen speichern: Sei es ein Geburtsdatum oder ein Name...

Oft ist es aber notwendig, sich mehrere Werte zu merken: zB eine Bestenliste bei einem Rennen...

Will man also mehrere Datensätze eines bestimmten Datentyps speichern, braucht man eine sogenannte Collection. Eine Collection ist ein Behälter für eine Ansammlung von Daten desselben Datentyps.

Es gibt mehrere Arten von Collections. In diesem Kapitel stellen wir Arrays vor.

## Die wichtigsten Eigenschaften eines Arrays

* **Fixe Länge**, die bei der Initialisierung definiert wird
* Der Zugriff auf Elemente erfolgt anhand eines Index (Position im Array), so ist die **Reihenfolge der Elemente wichtig**
* Das **erste Element** befindet sich immer an der **Position 0** (Index == 0)

![Array und Indices](../img/07-01-Array-Indices.png)

## Arrays Java / C#

**Array** ist ein Datentyp, der verwendet wird, um mehrere Elemente des gleichen Datentyps zu speichern. Sie bieten eine praktische Möglichkeit, Daten zu organisieren und zu verwalten. Hier sind Erklärungen zu Arrays in Java und C# mit anschaulichen Codebeispielen:

### Array deklarieren

In höheren Programmiersprachen kann ein Array auf folgende Art und Weisen deklariert werden:

#### Ein Array aus ganzen Zahlen mit Länge 8

```java
// Java

int[] intArray = new int[8];
```

```csharp
// C# 

int[] intArray = new int[8];
```

#### Ein Array aus Strings mit 3 Elementen: "Hello", "World" und "!"

```java
// Java

String[] stringArray = {"Hello", "World", "!"};
```

```csharp
// C# 

string[] stringArray = ["Hello", "World", "!"];
```

### Zugriff auf ein Element

Um nun auf ein Element des Arrays zuzugreifen wird der Index verwendet. Wie oben angeführt ist das erste Element an der Position 0. Das Element mit dem Index 3 erhalte ich mit folgender Zeile:

```java
// Java
public class Main {
    public static void main(String[] args) {

        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(intArray[3]); // Hier wird die Zahl mit dem Index 3 ausgegeben. 
        // ACHTUNG! In einem Array ist das erste Element am Index 0!!!, also wird hier die Zahl 4 ausgegeben!
    }
}
```

```csharp
// C# 

int[] intArray = [1,2,3,4,5,6,7,8];
Console.WriteLine(intArray[3]);
```

ACHTUNG! Wenn man einen Zugriff mit einem Index größer oder gleich der Größe des Arrays versucht wird ein Fehler, eine sogenannte Exception, ausgeworfen, da man versucht, auf ein Element zuzugreifen, das nicht im Array zu finden ist.

![Array Out of Bound](../img/07-02-Array-OutOfBound.png)

### Wert eines Elements ändern

Verändern kann man den Wert auf dieselbe Weise:

```Java
// Java
public class Main {
    public static void main(String[] args) {

        int[] intArray = new int[8];
        // Der Index des ersten Elements ist immer 0!
        intArray[0] = 4; // Der Wert des Elements an der Position 0 wird auf 4 gesetzt.
        System.out.println(intArray[0]);
    }
}
```

```csharp
// C# 

int[] intArray = new int[8];
// Der Index des ersten Elements ist immer 0!
intArray[0] = 4; // Der Wert des Elements an der Position 0 wird auf 4 gesetzt.
Console.WriteLine(intArray[0]);
```

## Mehrdimensionale Arrays

Ein `String[]` ist auch ein Datentyp genauso wie String und int. Man kann also ein Array von `String[]` erstellen, um zum Beispiel eine zweidimensionale Tabelle abzubilden.

**Beispiele**:

```Java
// Java
String[][] twoDimensionalArray = new String[3][5];
```

```csharp
// C#
string[,] twoDimensionalArray = new string[3,5];
```

Ein 2-dimensionales Array kann zur Speicherung eines Spielfeldes eingesetzt werden. 

z.B.: Speichere ein 3x3 Feld aus Zahlen und gib dieses auf der Konsole aus.

```Java
// Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] field = new int[3][3]; // init 3x3 field
        Scanner scanner = new Scanner(System.in);

        // iterate through rows
        for (int i = 0; i < field.length; i++) {
            // iterate through columns
            for (int j = 0; j < field[i].length; j++) {
                System.out.println("Geben Sie bitte eine Zahl ein:");
                field[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }

        // Inhalt des Arrays ausgeben
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                // print current cell
                System.out.print(" " + field[i][j]);
            }
            System.out.println(); // line break
        }

        scanner.close();
    }
}
```

```csharp
// C# 

int[,] field = new int[3,3];
for (int i = 0; i <field.GetLength(0);i++){
    for (int j = 0; j < field.GetLength(1); j++){
        Console.WriteLine("Geben Sie bitte eine Zahl ein:");
        field[i, j] = int.Parse(Console.ReadLine());
    }
}
// Inhalt des Arrays ausgeben
for (int i = 0; i <field.GetLength(0);i++){
    for (int j = 0; j < field.GetLength(1); j++){
        Console.Write(" " + field[i,j])
    }
    Console.WriteLine();
}
```

Zurück zur [Startseite](../README.md)
