# Rekursion

![Video-Rekursion](../img/07-14-video-recursion.png)

Dieses Bild stellt dar, wie man in einem Video/einem Foto eine endlose Rekursion erkennt: man filmt/fotografiert den Bildschirm, der darstellt, was man gerade filmt/fotografiert... ;-)

## Wozu Rekursion?

Grundsätzlich sind alle Fälle iterativ lösbar, allerdings macht es manchmal Sinn den Weg über die Rekursion zu überlegen, weil z.B. der Quellcode dadurch deutlich lesbarer und kürzer wird. 

Aber Achtung! Es muss immer sichergestellt werden, dass kein StackOverflow (also so viele Rekursionen, dass der Speicher übergeht) kommt! Wie kommt es vor: Bei jedem Aufruf einer Methode wird u.a. für die Variablen bzw. die übergebenen Parameter Speicher reserviert. Bei der Rekursion ist es so, dass die aufrufende Methode bereits Speicher reserviert (Rekursion 0). Diese Methode ruft sich selbst auf (Rekursion 1). Also Rekursion 0 reserviert Speicher, solange diese nicht zum Ende der Methode kommt. Dies erfolgt nicht, weil Rekursion 0 darauf wartet, dass Rekursion 1 fertig ist. So benötigen wir den Speicher für Rekursion 0 und für Rekursion 1. Rekursion 1 ruft sich nochmals selbst auf (Rekursion 2). So läuft es weiter, bis die Endebedingung erfüllt ist. Allerdings kann es bei vielen Rekursionen dazu kommen, dass der Speicher zuerst voll ist, bevor die Endebedingung erfüllt ist. Hier spricht man von einem StackOverflow.   

Ein Paradebeispiel für die Rekursion ist das Durchlaufen eines Baumes. Ein weiteres Paradebeispiel sind die Sortieralgorithmen MergeSort und Quicksort.

Da die Rekursion darauf beruht, dass sich eine Methode selbst aufruft, würde dies zu einem endlosen Programm führen. Also liegt der Kern der Rekursion in der Abbruchbedingung! Diese muss gut überlegt sein, um sicherzustellen, dass das Programm aus der Rekursion herauskommt.

Würde das Programm nicht aus der Rekursion herauskommen, würde es zu einem Memory-Overflow kommen. Mittlerweile sichern sich Programmiersprachen ab, indem erkannt wird, ob man sich in einer endlosen Rekursion befindet und brechen das Programm mit einem Fehler ab.

Im Vergleich zu einer iterativen Schleife, verbraucht Rekursion immer mehr Speicher, weil die Variablen in der Methode bei jeder Rekursion neu instanziiert werden, aber nicht mehr freigegeben werden, solange die Rekursion nicht endet. In iterativen Schleifen werden die Variablen, die in der Schleife instanziiert werden, immer nach Ende der Iteration wieder freigegeben.

## Definition

Als Rekursion (lateinisch recurrere ‚zurücklaufen‘) wird ein prinzipiell unendlicher Vorgang, der sich selbst als Teil enthält oder mithilfe von sich selbst definierbar ist, bezeichnet.

Kurz gesagt ist eine Rekursion eine Funktion, die sich selbst aufruft und sich selbst immer wieder neu definiert.

Üblicherweise sind rekursive Vorgänge relativ kurz beschreibbar bzw. können durch eine relativ kurze Anweisung ausgelöst werden.

## Abbruchbedingung

Der wichtigste Teil der Rekursion ist die Abbruchbedingung. Ohne diese läuft das Programm unendlich, bis die virtuelle Maschine verhindert, dass der Speicher des Rechners voll wird.

Diese muss gut durchdacht sein, um sicherzugehen, dass sie immer eintritt!

## Rekursion als Lösungsstrategie

Rekursion ist auch eine Problemlösungsstrategie. Komplexe Sachverhalte können oft mit rekursiv formulierten Regeln sehr elegant und kurz gelöst werden.

Das Grundprinzip ist dabei dann das Zurückführen einer allgemeinen Aufgabe auf eine einfachere Aufgabe derselben Klasse. Teile-und-herrsche-Strategie (Divide and Conquer)

## Das “klassische” erste Beispiel für Rekursion

Die Fakultät (Faktorielle) ist in der Mathematik eine Funktion, die einer
natürlichen Zahl das Produkt aller natürlichen Zahlen (ohne Null) kleiner und
gleich dieser Zahl zuordnet.

![Fakultät in Zahlen](../img/07-16-factorial.png)

Diese Funktion ist von Natur aus rekursiv, warum?
Man kann die Fakultät von n berechnen, indem man zuerst die Fakultät von (n-1) berechnet. Daher bildet die Berechnung von (n-1)! ein Subproblem, das wir lösen müssen, um n zu berechnen! 

z.B. kann 
- 5! durch (4! * 5 ) gelöst werden.
- 4! kann wiederum durch (3! * 4 ) gelöst werden usw.
- dies kann fortgesetzt werden, bis wir bei 0! = 1 landen, was unser Basisfall ist und Abbruchbedingung. 

Die formale rekursive Definition lautet:

![Fakultät-Formel](../img/07-17-factorial-formula.png)

Programmiert schaut die Implementierung folgendermaßen aus:

```Java
// Java

// Methode zur Berechnung der Fakultät einer Zahl unter Verwendung von Rekursion
public static int factorial(int n) {
    // Basisfall: Fakultät von 0 oder 1 ist 1
    if (n == 0 || n == 1) {
        return 1;
    }
    // Rekursiver Fall: Fakultät von n ist n multipliziert mit Fakultät von (n-1)
    return n * factorial(n - 1);
}
```

```csharp
// C#

// Methode zur Berechnung der Fakultät einer Zahl unter Verwendung von Rekursion
public static int factorial(int n) {
    // Basisfall: Fakultät von 0 oder 1 ist 1
    if (n == 0 || n == 1) {
        return 1;
    }
    // Rekursiver Aufruf: Fakultät von n ist gleich n multipliziert mit Fakultät von (n-1)
    return n * factorial(n - 1);
}
```

## Call Stack

Um Rekursion zu verstehen, ist es wichtig sich bewusst zu machen, wie der Call Stack (Aufrufstapel) funktioniert.

Hier dient er dazu, den Speicherbereich für Funktionsaufrufe dynamisch zu verwalten. Dieser Speicherbereich kann anwachsen und wieder schrumpfen.

Der Compiler, der diesen Stack verwaltet, legt hier alle Daten ab, die er zur Verwaltung von Funktionsaufrufen benötigt.

Wenn eine Funktion aufgerufen wird, erweitert der Compiler den Stack um einen Datenblock(Stack-Frame). In diesem Datenblock werden die Parameter, die lokalen Variablen und die Rücksprungadresse zur aufrufenden Funktion angelegt. Der Datenblock bleibt so lange bestehen, bis diese Funktion wieder endet. Wird in ihm aber eine weitere Funktion aufgerufen, wird ein weiterer
Datenblock auf den aktuellen gepackt.

![Fakultät - Call Stack](../img/07-18-factorial-call-stack.png)

## Rekursiv oder Iterativ

Jede Aufgabe, die rekursiv gelöst werden kann, kann auch iterativ gelöst werden. Aber warum lernt  man dann die Rekursivität, wenn man alles iterativ lösen könnte?

```Java
// Java

public static int factorialIterative(int n) {
    int result = 1;
    if (n > 1) { 
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
    }
    return result;
}
```

```csharp
// C#

public static int factorialIterative(int n) {
    int result = 1;
    if (n > 1) { 
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
    }
    return result;
}
```

Wie man an der iterativen Lösung der Fakultät erkennen kann, schaut die rekursive Lösung viel einfacher aus und ist auch deutlich kürzer!

## Beispiele

### Beispiel mit der Fee

Angenommen wir treffen auf einem Spaziergang im Wald eine Fee. Wir haben
das Glück des Lebens getroffen, denn wir haben drei Wünsche frei. Was
würden wir uns wünschen?
![Waldfee und Baum](img/07-15-fairy.png)
Hier kennen wir einen Trick, sicher schon vom Kindergarten :)
Wir wünschen uns beim dritten Wunsch einfach nochmal unsere drei
Wünsche. Angenommen wir wünschen uns zuerst mal einen Ferrari und eine
Luxusvilla, weil wir so bescheiden sind. Wichtigere Angelegenheiten wie etwa
Weltfrieden, können wir uns ja alles noch wünschen, da wir ja mehr als genug
Wünsche zur Verfügung haben ;)
Wenn man dieses Beispiel programmiert, würde es wie folgt aussehen:
```Java
// Java
public static void fulfillThreeWishes() {
    System.out.println(getFerrari());
    System.out.println(getLuxuryVilla());
    fulfillThreeWishes();
}
public static String getFerrari() {
    return "Ferrari";
}
public static String getLuxuryVilla() {
    return "Luxury Villa";
}
```

```csharp
// C#
public static void fulfillThreeWishes() {
    Console.WriteLine(getFerrari());
    Console.WriteLine(getLuxuryVilla());
    fulfillThreeWishes();
}
public static String getFerrari() {
    return "Ferrari";
}
public static String getLuxuryVilla() {
    return "Luxury Villa";
}
```
Welches Problem besteht hier?

Die Methode `fulfillThreeWishes()` ruft sich selbst auf, also endet das Programm nie (bzw. erst wenn der Fehler Stack-Overflow ausgeworfen wird, da es unweigerlich zu einem Speicherüberlauf kommen wird).

Wir wollen versuchen, die Wünsche auf 3 zu begrenzen, d.h. “wieder drei Wünsche” kann man höchstens nur 2 mal wünschen. Im Code machen wir nun folgendes:
- wir geben der wish Methode einen Zähler als Parameter mit
- dieser wird beim nochmaligen Methodenaufruf heruntergezählt
- wenn der Zähler 0 erreicht, wird die Methode beendet

```Java
// Java

public static void main(String[] args) {
    wish(3);
}

static void wish(int n) {
    if (n <= 0) {
        System.out.println("Sorry,you have no more wishes");
        return;
    }
    
    if (n % 2 == 0) {
        System.out.println(getFerrari());
    } else {
        System.out.println(getLuxuryVilla());
    }
    
    wish(n - 1);
}

static String getFerrari() { return "Ferrari"; }
static String getLuxuryVilla() { return "Luxury Villa"; }
```

```csharp
// C#

public static void main(String[] args) {
    wish(3);
}

static void wish(int n) {
    if (n <= 0) {
        Console.WriteLine("Sorry,you have no more wishes");
        return;
    }
    
    if (n % 2 == 0) {
        Console.WriteLine(getFerrari());
    } else {
        Console.WriteLine(getLuxuryVilla());
    }
    
    wish(n - 1);
}

static string getFerrari() { return "Ferrari"; }
static string getLuxuryVilla() { return "Luxury Villa"; }
```

## Fibonacci-Folge

Die Fibonacci-Folge ist ein anderer Klassiker für die Rekursion. Sie ist eine
unendliche Folge von Zahlen, bei der sich die jeweils folgende Zahl durch
Addition ihrer beiden vorherigen Zahlen ergibt:

![Fibonacci-Folge](../img/07-19-fibonacci.png)

Implementiert sieht die Fibonacci-Folge wie folgt aus:

```Java
// Java

static int fibonacci(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

```csharp
// C#

static int fibonacci(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

## Summe aller Elemente eines Arrays berechnen

```Java
// Java

public static int sumArray(int[] array, int index) {
    if (index < 0) {
        return 0;
    }
    return array[index] + sumArray(array, index - 1);
}
```

```csharp
// C#

public static int sumArray(int[] array, int index) {
    if (index < 0) {
        return 0;
    }
    return array[index] + sumArray(array, index - 1);
}
```

Am besten zeichnest du den Rekursionsbaum und den Callstack, um besser zu verstehen, was dieses Programm genau macht.

Zurück zur [Startseite](../README.md)
