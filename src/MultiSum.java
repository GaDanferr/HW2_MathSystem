public class MultiSum extends Function{
    final Function[] functions;
    final int sumSize;
    public MultiSum(Function... functions){
        int sumSize = functions.length;
        this.functions = functions;
        this.sumSize = sumSize;
    }
    @Override
    public double valueAt(double x) {
        double value = 0;
        for(int i = 0 ; i < sumSize ; i++){
            value += functions[i].valueAt(x);
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder functionString = new StringBuilder(functions[0].toString());
        for (int i = 1 ; i < sumSize; i++){
            functionString.append(" + ").append(functions[i].toString());
        }
        return "(" +functionString +")";
    }

    @Override
    public MultiSum derivative() {
        if(sumSize==2){
            return new Sum(functions[0].derivative(),functions[1].derivative());
        }
        Function[] derivatives = new Function[sumSize];
        for (int i = 0 ; i < sumSize ; i++){
            derivatives[i] = functions[i].derivative();
        }
        return new MultiSum(derivatives);
    }
}
