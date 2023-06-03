public class Product extends Function {
    private final Function funcOne;
    private final Function funcTwo;

    public Product(Function funcOne,Function funcTwo) {
        this.funcOne = funcOne;
        this.funcTwo = funcTwo;
    }

    @Override
    public double valueAt(double x) {
        return funcOne.valueAt(x) * funcTwo.valueAt(x);
    }

    @Override
    public String toString() {
        return "(" + funcOne + " * " + funcTwo + ")";
    }

    @Override
    public Sum derivative() {
        Product leftProduct = new Product(funcOne.derivative(),funcTwo);
        Product rightProduct = new Product(funcOne,funcTwo.derivative());
        return new Sum(leftProduct,rightProduct);
    }


}
