public class Absolute extends AbstractFunction {
    @Override
    double f(double x){
        return (Math.abs(x)-3);
    }

    public static void main(String[] args) {
        Absolute f = new Absolute();
        AbstractFunction.precision=1.0e-6;
        AbstractFunction.increment=1.0e-7;
        AbstractFunction.epsilon=1.0e-6;
        System.out.println(f.getRootBisection(-1, 3));
        System.out.println(f.definite_integral(3, 7));
        System.out.println(f.golden_ratio_min(-5, 5));
        
    }
    
}
