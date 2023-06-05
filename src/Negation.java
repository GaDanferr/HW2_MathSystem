/**
 * An object depicting a negation relationship on a single function.
 */
public class Negation extends Function{
    private final Function function;
    public Negation(Function function){
        this.function = function;
    }

    @Override
    public double valueAt(double x) {
        double value = function.valueAt(x);
        return -value;
    }

    @Override
    public String toString() {
        return "(-" + function.toString() +")";
    }

    @Override
    public Negation derivative() {
        return new Negation(function.derivative());
    }


}
