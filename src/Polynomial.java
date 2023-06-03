public class Polynomial extends Function{
    private final double[] coefficient;
    private final int biggestPower;

    public Polynomial(double... varargs){
        int arrSize = varargs.length;


        if(arrSize==1){
            new Constant(varargs[0]);
        }
        int j = 1;
        boolean flag = true;
        while ((j < arrSize)&&flag){
            if (varargs[j] != 0){
                flag = false;
            }
            j++;
        }
        if(flag){
            new Constant(varargs[0]);
        }

        this.biggestPower = arrSize - 1;
        this.coefficient = new double[biggestPower + 1];

        for(int i = 0; i < biggestPower + 1;i++){
            this.coefficient[i] = varargs[i];
        }
    }

    public Polynomial(double constant){
        this.biggestPower = 0;
        coefficient = new double[1];
        coefficient[0] = constant;
    }

    protected double getCoefficient(int i){
        return coefficient[i];
    }
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        double currentCoefficient = getCoefficient(0);
        if(currentCoefficient!=0){
            if(convertInt(currentCoefficient)){
                string.append((int)currentCoefficient);
            }
            else{
                string.append(currentCoefficient);
            }
        }

        for(int i = 1 ; i< this.biggestPower +1; i++){
            currentCoefficient = this.getCoefficient(i);
            if(currentCoefficient !=0){
                if(currentCoefficient >0) {
                    string.append(" + ");
                }
                else{
                    string.append(" - ");
                }
                double absoluteVal = Function.absoluteValue(currentCoefficient);
                if(absoluteVal != 1){
                    if(Function.convertInt(currentCoefficient)){
                        string.append((int)absoluteVal);
                    }
                    else {
                        string.append(absoluteVal);
                    }
                }
                string.append("x");
                if (i!=1) {
                    string.append("^").append(i);
                }

            }
        }
        return "(" + string + ")";
    }

    @Override
    public Polynomial derivative() {
        if (biggestPower == 0){
            return new Constant(0);
        }
        if (biggestPower == 1){
            return new Constant(this.getCoefficient(1));
        }
        else {
            double[] DervCoeff = new double[biggestPower];
            for(int i = 0 ; i<biggestPower;i++) {
                DervCoeff[i] = this.getCoefficient(i+1)*(i+1);
            }
            return new Polynomial(DervCoeff);
        }
    }


    @Override
    public double valueAt(double x) {
        double value = this.getCoefficient(0) ;
        for(int i = 1; i< biggestPower+1 ; i++){
            value += this.getCoefficient(i)*Math.pow(x,i);
        }
        return value;
    }

}
