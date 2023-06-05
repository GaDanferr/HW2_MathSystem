/**
 * Depicts a new class depicting a relationship between multiple functions.
 */
public abstract class MultiFunction extends  Function{
    final  private Function[] functions;
    final private int functionCount;

    /**
     * Gets the functions array for internal use by the child classes.
     * @return the functions array.
     */
    protected Function[] getFunctions() {
        return functions;
    }

    /**
     *
     * @return the functionCount
     */
    protected int getFunctionCount() {
        return functionCount;
    }

    /**
     *
     * @param i the index of the function in the function array.
     * @return the i'th function in the array.
     */
    protected Function getFunction(int i){
        Function[] functions = getFunctions();
        return functions[i];
    }

    /**
     *constructs a multiFunction used by the child classes as an attribute corrugation.
     * @param firstFunction the first function of the multi-function.
     * @param secondFunction the second function of the multi-function.
     * @param otherFunctions the other functions of the multi-function.
     */
    public MultiFunction(Function firstFunction , Function secondFunction ,Function... otherFunctions){
        this.functionCount = 2+ otherFunctions.length;
        this.functions = new Function[functionCount];
        this.functions[0] = firstFunction;
        this.functions[1] = secondFunction;
        for(int i = 2; i< functionCount; i++){
            this.functions[i] = otherFunctions[i-2];
        }
    }
}
