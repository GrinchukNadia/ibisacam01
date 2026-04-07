# Sortieralgorithmen

Sortieralgorithmen sind Algorithmen, die verwendet werden, um eine Liste von Elementen in einer bestimmten Reihenfolge zu ordnen. Es gibt verschiedene Sortieralgorithmen, die jeweils unterschiedliche Vor- und Nachteile haben. Hier sind Erklärungen zu einigen häufig verwendeten Sortieralgorithmen in Java und C#:

Folgende sind die bekanntesten:
- Selection Sort
- Insertion Sort
- Bubble Sort
- Merge Sort
- Quick Sort

## Selection Sort

Selection Sort ist ein einfacher Sortieralgorithmus, der wiederholt das kleinste Element in der Liste auswählt und an die erste unsortierte Position platziert. Er hat eine Zeitkomplexität von O(n^2) und eignet sich gut für kleine Listen oder wenn zusätzlicher Speicherplatz knapp ist.
Zu Beginn ist das gesamte Array unsortiert.

![Selection Sort - Beispiel 1](../img/07-03-Selection-Sort-1.png)

![Selection Sort - Beispiel 2](../img/07-04-Selection-Sort-2.png)

### Verwendungszwecke:

* Wenn eine einfache Implementierung gewünscht wird.
* Wenn die Liste klein ist oder der Speicher begrenzt ist.
* Wenn man sich um die Anzahl der Tauschoperationen nicht kümmert, da Selection Sort immer die gleiche Anzahl von Tauschoperationen benötigt, unabhängig von der Eingabe.


## Insertion Sort

Insertion Sort ist ein einfacher Sortieralgorithmus, der das Einfügen von Elementen in die sortierte Teilmenge eines Arrays oder einer Liste durchläuft. Er hat eine Zeitkomplexität von O(n^2), aber in der Praxis ist er effizienter als Selection Sort und Bubble Sort für kleine Listen.
Zu Beginn ist das gesamte Array unsortiert.

![Insertion Sort - Beispiel 1](../img/07-05-Insertion-Sort-1.png)

![Insertion Sort - Beispiel 2](../img/07-06-Insertion-Sort-2.png)

### Verwendungszwecke:

* Wenn die Liste bereits teilweise sortiert ist oder nur wenige Elemente unsortiert sind.
* Wenn zusätzlicher Speicherplatz knapp ist, da Insertion Sort im Ort arbeitet.
* Wenn Stabilität wichtig ist, da Insertion Sort stabiler ist als Selection Sort.

## Bubble Sort

Bubble Sort ist ein einfacher Sortieralgorithmus, der benachbarte Elemente vergleicht und sie vertauscht, wenn sie in der falschen Reihenfolge sind. Er hat eine Zeitkomplexität von O(n^2) und ist weniger effizient als Insertion Sort und Selection Sort.

![Bubble Sort - Beispiel 1](../img/07-07-Bubble-Sort-1.png)

![Bubble Sort - Beispiel 2](../img/07-08-Bubble-Sort-2.png)

![Bubble Sort - Beispiel 3](../img/07-09-Bubble-Sort-3.png)

![Bubble Sort - Beispiel 4](../img/07-10-Bubble-Sort-4.png)

![Bubble Sort - Beispiel 5](../img/07-11-Bubble-Sort-5.png)

### Verwendungszwecke:

* Wenn eine einfache Implementierung erforderlich ist und die Liste bereits fast sortiert ist (in diesem Fall ist Bubble Sort schnell).
* Wenn man sich nicht um die Effizienz kümmert und die Liste sehr klein ist.

## Merge Sort

Merge Sort ist ein effizienter, stabiler Sortieralgorithmus, der auf dem Prinzip **"Teile und herrsche"** basiert. Er teilt die Liste in kleinere Teile, sortiert sie rekursiv und fusioniert dann die sortierten Teile zurück. Er hat eine Zeitkomplexität von O(n log n) und ist effizient für große Listen.

![Merge Sort - Beispiel 1](../img/07-12-Merge-Sort-1.png)

![Merge Sort - Beispiel 2](../img/07-13-Merge-Sort-2.png)

### Verwendungszwecke:

* Wenn eine effiziente Sortierung für große Listen benötigt wird.
* Wenn Stabilität wichtig ist, da Merge Sort stabil ist.
* Wenn zusätzlicher Speicherplatz kein Problem ist, da Merge Sort zusätzlichen Speicherplatz benötigt.

## Quick Sort

Quick Sort ist ein effizienter, instabiler Sortieralgorithmus, der auf dem Prinzip "Teile und herrsche" basiert. Er wählt ein Pivot-Element aus der Liste aus, teilt die Liste in Elemente kleiner als das Pivot-Element und Elemente größer als das Pivot-Element auf und sortiert dann rekursiv die beiden Teillisten. Er hat eine durchschnittliche Zeitkomplexität von O(n log n) und ist in der Praxis einer der schnellsten Sortieralgorithmen.

## animierte Visualisierung von Sortieralgorithmen 

[animierter Vergleich von Sortieralgorithmen](https://www.toptal.com/developers/sorting-algorithms)

### Verwendungszwecke:

* Wenn eine schnelle Sortierung für große Listen benötigt wird.
* Wenn zusätzlicher Speicherplatz kein Problem ist, da Quick Sort im Ort arbeitet.
* Wenn man sich nicht um Stabilität kümmert, da Quick Sort instabil ist.


Zurück zur [Startseite](../README.md)
