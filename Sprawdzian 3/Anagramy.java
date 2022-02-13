// Paulina Wojnarska

import java.util.*;

class Anagramy
{
	// Zamienia dwa chary miejscami
	static void swap(char[] str, int i, int j){
		char t = str[i];
		str[i] = str[j];
		str[j] = t;
	}

	// Odwraca stringa
	static void reverse(char str[], int l, int h){
		while (l < h) {
			swap(str, l, h);
			l++;
			h--;
		}
	}

	static int findCeil(char str[], char first, int l, int h){
		int ceilIndex = l;
		for (int i = l + 1; i <= h; i++)
			if (str[i] > first && str[i] < str[ceilIndex])
				ceilIndex = i;

		return ceilIndex;
	}

		// Funkcje mozna wywolac z flaga "wypisuj_liste" 
		// co spowoduje wypisanie listy anagramow az do napotkania podanego slowa

	static void sortedPermutations(String jakis_string, boolean wypisuj_liste){
        char str[] = jakis_string.toCharArray();
		int size = str.length;
        int index = 0;
		Arrays.sort(str);

		if (wypisuj_liste){
			System.out.println("POSORTOWANA LISTA ANAGRAMOW DO TEGO SLOWA TO: ");
		}

		boolean isFinished = false;
		while (!isFinished){
			index++;
			String aktualny_string = new String(str);

			if (wypisuj_liste){
				System.out.println(index + ". " + new String(aktualny_string));
			}

			if (jakis_string.equals(new String(aktualny_string))){
				isFinished = true;
				System.out.println("SLOWO '" + jakis_string +  "' JEST NUMEREM - " + index + " - NA LISCIE POSORTOWANYCH SLOW");
            }
			else{
				
				int i;
				for (i = size - 2; i >= 0; --i)
					if (str[i] < str[i + 1])
						break;

				if (i == -1)
					isFinished = true;
				else {
					int ceilIndex = findCeil(str, str[i], i + 1, size - 1);
					swap(str, i, ceilIndex);
					reverse(str, i + 1, size - 1);
				}
			}
		}
	}

	public static void main(String[] args){
		Scanner skanuj = new Scanner(System.in);
        System.out.println("WPISZ SLOWO");
        String slowo = skanuj.nextLine().toUpperCase();
        skanuj.close();
		
		int size = slowo.length();
        if (size < 2) {
			System.out.println("ZA KROTKIE SLOWO");
            System.exit(1);
        } else if (size == 2 && slowo.charAt(0) == slowo.charAt(1) ){
			System.out.println("SLOWO NIE MOZE SIE SKLADAC TYLKO Z TYCH SAMYCH LITER");
            System.exit(1);
        }
        else {
			System.out.println("PODANE SLOWO TO '" + slowo + "'");
			// Funkcje mozna wywolac z flaga "wypisuj_liste" 
			// co spowoduje wypisanie listy anagramow az do napotkania podanego slowa
			sortedPermutations(slowo, false);
        }
	}
}
