public class Difference extends Function {
    Function funcOne;
    Function funcTwo;
    public Difference(Function funcOne, Function funcTwo){
        this.funcOne = funcOne;
        this.funcTwo = funcTwo;
    }
    @Override
    public double valueAt(double x) {
        return funcOne.valueAt(x) - funcTwo.valueAt(x);
    }

    @Override
    public String toString() {
        return "(" + funcOne.toString() +" - " + funcTwo.toString() +")";
    }

    @Override
    public Difference derivative() {
        return new Difference(funcOne.derivative(),funcTwo.derivative());
    }
}
