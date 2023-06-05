/**
 * Depicts a power relationship of a function
 */
public class Power extends Function{
    final private int power;
    final private Function function;

    /**
     * Creates a new power function object.
     * @param function the function being raised by a power.
     * @param power the power being raised where-as the power can only be a non-negative whole number.
     */
    public  Power(Function function , int power){
        this.function = function;
        this.power = power;
    }
    @Override
    public double valueAt(double x) {
        return Math.pow(this.function.valueAt(x),power);
    }

    @Override
    public String toString() {
        return "("+"" + function.toString() + "^" + power +")";
    }

    /**
     * Creates a derivative of the function
     * @return Creates a new Function object depicting the derivative
     * A new constant for power = 0 else a new multi product
     */
    @Override
    public Function derivative() {
        if (power==0){
            return new Constant(0);
        }
        if(power == 1){
            return function.derivative();
        }
        else{
            return new MultiProduct(new Constant(power) , new Power(function,power-1) , function.derivative());
        }
    }
}
