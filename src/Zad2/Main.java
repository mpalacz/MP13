package Zad2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashSet<String> listaPracownikow = new HashSet<String>();
        int bajt;
        String pracownik = "";

        try (FileInputStream fis = new FileInputStream("pracownicy.txt")) {
            do {
                bajt = fis.read();
                if (bajt == 13 || bajt == -1) {
                    if (!listaPracownikow.contains(pracownik))
                        listaPracownikow.add(pracownik);
                    pracownik = "";
                    fis.skip(1);
                } else if (bajt != -1) pracownik += (char) bajt;
            } while (bajt != -1);
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
            return;
        } catch (IOException e) {
            System.out.println("Błąd odczytu");
        }

        System.out.println("Rozmiar listy: " + listaPracownikow.size());
        System.out.println();

        System.out.println("Wydrukowanie zawartości listy za pomocą zwykłego for-a");
        for (int i = 0; i < listaPracownikow.size(); i++)
            System.out.println(listaPracownikow.toArray()[i]);
        System.out.println("\n");

        System.out.println("Wydrukowanie zawartości listy za pomocą for each");
        for (String element : listaPracownikow)
            System.out.println(element);
        System.out.println("\n");

        System.out.println("Wydrukowanie zawartości listy za pomocą interfacu Iterator");
        Iterator<String> iter = listaPracownikow.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
    }
}
