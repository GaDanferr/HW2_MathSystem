public class Product extends MultiProduct {

    public Product(Function firstFunction,Function secondFunction) {
        super(firstFunction,secondFunction);
    }

    @Override
    public Sum derivative() {
        Product leftProduct = new Product(getFunction(0).derivative(),getFunction(1));
        Product rightProduct = new Product(getFunction(0),getFunction(1).derivative());
        return new Sum(leftProduct,rightProduct);
    }


}
