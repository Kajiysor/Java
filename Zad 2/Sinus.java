public class Sinus extends AbstractFunction {
    @Override
    double f(double x){
        return (Math.sin(x));
    }

    public static void main(String[] args) {
        Sinus f = new Sinus();
        AbstractFunction.precision=1.0e-5;
        System.out.println(f.getRootBisection(1, 4));
        System.out.println(f.definite_integral(0, 2));
        System.out.println(f.golden_ratio_min(Math.PI, 2*Math.PI));
        
    }
    
}
