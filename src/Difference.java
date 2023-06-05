/**Depicts a difference between two functions */
public class Difference extends Function {
    Function funcOne;
    Function funcTwo;

    /**
     * Creates a new difference function as F(x) = functionOne - FunctionTwo
     * @param firstFunction The first unchanged function.
     * @param secondFunction The second function being negated.
     */
    public Difference(Function firstFunction, Function secondFunction){
        this.funcOne = firstFunction;
        this.funcTwo = secondFunction;
    }

    /**
     * evaluates the function at point X whereas the value is F(X) - G(X)
     * @param x receives as input a point in which the function will be evaluated.
     * @return the value of the subtraction of the value of second function from the first function.
     */
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
