//Paulina Wojnarska
import java.util.*;
import java.util.Scanner;


public class Anagram {
    static ArrayList<String> ar = new ArrayList<String>();
    public static void main(String[] args) {
        Scanner skanuj = new Scanner(System.in);
        System.out.println("WPISZ SŁOWO");
        String str = skanuj.nextLine();
        skanuj.close();
        int size = str.length();
        if (size < 2) {
            System.out.println("ZA KRÓTKIE SŁOWO");
            System.exit(1);
        } else if (size == 2 && str.charAt(0) == str.charAt(1) ){
            System.out.println("LITERY NIE MOGĄ SIĘ POWTARZAĆ");
            System.exit(1);
        }
        else {
            System.out.println("PODANE SŁOWO TO " + str);
            System.out.println("POSORTOWANA LISTA ANAGRAMÓW TEGO SŁOWA TO: ");
            Anagram a = new Anagram();
            a.anagm(str, 0, size - 1);
            Collections.sort(ar);
            System.out.println(ar);
            System.out.println("Numer na liście zaczynającej się od 1 słowa " + str + " : "+ (ar.indexOf(str)+1));
        }
    }

    public void anagm(String str, int start, int end)
    {

        if (start == end) {
            if(!(ar.contains(str))) {
                ar.add(str);
            }
        }
        else {
            for (int i = start; i <= end; i++) {
                str = swap(str, start, i);
                anagm(str, start + 1, end);
                str = swap(str, start, i);
            }
        }

    }

    public String swap(String a, int i, int j)
    {
        char temp;
        char[]charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}


