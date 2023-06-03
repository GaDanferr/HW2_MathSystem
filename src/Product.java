public class Product extends MultiProduct {


    public Product(Function funcOne,Function funcTwo) {
        super(funcOne,funcTwo);
    }


    @Override
    public Sum derivative() {
        Product leftProduct = new Product(getFunction(0).derivative(),getFunction(1));
        Product rightProduct = new Product(getFunction(0),getFunction(1).derivative());
        return new Sum(leftProduct,rightProduct);
    }


}
