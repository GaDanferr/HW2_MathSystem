/**
 * Depicts a single product relationship between two functions
 */
public class Product extends MultiProduct {
    /**
     * Creates a new product class object
     * @param firstFunction the first function
     * @param secondFunction the second function
     */
    public Product(Function firstFunction,Function secondFunction) {
        super(firstFunction,secondFunction);
    }

    /**
     * derives the function
     * @return a sum object describing the derivative.
     */
    @Override
    public Sum derivative() {
        Product leftProduct = new Product(getFunction(0).derivative(),getFunction(1));
        Product rightProduct = new Product(getFunction(0),getFunction(1).derivative());
        return new Sum(leftProduct,rightProduct);
    }


}
