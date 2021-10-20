public abstract class AbstractFunction {

    public static double precision = 1.0e-5;
    abstract double f(double x);

    double getRootBisection(double xmin, double xmax){
        double fmin = f(xmin);
        double fmax = f(xmax);
        if (fmin*fmax > 0){
            System.out.println("wrong data");
            return 0;
        }
        if (fmin == 0){
            return xmin;
        }
        if (fmax ==0 ){
            return xmax;
        }
        while (Math.abs(xmax-xmin) > precision){
            double xmid = 0.5*(xmax+xmin);
            double fmid = f(xmid);
            if (fmin*fmid < 0){
                xmax = xmid;
                fmax = fmid;
            } else if (fmin*fmid > 0){
                xmin = xmid;
                fmin = fmid;
            }
            else {
                return xmid;
            }
        }
        return (0.5*(xmax+xmin));
    }
    
}
