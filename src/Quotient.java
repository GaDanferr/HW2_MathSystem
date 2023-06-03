import java.util.DuplicateFormatFlagsException;

public class Quotient extends Function{
    Function dividend;
    Function divisor;
    public Quotient(Function dividend, Function divisor){
        this.dividend = dividend;
        this.divisor = divisor;
    }
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

    @Override
    public Quotient derivative() {
        Product leftProduct = new Product(dividend.derivative(),divisor);
        Product rightProduct = new Product(dividend,divisor.derivative());
        Difference newDividend = new Difference(leftProduct,rightProduct);
        Power newDivisor = new Power(divisor,2);
        return new Quotient(newDividend,newDivisor);
    }

}
