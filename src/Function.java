public abstract class Function {
    public static boolean convertInt(double number){
        int intCasted = (int)number;
        return intCasted == number;
    }
    public abstract double valueAt(double x);
    public abstract String toString();
    public abstract Function derivative();
    public static double Factorial(int n){
        if(n < 0){
            return 0;
        }
        else if (n==0) {
            return 1;

        }
        else{
            return n * Factorial(n-1);
        }
    }
    protected static double absoluteValue(double value){
        if (value < 0){
            return -value;
        }
        else{
            return value;
        }
    }
    public double bisectionMethod(double a,double b,double error){
        double left = a;
        double right = b;
        double mid;
        while (absoluteValue(right-left)>error){
            mid = (left + right) / 2;
            if (this.valueAt(left)*this.valueAt(right) >0){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        return (left+right)/2;
    }
    public double bisectionMethod(double a,double b) {
        return bisectionMethod(a,b,Math.pow(10,-5));
    }
    public double newtonRaphsonMethod (double a , double epsilon){
        double x_k = a;
        while(Function.absoluteValue(this.valueAt(x_k))>= epsilon  ){
            x_k = x_k - (this.valueAt(x_k)/this.derivative().valueAt(x_k));
        }
        return x_k;
    }
    public double newtonRaphsonMethod (double a) {
        return newtonRaphsonMethod(a,Math.pow(10,-5));
    }
    protected Polynomial taylorPolynomial(int n){

        double[] coefficient = new double[n+1];
        coefficient[0] = this.valueAt(0);
        if (n == 0){
            return new Constant(coefficient[0]);
        }
        Function derivative = this;
        for(int i = 0 ; i < n ; i++){
            derivative = derivative.derivative();
            coefficient[i+1] = derivative.valueAt(0) / Factorial(i+1);
        }
        return new Polynomial(coefficient);
    }
}
