public abstract class MultiFunction extends  Function{
    final  private Function[] functions;
    final private int functionCount;

    protected Function[] getFunctions() {
        return functions;
    }

    protected int getFunctionCount() {
        return functionCount;
    }

    protected Function getFunction(int i){
        Function[] functions = getFunctions();
        return functions[i];
    }
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
