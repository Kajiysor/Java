public class MyFunction extends AbstractFunction {
    @Override
    double f(double x){
        return Math.sin(x);
    }

    public static void main(String[] args) {
        MyFunction f = new MyFunction();
        AbstractFunction.precision=1.0e-10;
        System.out.println(f.getRootBisection(1, 4));
        
    }
    
}
