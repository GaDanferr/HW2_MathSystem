public class MultiSum extends MultiFunction{
    public MultiSum(Function firstFunction, Function secondFunction, Function... otherFunctions){
        super(firstFunction,secondFunction,otherFunctions);
    }
    @Override
    public double valueAt(double x) {
        int funcCount = getFunctionCount();
        Function[] functions = getFunctions();
        double value = 0;
        for(int i = 0; i < funcCount; i++){

            value += functions[i].valueAt(x);
        }
        return value;
    }

    @Override
    public String toString() {
        Function[] functions = getFunctions();
        int funcCount = getFunctionCount();
        StringBuilder functionString = new StringBuilder(functions[0].toString());
        for (int i = 1; i < funcCount; i++){
            functionString.append(" + ").append(functions[i].toString());
        }
        return "(" +functionString +")";
    }

    @Override
    public MultiSum derivative() {
        int funcCount = getFunctionCount();
        Function[] functions = getFunctions();


        Function[] otherDerivatives = new Function[funcCount - 2];
        for (int i = 2; i < funcCount; i++){
            otherDerivatives[i-2] = functions[i].derivative();
        }
        return new MultiSum(functions[0].derivative(),functions[1].derivative(),otherDerivatives);
    }
}
