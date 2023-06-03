public class MultiProduct extends Function {
    final Function[] functions;
    final int funcCount;
    public MultiProduct(Function... functionsList){
        this.funcCount = functionsList.length;
        this.functions = new Function[funcCount];
        for(int i = 0 ; i<funcCount; i++){
            this.functions[i] = functionsList[i];
        }
    }

    @Override
    public double valueAt(double x) {
        double value = functions[0].valueAt(x);
        for(int i = 1 ; i < funcCount ; i++){
            value *= functions[i].valueAt(x);
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder functionsString = new StringBuilder(functions[0].toString());
        for(int i = 1 ; i<funcCount ; i++){
            functionsString.append(" * ").append(functions[i].toString());
        }
        return "("+ functionsString +")";
    }

    @Override
    public Function derivative()
    {
        MultiProduct[] sumOfDerivatives = new MultiProduct[funcCount];
        Function[] certainDerivative = new Function[funcCount];
        int offset;
        for(int i = 0 ; i < funcCount ; i++){
            certainDerivative[0] = functions[i].derivative();
            offset = 1;
            for(int j = 0 ; j < funcCount; j++){
                if(i!=j) {
                    certainDerivative[j+offset] = functions[j];
                }
                else{
                    offset = 0;
                }
            }
            sumOfDerivatives[i] = new MultiProduct(certainDerivative);
        }
        return new MultiSum(sumOfDerivatives) ;
    }




}
