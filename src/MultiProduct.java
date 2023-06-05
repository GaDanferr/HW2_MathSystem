public class MultiProduct extends MultiFunction {

    public MultiProduct(Function firstFunction, Function secondFunction ,Function... otherFunctions){
        super(firstFunction,secondFunction,otherFunctions);
    }


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

    @Override
    public Function derivative()
    {
        int functionCount = getFunctionCount();
        Function[] functions = getFunctions();
        MultiProduct[] sumOfDerivatives = new MultiProduct[functionCount];
        Function[] certainDerivative = new Function[functionCount];
        int offset;
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
            tmp = Converter(certainDerivative);
            sumOfDerivatives[i] = new MultiProduct(certainDerivative[0],certainDerivative[1],tmp) ;
        }
        tmp = Converter(sumOfDerivatives);
        return new MultiSum(sumOfDerivatives[0],sumOfDerivatives[1],tmp) ;
    }
    protected Function[] Converter(Function... functions) {

        int otherFunctionSize = functions.length-2;
        Function[] otherFunctions = new Function[otherFunctionSize];
        for (int i = 0; i < otherFunctionSize; i++) {
            otherFunctions[i] = functions[i + 2];
        }
        return otherFunctions;
    }




}
