public class Roots {
    public static final double precision = 1.0e-5;

    /* Metoda, która podnosi liczbę do danej potęgi za pomocą rekurencji */
    static double pow(double a, double b) {
        if(b == 0) {
            return 1;
        }
        return a * pow(a, b-1);
    }

    public static double calculateSquareRoot(double x, double n){
        
        double guess = 1.0;
        do{
            /* Metoda Newtona na wyliczenie pierwiastka n-tego stopnia */
            guess = (1/n)*((n-1)*guess + x / pow(guess, n-1));
        }   /* Sprawdzenie czy wynik mieści się w naszym przedziale precyzji */
        while( (pow(guess, n)/x < 1.0-precision) || (pow(guess, n)/x> 1.0+precision));
        return guess;
    }

    public static void main(String[] args){
        if (args.length<2)
            System.out.println("Brak odpowiedniej ilosci argumentow");
        else
            System.out.println(calculateSquareRoot(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
    }
}