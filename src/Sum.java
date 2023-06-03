public class Sum extends Function{
    private final Function funcOne;
    private final Function funcTwo;

    public Sum(Function funcOne, Function funcTwo){
        this.funcOne = funcOne;
        this.funcTwo = funcTwo;
    }

    @Override
    public double valueAt(double x) {
        return funcOne.valueAt(x) + funcTwo.valueAt(x);
    }

    @Override
    public String toString() {
        return "(" + funcOne.toString() + " + " + funcTwo.toString() + ")" ;
    }

    @Override
    public Sum derivative() {
        return new Sum(funcOne.derivative(),funcTwo.derivative());
    }


}
