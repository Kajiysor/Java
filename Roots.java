public class Roots {
    public static final double precision = 1.0e-5;

    static double pow(double a, double b) {
        if(b == 0) {
            return 1;
        }
        return a * pow(a, b-1);
    }

    public static double calculateSquareRoot(double x, double n){
        
        double guess = 1.0;
        do{
            /*guess = (guess + x/guess)/2.0;*/
            guess = (1/n)*((n-1)*guess + x / pow(guess, n-1));
            /*guess = guess1;*/
        }while( (pow(guess, n)/x < 1.0-precision) || (pow(guess, n)/x> 1.0+precision));
        return guess;
    }

    public static void main(String[] args){
        if (args.length<1)
            System.out.println("Brak argumentu");
        else
            System.out.println(calculateSquareRoot(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
    }
}