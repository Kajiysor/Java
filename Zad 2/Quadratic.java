public class Quadratic extends AbstractFunction {
    @Override
    double f(double x){
        return (Math.pow(x, 2) - 1);
    }

    public static void main(String[] args) {
        Quadratic f = new Quadratic();
        AbstractFunction.precision=1.0e-4;
        AbstractFunction.increment=1.0e-6;
        AbstractFunction.epsilon=1.0e-4;
        System.out.println(f.getRootBisection(0, 4));
        System.out.println(f.definite_integral(-2, 2));
        System.out.println(f.golden_ratio_min(-2, 2));
        
    }
    
}
