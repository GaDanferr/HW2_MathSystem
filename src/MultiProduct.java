/**Class containing multiple product of multiple functions */
public class MultiProduct extends MultiFunction {
    /**
     * Constructs a MultiProduct Function by calling its parent class MultiFunction
     *
     * @param firstFunction The first function in the multi product
     * @param secondFunction The second function in the multi product
     * @param otherFunctions an array containing any amount of other functions in the multi product
     */
    public MultiProduct(Function firstFunction, Function secondFunction ,Function... otherFunctions){
        super(firstFunction,secondFunction,otherFunctions);
    }


    /**
     *  evaluates the multi-product at the point x
     * @param x receives as input a point in which the function will be evaluated.
     * @return the product of all functions
     */
    @Override
    public double valueAt(double x) {
        Function[] functions;
        int functionCount = getFunctionCount();
        functions = getFunctions();
        double value = functions[0].valueAt(x);
        for(int i = 1; i < functionCount; i++){
            value *= functions[i].valueAt(x);
        }
        return value;
    }

    @Override
    public String toString() {
        Function[] functions = getFunctions();
        int functionCount = getFunctionCount();
        StringBuilder functionsString = new StringBuilder(functions[0].toString());
        for(int i = 1; i< functionCount; i++){
            functionsString.append(" * ").append(functions[i].toString());
        }
        return "("+ functionsString +")";
    }

    /**
     * derives the function where-as if the functions are listed as f1 f2 f3... fn and f'i is the derivative
     * of the i'th function the derivative would be:
     * f'1*f2*f3... + f'2*f1*f3 .... + ....f'n*f1*f2...
     * @return MultiSum object of the derivative
     */
    @Override
    public Function derivative()
    {
        int functionCount = getFunctionCount();
        Function[] functions = getFunctions();
        MultiProduct[] allDerivatives = new MultiProduct[functionCount]; // Used at the end of the function to create
                                                                            // a new MultiSum object
        Function[] certainDerivative = new Function[functionCount]; // Used in the loop to arrange the derivatives
        int offset;                                                //offset controls the location in the array
                                                                  // used to avoid one function being added twice
        Function[] tmp;
        for(int i = 0; i < functionCount; i++){
            certainDerivative[0] = functions[i].derivative();
            offset = 1;
            for(int j = 0; j < functionCount; j++){
                if(i!=j) {
                    certainDerivative[j+offset] = functions[j];
                }
                else{
                    offset = 0;
                }
            }
            tmp = Converter(certainDerivative); //Depicts the last n-2 derivatives to accommodate the product builder
            allDerivatives[i] = new MultiProduct(certainDerivative[0],certainDerivative[1],tmp) ;
        }
        tmp = Converter(allDerivatives);
        return new MultiSum(allDerivatives[0], allDerivatives[1],tmp) ;
    }

    /**
     *
     * Internal use function . Used exclusively by the class at derivative() to split an array.
     *
     * @param functions receives an n-length array of functions
     * @return returns an array without the first two functions
     */
    protected Function[] Converter(Function... functions) {

        int otherFunctionSize = functions.length-2;
        Function[] otherFunctions = new Function[otherFunctionSize];
        for (int i = 0; i < otherFunctionSize; i++) {
            otherFunctions[i] = functions[i + 2];
        }
        return otherFunctions;
    }




}
