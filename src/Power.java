public class Power extends Function{
    final private int power;
    final private Function function;
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
        return "("+"(" + function.toString() + ")^" + power +")";
    }

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
