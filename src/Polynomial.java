import java.security.ProtectionDomain;

public class Polynomial extends Function{
    private final double[] coefficient;
    private final int arrSize;

    public Polynomial(double... varargs){
        this.arrSize = varargs.length;
        this.coefficient = new double[arrSize];

        for(int i = 0; i < arrSize ;i++){
            this.coefficient[i] = varargs[i];
        }
    }
    protected int findFirstNonZero(){
        double currentCoefficient;
        if(arrSize==1){
            return 0;
        }
        else{
            for (int i = 1 ;i < arrSize; i++) {
                currentCoefficient = getCoefficient(i);
                if (currentCoefficient !=0){
                    return i;
                }
            }
        }


            return arrSize;
    }

    public Polynomial(double constant){
        this.arrSize = 1;
        coefficient = new double[1];
        coefficient[0] = constant;
    }

    protected double getCoefficient(int i){
        return coefficient[i];
    }
    public int countNonZeroCoefficient(){
        int count = 0;
        for(int i = 0 ;i < arrSize ;i++){
            if(getCoefficient(i)!=0){
                count++;
            }
        }

        return count;
    }
    @Override
    public String toString() {
        double[] nonZeroCoefficientArray;
        int[] nonZeroIndexArray;
        int count = this.countNonZeroCoefficient();

        if(count == 0 ){
            return "(0)";
        }


        nonZeroCoefficientArray = new double[count];
        nonZeroIndexArray = new int[count];
        int counter = 0;
        for(int i = 0 ;i < arrSize ;i++ ){
            double currentCoefficient = getCoefficient(i);
            if(currentCoefficient!=0){
                nonZeroCoefficientArray[counter] = currentCoefficient;
                nonZeroIndexArray[counter] = i;
                counter++;
            }
        }


        StringBuilder string = new StringBuilder();
        int firstIndex = nonZeroIndexArray[0];
        double firstCoefficient = nonZeroCoefficientArray[0] ;
        if(firstIndex == 0) {
            if (convertInt(firstCoefficient)) {
                string.append((int) firstCoefficient);
            } else {
                string.append(firstCoefficient);
            }
        }
        else {
            if (absoluteValue(firstCoefficient) != 1) {
                if(convertInt(firstCoefficient)){
                    string.append((int)firstCoefficient);
                }
                else{
                    string.append(firstCoefficient);
                }
            }
            else{
                if(firstCoefficient<0){
                    string.append("-");
                }
            }
        }
        if(firstIndex>=1){
            string.append("x");
        }
        if(firstIndex>1){
            string.append("^").append(firstIndex);
        }

        for(int i = 1 ;i < count ;i++){
            double currentNumber = nonZeroCoefficientArray[i];
            int currentIndex = nonZeroIndexArray[i];
            if(currentNumber > 0){
                string.append(" + ");
            }
            else{
                string.append(" - ");
            }
            currentNumber = absoluteValue(currentNumber);
            if(currentNumber!=1){
                if(convertInt(currentNumber)){
                    string.append((int)currentNumber);
                }
                else{
                    string.append(currentNumber);
                }
            }
            string.append("x");
            if(currentIndex > 1){
                string.append("^").append(currentIndex);
            }
        }
        return "(" + string + ")";
    }

    @Override
    public Polynomial derivative() {
        if ((arrSize == 1) ||findFirstNonZero()==arrSize){
            return new Constant(0);
        }
        if (arrSize == 2){
            return new Constant(this.getCoefficient(1));
        }
        else {
            int newArrSize = arrSize-1;
            double[] DervCoefficient = new double[newArrSize];
            for(int i = 0 ; i<newArrSize;i++) {
                DervCoefficient[i] = this.getCoefficient(i+1)*(i+1);
            }
            return new Polynomial(DervCoefficient);
        }
    }


    @Override
    public double valueAt(double x) {
        double value = this.getCoefficient(0) ;
        for(int i = 1; i< arrSize ; i++){
            value += this.getCoefficient(i)*Math.pow(x,i);
        }
        return value;
    }

}
