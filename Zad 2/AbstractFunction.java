public abstract class AbstractFunction {

    public static double precision = 1.0e-5;
    public static double increment = 1.0e-4;
    public static double epsilon = 1.0e-5;
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

    double definite_integral(double x1, double x2){
        double area = 0;
        double mod = 1;
        if (x1 > x2){
            double temp_x = x1;
            x1 = x2;
            x2 = temp_x;
            mod = -1;
        }
        for (double i = x1 + increment; i<x2; i += increment){
            double x1_dist = i - x1;
            area += (increment/2) * (f(x1+x1_dist) + f(x1 + x1_dist - increment));
        }
        return (area*mod);
    }

    double golden_ratio_min(double a, double b){
        double k = (Math.sqrt(5)-1)/2;
        double xL = b - k * (b - a);
        double xR = a + k * (b - a);

        while ( (b-a) > epsilon){
            if (f(xL) < f(xR)){
                b = xR;
                xR = xL;
                xL = b - k * (b - a);
            }
            else{
                a = xL;
                xL = xR;
                xR = a + k * (b - a);
            }
        }
        return f((a+b)/2);
    }
    
}
