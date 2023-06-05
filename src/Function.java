/**Class depicting general one variable mathematical functions   */
public abstract class Function {
    /**
     * Used to check if a number is safe to convert to int.
     *
     * @param number receives a double as input.
     * @return boolean Whether a function is safe to convert
     */
    public static boolean convertInt(double number){
        int intCasted = (int)number;
        return intCasted == number;
    }

    /**
     * Evaluates a function at a point.
     *
     * @param x receives as input a point in which the function will be evaluated.
     * @return returns the evaluated value of the function at the point.
     */
    public abstract double valueAt(double x);

    /**
     * Constructs a string depicting the function.
     *
     * @return returns a string depicting the function
     */
    public abstract String toString();

    /**
     * Used to derive a function.
     *
     * @return Returns the derivative of the function.
     */
    public abstract Function derivative();

    /**
     * Calculated a factorial (n!).
     * @param n recieves an integer to evaluate its factorial.
     * @return the factorial of the integer.
     */
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

    /**
     * Calculate the absolute value of a double.
     * @param value the value to evaluate.
     * @return the absolute value of the input.
     */
    protected static double absoluteValue(double value){
        if (value < 0){
            return -value;
        }
        else{
            return value;
        }
    }

    /**
     * Using the Newton method approximates the root of a function the closed interval [a,b]
     * with an approximation.
     * The function works under the following assumptions:
     * (1)The function is continuous for every real number in the closed interval and
     *    in part is part of its domain.
     * (2)The value of the function at points a and b are of opposite sign.
     * (3)There is exactly one root at the closed interval.
     * (4)a is smaller than b.
     * @param a the left limit point of the interval.
     * @param b the right limit point of the interval.
     * @param epsilon the margin of error the user accepts with a default of 10^-5.
     * @return the approximation of the root.
     */
    public double bisectionMethod(double a,double b,double epsilon){
        double left = a;
        double right = b;
        double mid;
        while (right-left> epsilon){
            mid = (left + right) / 2;
            if (this.valueAt(left)*this.valueAt(mid) >0){
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
    /**
     * Using Raphson's theory approximates the root of a function at the neighbourhood of a
     * with an approximation.
     * The function works under the following assumptions:
     * (1) the function is derivable and in turn continuous and defined in the
     *     neighbourhood of a and the point a itself.
     * @param a the point the neighbourhood surrounds.
     * @param epsilon margin of error the user accepts with a default of 10^-5.
     * @return the approximation of the root.
     */
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

    /**
     * Creates Mclaurin series(taylor polynomial / taylor series) of order n of
     * the function under the following assumptions:
     * (1) The function is defined at the point 0 and its neighbourhood.
     * (2) The derivative of the n-th order of the function exists.
     *
     * @param n the order of the taylor series.
     * @return polynomial depicting the Mclaurin series of the function of n-th order.
     */
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
