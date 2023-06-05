/**
 * Depicts a quotient relationship between two functions.
 */
public class Quotient extends Function{
    Function dividend;
    Function divisor;

    /**
     * Creates a new function depicting a quotient relationship between two functions.
     * @param dividend the dividend of the quotient.
     * @param divisor the divisor of the quotient.
     */
    public Quotient(Function dividend, Function divisor){
        this.dividend = dividend;
        this.divisor = divisor;
    }

    /**
     * evaluates the function at x
     * @param x receives as input a point in which the function will be evaluated.
     * @return the value of the function at point x
     */
    @Override
    public double valueAt(double x) {
        double divisorValue = divisor.valueAt(x);
        if(divisorValue == 0){
            return 0;
        }
        else{
            return dividend.valueAt(x)/divisor.valueAt(x);
        }
    }

    @Override
    public String toString() {
        return "(" +dividend+ " / " +divisor+")";
    }

    /**
     * derives the function
     * @return a new quotient object depicting the derivative of the function
     */
    @Override
    public Quotient derivative() {
        Product leftProduct = new Product(dividend.derivative(),divisor);
        Product rightProduct = new Product(dividend,divisor.derivative());
        Difference newDividend = new Difference(leftProduct,rightProduct);
        Power newDivisor = new Power(divisor,2);
        return new Quotient(newDividend,newDivisor);
    }

}
